package com.hblg.forum.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hblg.forum.Entity.Comment;
import com.hblg.forum.Mapper.CommentMapper;
import com.hblg.forum.Service.CommentService;
import com.hblg.forum.pojo.CommentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<CommentPojo> getComments(Long postId) {
        QueryWrapper<Comment> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(Comment::getPostId,postId)
                .eq(Comment::getParentId,0);
        //找到一级评论
        List<Comment> commentList=commentMapper.selectList(queryWrapper);
        List<CommentPojo> commentPojoList=new ArrayList<>();
        for(Comment item : commentList){
            //将数据拷贝到Comment工具类
            CommentPojo commentPojo=new CommentPojo();
            copyComment(item,commentPojo);
//            //找子评论
            QueryWrapper<Comment> query=new QueryWrapper<>();
            query.lambda().eq(Comment::getParentId,item.getId());
            List<Comment> children=commentMapper.selectList(query);
//            //父子评论的集合
            commentPojo.setChildren(children);
            commentPojoList.add(commentPojo);
        }
        return commentPojoList;
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insert(comment);
    }

    public void copyComment(Comment comment,CommentPojo commentPojo){
        commentPojo.setId(comment.getId());
        commentPojo.setSenderName(comment.getSenderName());
        commentPojo.setSenderAvatar(comment.getSenderAvatar());
        commentPojo.setLikeNum(comment.getLikeNum());
        commentPojo.setReceiverName(comment.getReceiverName());
        commentPojo.setPostDate(comment.getPostDate());
        commentPojo.setParentId(comment.getParentId());
        commentPojo.setText(comment.getText());
        commentPojo.setPostId(comment.getPostId());
    }
}

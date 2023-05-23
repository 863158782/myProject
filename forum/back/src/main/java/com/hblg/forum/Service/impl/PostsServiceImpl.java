package com.hblg.forum.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hblg.forum.Entity.Posts;
import com.hblg.forum.Mapper.PostsMapper;
import com.hblg.forum.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    PostsMapper postsMapper;

    @Override
    public List<Posts> getAllPosts() {
        List<Posts> list=postsMapper.selectList(null);
        return list;
    }

    @Override
    public void addPosts(Posts posts) {
        if(posts.getId()==null){
            postsMapper.insert(posts);
        }
        else{
            QueryWrapper<Posts> wrapper=new QueryWrapper<>();
            wrapper.lambda().eq(Posts::getId,posts.getId());
            postsMapper.update(posts,wrapper);
        }

    }
}

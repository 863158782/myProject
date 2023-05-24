package com.hblg.forum.Service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hblg.forum.Entity.Posts;
import com.hblg.forum.Entity.User;
import com.hblg.forum.Mapper.PostsMapper;
import com.hblg.forum.Service.PostsService;
import com.hblg.forum.pojo.PostsPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostsServiceImpl implements PostsService {


    @Autowired
    PostsMapper postsMapper;

    @Autowired
    UserServiceImpl userService;

    @Override
    public List<PostsPojo> getAllPosts() {
        List<PostsPojo> postsPojos=new ArrayList<>();
        List<Posts> list=postsMapper.selectList(null);
        for(int i=0;i<list.size();i++){
            PostsPojo po=new PostsPojo();
            copyPosts(list.get(i),po);
            postsPojos.add(po);
            User user=userService.findUserByID(list.get(i).getAuthor());
            postsPojos.get(i).setUsername(user.getUsername());
            System.out.println(postsPojos.get(i).getUsername());
        }

        return postsPojos;
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

    @Override
    public PostsPojo findPostById(Long id) {
        //增加访问量
        Posts posts=postsMapper.selectById(id);
        posts.setVisited(posts.getVisited()+1);
        QueryWrapper<Posts> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(Posts::getId,posts.getId());
        postsMapper.update(posts,wrapper);
        //拷贝
        PostsPojo postsPojo=new PostsPojo();
        copyPosts(posts,postsPojo);
        //找到用户名并设置
        postsPojo.setUsername(userService.findUserByID(postsPojo.getId()).getUsername());
        return postsPojo;
    }

    @Override
    public void delPostById(Long id) {
        postsMapper.deleteById(id);
    }

    public void copyPosts(Posts posts,PostsPojo postsPojo){
        postsPojo.setId(posts.getId());
        postsPojo.setTitle(posts.getTitle());
        postsPojo.setAuthor(posts.getAuthor());
        postsPojo.setContext(posts.getContext());
        postsPojo.setCover(posts.getCover());
        postsPojo.setVisited(posts.getVisited());
        postsPojo.setDate(posts.getDate());
        postsPojo.setDescription(posts.getDescription());
    }
}

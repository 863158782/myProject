package com.hblg.forum.Service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Posts> getAllPosts(Long pid) {
//        List<PostsPojo> postsPojos=new ArrayList<>();
        QueryWrapper<Posts> queryWrapper=new QueryWrapper<>();
        List<Posts> list=new ArrayList<>();
        if(pid==0)
            list=postsMapper.selectList(null);
        else{
            queryWrapper.lambda().eq(Posts::getPid,pid);
            list=postsMapper.selectList(queryWrapper);
        }

//        for(int i=0;i<list.size();i++){
//            PostsPojo po=new PostsPojo();
//            copyPosts(list.get(i),po);
//            postsPojos.add(po);
//            User user=userService.findUserByID(list.get(i).getAuthor());
//            postsPojos.get(i).setUsername(user.getUsername());
//            System.out.println(postsPojos.get(i).getUsername());
//        }

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

    @Override
    public Posts findPostById(Long id) {
        //增加访问量
        Posts posts=postsMapper.selectById(id);
        posts.setVisited(posts.getVisited()+1);
        QueryWrapper<Posts> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(Posts::getId,posts.getId());
        postsMapper.update(posts,wrapper);
        //拷贝
//        PostsPojo postsPojo=new PostsPojo();
//        copyPosts(posts,postsPojo);
//        //找到用户名并设置
//        postsPojo.setUsername(userService.findUserByID(postsPojo.getId()).getUsername());
        return posts;
    }

    @Override
    public void delPostById(Long id) {
        postsMapper.deleteById(id);
    }

    @Override
    public List<Posts> getPostsByNname(String name) {
        QueryWrapper<Posts> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("title",name).or().like("author",name);
        return postsMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Posts> selectPage(int current, int size,Long pid,String name) {
        Page<Posts> page=new Page<>(current,size);
//        System.out.println(pid);
        QueryWrapper<Posts> queryWrapper=new QueryWrapper<>();
        String str=name==null?"":name;
        if(pid!=0)
            queryWrapper.lambda()
                    .and(i -> i.like(Posts::getTitle,str)
                    .or()
                    .like(Posts::getAuthor,str)
                    )
                    .eq(Posts::getPid,pid);
        else
            queryWrapper.lambda().like(Posts::getTitle,str)
                    .or()
                    .like(Posts::getAuthor,str);
        System.out.println(postsMapper.selectPage(page,queryWrapper).toString());
        return postsMapper.selectPage(page,queryWrapper);
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

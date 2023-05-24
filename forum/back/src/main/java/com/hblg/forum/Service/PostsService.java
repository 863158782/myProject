package com.hblg.forum.Service;

import com.hblg.forum.Entity.Posts;
import com.hblg.forum.pojo.PostsPojo;

import java.util.*;

public interface PostsService {
    public List<PostsPojo> getAllPosts();

    public void addPosts(Posts posts);

    public PostsPojo findPostById(Long id);

    public void delPostById(Long id);
}

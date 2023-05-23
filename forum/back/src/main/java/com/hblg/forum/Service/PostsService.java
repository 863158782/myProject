package com.hblg.forum.Service;

import com.hblg.forum.Entity.Posts;
import java.util.*;

public interface PostsService {
    public List<Posts> getAllPosts();

    public void addPosts(Posts posts);
}

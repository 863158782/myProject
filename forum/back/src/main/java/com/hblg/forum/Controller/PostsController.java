package com.hblg.forum.Controller;

import com.hblg.forum.Entity.Posts;
import com.hblg.forum.Service.impl.PostsServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api")
public class PostsController {
    @Autowired
    PostsServiceImpl postsService;

    @GetMapping("/getPosts")
    public Result getAllPosts(){
        Result result=new Result();
        result.setCode(200);
        result.setData(postsService.getAllPosts());
        return result;
    }

    @PostMapping("/Posts")
    public Result addPosts(@RequestBody Posts posts){
        postsService.addPosts(posts);
        return new Result(200);
    }
}

package com.hblg.forum.Controller;

import com.hblg.forum.Entity.Comment;
import com.hblg.forum.Service.CommentService;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getComments/{postId}")
    public Result getComments(@PathVariable Long postId){

        return new Result(commentService.getComments(postId));
    }

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment){
        commentService.insertComment(comment);
        return new Result(200);
    }
}

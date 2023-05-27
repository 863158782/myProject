package com.hblg.forum.Service;

import com.hblg.forum.Entity.Comment;
import com.hblg.forum.pojo.CommentPojo;
import org.springframework.stereotype.Service;

import java.util.*;


public interface CommentService {
    public List<CommentPojo> getComments(Long postId);

    public void insertComment(Comment comment);
}

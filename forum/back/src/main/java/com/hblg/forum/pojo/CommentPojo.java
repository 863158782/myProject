package com.hblg.forum.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hblg.forum.Entity.Comment;
import lombok.Data;
import java.util.*;

@Data
public class CommentPojo {
    @TableId(type= IdType.AUTO)
    Long id;
    String senderName;
    String senderAvatar;
    String text;
    String postDate;
    Long parentId;
    Long likeNum;
    Long postId;
    String receiverName;
    String receiverAvatar;
    List<Comment> children;
}

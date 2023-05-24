package com.hblg.forum.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class PostsPojo {
        @TableId(type = IdType.AUTO)
        Long id;
        String cover;
        String title;
        Long author;
        String date;
        String description;
        String context;
        Long pid;
        Long visited;
        String username;
}

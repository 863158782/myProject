package com.hblg.forum.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Posts {
    @TableId(type = IdType.AUTO)
    Long id;
    String cover;
    String title;
    String author;
    String date;
    String description;
    String context;
    Long pid;
}

package com.hblg.forum.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hblg.forum.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}

package com.hblg.forum.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hblg.forum.Entity.Posts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostsMapper extends BaseMapper<Posts> {
}

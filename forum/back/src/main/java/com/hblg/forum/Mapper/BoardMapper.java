package com.hblg.forum.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hblg.forum.Entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper extends BaseMapper<Board> {
}

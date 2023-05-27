package com.hblg.forum.Service.impl;

import com.hblg.forum.Entity.Board;
import com.hblg.forum.Mapper.BoardMapper;
import com.hblg.forum.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<Board> getAllBoard() {
        return boardMapper.selectList(null);
    }

    @Override
    public void addBoard(Board board) {
        boardMapper.insert(board);
    }
}

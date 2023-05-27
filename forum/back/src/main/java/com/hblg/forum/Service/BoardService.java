package com.hblg.forum.Service;

import com.hblg.forum.Entity.Board;
import java.util.*;

public interface BoardService {

    public List<Board> getAllBoard();
    public void addBoard(Board board);
}

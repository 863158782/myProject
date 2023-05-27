package com.hblg.forum.Controller;

import com.hblg.forum.Entity.Board;
import com.hblg.forum.Service.impl.BoardServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api")
public class BoardController {

    @Autowired
    BoardServiceImpl boardService;

    @GetMapping("/getAllBoard")
    public Result getAllBoard(){
        return new Result(boardService.getAllBoard());
    }

    @PostMapping("/insertBoard")
    public Result insertBoard(@RequestBody Board board){
        boardService.addBoard(board);
        return new Result(200);
    }
}

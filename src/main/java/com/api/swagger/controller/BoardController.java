package com.api.swagger.controller;

import com.api.swagger.service.BoardService;
import com.api.swagger.vo.BoardVO;
import com.api.swagger.vo.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080/")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping(value = "/list", name = "게시판 목록")
    public Map<String, Object> boardList(Pagination pagination) {
        return boardService.boardList(pagination);
    }

    @GetMapping(value = "/{seq}", name = "게시판 상세")
    public Map<String, Object> boardDetail(@PathVariable int seq) {
        return boardService.boardDetail(seq);
    }

    @PostMapping(value = "/insert", name = "게시판 등록")
    public int boardInsert(@RequestBody BoardVO boardVO, HttpServletRequest request) {
        return boardService.boardInsert(boardVO, request);
    }

    @PatchMapping(value = "/{seq}", name = "게시판 수정")
    public int boardUpdate(@PathVariable int seq, @RequestBody BoardVO boardVO, HttpServletRequest request) {
        boardService.boardUpdate(boardVO, request);
        return seq;
    }

    @DeleteMapping(value = "/{seq}", name = "게시판 삭제")
    public int boardDelete(@PathVariable int seq) {
        return boardService.boardDelete(seq);
    }
}

package com.api.swagger.controller;

import com.api.swagger.service.BoardService;
import com.api.swagger.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Map<String, Object>> boardList() {
        return boardService.boardList();
    }

    @GetMapping(value = "/{seq}", name = "게시판 상세")
    public Map<String, Object> boardDetail(@PathVariable int seq) {
        return boardService.boardDetail(seq);
    }

    @PostMapping(value = "/insert", name = "게시판 등록")
    public int boardInsert(@RequestBody BoardVO boardVO) {
        log.info("boardVO : ", boardVO);
        System.out.println("boardVO : " + boardVO);
//        int res = boardService.boardInsert(param);
        return 7;
    }

    @PatchMapping(value = "/{seq}", name = "게시판 수정")
    public int boardUpdate(@PathVariable int seq, @RequestParam Map<String, Object> param) {
        log.info("param : ", param, " : ", seq);
        System.out.println("param : " + param + " : " + seq);
        return 8;
    }
}

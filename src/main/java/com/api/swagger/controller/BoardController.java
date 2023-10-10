package com.api.swagger.controller;

import com.api.swagger.service.BoardService;
import com.api.swagger.vo.BoardVO;
import com.api.swagger.vo.Pagination;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin
@Api(tags = {"01. Board Info"}, description = "게시판 서비스")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Operation(summary = "게시판 목록", description = "게시판 목록을 조회합니다.")
    @GetMapping(value = "/list", name = "게시판 목록")
    public Map<String, Object> boardList(Pagination pagination) {
        return boardService.boardList(pagination);
    }

    @Operation(summary = "게시판 상세", description = "게시판 상세를 조회합니다.")
    @GetMapping(value = "/{seq}", name = "게시판 상세")
    public Map<String, Object> boardDetail(@PathVariable int seq) {
        return boardService.boardDetail(seq);
    }

    @Operation(summary = "게시판 등록", description = "게시판을 등록합니다.")
    @PostMapping(value = "/insert", name = "게시판 등록")
    public int boardInsert(@RequestBody BoardVO boardVO, HttpServletRequest request) {
        return boardService.boardInsert(boardVO, request);
    }

    @Operation(summary = "게시판 수정", description = "게시판을 수정합니다.")
    @PatchMapping(value = "/{seq}", name = "게시판 수정")
    public int boardUpdate(@PathVariable int seq, @RequestBody BoardVO boardVO, HttpServletRequest request) {
        boardService.boardUpdate(boardVO, request);
        return seq;
    }

    @Operation(summary = "게시판 삭제", description = "게시판을 삭제합니다.")
    @DeleteMapping(value = "/{seq}", name = "게시판 삭제")
    public int boardDelete(@PathVariable int seq) {
        return boardService.boardDelete(seq);
    }
}

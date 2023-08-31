package com.api.swagger.controller;

import com.api.swagger.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

}

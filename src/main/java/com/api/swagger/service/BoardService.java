package com.api.swagger.service;

import com.api.swagger.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<Map<String, Object>> boardList() {
        return boardMapper.boardList();
    }
}

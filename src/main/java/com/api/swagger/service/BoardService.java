package com.api.swagger.service;

import com.api.swagger.mapper.BoardMapper;
import com.api.swagger.util.CommonUtil;
import com.api.swagger.vo.BoardVO;
import com.api.swagger.vo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public Map<String, Object> boardList(Pagination pagination) {
        Map<String, Object> result = new HashMap<>();
        int totalCount = boardMapper.boardTotalCount();

        Pagination paging = new Pagination(totalCount, pagination.getPage(), pagination.getPageSize(), pagination.getPageSize());
        List<Map<String, Object>> resList = boardMapper.boardList(paging);

        result.put("totalCount", totalCount);
        result.put("resList", resList);
        result.put("pagination", paging);

        return result;
    }

    public Map<String, Object> boardDetail(int seq) {
        return boardMapper.boardDetail(seq);
    }

    public int boardInsert(BoardVO boardVO, HttpServletRequest request) {
        boardVO.setIp(CommonUtil.ipView(request));
        return boardMapper.boardInsert(boardVO);
    }

    public int boardUpdate(BoardVO boardVO, HttpServletRequest request) {
        boardVO.setIp(CommonUtil.ipView(request));
        return boardMapper.boardUpdate(boardVO);
    }

    public int boardDelete(int seq) {
        return boardMapper.boardDelete(seq);
    }
}

package com.api.swagger.mapper;

import com.api.swagger.vo.BoardVO;
import com.api.swagger.vo.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String, Object>> boardList(Pagination pagination);

    int boardTotalCount(Pagination pagination);

    Map<String, Object> boardDetail(int seq);

    int boardInsert(BoardVO boardVO);

    int boardUpdate(BoardVO boardVO);

    int boardDelete(int seq);
}

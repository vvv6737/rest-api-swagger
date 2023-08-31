package com.api.swagger.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String, Object>> boardList();

    Map<String, Object> boardDetail(int seq);

    int boardInsert(Map<String, Object> param);
}

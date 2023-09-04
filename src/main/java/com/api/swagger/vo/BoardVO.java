package com.api.swagger.vo;

import lombok.Data;

@Data
public class BoardVO extends Pagination{

    private int boardSeq;
    private int userSeq;
    private String title;
    private String contents;
    private String author;
    private String ip;

}

package com.api.swagger.vo;

import lombok.Data;

@Data
public class UserVO {
    private int seq;
    private String userId;
    private String userName;
    private String userPassword;
    private String userPhoneNum;
    private String zipCode;
    private String address;
    private String detailAddress;
    private String userEmail;
    private String userRegDate;
}

package com.api.swagger.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="USER")
@Entity
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userSeq;
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

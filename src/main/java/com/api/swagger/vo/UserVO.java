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
    private int USER_SEQ;

    @Column(name="USER_ID")
    private String userId;

    private String USER_PASSWORD;

    private String USER_NAME;

//    private String USER_PHONE1;
//    private String USER_PHONE2;
//    private String USER_PHONE3;
//    private String USER_ZIPCODE;
//    private String USER_ADD;
//    private String USER_DETAIL_ADD;
//    private String USER_EMAIL;
//    private String USER_REG_DATE;
//    private String USER_PHONENUM;
}

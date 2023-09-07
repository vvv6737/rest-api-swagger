package com.api.swagger.mapper;

import com.api.swagger.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<UserVO, Long> {

}

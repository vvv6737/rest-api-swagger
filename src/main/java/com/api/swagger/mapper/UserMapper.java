package com.api.swagger.mapper;

import com.api.swagger.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMapper extends JpaRepository<UserVO, Long> {
    Optional<UserVO> findByUserId(String userId);
}

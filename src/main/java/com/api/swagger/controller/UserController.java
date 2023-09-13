package com.api.swagger.controller;

import com.api.swagger.service.UserService;
import com.api.swagger.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/user")
public class UserController {

    private final JWTUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "/login", name = "유저 로그인")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
        String userId = paramMap.get("user_id");
        String userPw = paramMap.get("user_pw");

        UserDetails loginUser = userService.loadUserByUsername(userId); //userId로 정보 가져오기

        Authentication authentication = authenticationManager.authenticate(     //가져온 정보와 입력한 비밀번호로 검증
                new UsernamePasswordAuthenticationToken(loginUser, userPw)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);   // 검증 통과 후 authentication 세팅
        String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());     //accessToken 생성

        Map<String, Object> result = new HashMap<>();
        result.put("user_id", loginUser.getUsername());
        result.put("user_token", accessToken);
        result.put("user_role", loginUser.getAuthorities().stream().findFirst().get().getAuthority());
        System.out.println("result : " + result);

        return ResponseEntity.ok(result);
    }

}

package com.api.swagger.ex;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("sfjasdjlfhasjlfhasdjkfsdajkfajhsfhaskdjfhasldjfhaskjfhasklj");
    }
}

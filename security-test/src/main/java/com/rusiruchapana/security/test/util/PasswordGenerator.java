package com.rusiruchapana.security.test.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordGenerator {
    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("rusiru"));
        System.out.println(passwordEncoder.encode("admin"));

    }
}

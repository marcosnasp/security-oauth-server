package com.example.spring.security.oauth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utils {

    public static String passwordEncoder(String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }
    
    public static void main(String[] args) {
		System.out.println(passwordEncoder("postman"));
	}
}
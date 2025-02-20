package com.example.springdemo2.dto;

import java.util.List;


public record AdminUserDTO() {
    private static String username;
    private static String password;
    private static List<Integer> roles;
}

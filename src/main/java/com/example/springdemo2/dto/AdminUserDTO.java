package com.example.springdemo2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AdminUserDTO {
    private String username;
    private String password;
    private List<Integer> roles;
}

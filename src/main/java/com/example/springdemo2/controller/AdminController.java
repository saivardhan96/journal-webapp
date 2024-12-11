package com.example.springdemo2.controller;


import com.example.springdemo2.Entity.UserEntity;
import com.example.springdemo2.Service.UserService;
import com.example.springdemo2.cache.AppCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;
    private final AppCache appCache;
    public AdminController(UserService userService, AppCache appCache) {
        this.userService = userService;
        this.appCache = appCache;
    }

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        if(users != null && !users.isEmpty()) return new ResponseEntity<>(users, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clear-cache")
    public void clearCache(){
        appCache.init();
    }

    @PostMapping("/create-admin")
    public void createAdmin(@RequestBody UserEntity user){
        userService.saveNewAdmin(user);
    }

    @DeleteMapping("/{username}")
    public void removeUser(@PathVariable String username){
        userService.deleteByUsername(username);
    }

}

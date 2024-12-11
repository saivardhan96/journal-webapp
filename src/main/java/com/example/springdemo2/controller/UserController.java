package com.example.springdemo2.controller;


import com.example.springdemo2.Entity.UserEntity;
import com.example.springdemo2.Service.UserService;
import com.example.springdemo2.Service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final WeatherService weatherService;

    public UserController(UserService userService, WeatherService weatherService) {
        this.userService = userService;
        this.weatherService = weatherService;
    }

    @PostMapping("/home")
    public ModelAndView homePage(){

        return new ModelAndView("homePage");
    }


    @GetMapping("/greet")
    public ResponseEntity<?> greeting(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>("Hi, "+auth.getName() + ". It feels like " +weatherService.getWeatherResp().getMain().getFeelsLike()  , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> userById(@PathVariable String id){
        return userService.getUserById(id);
    }


    @PutMapping("/update")
    public void updateUser(@RequestBody UserEntity newUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.updateUser(newUser, username);
    }

    @DeleteMapping("{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteByUsername(username);
    }

}

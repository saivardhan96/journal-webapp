package com.example.springdemo2.controller;


import com.example.springdemo2.Entity.UserEntity;
import com.example.springdemo2.Service.EmailService;
import com.example.springdemo2.Service.UserDetailServiceImpl;
import com.example.springdemo2.Service.UserService;
import com.example.springdemo2.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final UserService userService;
    private final EmailService emailService;
    private final UserDetailServiceImpl userDetailService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public PublicController(UserService userService, EmailService emailService, UserDetailServiceImpl userDetailService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.emailService = emailService;
        this.userDetailService = userDetailService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userDetailService.loadUserByUsername(user.getUsername()); // kind of unnecessary
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println("Exception has occurred!!");
            return new ResponseEntity<>("Incorrect username or passcode.", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/new-user")
    public void newUser(@RequestBody UserEntity user){
        userService.saveNewUSer(user);
    }


/*
    @PostMapping("/new-user")
    public ModelAndView saveUSer(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("register");
        UserEntity user = new UserEntity();
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        user.setUsername(name);
        user.setPassword(password);
        userService.saveNewUSer(user);
        String msg = "Hey,Thank you for creating account in our website. We are really happy to have you here and looking" +
                " forward for a beautiful journey with us." +
                " \n" +
                "Your credentials are : \n" +
                "Username: " + name +"\n"+
                "Password: "+password+ "\n"+
                " Feel free to reach out to us in case of any queries.\n" +
                "Thank you, again.\n"+
                "Team - Nirvana...\n" +
                "Contact Us - help@nirvana.com | instagram.com/saivardhan96";
        emailService.ssendMail(request.getParameter("email"),"Welcome to Spring boot",msg);
        modelAndView.setViewName("result");
        modelAndView.addObject("message", "Registered Successfully!!");
        return modelAndView;
    }
*/

    @GetMapping("/health")
    public String healthCheck(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return "Working fine...";
    }


/*    @GetMapping("/login")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }*/

    @GetMapping("/welcome")
    public ModelAndView welcome(@RequestParam(value = "name") String name){
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}

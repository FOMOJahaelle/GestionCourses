package com.shopping.shopping.controllers;

import com.shopping.shopping.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;

    @Autowired
   private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user")
    public String getUser() {
        return "Welcome, User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome, Admin";
    }



}

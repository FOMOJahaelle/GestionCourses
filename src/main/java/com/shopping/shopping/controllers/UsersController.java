package com.shopping.shopping.controllers;

import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.securities.JwtTokenProvider;
import com.shopping.shopping.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

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

    @Operation(summary = "creer un utilisateur", description = "Creer un utilisateur ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user Create",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taches.class))}),
            @ApiResponse(responseCode = "400", description = "user exist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/create")
    public Users createAccount(@RequestBody UserDto user){
        return usersService.CreateAccount(user);


    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome, Admin";
    }



}

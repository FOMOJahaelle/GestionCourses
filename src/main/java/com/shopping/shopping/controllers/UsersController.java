package com.shopping.shopping.controllers;

import com.shopping.shopping.Dto.JwtAuthenticationResponse;
import com.shopping.shopping.Dto.LoginDto;
import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;
//import com.shopping.shopping.securities.JwtTokenProvider;
import com.shopping.shopping.exceptions.PasswordUserNameIncorrectException;
//import com.shopping.shopping.securities.JwtTokenProvider;
import com.shopping.shopping.securities.JwtServiceImpl;
import com.shopping.shopping.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UsersController{

//    @Autowired
//    private AuthenticationManager authenticationManager;


    private PasswordEncoder encoder = new BCryptPasswordEncoder();

//    @Autowired
//    private  final JwtTokenProvider jwtTokenProvider;
//   private final JwtTokenProvider jwtService;

    private final  JwtServiceImpl JwtServiceImpl;
//    @Autowired
   private final UsersService usersService;




    @Operation(summary = "creer un utilisateur", description = "Creer un utilisateur ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user Create",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
            @ApiResponse(responseCode = "400", description = "user exist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/create")
//    @PostMapping("/signup")
    public Users signup(@RequestBody UserDto request) {

        return usersService.signup(request);
    }
//    public Users createAccount(@RequestBody Users user){
//        return usersService.CreateAccount(user);
//
//
//    }

    @Operation(summary = "retourner tous les utilisateurs", description = "Avoir la liste des utlisateurs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
            @ApiResponse(responseCode = "400", description = "not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/all")
    public List<Users> findAll(){

        return  usersService.findAll();
    }



    @Operation(summary = "se connecter a la plateforme", description = "Avoir un utilisateur connecte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user connecte",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
            @ApiResponse(responseCode = "400", description = "not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginDto request) {
        return ResponseEntity.ok(usersService.login(request));
    }

//    public Users Login (@RequestBody @Valid LoginDto login) {
//        Users users = usersService.findByUserName(login.getUsername());
//        try {
//            if (users != null && encoder.matches(login.getPassword(), users.getPassword())) {
//                users.setUserName(users.getUsername());
//                users.setPassWord(users.getPassword());
////                users.setToken(JwtServiceImpl.generateToken(users));
//                usersService.save(users);
//
//            } else {
////                System.out.println("connexion a echoue");
//
//                throw new PasswordUserNameIncorrectException("Le nom d'utilisateur ou le mot de passe incorrect");
//            }
//
//        }catch (Exception e){
//            users.setUserName(users.getUsername());
//            usersService.save(null);
//            throw new PasswordUserNameIncorrectException("Le nom d'utilisateur ou le mot de passe incorrect");
//        }
//        System.out.println("connexion reussie");
//       return users;
////       throw new ConnexionReussieException("connexion avec succes");
//    }
}

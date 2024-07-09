package com.shopping.shopping.services;

import com.shopping.shopping.Dto.JwtAuthenticationResponse;
import com.shopping.shopping.Dto.LoginDto;
import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface  UsersService {
    //    public UserDetailsService userDetailsService() {
//    UserDetailsService userDetailsService();


    Users getOne (Long id);
    // retourne toutes les utilisateurs
    List<Users> findAll ();

    // retourne un utilisateur a partir de son nom d'utilisateur
  Users findByUserName(String username);

    Users CreateAccount(Users user);
    Users save(Users user);

    Users signup(UserDto request);

    JwtAuthenticationResponse login(LoginDto request);

//    Users loadUserByUsername(String username) throws UsernameNotFoundException;
}

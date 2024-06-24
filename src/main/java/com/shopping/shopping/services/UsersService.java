package com.shopping.shopping.services;

import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;

import java.util.List;
import java.util.Optional;

public interface  UsersService {

    Users getOne (Long id);
    // retourne toutes les utilisateurs
    List<Users> findAll ();

    // retourne un utilisateur a partir de son nom d'utilisateur
     Users findByUserName(String username);

    Users CreateAccount(UserDto user);
}

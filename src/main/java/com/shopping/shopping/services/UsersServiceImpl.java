package com.shopping.shopping.services;

import com.shopping.shopping.Dto.JwtAuthenticationResponse;
import com.shopping.shopping.Dto.LoginDto;
import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.repositories.UserRepository;
import com.shopping.shopping.securities.JwtService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
@AllArgsConstructor
//@Transactional
//@Qualifier("userDetailsService")

public class UsersServiceImpl implements  UsersService{
    //@Autowired

    private final UserRepository userRepository;
//    @Autowired

    private final PasswordEncoder passwordEncoder;
//    @Autowired

    private final  JwtService jwtService;
//    @Autowired

    private final  AuthenticationManager authenticationManager;


    @Override
    public Users getOne(Long id) {

        return userRepository.getOne(id);
    }

    @Override
    public List<Users> findAll() {

        return userRepository.findAll();
    }

    @Override
    public Users findByUserName(String username) {

        return  userRepository.findByUserName(username);
    }

    @Override
    public Users CreateAccount(Users user) {

        return userRepository.save(user);
    }

    @Override
    public Users save(Users user) {

        return userRepository.save(user);
    }

    @Override
    public Users signup(UserDto request) {
        var user = Users.builder().userName(request.getUsername())
                .passWord(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()).build();
        userRepository.save(user);
//        var jwt = jwtService.generateToken(user);
        return userRepository.save(user);
    }

    @Override
    public JwtAuthenticationResponse login(LoginDto request) {
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUserName(request.getUsername());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }



}

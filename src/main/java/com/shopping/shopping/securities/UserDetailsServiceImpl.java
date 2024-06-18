package com.shopping.shopping.securities;

import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private   UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = UserRepository.findByUserName(username).orElse(null);
//        if(user == null){
//            throw new UsernameNotFoundException(username);
//        }
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
  return null;
    }

}

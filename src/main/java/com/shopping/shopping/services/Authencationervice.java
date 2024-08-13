package com.shopping.shopping.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface Authencationervice {

    UserDetailsService userDetailsService();


}

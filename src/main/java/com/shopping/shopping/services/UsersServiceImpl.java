package com.shopping.shopping.services;

import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UsersServiceImpl implements  UsersService{

    @Autowired
    private  final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());


    public UsersServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

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
}

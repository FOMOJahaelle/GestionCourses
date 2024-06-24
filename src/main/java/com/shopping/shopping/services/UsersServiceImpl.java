package com.shopping.shopping.services;

import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.enums.Role;
import com.shopping.shopping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
//@Qualifier("userDetailsService")

public class UsersServiceImpl implements  UsersService{
    @Autowired
    private  final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    private Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());


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

    @Override
    public  Users CreateAccount(UserDto user){
        Users users = new Users();
        users.setUserName(user.getUserName());
        users.setPassWord(passwordEncoder.encode(users.getPassword()));

//        if(userRepository.findAll().isEmpty()) {
//            user.setRole("ROOT");
//        }
//        switch (user.getRole()) {
//            case "ADMIN":
//                users.setRole(Role.ADMIN);
//                break;
//            default:
//                users.setRole(Role.ROOT);
//                break;
//        }
        return userRepository.save(users);


    }
}

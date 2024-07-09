//package com.shopping.shopping.securities;
//
//import com.shopping.shopping.entyties.Users;
//import com.shopping.shopping.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        Users user = userRepository.findByUserName(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//
//        return new MyUserDetails(user);
//    }
//
//
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        Users user = userRepository.findByUserName(username);
////        if(user == null){
////            throw new UsernameNotFoundException(username);
////        }
////
////        Set<GrantedAuthority> authorities = new HashSet<>();
////        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
////
////        return new org.springframework.security.core.userdetails.User
////                (user.getUserName(), user.getPassword(), authorities);
////    }
//
////       @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        Users user = userRepository.findByUserName(username);
////           return new User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user.getRole()));
////        if(user == null){
////            throw new UsernameNotFoundException(username);
////        }
////        Set<GrantedAuthority> authorities = new HashSet<>();
////        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
////        return new org.springframework.security.core.userdetails.User(user.getUserName(),
////                user.getPassword(),authorities);
////
////    }
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////            return userRepository.findByUserName(username)
////                    .orElseThrow(()->
////                            new UsernameNotFoundException(String.format("username %s not found",username))
////                            );
////
////    }
//
//
////    @Autowired
////    private UserRepository userRepository;
//
////    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////        logger.debug("Entering in loadUserByUsername Method...");
////        Optional<Users> user = userRepository.findByUserName(username);
////        if(user == null){
////            logger.error("Username not found: " + username);
////            throw new UsernameNotFoundException("could not found user..!!");
////        }
////        logger.info("User Authenticated Successfully..!!!");
////        return new CustomUserDetails(user);
////    }
//}
package com.shopping.shopping;

import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.enums.Role;
import com.shopping.shopping.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@AllArgsConstructor
@SpringBootApplication
@EnableScheduling
public class ShoppingApplication {

//	implements CommandLineRunner
//	private final UserRepository userRepository;
//	@Autowired
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


//	private final BCryptPasswordEncoder passwordEncoder;


	public static void main(String[] args) {

		SpringApplication.run(ShoppingApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Users users = new Users();
//		users.setUserName("yonah");
//		users.setPassWord(passwordEncoder.encode("yonah"));
//		users.setRole(Role.USER);
//
//		Users users1 = new Users();
//		users1.setUserName("jahaelle");
//		users1.setPassWord(passwordEncoder.encode("passion"));
//     	users1.setRole(Role.ADMIN);
//
//		if(userRepository.findAll().isEmpty()) {
//			 userRepository.save(users);
//		 userRepository.save(users1);
//      }
//
//	}
}

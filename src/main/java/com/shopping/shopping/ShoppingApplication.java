package com.shopping.shopping;

import com.shopping.shopping.entyties.Users;
import com.shopping.shopping.enums.Role;
import com.shopping.shopping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
@EnableScheduling
public class ShoppingApplication implements CommandLineRunner {

//	@Bean
//	public AuditorAware<String> auditorAware() {
//
//		return new SpringSecurityAuditorAware();
//	}
	@Autowired
	UserRepository userRepository;
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	public static void main(String[] args) {

		SpringApplication.run(ShoppingApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		Users users = new Users();
		users.setUserName("yonah");
		users.setPassWord(passwordEncoder.encode("yonah"));
		users.setRole(Role.ROOT);
		if(userRepository.findAll().isEmpty()) {
			 userRepository.save(users);
      }

	}
}

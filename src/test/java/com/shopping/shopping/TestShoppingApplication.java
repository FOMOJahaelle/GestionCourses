package com.shopping.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestShoppingApplication {


	public static void main(String[] args) {
		SpringApplication.from(ShoppingApplication::main).with(TestShoppingApplication.class).run(args);
	}

}

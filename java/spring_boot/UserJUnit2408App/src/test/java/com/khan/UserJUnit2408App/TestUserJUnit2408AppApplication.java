package com.khan.UserJUnit2408App;

import org.springframework.boot.SpringApplication;

public class TestUserJUnit2408AppApplication {

	public static void main(String[] args) {
		SpringApplication.from(UserJUnit2408AppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

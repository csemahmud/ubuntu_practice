package com.khan.UserJUnit2409App;

import org.springframework.boot.SpringApplication;

public class TestUserJUnit2409AppApplication {

	public static void main(String[] args) {
		SpringApplication.from(UserJUnit2409AppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

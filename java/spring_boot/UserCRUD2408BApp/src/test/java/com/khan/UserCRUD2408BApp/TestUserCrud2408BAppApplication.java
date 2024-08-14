package com.khan.UserCRUD2408BApp;

import org.springframework.boot.SpringApplication;

public class TestUserCrud2408BAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(UserCrud2408BAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

package com.khan.UserJUnit2408App;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class UserJUnit2408AppApplicationTests {

	@Test
	void contextLoads() {
	}

}

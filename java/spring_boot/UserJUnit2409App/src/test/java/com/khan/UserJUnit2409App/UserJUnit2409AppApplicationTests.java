package com.khan.UserJUnit2409App;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class UserJUnit2409AppApplicationTests {

	@Test
	public void contextLoads() {
	}

}

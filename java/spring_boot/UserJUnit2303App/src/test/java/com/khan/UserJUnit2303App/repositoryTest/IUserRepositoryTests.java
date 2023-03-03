/**
 * 
 */
package com.khan.UserJUnit2303App.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khan.UserJUnit2303App.UserJUnit2303AppApplication;
import com.khan.UserJUnit2303App.models.UserDAO;
import com.khan.UserJUnit2303App.repository.IUserRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = UserJUnit2303AppApplication.class)
public class IUserRepositoryTests {
	
	private int testUserId = 0;
	
	@Autowired
	@Mock
	private IUserRepository userRepository;
	
	// JUnit Test For saveUser
	
	@Test
	public void saveUserTest() {
		
		final String NAME = "MAHMUDUL HASAN KHAN TEST";
		final String EMAIL = "cse.mahmudul.test@gmail.com";
		
		UserDAO user = null;
		
		user = userRepository.findByName(NAME);
		
		if(user == null) {
			
			user = userRepository.findByEmail(EMAIL);
			
			if(user == null) {
				
				user = UserDAO.builder()
						.name(NAME)
						.email(EMAIL)
						.domain("full-stack")
						.age(30)
						.experience(5)
						.salary(20000)
						.build();
				
				userRepository.save(user);
				
			}
		}
		
		testUserId = user.getId();
		assertThat(testUserId).isGreaterThan(0);
	}
	
//	@Test
//	public void getUserTest() {
//		
//		UserDAO user = userRepository.findById(1).get();
//		
//		if(user == null) {
//			
//			final String NAME = "MAHMUDUL HASAN KHAN TEST";
//			final String EMAIL = "cse.mahmudul.test@gmail.com";
//			
//			user = userRepository.findByName(NAME);
//			
//			if(user == null) {
//				
//				user = userRepository.findByEmail(EMAIL);
//				
//				if(user == null) {
//					
//					user = UserDAO.builder()
//							.name(NAME)
//							.email(EMAIL)
//							.domain("full-stack")
//							.age(30)
//							.experience(5)
//							.salary(20000)
//							.build();
//					
//					userRepository.save(user);
//					
//				}
//			}
//			
//			testUserId = user.getId();
//			user = userRepository.findById(testUserId).get();
//		}
//		
//		assertThat(user.getId()).isEqualTo(testUserId);
//		
//	}
	
	@Test
	public void getUserListTest() {
		
		final String NAME = "MAHMUDUL HASAN KHAN TEST";
		final String EMAIL = "cse.mahmudul.test@gmail.com";
		
		UserDAO user = null;
		
		user = userRepository.findByName(NAME);
		
		if(user == null) {
			
			user = userRepository.findByEmail(EMAIL);
			
			if(user == null) {
				
				user = UserDAO.builder()
						.name(NAME)
						.email(EMAIL)
						.domain("full-stack")
						.age(30)
						.experience(5)
						.salary(20000)
						.build();
				
				userRepository.save(user);
				
			}
		}
		
		testUserId = user.getId();
		
		List <UserDAO> userList = userRepository.findAll();
		
		assertThat(userList.size()).isGreaterThan(0);
		
	}
	
}
		
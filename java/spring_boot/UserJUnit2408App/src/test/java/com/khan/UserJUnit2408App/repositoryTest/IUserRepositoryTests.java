/**
 * 
 */
package com.khan.UserJUnit2408App.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khan.UserJUnit2408App.UserJUnit2408AppApplication;
import com.khan.UserJUnit2408App.models.UserDAO;
import com.khan.UserJUnit2408App.repository.IUserRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = UserJUnit2408AppApplication.class)
public class IUserRepositoryTests {
	
	private int testUserId = 0;
	
	@Autowired
	@Mock
	private IUserRepository userRepository;
	
	// JUnit test for saveUser
	
	@Test
	public void saveUserTest() {
		
		final String NAME = "MAHMUDUL HASAN KHAN TEST";
		final String EMAIL = "lone.wolf.mahmud.test@gmail.com";
		
		UserDAO user = null;
		
		user = userRepository.findByName(NAME);
		
		if(user == null) {
			
			user = userRepository.findByEmail(EMAIL);
			
			if(user == null) {
				
				user = UserDAO.builder()
						.name(NAME)
						.email(EMAIL)
						.domain("full-stack")
						.age(35)
						.experience(5)
						.salary(250000)
						.build();
				
				userRepository.save(user);
				
			}
			
		}
		
		testUserId = user.getId();
		assertThat(testUserId).isGreaterThan(0);
		
	}
	
	@Test
	public void getUserTest() {
		
		UserDAO user = userRepository.findById(1).get();
		
		if(user == null) {
			
			final String NAME = "MAHMUDUL HASAN KHAN TEST";
			final String EMAIL = "lone.wolf.mahmud.test@gmail.com";
			
			user = userRepository.findByName(NAME);
			
			if(user == null) {
				
				user = userRepository.findByEmail(EMAIL);
				
				if(user == null) {
					
					user = UserDAO.builder()
							.name(NAME)
							.email(EMAIL)
							.domain("full-stack")
							.age(35)
							.experience(5)
							.salary(250000)
							.build();
					
					userRepository.save(user);
					
				}
			}
			
			testUserId = user.getId();
			user = userRepository.findById(testUserId).get();
		}
		
		assertThat(user.getId()).isEqualTo(testUserId);
		
	}
	
	@Test
	public void findAllUserTest() {
		
		final String NAME = "MAHMUDUL HASAN KHAN TEST";
		final String EMAIL = "lone.wolf.mahmud.test@gmail.com";
		
		UserDAO user = null;
		
		user = userRepository.findByName(NAME);
		
		if(user == null) {
			
			user = userRepository.findByEmail(EMAIL);
			
			if(user == null) {
				
				user = UserDAO.builder()
						.name(NAME)
						.email(EMAIL)
						.domain("full-stack")
						.age(35)
						.experience(5)
						.salary(250000)
						.build();
				
				userRepository.save(user);
				
			}
			
		}
		
		testUserId = user.getId();
		
		List <UserDAO> userList = userRepository.findAll();
		
		assertThat(userList.get(userList.size() - 1).getId()).isEqualTo(testUserId);
		
	}
	
}

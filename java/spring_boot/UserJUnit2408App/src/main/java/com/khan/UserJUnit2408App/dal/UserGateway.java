/**
 * 
 */
package com.khan.UserJUnit2408App.dal;

import java.util.List;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.UserJUnit2408App.models.UserDAO;
import com.khan.UserJUnit2408App.repository.IUserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserGateway {
	
	@Autowired
	private IUserRepository userRepository;
	
	public UserDAO saveUser(UserDAO user) {
		return userRepository.save(user);
	}
	
	public List<UserDAO> saveUsers(List<UserDAO> userList){
		return userRepository.saveAll(userList);
	}
	
	public List<UserDAO> getAllUsers(){
		return userRepository.findAll();
	}
	
	public UserDAO getUserById(int id){
		return userRepository.findById(id).orElse(null);
	}
	
	public UserDAO getUserByName(String name){
		return userRepository.findByName(name);
	}
	
	public UserDAO getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public UserDAO deleteUser(int id) throws Exception {
		UserDAO existingUser = userRepository.findById(id).orElse(null);
		
		try {
			userRepository.delete(existingUser);
		} catch (IllegalIdentifierException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			throw ex;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			throw ex;
		}
		
		return existingUser;
	}
	
	public UserDAO updateUser(UserDAO user){
		return userRepository.save(user);
	}
	
}

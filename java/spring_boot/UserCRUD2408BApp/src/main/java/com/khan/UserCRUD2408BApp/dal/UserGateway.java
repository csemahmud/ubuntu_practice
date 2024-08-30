/**
 * 
 */
package com.khan.UserCRUD2408BApp.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.UserCRUD2408BApp.models.UserDAO;
import com.khan.UserCRUD2408BApp.repository.IUserRepository;

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
	
	public List <UserDAO> getAllUsers(){
		return userRepository.findAll();
	}
	
	public UserDAO getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public UserDAO getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public UserDAO getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User [" + id + "] has been DELETED successfully";
	}
	
	public UserDAO updateUser(UserDAO user) {
		return userRepository.save(user);
	}
}

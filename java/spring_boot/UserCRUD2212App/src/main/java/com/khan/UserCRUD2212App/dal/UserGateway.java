/**
 * 
 */
package com.khan.UserCRUD2212App.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.UserCRUD2212App.models.UserDAO;
import com.khan.UserCRUD2212App.repository.IUserRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Service
public class UserGateway {
	
	@Autowired
	private IUserRepository userRepository;

	/**
	 * 
	 */
	public UserGateway() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDAO saveUser(UserDAO user) {
		return userRepository.save(user);
	}
	
	public List<UserDAO> saveUsers(List<UserDAO> userList) {
		return userRepository.saveAll(userList);
	}
	
	public List<UserDAO> getAllUsers() {
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
		return "User [" + id + "] has been DELETED successfully .";
	}
	
	public UserDAO updateUser(UserDAO user) {
		UserDAO existingUser = userRepository.findById(user.getId()).orElse(null);
		if(existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setDomain(user.getDomain());
			existingUser.setAge(user.getAge());
			existingUser.setExperience(user.getExperience());
			existingUser.setSalary(user.getSalary());
		}
		return userRepository.save(existingUser);
	}

}

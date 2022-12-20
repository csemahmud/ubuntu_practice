/**
 * 
 */
package com.khan.UserCRUD2212App.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khan.UserCRUD2212App.dal.UserGateway;
import com.khan.UserCRUD2212App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserManager {
	
	@Autowired
	private UserGateway aUserGateway;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDAO user) {
		try {
			return aUserGateway.saveUser(user)
					+ " has been SAVED successfully.";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@PostMapping("/addUsers")
	public String addUsers(@RequestBody List<UserDAO> userList) {
		try {
			return aUserGateway.saveUsers(userList)
					+ " has been SAVED successfully.";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@GetMapping("/users")
	public List<UserDAO> findAllUsers(){
		return aUserGateway.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public UserDAO findUserById(@PathVariable int id) {
		return aUserGateway.getUserById(id);
	}
	
	@GetMapping("/userByName/{name}")
	public UserDAO findUserById(@PathVariable String name) {
		return aUserGateway.getUserByName(name);
	}
	
	@GetMapping("/userByEmail/{email}")
	public UserDAO findUserByEmail(@PathVariable String email) {
		return aUserGateway.getUserByEmail(email);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody UserDAO user) {
		try {
			return aUserGateway.updateUser(user)
					+ " has been UPDATED successfully.";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return aUserGateway.deleteUser(id);
	}

	/**
	 * 
	 */
	public UserManager() {
		// TODO Auto-generated constructor stub
	}

}

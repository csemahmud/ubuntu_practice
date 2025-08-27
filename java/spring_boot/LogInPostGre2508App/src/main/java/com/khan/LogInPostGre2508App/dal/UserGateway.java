/**
 * 
 */
package com.khan.LogInPostGre2508App.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.LogInPostGre2508App.util.UserValidator;
import com.khan.LogInPostGre2508App.models.UserDAO;
import com.khan.LogInPostGre2508App.repository.IUserRepository;

import jakarta.annotation.PostConstruct;
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

    private UserValidator validator;

    @PostConstruct
    public void init() {
        validator = new UserValidator(userRepository);
    }

    public UserDAO saveUser(UserDAO user) {
        validator.validateSaveOrUpdate(user);
        return userRepository.save(user);
    }

    public List<UserDAO> saveUsers(List<UserDAO> userList) {
        for (UserDAO user : userList) {
            validator.validateSaveOrUpdate(user);
        }
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

    public List<UserDAO> getUsersByCategoryId(Integer categoryId) {
        return userRepository.getUsersByCategoryId(categoryId);
    }

    public UserDAO deleteUser(int id) throws Exception {
        UserDAO existingUser = userRepository.findById(id).orElse(null);
        validator.validateDelete(existingUser);
        userRepository.delete(existingUser);
        return existingUser;
    }

    public UserDAO updateUser(UserDAO user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided for update.");
        }
        validator.validateSaveOrUpdate(user);
        return userRepository.save(user);
    }
}
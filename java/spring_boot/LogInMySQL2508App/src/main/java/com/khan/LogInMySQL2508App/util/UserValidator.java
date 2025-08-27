package com.khan.LogInMySQL2508App.util;

import com.khan.LogInMySQL2508App.models.UserDAO;
import com.khan.LogInMySQL2508App.repository.IUserRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

public class UserValidator {

    private final IUserRepository userRepository;

    public UserValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Validate uniqueness of user name
     */
    public void validateUniqueName(UserDAO user) {
        UserDAO existing = userRepository.findByName(user.getName());
        if (existing != null && !existing.getId().equals(user.getId())) {
            throw new IllegalArgumentException("User name '" + user.getName() + "' already exists.");
        }
    }

    /**
     * Validate uniqueness of email
     */
    public void validateUniqueEmail(UserDAO user) {
        UserDAO existing = userRepository.findByEmail(user.getEmail());
        if (existing != null && !existing.getId().equals(user.getId())) {
            throw new IllegalArgumentException("Email '" + user.getEmail() + "' is already in use.");
        }
    }

    /**
     * Validate user deletion (additional rules can be added here)
     */
    public void validateDelete(UserDAO user) {
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
    }

    /**
     * Validate before saving or updating a user
     */
    public void validateSaveOrUpdate(UserDAO user) {
        validateUniqueName(user);
        validateUniqueEmail(user);
    }
}

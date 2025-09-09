package com.khan.LogInPostGre2508App.util;

import java.util.Optional;

import com.khan.LogInPostGre2508App.dto.UserDTO;
import com.khan.LogInPostGre2508App.models.UserDAO;
import com.khan.LogInPostGre2508App.repository.IUserRepository;

/**
 * UserValidator: Validates business rules for UserDTO
 * Uses repository to check uniqueness and deletion constraints
 * Author: KHAN MAHMUDUL HASAN CSE BD JP
 */
public class UserValidator {

    private final IUserRepository userRepository;

    public UserValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ------------------ Uniqueness Checks ------------------

    /**
     * Validate that the user name is unique (ignoring current entity)
     */
    public void validateUniqueName(UserDTO userDTO) {
        Optional<UserDAO> existing = userRepository.findByName(userDTO.getName());
        if (existing.isPresent() && !existing.get().getId().equals(userDTO.getId())) {
            throw new IllegalArgumentException(
                "User name '" + userDTO.getName() + "' already exists."
            );
        }
    }

    /**
     * Validate that the email is unique (ignoring current entity)
     */
    public void validateUniqueEmail(UserDTO userDTO) {
        Optional<UserDAO> existing = userRepository.findByEmail(userDTO.getEmail());
        if (existing.isPresent() && !existing.get().getId().equals(userDTO.getId())) {
            throw new IllegalArgumentException(
                "Email '" + userDTO.getEmail() + "' is already in use."
            );
        }
    }

    // ------------------ Deletion Check ------------------

    /**
     * Validate user deletion
     */
    public void validateDelete(UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() == null) {
            throw new IllegalArgumentException("User not found.");
        }
    }

    // ------------------ Save / Update Validation ------------------

    /**
     * Validate before saving or updating a user DTO
     * Checks for uniqueness of name and email
     */
    public void validateSaveOrUpdate(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User DTO cannot be null.");
        }
        validateUniqueName(userDTO);
        validateUniqueEmail(userDTO);
    }
}

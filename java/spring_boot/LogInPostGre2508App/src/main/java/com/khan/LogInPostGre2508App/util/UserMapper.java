package com.khan.LogInPostGre2508App.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.khan.LogInPostGre2508App.dto.UserDTO;
import com.khan.LogInPostGre2508App.models.CategoryDAO;
import com.khan.LogInPostGre2508App.models.UserDAO;

/**
 * UserMapper: Maps between UserDTO and UserDAO
 * Uses BCryptPasswordEncoder for hashing passwords
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
public class UserMapper {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ------------------ DTO -> Entity ------------------
    public static UserDAO toEntity(UserDTO dto, CategoryDAO category) {
        UserDAO user = new UserDAO();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setCategory(category);

        // Hash rawPassword only if provided
        if (dto.getRawPassword() != null && !dto.getRawPassword().isBlank()) {
            user.setHashedPassword(passwordEncoder.encode(dto.getRawPassword()));
        }

        user.setDomain(dto.getDomain());
        user.setAge(dto.getAge());
        user.setExperience(dto.getExperience());
        user.setSalary(dto.getSalary());
        user.setImagePath(dto.getImagePath());
        user.setImageName(dto.getImageName());
        return user;
    }

    // ------------------ Entity -> DTO ------------------
    public static UserDTO toDTO(UserDAO user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCategoryId(user.getCategory() != null ? user.getCategory().getId() : null);
        dto.setDomain(user.getDomain());
        dto.setAge(user.getAge());
        dto.setExperience(user.getExperience());
        dto.setSalary(user.getSalary());
        dto.setImagePath(user.getImagePath());
        dto.setImageName(user.getImageName());

        // ✅ Include hashed password for login
        dto.setHashedPassword(user.getHashedPassword());
        return dto;
    }
}

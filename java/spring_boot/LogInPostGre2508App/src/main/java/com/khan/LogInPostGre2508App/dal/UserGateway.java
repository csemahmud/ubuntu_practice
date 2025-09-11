package com.khan.LogInPostGre2508App.dal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.khan.LogInPostGre2508App.dto.UserDTO;
import com.khan.LogInPostGre2508App.models.UserDAO;
import com.khan.LogInPostGre2508App.models.CategoryDAO;
import com.khan.LogInPostGre2508App.repository.IUserRepository;
import com.khan.LogInPostGre2508App.repository.ICategoryRepository;
import com.khan.LogInPostGre2508App.util.UserMapper;
import com.khan.LogInPostGre2508App.util.UserValidator;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * UserGateway: Handles CRUD operations for User using DTOs
 * Validates business rules and maps between DTO and DAO
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserGateway {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    private UserValidator validator;

    @PostConstruct
    public void init() {
        validator = new UserValidator(userRepository);
    }

    // ------------------ Create / Save ------------------

    public UserDTO saveUser(UserDTO userDTO) {
        System.out.println("Saving UserDTO: " + userDTO);
        if (userDTO.getCategoryId() == null) {
            throw new IllegalArgumentException("CategoryId is required but was null");
        }

        CategoryDAO category = categoryRepository.findById(userDTO.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("Category not found with id " + userDTO.getCategoryId()));

        validator.validateSaveOrUpdate(userDTO);
        UserDAO saved = userRepository.save(UserMapper.toEntity(userDTO, category));
        return UserMapper.toDTO(saved);
    }

    public List<UserDTO> saveUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(dto -> {
            CategoryDAO category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            validator.validateSaveOrUpdate(dto);
            UserDAO saved = userRepository.save(UserMapper.toEntity(dto, category));
            return UserMapper.toDTO(saved);
        }).collect(Collectors.toList());
    }

    // ------------------ Read ------------------

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(int id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public UserDTO getUserByName(String name) {
        return userRepository.findByName(name)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public List<UserDTO> getUsersByCategoryId(Integer categoryId) {
        return userRepository.findByCategoryId(categoryId).stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ------------------ Update ------------------

    public UserDTO updateUser(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided for update.");
        }

        // Fetch managed user entity
        UserDAO existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Fetch category
        CategoryDAO category = categoryRepository.findById(userDTO.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        // Validate DTO
        validator.validateSaveOrUpdate(userDTO);

        // Update fields
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setCategory(category);
        existingUser.setDomain(userDTO.getDomain());
        existingUser.setAge(userDTO.getAge());
        existingUser.setExperience(userDTO.getExperience());
        existingUser.setSalary(userDTO.getSalary());
        existingUser.setImagePath(userDTO.getImagePath());
        existingUser.setImageName(userDTO.getImageName());

        // Only update password if rawPassword is provided
        if (userDTO.getRawPassword() != null && !userDTO.getRawPassword().isBlank()) {
            existingUser.setHashedPassword(
                new BCryptPasswordEncoder().encode(userDTO.getRawPassword())
            );
        }

        // Save the managed entity
        UserDAO updated = userRepository.save(existingUser);

        return UserMapper.toDTO(updated);
    }

    // ------------------ Delete ------------------

    public UserDTO deleteUser(int id) {
        UserDAO existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found for deletion."));
        userRepository.delete(existingUser);
        return UserMapper.toDTO(existingUser);
    }
}

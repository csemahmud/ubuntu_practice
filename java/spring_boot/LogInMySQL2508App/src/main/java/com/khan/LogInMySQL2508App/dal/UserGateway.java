package com.khan.LogInMySQL2508App.dal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.khan.LogInMySQL2508App.dto.UserDTO;
import com.khan.LogInMySQL2508App.models.UserDAO;
import com.khan.LogInMySQL2508App.models.CategoryDAO;
import com.khan.LogInMySQL2508App.repository.IUserRepository;
import com.khan.LogInMySQL2508App.repository.ICategoryRepository;
import com.khan.LogInMySQL2508App.util.UserMapper;
import com.khan.LogInMySQL2508App.util.UserValidator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * UserGateway: Handles CRUD operations for User using DTOs
 * Validates business rules and maps between DTO and DAO
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserGateway {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private UserValidator validator;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ------------------ Create / Save ------------------

    public UserDTO saveUser(UserDTO userDTO) {

        if (userDTO.getCategoryId() == null) {
            throw new IllegalArgumentException("CategoryId is required");
        }

        CategoryDAO category = categoryRepository.findById(userDTO.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        validator.validateSaveOrUpdate(userDTO);

        UserDAO saved = userRepository.save(
                UserMapper.toEntity(userDTO, category)
        );

        return UserMapper.toDTO(saved);
    }
    
    public List<UserDTO> saveUsers(List<UserDTO> userDTOs) {

        List<UserDAO> entities = userDTOs.stream().map(dto -> {
            CategoryDAO category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));

            validator.validateSaveOrUpdate(dto);

            return UserMapper.toEntity(dto, category);
        }).collect(Collectors.toList());

        List<UserDAO> saved = userRepository.saveAll(entities);

        return saved.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ------------------ Login ------------------

    public UserDTO login(String email, String rawPassword) {

        UserDAO user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(rawPassword, user.getHashedPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Convert to DTO
        UserDTO dto = UserMapper.toDTO(user);

        // Add JWT later here
        // dto.setToken(jwtUtil.generateToken(user.getEmail()));

        return dto;
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

        categoryRepository.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        return userRepository.findByCategoryId(categoryId).stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ------------------ Update ------------------

    public UserDTO updateUser(UserDTO userDTO) {

        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided.");
        }

        UserDAO existing = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        CategoryDAO category = categoryRepository.findById(userDTO.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        validator.validateSaveOrUpdate(userDTO);

        existing.setName(userDTO.getName());
        existing.setEmail(userDTO.getEmail());
        existing.setCategory(category);
        existing.setDomain(userDTO.getDomain());
        existing.setAge(userDTO.getAge());
        existing.setExperience(userDTO.getExperience());
        existing.setSalary(userDTO.getSalary());
        existing.setImagePath(userDTO.getImagePath());
        existing.setImageName(userDTO.getImageName());

        if (userDTO.getRawPassword() != null && !userDTO.getRawPassword().isBlank()) {
            existing.setHashedPassword(
                passwordEncoder.encode(userDTO.getRawPassword())
            );
        }

        return UserMapper.toDTO(userRepository.save(existing));
    }

    // ------------------ Delete ------------------

    public UserDTO deleteUser(int id) {
        UserDAO existing = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.delete(existing);
        return UserMapper.toDTO(existing);
    }
}

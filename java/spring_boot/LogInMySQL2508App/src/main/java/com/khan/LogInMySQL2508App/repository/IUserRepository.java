package com.khan.LogInMySQL2508App.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.LogInMySQL2508App.models.UserDAO;

/**
 * Repository for UserDAO entity
 * Provides CRUD operations and custom finders
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 */
@Repository
public interface IUserRepository extends JpaRepository<UserDAO, Integer> {

    // Find a single user by name
    Optional<UserDAO> findByName(String name);

    // Find a single user by email
    Optional<UserDAO> findByEmail(String email);

    // Fetch all users for a given category ID
    List<UserDAO> findByCategoryId(Integer categoryId);

    // Optional: check existence for validation
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}

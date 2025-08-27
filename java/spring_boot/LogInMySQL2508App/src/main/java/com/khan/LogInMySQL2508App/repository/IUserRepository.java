/**
 * 
 */
package com.khan.LogInMySQL2508App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.LogInMySQL2508App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Repository
public interface IUserRepository extends JpaRepository<UserDAO, Integer> {
	UserDAO findByName(String name);
	UserDAO findByEmail(String email);

    // Fetch all users for a given category ID
    List<UserDAO> getUsersByCategoryId(Integer categoryId);
}

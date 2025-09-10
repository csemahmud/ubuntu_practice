/**
 * 
 */
package com.khan.LogInPostGre2508App.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.LogInPostGre2508App.models.CategoryDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryDAO, Integer> {

    // Case-sensitive search
	Optional<CategoryDAO> findByName(String name);

    // Case-insensitive search
	Optional<CategoryDAO> findByNameIgnoreCase(String name);
	
	// Fetch all categories for a given name ignoring case
	List<CategoryDAO> findAllByNameContainingIgnoreCase(String keyword);
	
	// Optional: check existence for validation
	boolean existsByName(String name);
	boolean existsByNameIgnoreCase(String name);
}

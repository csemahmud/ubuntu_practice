/**
 * 
 */
package com.khan.LogInMySQL2508App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.LogInMySQL2508App.models.CategoryDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryDAO, Integer> {

    // Case-sensitive search
    CategoryDAO findByName(String name);

    // Case-insensitive search
    CategoryDAO findByNameIgnoreCase(String name);
}

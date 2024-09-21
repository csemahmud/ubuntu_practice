/**
 * 
 */
package com.khan.UserJUnit2409App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.UserJUnit2409App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Repository
public interface IUserRepository extends JpaRepository<com.khan.UserJUnit2409App.models.UserDAO, Integer> {
	UserDAO findByName(String name);
	UserDAO findByEmail(String email);
}

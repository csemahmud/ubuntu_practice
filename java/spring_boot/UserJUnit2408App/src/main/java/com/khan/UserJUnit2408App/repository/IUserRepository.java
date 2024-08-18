/**
 * 
 */
package com.khan.UserJUnit2408App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.UserJUnit2408App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Repository
public interface IUserRepository extends JpaRepository<UserDAO, Integer> {
	UserDAO findByName(String name);
	UserDAO findByEmail(String email);
}

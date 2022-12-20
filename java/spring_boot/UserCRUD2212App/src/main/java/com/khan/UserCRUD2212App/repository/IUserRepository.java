/**
 * 
 */
package com.khan.UserCRUD2212App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.UserCRUD2212App.models.UserDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public interface IUserRepository extends JpaRepository<UserDAO, Integer> {
	UserDAO findByName(String name);
	UserDAO findByEmail(String email);
}

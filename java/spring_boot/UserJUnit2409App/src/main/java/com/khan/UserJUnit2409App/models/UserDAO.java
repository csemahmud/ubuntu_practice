/**
 * 
 */
package com.khan.UserJUnit2409App.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tbl_user")
public class UserDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name", length = 100, unique = true)
	private String name;
	@Column(name = "email", length = 100, unique = true)
	private String email;
	@Column
	private String domain;
	@Column
	private int age;
	@Column
	private int experience;
	@Column
	private double salary;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDAO [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append(", domain=").append(domain).append(", age=").append(age).append(", experience=")
				.append(experience).append(", salary=").append(salary).append("]");
		return builder.toString();
	}
	
	
}

/**
 * 
 */
package com.khan.UserCRUD2212App.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	/**
	 * @return the id
	 */
	public synchronized final int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public synchronized final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public synchronized final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public synchronized final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the domain
	 */
	public synchronized final String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public synchronized final void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the age
	 */
	public synchronized final int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public synchronized final void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the experience
	 */
	public synchronized final int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public synchronized final void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the salary
	 */
	public synchronized final double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public synchronized final void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDAO [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append(", domain=").append(domain).append(", age=").append(age).append(", experience=")
				.append(experience).append(", salary=").append(salary).append("]");
		return builder.toString();
	}

	/**
	 * 
	 */
	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

}

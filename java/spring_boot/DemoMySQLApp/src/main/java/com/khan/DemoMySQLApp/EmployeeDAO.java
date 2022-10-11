/**
 * 
 */
package com.khan.DemoMySQLApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Entity
@Table(name = "tbl_employee")
public class EmployeeDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "employee_id", length = 100, unique = true)
	private String employeeId;
	@Column
	private float salary;
	
	/**
	 * @param id
	 * @param name
	 * @param employeeId
	 * @param salary
	 */
	public EmployeeDAO(int id, String name, String employeeId, float salary) {
		this(name, employeeId, salary);
		this.id = id;
	}

	/**
	 * @param name
	 * @param employeeId
	 * @param salary
	 */
	public EmployeeDAO(String name, String employeeId, float salary) {
		this();
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	/**
	 * 
	 */
	public EmployeeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	 * @return the employeeId
	 */
	public synchronized final String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public synchronized final void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the salary
	 */
	public synchronized final float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public synchronized final void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDAO [id=").append(id).append(", name=").append(name).append(", employeeId=")
				.append(employeeId).append(", salary=").append(salary).append("]");
		return builder.toString();
	}
	
}

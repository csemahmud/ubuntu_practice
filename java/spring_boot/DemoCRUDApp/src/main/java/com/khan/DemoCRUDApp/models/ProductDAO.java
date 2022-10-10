/**
 * 
 */
package com.khan.DemoCRUDApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tbl_product")
public class ProductDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "prd_name", length = 100, unique = true)
	private String name;
	@Column
	private int quantity;
	@Column
	private double price;

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
	 * @return the quantity
	 */
	public synchronized final int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public synchronized final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public synchronized final double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public synchronized final void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDAO [id=").append(id).append(", name=").append(name).append(", quantity=")
				.append(quantity).append(", price=").append(price).append("]");
		return builder.toString();
	}

}

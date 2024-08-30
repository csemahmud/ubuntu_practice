/**
 * 
 */
package JDBC2408ApartmentLayeredAppPackage.models;

import java.sql.Date;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class ApartmentDAO {
	
	private int id;
	private String name;
	private int price;
	private Date date;

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param date
	 */
	public ApartmentDAO(int id, String name, int price, Date date) {
		this(name,price);
		this.id = id;
		this.date = date;
	}

	/**
	 * @param name
	 * @param price
	 */
	public ApartmentDAO(String name, int price) {
		this();
		this.name = name;
		this.price = price;
	}

	/**
	 * 
	 */
	public ApartmentDAO() {
		// TODO Auto-generated constructor stub
		super();
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
	 * @return the price
	 */
	public synchronized final int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public synchronized final void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the date
	 */
	public synchronized final Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public synchronized final void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t").append(id).append("\t").append(name).append("\t").append(price)
				.append("\t").append(date);
		return builder.toString();
	}
	
	

}

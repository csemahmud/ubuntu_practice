/**
 * 
 */
package com.khan.ApartmentLayeredJDBCApp.bll;

import java.sql.SQLException;

import com.khan.ApartmentLayeredJDBCApp.dal.ApartmentGateway;
import com.khan.ApartmentLayeredJDBCApp.models.ApartmentDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class ApartmentManager {
	
	private ApartmentGateway anApartmentGatewayObj = new ApartmentGateway();

	/**
	 * 
	 */
	public ApartmentManager() {
		// TODO Auto-generated constructor stub
	}

	public String saveApartment(ApartmentDAO apartment) {
		
		try {
			
			if(anApartmentGatewayObj.insertApartment(apartment) > 0) {
				
				return "Apartment " + apartment.getName()
						+ " has been SAVED successfully.";
				
			}
			
		} catch (SQLException ex) {	
			
			System.out.println("\n\n\n\tCREATING TABLE ..... \n\t");
			anApartmentGatewayObj.createTable();
			
			try {
				
				if(anApartmentGatewayObj.insertApartment(apartment) > 0) {
					
					return "Apartment " + apartment.getName()
							+ " has been SAVED successfully.";
					
				}
				
			} catch (SQLException e) {	
				
				e.printStackTrace();
				
			}
		}
		
		return "Could NOT SAVE " + apartment.getName();
		
	}
}

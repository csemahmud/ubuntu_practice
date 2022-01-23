/**
 * 
 */
package com.khan.ApartmentLayeredJDBCApp.bll;

import java.sql.SQLException;
import java.util.List;

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
	
	public List<ApartmentDAO> getAllApartments(){
		
		return anApartmentGatewayObj.selectAllApartments();
		
	}
	
	public ApartmentDAO getApartmentByName(String name) {
		
		return anApartmentGatewayObj.selectApartment().byName(name);
		
	}
	
	public String editApartment(ApartmentDAO apartment) {
		
		if(anApartmentGatewayObj.updateApartmentById(apartment) > 0) {
			
			return "Apartment " + apartment.getName()
				+ " has been UPDATED successfully.";
			
		}
		
		return "Could NOT update " + apartment.getName();
	}
	
	public String removeApartment(ApartmentDAO apartment) {
		
		if(anApartmentGatewayObj.deleteApartmentById(apartment.getId()) > 0) {
			
			return "Apartment " + apartment.getName()
				+ " has been REMOVED successfully.";
			
		}
		
		return "Could NOT remove " + apartment.getName();
	}
}

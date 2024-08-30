/**
 * 
 */
package JDBC2408ApartmentLayeredAppPackage.bll;

import java.util.List;

import JDBC2408ApartmentLayeredAppPackage.dal.ApartmentGateway;
import JDBC2408ApartmentLayeredAppPackage.models.ApartmentDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class ApartmentManager {
	
	private final ApartmentGateway anApartmentGatewayObj;

	/**
	 * 
	 */
	public ApartmentManager() {
		// TODO Auto-generated constructor stub
		
		anApartmentGatewayObj = new ApartmentGateway();
	}
	
	public List<ApartmentDAO> getAllApartments(){
		
		return anApartmentGatewayObj.selectAllApartments();
		
	}
	
	public List<ApartmentDAO> getAllApartmentsByReverseAlphabeically(){
		
		return anApartmentGatewayObj.selectAllApartmentsOrderByDesc("name");
		
	}
	
	public ApartmentDAO getApartmentByName(String name) {
		
		return anApartmentGatewayObj.selectApartment().byName(name);
		
	}
	
	public String saveApartment(ApartmentDAO apartment) {
		
		if(getApartmentByName(apartment.getName()) != null) {
			
			return "Apartment Name : \"" + apartment.getName()
				+ "\" Already EXISTS !!! Please choose a unique name .";
			
		}
		
		if(anApartmentGatewayObj.insertApartment(apartment) > 0) {
			
			return "Apartment : " + apartment.getName()
				+ " has been SAVED successfully .";
			
		}
		
		return "Could NOT save apartment : " + apartment.getName();
	}
	
	public String saveApartment(String name, int price) {
		
		return saveApartment(new ApartmentDAO(name, price));
		
	}
	
	public String editApartment(ApartmentDAO apartment) {
		
		ApartmentDAO checkApartment = getApartmentByName(apartment.getName());
		if((checkApartment != null) && (checkApartment.getId() != apartment.getId())) {
			
			return "Apartment Name : \"" + apartment.getName()
				+ "\" Already EXISTS !!! Please choose a unique name .";
			
		}
		
		if(anApartmentGatewayObj.updateApartmentById(apartment) > 0) {
			
			return "Apartment : " + apartment.getName()
				+ " has been UPDATED successfully .";
			
		}
		
		return "Could NOT update apartment : " + apartment.getName();
	}
	
	public String removeApartment(ApartmentDAO apartment) {
		
		if(anApartmentGatewayObj.deleteApartmentById(apartment.getId()) > 0) {
			
			return "Apartment : " + apartment.getName()
				+ " has been REMOVED successfully .";
			
		}
		
		return "Could NOT remove apartment : " + apartment.getName();
	}

}

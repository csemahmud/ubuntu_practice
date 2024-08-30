/**
 * 
 */
package JDBC2408ApartmentLayeredAppPackage;

import java.util.List;

import JDBC2408ApartmentLayeredAppPackage.bll.ApartmentManager;
import JDBC2408ApartmentLayeredAppPackage.models.ApartmentDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class MainProgram {
	
	private final static ApartmentManager anApartmentManagerObj;
	private static List<ApartmentDAO> allApartments;
	private final static String NORTH = "North Tower";
	private final static String HAMID = "Hamid Tower";
	private final static String NIRVANA = "Nirvana Tower";
	private final static String NEW = "New Tower";
	private final static String NEW_HAMID = "New Hamid Tower";
	
	static {
		
		anApartmentManagerObj = new ApartmentManager();
		
	}

	/**
	 * 
	 */
	public MainProgram() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n");
		System.out.println("\tStarting JDBC2408ApartmentLayeredApp .....\n");
		System.out.println("\t" + anApartmentManagerObj.saveApartment(NORTH, 10_000));
		System.out.println("\t" + anApartmentManagerObj.saveApartment(HAMID, 30_000));
		System.out.println("\t" + anApartmentManagerObj.saveApartment(NIRVANA, 20_000));
		System.out.println("\t" + anApartmentManagerObj.saveApartment(NEW, 40_000));
		
		allApartments = anApartmentManagerObj.getAllApartments();
		printApartments();
		System.out.println();
		
		System.out.println("\tShowing Apartments reverse alphabetically ..... ");
		allApartments = anApartmentManagerObj.getAllApartmentsByReverseAlphabeically();
		printApartments();
		System.out.println();
		
		allApartments.stream().forEach(apartment->{
			
			switch(apartment.getName()) {
			
			case NORTH:
				apartment.setPrice(apartment.getPrice() + 1_000);
				System.out.println("\t" + anApartmentManagerObj.editApartment(
						apartment));
				break;
				
			case NIRVANA:
				apartment.setPrice(apartment.getPrice() + 2_000);
				System.out.println("\t" + anApartmentManagerObj.editApartment(
						apartment));
				break;
			
			case HAMID:
				apartment.setName(NORTH);
				apartment.setPrice(apartment.getPrice() + 4_000);
				System.out.println("\t" + anApartmentManagerObj.editApartment(
						apartment));
				
				apartment.setName(NEW_HAMID);
				System.out.println("\t" + anApartmentManagerObj.editApartment(
						apartment));
				break;
			
			case NEW:
				apartment.setPrice(apartment.getPrice() + 4_000);
				System.out.println("\t" + anApartmentManagerObj.editApartment(
						apartment));
				break;
			
			}
			
		});
		
		allApartments = anApartmentManagerObj.getAllApartments();
		printApartments();
		
		System.out.println("\t" + anApartmentManagerObj.removeApartment(
				anApartmentManagerObj.getApartmentByName(NEW_HAMID)));
		
		allApartments = anApartmentManagerObj.getAllApartments();
		printApartments();
		
		allApartments.stream().forEach(apartment->{
			
			if(!apartment.getName().equals(NEW)) {
				
				System.out.println("\t" + anApartmentManagerObj.removeApartment(apartment));
				
			}
			
		});
		
		allApartments = anApartmentManagerObj.getAllApartments();
		printApartments();

	}

	private static void printApartments() {
		// TODO Auto-generated method stub
		
		if((allApartments != null) && (allApartments.size() > 0)) {
			
			System.out.println("\n\tTotal : " + allApartments.size()
							+ " apartments are : ");
			
			StringBuilder builder = new StringBuilder();
			builder.append("\tid").append("\tname\t").append("\tprice")
					.append("\tdate");
			System.out.println(builder);
			
			allApartments.stream().forEach(apartment->{
				System.out.println(apartment);
			});
			
		} else {
			System.out.println("\n\tNo Apartment to Show ..... ");
		}
		System.out.println();
	}

}

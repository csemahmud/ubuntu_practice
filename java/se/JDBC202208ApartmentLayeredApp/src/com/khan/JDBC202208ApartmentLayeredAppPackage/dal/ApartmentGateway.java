/**
 * 
 */
package com.khan.JDBC202208ApartmentLayeredAppPackage.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khan.JDBC202208ApartmentLayeredAppPackage.models.ApartmentDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class ApartmentGateway extends RootGateway {

	private final String TBL_APARTMENT = "tbl_apartment";
	private final String ID = "id";
	private final String NAME = "name";
	private final String PRICE = "price";
	private final String DATE = "date";
	
	private final String HEADING_RAW = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";";
	
	private final String CREATE_TABLE_RAW = "CREATE TABLE IF NOT EXISTS `" + TBL_APARTMENT + "` (\r\n"
			+ "  `" + ID + "` int(11) NOT NULL AUTO_INCREMENT,\r\n"
			+ "  `" + NAME + "` varchar(127) DEFAULT NULL,\r\n"
			+ "  `" + PRICE + "` int(11) DEFAULT NULL,\r\n"
			+ "  `" + DATE + "` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\r\n"
			+ "  PRIMARY KEY (`" + ID + "`),\r\n"
			+ " UNIQUE KEY `" + NAME + "` (`" + NAME + "`)\r\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;\r\n"
			+ "";

	/**
	 * 
	 */
	public ApartmentGateway() {
		// TODO Auto-generated constructor stub
		
		createTable();
	}
	
	public int createTable() {
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			PreparedStatement headStatement = conn.prepareStatement(HEADING_RAW);
			headStatement.executeUpdate();
			
			PreparedStatement statement = conn.prepareStatement(CREATE_TABLE_RAW);
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return -10;
	}
	
	public List<ApartmentDAO> selectAllApartments(){
		
		return selectAllApartments("SELECT * FROM " + TBL_APARTMENT);
	}

	public List<ApartmentDAO> selectAllApartments(String sql) {
		// TODO Auto-generated method stub
		
		List<ApartmentDAO> allApartments = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				allApartments.add(getApartmentFromResult(result));
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return allApartments;
	}
	
	public List<ApartmentDAO> selectAllApartmentsOrderByDesc(String propertyName){
		
		return selectAllApartments("SELECT * FROM " + TBL_APARTMENT
				+ " ORDER BY `" + propertyName + "` DESC");
	}

	private ApartmentDAO getApartmentFromResult(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return new ApartmentDAO(
				result.getInt(1), result.getString(NAME),
				result.getInt(3), result.getDate(DATE));
	}

	/**
		 * @author KHAN MAHMUDUL HASAN CSE BD JP
		 *
		 */
	public class SelectedApartment {
		
		public ApartmentDAO byPropertyValue(String property, String value) {
			
			try {
				
				return selectAllApartments("SELECT * FROM " + TBL_APARTMENT
						+ " WHERE `" + property + "` = '" + value + "'").get(0);
				
			} 	catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				
				return null;
			}
			
		}
		
		public ApartmentDAO byName(String name) {
			
			return byPropertyValue(NAME, name);
			
		}

		/**
		 * 
		 */
		public SelectedApartment() {
			// TODO Auto-generated constructor stub
		}

	}
	
	public SelectedApartment selectApartment() {
		
		return new SelectedApartment();
		
	}
	
	public int insertApartment(ApartmentDAO apartment) {
		
		String sql = "INSERT INTO "
				+ TBL_APARTMENT + " ("
				+ NAME + ", "
				+ PRICE + ") VALUES (?, ?);";
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, apartment.getName());
			statement.setString(2, Integer.toString(apartment.getPrice()));
			
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return -10;
		
	}
	
	public int updateApartmentById(ApartmentDAO apartment) {
		
		String sql = "UPDATE "
				+ TBL_APARTMENT + " SET "
				+ NAME + "=?, "
				+ PRICE + "=? WHERE " + ID + " = ?;";
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, apartment.getName());
			statement.setString(2, Integer.toString(apartment.getPrice()));
			statement.setString(3, Integer.toString(apartment.getId()));
			
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return -10;
		
	}
	
	public int deleteApartmentById(int apartmentId) {
		
		String sql = "DELETE FROM "
				+ TBL_APARTMENT
				+ " WHERE " + ID + " = ?;";
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, Integer.toString(apartmentId));
			
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return -10;
		
	}

}

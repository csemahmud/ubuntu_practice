/**
 * 
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khan.ApartmentLayeredJDBCApp.models.ApartmentDAO;

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
	
	private final String CREATE_TABLE_RAW = "CREATE TABLE `tbl_apartment` (\n" + 
			"  `id` int(11) NOT NULL,\n" + 
			"  `name` varchar(255) DEFAULT NULL,\n" + 
			"  `price` int(11) DEFAULT NULL,\n" + 
			"  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	private final String PRIMARY_KEY_RAW = "ALTER TABLE `tbl_apartment`\n" + 
			"  ADD PRIMARY KEY (`id`);";
	
	private final String ALTER_TABLE_RAW = "ALTER TABLE `tbl_apartment`\n" + 
			"  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";

	/**
	 * 
	 */
	public ApartmentGateway() {
		// TODO Auto-generated constructor stub
	}
	
	public int createTable() {
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			PreparedStatement headStatement = conn.prepareStatement(HEADING_RAW);
			headStatement.executeUpdate();
			
			PreparedStatement statement2 = conn.prepareStatement(CREATE_TABLE_RAW);
			statement2.executeUpdate();
			
			PreparedStatement statement3 = conn.prepareStatement(PRIMARY_KEY_RAW);
			statement3.executeUpdate();
			
			PreparedStatement statement4 = conn.prepareStatement(ALTER_TABLE_RAW);
			return statement4.executeUpdate();
			
		} catch (Exception ex) {
			// TODO: handle exception
			
			ex.printStackTrace();
		}
		
		return -10;
	}
	
	public int insertApartment(ApartmentDAO apartment) throws SQLException {
		
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
			throw ex;
			
		} catch (Exception ex) {
			// TODO: handle exception
			
			ex.printStackTrace();
			
		}
		return -10;
	}
	
	public List<ApartmentDAO> selectAllApartments(){
		
		List<ApartmentDAO> allApartments = new ArrayList<>();
		
		String sql = "SELECT * FROM " + TBL_APARTMENT;
		
		try(Connection conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)){
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				allApartments.add(new ApartmentDAO(
						result.getInt(1), result.getString(NAME),
						result.getInt(3), result.getDate(DATE)));
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
	
	/**
		 * @author KHAN MAHMUDUL HASAN CSE BD JP
		 *
		 */
	public class SelectedStudent {

		/**
		 * 
		 */
		public SelectedStudent() {
			// TODO Auto-generated constructor stub
		}

	}
	
	

}

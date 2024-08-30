/**
 * 
 */
package JDBC2408ApartmentLayeredAppPackage.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class RootGateway {
	
	protected final String SERVER;
	protected final String DATABASE;
	protected final String DBURL;
	protected final String DBURLWITHOUTDB;
	protected final String USERNAME;
	protected final String PASSWORD;
	
	protected final String HEADING_RAW;
	protected final String CREATE_DATABASE_RAW;
	protected final String USE_DATABASE_RAW;

	/**
	 * 
	 */
	public RootGateway() {
		// TODO Auto-generated constructor stub
		
		this.SERVER = "localhost";
		this.DATABASE = "db_JDBC2408ApartmentLayeredApp";
		this.DBURLWITHOUTDB = "jdbc:mysql://" + SERVER;
		this.DBURL = DBURLWITHOUTDB + "/" + DATABASE;
		this.USERNAME = "root";
		this.PASSWORD = "";
		this.HEADING_RAW = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";";
		this.CREATE_DATABASE_RAW = "CREATE DATABASE IF NOT EXISTS `" + DATABASE + "` \r\n"
		+ "DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;";
		this.USE_DATABASE_RAW = "USE `" + DATABASE + "`;";
		
		createDataBase();
	}

	public int createDataBase() {
		// TODO Auto-generated method stub
		
		try(Connection conn = DriverManager.getConnection(DBURLWITHOUTDB, USERNAME, PASSWORD)) {
			
			conn.prepareStatement(HEADING_RAW).executeUpdate();
			conn.prepareStatement(CREATE_DATABASE_RAW).executeUpdate();
			return conn.prepareStatement(USE_DATABASE_RAW).executeUpdate();
			
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

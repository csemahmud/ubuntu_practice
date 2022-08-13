/**
 * 
 */
package com.khan.JDBC202208ApartmentLayeredAppPackage.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	/**
	 * 
	 */
	public RootGateway() {
		// TODO Auto-generated constructor stub
		
		SERVER = "localhost";
		DATABASE = "db_JDBC202208ApartmentLayeredApp";
		DBURL = "jdbc:mysql://" + SERVER + "/" + DATABASE;
		DBURLWITHOUTDB = "jdbc:mysql://" + SERVER;
		USERNAME = "root";
		PASSWORD = "";
		
		HEADING_RAW = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";";
		
		CREATE_DATABASE_RAW = 
				"CREATE DATABASE IF NOT EXISTS `" + DATABASE + "` \r\n"
				+ "CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;";
		
		createDatabase();
	}
	
	public int createDatabase() {
		
		try(Connection conn = DriverManager.getConnection(DBURLWITHOUTDB, USERNAME, PASSWORD)){
			
			PreparedStatement headStatement = conn.prepareStatement(HEADING_RAW);
			headStatement.executeUpdate();
			
			PreparedStatement statement = conn.prepareStatement(CREATE_DATABASE_RAW);
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

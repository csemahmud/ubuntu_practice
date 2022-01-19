/**
 * 
 */
package dal;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public class RootGateway {
	
	protected final String SERVER;
	protected final String DATABASE;
	protected final String DBURL;
	protected final String USERNAME;
	protected final String PASSWORD;

	/**
	 * 
	 */
	public RootGateway() {
		// TODO Auto-generated constructor stub
		
		SERVER = "localhost";
		DATABASE = "db_real_estate_management_system";
		DBURL = "jdbc:mysql://" + SERVER + "/" + DATABASE;
		USERNAME = "root";
		PASSWORD = "";
	}

}

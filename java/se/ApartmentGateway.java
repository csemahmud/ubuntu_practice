import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentGateway{
    public static void main(String[] args){

        final String URL = "jdbc:mysql://localhost:3306/db_real_estate_management_system";//Host name: localhost Database name: db_real_estate_management_system
        final String USER = "root";//User name
        final String PASS = "";//password
        String SQL = "select * from tbl_apartment;";//SQL statement (select database book)

        //Check if JDBC can be imported
        try{
                Class cls = Class.forName("com.mysql.jdbc.Driver");
                System.out.println("JDBC sucess");
        }catch(ClassNotFoundException e){
                e.printStackTrace();
                System.exit(1);
        }

        //Access the database using JBDC
        try(
            Connection conn = DriverManager.getConnection(URL, USER, PASS);//Login to SQL
            PreparedStatement ps = conn.prepareStatement(SQL)){//Execution of SQL statement
            try(ResultSet rs = ps.executeQuery()){//Store database information in rs
                while(rs.next()){//Update selected column
                    System.out.println(//Display of read columns
                    	rs.getInt("id") + " " +
                    	rs.getString("name") + " " +
                        rs.getString("price") +" "+
			rs.getDate("date"));
                }           
            }catch(SQLException e){//Database information acquisition error
                e.printStackTrace();
                System.exit(1);
            }
        }catch(SQLException e){//Login or SQL statement execution error
            e.printStackTrace();
            System.exit(1);
        }finally{
            System.out.println("finish");//Run if nothing happens
            System.exit(0);
        }
    }
}

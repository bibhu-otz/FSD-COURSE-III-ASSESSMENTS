package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() {
		
		   Connection con=null;
	        try
	        {
	        	Class.forName("com.mysql.cj.jdbc.Driver");  
				 con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/la","root","skill"); 
	            
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return con;
	
	}
	public static String Path() {
		String Path="C:/Users/PARTHA/eclipse-workspace/LearnersAcademy/src/main/webapp/admin/resources/img";
		return Path;
	}

}

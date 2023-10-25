package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Classes;
import utility.DbConnection;

public class ClassDao {
	//add class
	
		 public void  addClass(String class_name) {
			 try{
				Connection con=DbConnection.getConnection();
				String query="INSERT INTO classes(class_name) VALUES(?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,class_name);
				ps.executeUpdate();
			  }catch (SQLException e) {e.printStackTrace();}	
		    } 
		 //view class
		 public List<Classes> viewClasses(){
			 ArrayList<Classes> clsList=new ArrayList<Classes>();
	    	 try {
	    		Connection con = DbConnection.getConnection();
	  		    String sql="select * from Classes";
	  		    PreparedStatement ps=con.prepareStatement(sql);  
	  		    ResultSet rs=ps.executeQuery();  
	  		    while(rs.next())
	  		    {
	  		    	Classes c=new Classes();
	  		    	c.setClass_id(rs.getInt(1));
	  		    	c.setClass_name(rs.getString(2));;
	  		    	clsList.add(c);
	  		    }
	  	        con.close();  
	  		}catch(Exception ex) {ex.printStackTrace();}
			return clsList ;	
		}
		 
		 //delete class
	
		 public static int deleteClass(int class_id){  
			 int status=0;
			    try{  
			    	Connection con=DbConnection.getConnection(); 
			    	String sql="delete from Classes where class_id=?";
			        PreparedStatement ps=con.prepareStatement(sql);  
			        ps.setInt(1,class_id);  
			        status =ps.executeUpdate();  
			    }catch(Exception e){System.out.println(e);}  
			  
			    return status;  
			}
		//view class
		 public List<Classes> getClassById(int class_id){
			 ArrayList<Classes> clsList=new ArrayList<Classes>();
	    	 try {
	    		Connection con = DbConnection.getConnection();
	  		    String sql="select * from Classes where class_id=?";
	  		    PreparedStatement ps=con.prepareStatement(sql);  
	  		    ps.setInt(1,class_id);
	  		    ResultSet rs=ps.executeQuery();  
	  		    while(rs.next())
	  		    {
	  		    	Classes c=new Classes();
	  		    	c.setClass_id(rs.getInt(1));
	  		    	c.setClass_name(rs.getString(2));;
	  		    	clsList.add(c);
	  		    }
	  	        con.close();  
	  		}catch(Exception ex) {ex.printStackTrace();}
			return clsList ;	
		}
		 
		 //update class
		 public void  updateClass(String class_name,int class_id) {
			  
		    	try {
					Connection con=DbConnection.getConnection();
					String query="update classes set class_name=? where class_id=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,class_name);
					ps.setInt(2,class_id);
					ps.executeUpdate();
				}  catch (SQLException e) {e.printStackTrace();}	
		    } 
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Subject;
import utility.DbConnection;

public class SubjectDao {
	//add Subject
	
	 public void  addSubject(String sub_name) {
		  
	    	try {
				Connection con=DbConnection.getConnection();
				String query="INSERT INTO Subject(sub_name) VALUES(?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,sub_name);
				ps.executeUpdate();
			}  catch (SQLException e) {e.printStackTrace();}	
	    } 
	 
	 
	 //view Subject
	 public List<Subject> viewSubjects(){
		 ArrayList<Subject> subList=new ArrayList<Subject>();
   	 try {
   		Connection con = DbConnection.getConnection();
 		    String sql="select * from Subject";
 		    PreparedStatement ps=con.prepareStatement(sql);  
 		    ResultSet rs=ps.executeQuery();  
 		    while(rs.next())
 		    {
 		    	Subject s=new Subject();
 		    	s.setSub_id(rs.getInt(1));
 		    	s.setSub_name(rs.getString(2));;
 		    	subList.add(s);
 		    }
 	        con.close();  
 		}catch(Exception ex) {ex.printStackTrace();}
		return subList ;	
	}
	 
	 //delete Subject

	 public static int deleteSubject(int sub_id){  
		 int status=0;
		    try{  
		    	Connection con=DbConnection.getConnection(); 
		    	String sql="delete from Subject where sub_id=?";
		        PreparedStatement ps=con.prepareStatement(sql);  
		        ps.setInt(1,sub_id);  
		        status =ps.executeUpdate();  
		    }catch(Exception e){System.out.println(e);}  
		  
		    return status;  
		}
	//view Subject by id
	 public List<Subject> getSubjectById(int sub_id){
		 ArrayList<Subject> subList=new ArrayList<Subject>();
   	 try {
   		Connection con = DbConnection.getConnection();
 		    String sql="select * from Subject where sub_id=?";
 		    PreparedStatement ps=con.prepareStatement(sql);  
 		    ps.setInt(1,sub_id);
 		    ResultSet rs=ps.executeQuery();  
 		    while(rs.next())
 		    {
 		    	Subject s=new Subject();
 		    	s.setSub_id(rs.getInt(1));
 		    	s.setSub_name(rs.getString(2));
 		    	subList.add(s);
 		    }
 	        con.close();  
 		}catch(Exception ex) {ex.printStackTrace();}
		return subList ;	
	}
	 
	 //update Subject
	 public void  updateSubject(String sub_name,int sub_id) {
		  
	    	try {
				Connection con=DbConnection.getConnection();
				String query="update Subject set sub_name=? where sub_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,sub_name);
				ps.setInt(2,sub_id);
				ps.executeUpdate();
			}  catch (SQLException e) {e.printStackTrace();}	
	    } 
}

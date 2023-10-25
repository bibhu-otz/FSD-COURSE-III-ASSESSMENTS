package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CSM;
import bean.Student;
import utility.DbConnection;

public class StudentDao {
	// add Student
		 public void  addStudent(Student std) {
			  
		    	try {
					Connection con=DbConnection.getConnection();
					String query="INSERT INTO student(std_name,std_rollno,admission_date,std_address,class_id) VALUES(?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,std.getStd_name());
					ps.setString(2,std.getStd_rollno());
					ps.setString(3,std.getAdmission_date());
					ps.setString(4,std.getStd_address());
					ps.setInt(5,std.getClass_id());
					ps.executeUpdate();
				}  catch (SQLException e) {e.printStackTrace();}	
		    } 
		 
// view students
		 public List<Student> viewStudents(){
			 ArrayList<Student> stdList=new ArrayList<Student>();
	   	 try {
	   		Connection con = DbConnection.getConnection();
	 		    String sql="select A.std_id,A.std_name,A.std_rollno,A.admission_date,A.std_address,B.class_name from Student A inner join classes B on A.class_id=B.class_id  ";
	 		    PreparedStatement ps=con.prepareStatement(sql);  
	 		    ResultSet rs=ps.executeQuery();  
	 		    while(rs.next())
	 		    {
	 		    	Student std=new Student();
	 		    	std.setStd_id(rs.getInt(1));
	 		    	std.setStd_name(rs.getString(2));
	 		    	std.setStd_rollno(rs.getString(3));
	 		    	std.setAdmission_date(rs.getString(4));
	 		    	std.setStd_address(rs.getString(5));
	 		    	std.setClass_name(rs.getString(6));
	 		    	stdList.add(std);
	 		    }
	 	        con.close();  
	 		}catch(Exception ex) {ex.printStackTrace();}
			return stdList ;	
		}
		 
		//delete Student
			
		 public static int deleteStudent(int std_id){  
			 int status=0;
			    try{  
			    	Connection con=DbConnection.getConnection(); 
			    	String sql="delete from Student where std_id=?";
			        PreparedStatement ps=con.prepareStatement(sql);  
			        ps.setInt(1,std_id);  
			        status =ps.executeUpdate();  
			    }catch(Exception e){System.out.println(e);}  
			  
			    return status;  
			}
		 // get Student by id
		
		 public List<Student> getStudentById(int std_id){
			 ArrayList<Student> stdList=new ArrayList<Student>();
	   	 try {
	   		Connection con = DbConnection.getConnection();
	 		    String sql="select * from student where std_id=?";
	 		    PreparedStatement ps=con.prepareStatement(sql);  
	 		    ps.setInt(1,std_id);
	 		    ResultSet rs=ps.executeQuery();  
	 		    while(rs.next())
	 		    {
	 		    	
	 		    	Student std=new Student();
	 		    	std.setStd_id(rs.getInt(1));
	 		    	std.setStd_name(rs.getString(2));
	 		    	std.setStd_rollno(rs.getString(3));
	 		    	std.setAdmission_date(rs.getString(4));
	 		    	std.setStd_address(rs.getString(5));
	 		    	std.setClass_id(rs.getInt(6));
	 		    	stdList.add(std);
	 		    }
	 	        con.close();  
	 		}catch(Exception ex) {ex.printStackTrace();}
			return stdList ;	
		} // update Student
		 public void  updateStudent(Student std) {
			  
		    	try {
					Connection con=DbConnection.getConnection();
					String query="update Student set std_name=?,std_rollno=?,admission_date=?,std_address=?,class_id=? where std_id=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, std.getStd_name());
					ps.setString(2,std.getStd_rollno());
					ps.setString(3,std.getAdmission_date());
					ps.setString(4,std.getStd_address());
					ps.setInt(5, std.getClass_id());
					ps.setInt(6, std.getStd_id());
					ps.executeUpdate();
				}  catch (SQLException e) {e.printStackTrace();}	
		    } 
		 
}

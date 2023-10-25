package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Teacher;
import utility.DbConnection;

public class TeacherDao {
	
	//add teacher
	
	 public static int addTeacher(Teacher teacher) {
		  int status=0;
	    	try {
				Connection con=DbConnection.getConnection();
				String query="INSERT INTO teacher(teacher_name,teacher_img,teacher_address,teacher_phno,teacher_qualification,join_date,teacher_salary)VALUES(?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,teacher.getTeacher_name());
				ps.setString(2,teacher.getTeacher_img());
				ps.setString(3,teacher.getTeacher_address());
				ps.setString(4,teacher.getTeacher_phno());
				ps.setString(5,teacher.getTeacher_qualification());
				ps.setString(6,teacher.getJoin_date());
				ps.setDouble(7,teacher.getTeacher_salary());
				status=ps.executeUpdate();
				
			}  catch (SQLException e) {
				
				e.printStackTrace();
			}	
	    	
	    	return status;
	    } 
	 
	 // view teachers

	 public List<Teacher> viewTeachers(){
		 ArrayList<Teacher> teacherList=new ArrayList<Teacher>();//Creating Arraylist 
    	 try {
    		Connection con = DbConnection.getConnection();
  		    String sql="select * from Teacher";
  		    PreparedStatement ps=con.prepareStatement(sql);  
  		    ResultSet rs=ps.executeQuery();  
  		    while(rs.next())
  		    {
  		    	Teacher teacher=new Teacher();
  		    	teacher.setTeacher_id(rs.getInt(1));
  		    	teacher.setTeacher_name(rs.getString(2));
  		    	teacher.setTeacher_img(rs.getString(3));
  		    	teacher.setTeacher_address(rs.getString(4));
  		    	teacher.setTeacher_phno(rs.getString(5));
  		    	teacher.setTeacher_qualification(rs.getString(6));
  		    	teacher.setJoin_date(rs.getString(7));
  		    	teacher.setTeacher_salary(rs.getDouble(8));
  		    	teacherList.add(teacher);
  		    }
  	        con.close();  
  		}catch(Exception ex) {
  			ex.printStackTrace();
  		}
		return teacherList ;	
	}
	// delete Teacher
	 public static int deleteTeacher(int teacher_id){  
		 int status=0;
		    try{  
		    	Connection con=DbConnection.getConnection(); 
		    	String sql="delete from Teacher where teacher_id=?";
		        PreparedStatement ps=con.prepareStatement(sql);  
		        ps.setInt(1,teacher_id);  
		        status =ps.executeUpdate();  
		    }catch(Exception e){System.out.println(e);}  
		  
		    return status;  
		}
	 
	// sort Teacher by Id
				public  List<Teacher> getTeacherDetailsById(int teacher_id){
				 ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
				 try {
					 Connection con = DbConnection.getConnection();
				     String sql="Select * from Teacher where teacher_id=?";
				     PreparedStatement ps=con.prepareStatement(sql);
				     ps.setInt(1, teacher_id);
				     ResultSet rs=ps.executeQuery();  
				    while(rs.next())
				    {
				    	Teacher teacher=new Teacher();
		  		    	teacher.setTeacher_id(rs.getInt(1));
		  		    	teacher.setTeacher_name(rs.getString(2));
		  		    	teacher.setTeacher_img(rs.getString(3));
		  		    	teacher.setTeacher_address(rs.getString(4));
		  		    	teacher.setTeacher_phno(rs.getString(5));
		  		    	teacher.setTeacher_qualification(rs.getString(6));
		  		    	teacher.setJoin_date(rs.getString(7));
		  		    	teacher.setTeacher_salary(rs.getDouble(8));
		  		    	teacherList.add(teacher);
				    }
			       con.close();  
				}catch(Exception ex) {ex.printStackTrace();}
				return teacherList ;
			}
				
				
	// update teacher
				
				 public static int updateTeacher(Teacher teacher) {
					  int status=0;
				    	try {
							Connection con=DbConnection.getConnection();
							String query="update teacher set teacher_name=?,teacher_img=?,teacher_address=?,teacher_phno=?,teacher_qualification=?,join_date=?,teacher_salary=? where teacher_id=?";
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1,teacher.getTeacher_name());
							ps.setString(2,teacher.getTeacher_img());
							ps.setString(3,teacher.getTeacher_address());
							ps.setString(4,teacher.getTeacher_phno());
							ps.setString(5,teacher.getTeacher_qualification());
							ps.setString(6,teacher.getJoin_date());
							ps.setDouble(7,teacher.getTeacher_salary());
							ps.setInt(8, teacher.getTeacher_id());
							status=ps.executeUpdate();
						}  catch (SQLException e) {e.printStackTrace();}	
				    	return status;
				    } 
}

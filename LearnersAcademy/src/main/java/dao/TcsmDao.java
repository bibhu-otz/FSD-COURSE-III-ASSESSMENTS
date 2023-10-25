package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CSM;
import utility.DbConnection;

public class TcsmDao {
// add Tcsm
	 public void  addTcsm(CSM csm) {
		  
	    	try {
				Connection con=DbConnection.getConnection();
				String query="INSERT INTO tcsm(class_id,sub_id,class_time,teacher_id) VALUES(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1,csm.getClass_id());
				ps.setInt(2,csm.getSub_id());
				ps.setString(3,csm.getClass_time());
				ps.setInt(4,csm.getTeacher_id());
				ps.executeUpdate();
			}  catch (SQLException e) {e.printStackTrace();}	
	    } 
	 
	 //view tcsm
	
	 public List<CSM> viewTcsms(){
		 ArrayList<CSM> csmList=new ArrayList<CSM>();
   	 try {
   		Connection con = DbConnection.getConnection();
 		    String sql="select A.tcsm_id,B.class_name,C.sub_name,D.teacher_name,A.class_time from tcsm A inner join classes B on A.class_id=B.class_id  inner join subject C on A.sub_id=C.sub_id inner join Teacher D on A.teacher_id=D.teacher_id ";
 		    PreparedStatement ps=con.prepareStatement(sql);  
 		    ResultSet rs=ps.executeQuery();  
 		    while(rs.next())
 		    {
 		    	CSM csm=new CSM();
 		    	csm.setTcsm_id(rs.getInt(1));
 		    	csm.setClass_name(rs.getString(2));
 		    	csm.setSub_name(rs.getString(3));
 		    	csm.setTeacher_name(rs.getString(4));
 		    	csm.setClass_time(rs.getString(5));
 		    	csmList.add(csm);
 		    }
 	        con.close();  
 		}catch(Exception ex) {ex.printStackTrace();}
		return csmList ;	
	}
	 //delete TCSM
	
			 public static int deleteTcsm(int tcsm_id){  
				 int status=0;
				    try{  
				    	Connection con=DbConnection.getConnection(); 
				    	String sql="delete from tcsm where tcsm_id=?";
				        PreparedStatement ps=con.prepareStatement(sql);  
				        ps.setInt(1,tcsm_id);  
				        status =ps.executeUpdate();  
				    }catch(Exception e){System.out.println(e);}  
				  
				    return status;  
				}
			 
			 
			 
			//view TCSM by id
			 public List<CSM> getTcsmById(int tcsm_id){
				 ArrayList<CSM> tcsmList=new ArrayList<CSM>();
		   	 try {
		   		Connection con = DbConnection.getConnection();
		 		    String sql="select * from tcsm where tcsm_id=?";
		 		    PreparedStatement ps=con.prepareStatement(sql);  
		 		    ps.setInt(1,tcsm_id);
		 		    ResultSet rs=ps.executeQuery();  
		 		    while(rs.next())
		 		    {
		 		    	CSM csm=new CSM();
		 		    	csm.setTcsm_id(rs.getInt(1));
		 		    	csm.setClass_id(rs.getInt(2));
		 		    	csm.setSub_id(rs.getInt(3));
		 		    	csm.setClass_time(rs.getString(4));
		 		    	csm.setTeacher_id(rs.getInt(5));
		 		    	tcsmList.add(csm);
		 		    }
		 	        con.close();  
		 		}catch(Exception ex) {ex.printStackTrace();}
				return tcsmList ;	
			}
			 
			 // update csm
			 public void  updateTcsm(CSM csm) {
				  
			    	try {
						Connection con=DbConnection.getConnection();
						String query="update tcsm set class_id=?,sub_id=?,class_time=?,teacher_id=? where tcsm_id=?";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setInt(1,csm.getClass_id());
						ps.setInt(2,csm.getSub_id());
						ps.setString(3,csm.getClass_time());
						ps.setInt(4,csm.getTeacher_id());
						ps.setInt(5,csm.getTcsm_id());
						ps.executeUpdate();
					}  catch (SQLException e) {e.printStackTrace();}	
			    } 
}

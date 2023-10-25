package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.CSM;
import utility.DbConnection;

public class CSMDao {
// add csm

	 public void  addCsm(int class_id,int sub_id) {
		  
	    	try {
				Connection con=DbConnection.getConnection();
				String query="INSERT INTO csm(class_id,sub_id) VALUES(?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1,class_id);
				ps.setInt(2,sub_id);
				ps.executeUpdate();
			}  catch (SQLException e) {e.printStackTrace();}	
	    } 
	//view CSM
		 public List<CSM> viewCSMs(){
			 ArrayList<CSM> csmList=new ArrayList<CSM>();
	   	 try {
	   		Connection con = DbConnection.getConnection();
	 		    String sql="select A.csm_id,B.class_name,C.sub_name from csm A inner join classes B on A.class_id=B.class_id  inner join subject C on A.sub_id=C.sub_id ";
	 		    PreparedStatement ps=con.prepareStatement(sql);  
	 		    ResultSet rs=ps.executeQuery();  
	 		    while(rs.next())
	 		    {
	 		    	CSM csm=new CSM();
	 		    	csm.setCsm_id(rs.getInt(1));
	 		    	csm.setClass_name(rs.getString(2));
	 		    	csm.setSub_name(rs.getString(3));
	 		    	csmList.add(csm);
	 		    }
	 	        con.close();  
	 		}catch(Exception ex) {ex.printStackTrace();}
			return csmList ;	
		}
// delete csm
		 public static int deleteCsm(int csm_id){  
			 int status=0;
			    try{  
			    	Connection con=DbConnection.getConnection(); 
			    	String sql="delete from csm where csm_id=?";
			        PreparedStatement ps=con.prepareStatement(sql);  
			        ps.setInt(1,csm_id);  
			        status =ps.executeUpdate();  
			    }catch(Exception e){System.out.println(e);}  
			   return status;  
			}
		 
//view CSM by id
		 public List<CSM> getCsmById(int csm_id){
			 ArrayList<CSM> csmList=new ArrayList<CSM>();
	   	 try {
	   		Connection con = DbConnection.getConnection();
	 		    String sql="select * from csm where csm_id=?";
	 		    PreparedStatement ps=con.prepareStatement(sql);  
	 		    ps.setInt(1,csm_id);
	 		    ResultSet rs=ps.executeQuery();  
	 		    while(rs.next())
	 		    {
	 		    	CSM csm=new CSM();
	 		    	csm.setCsm_id(rs.getInt(1));
	 		    	csm.setClass_id(rs.getInt(2));
	 		    	csm.setSub_id(rs.getInt(3));
	 		    	csmList.add(csm);
	 		    }
	 	        con.close();  
	 		}catch(Exception ex) {ex.printStackTrace();}
			return csmList ;	
		}
		 
		 //update csm
		 public void  updateCsm(CSM csm) {
			  try {
					Connection con=DbConnection.getConnection();
					String query="update csm set class_id=?,sub_id=? where csm_id=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1,csm.getClass_id());
					ps.setInt(2,csm.getSub_id());
					ps.setInt(3,csm.getCsm_id());
					ps.executeUpdate();
				}  catch (SQLException e) {e.printStackTrace();}	
		    } 
}

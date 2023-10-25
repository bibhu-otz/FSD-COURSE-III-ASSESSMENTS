package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admin;
import utility.DbConnection;



public class AdminLoginDao {
	boolean status;
	public boolean validate(Admin admin) {
		try {
		Connection con=DbConnection.getConnection();
		String sql="SELECT count(*) FROM login WHERE user_name=? AND password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,admin.getUser_name());
		ps.setString(2,admin.getPassword());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			int r=rs.getInt(1);
			if(r>0) {
				status=true;
			}else {
				status = false;
			}
		}
		} catch (SQLException e) {e.printStackTrace();}
		return status;
	}
}

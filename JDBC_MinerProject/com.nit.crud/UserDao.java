package com.nit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	//1.Insert Operation
	
	public  void insertUser(int id,String name,int mob,String email) throws ClassNotFoundException, SQLException 
	{
		Connection conn=DBUtil.getConnection();
		String query="INSERT INTO USER VALUES(?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(query);	
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, mob);
		ps.setString(4, email);
		
		int rows=ps.executeUpdate();
		conn.close();
		
		System.out.println("No of rows inserted is:"+rows);
		System.out.println("Data Has Been Inserted Sucessfully...");
				

	}
	
	//2.Update Operation
	public void updateUser(String name,int mob,String email,int id) throws ClassNotFoundException, SQLException
	{
		Connection conn=DBUtil.getConnection();
		String query="UPDATE USER SET name=?,mob=?,email=? WHERE id=?";
		
		PreparedStatement ps=conn.prepareStatement(query);	
		
		ps.setString(1, name);
		ps.setInt(2, mob);
		ps.setString(3, email);
		ps.setInt(4, id);
		
		int rows=ps.executeUpdate();
		conn.close();
		
		System.out.println("No of rows Update is:"+rows);
		System.out.println("Data Has Been Update Sucessfully...");
		
	}
	
	    //3.Delete Operation
		public void deleteUser(int id) throws ClassNotFoundException, SQLException
		{
			Connection conn=DBUtil.getConnection();
			String query="DELETE FROM USER WHERE id=?";
			
			PreparedStatement ps=conn.prepareStatement(query);	
			
			
			ps.setInt(1, id);
			
			
			int rows=ps.executeUpdate();
			conn.close();
			
			System.out.println("No of rows Deleted is:"+rows);
			System.out.println("Data Has Been Deleted Sucessfully...");
			
		}
		
		//4.Featch Operation
		
				public void fetchUser() throws ClassNotFoundException, SQLException
				{
					Connection conn=DBUtil.getConnection();
					String query="SELECT * FROM USER";
					
					PreparedStatement ps=conn.prepareStatement(query);	
					
					ResultSet rs = ps.executeQuery();
					System.out.println("ID        NAME      MOB         EMAIL");
					while(rs.next()) {
						System.out.println(
								rs.getInt("ID") + "       " +
								rs.getString("NAME") + "	   " +
								rs.getInt("MOB")+ "	   " +
								rs.getString("EMAIL")
						);
					}
					
					conn.close();
					System.out.println("Data Has Been Fetched Sucessfully...");
					
				}

}

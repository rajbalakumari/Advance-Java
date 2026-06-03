package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db_54", "root", "Root");
		 Statement s=conn.createStatement();
		 ResultSet rs=s.executeQuery("SELECT*FROM STUDENT");
		 while(rs.next())
			 {
			 System.out.println(rs.getInt(1));
			 System.out.println(rs.getString(2));
			 System.out.println(rs.getString(3));
			 System.out.println(rs.getInt(4));
			 System.out.println("*******");
			 }
		 conn.close();
		 System.out.println("Data fetched Sucessfully");

	}

}

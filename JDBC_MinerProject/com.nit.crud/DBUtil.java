package com.nit.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String url="jdbc:mysql://localhost:3306/jdbc_minerproject";
    private static final String user_name="root";
    private static final String password="Password");(Put Your Password)
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=DriverManager.getConnection(url, user_name, password);
    	return conn;
    }
      
      
      
      
}

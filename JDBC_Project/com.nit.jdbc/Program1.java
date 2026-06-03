package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.load The Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//"jdbc:mysql://localhost:3306/jdbc2_db39","root","root"
		//2.establish the connection
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db_54", "root", "Root");
        //3.Create Statement
        Statement s=conn.createStatement();
        //4.execute the query
        s.execute("INSERT INTO STUDENT VALUES(105,'Shreno','DS',8956)");
        //5.CLOSE THE CONNECTION
        conn.close();
        System.out.println("Data has Inserted Sucessfully.....");
        
	}

}

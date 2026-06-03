package com.nit.transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTransaction2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_transaction", "root", "Password");(Put your password)
		conn.setAutoCommit(false);
		
		Statement s=conn.createStatement();
		s.execute("DELETE FROM USER WHERE Acc_No=105");
		
		
		conn.commit();
		conn.close();
		System.out.println("Transaction hasn benn insertaed sucessfully");

	}

}

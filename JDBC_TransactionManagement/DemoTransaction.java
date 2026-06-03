package com.nit.transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTransaction {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_transaction", "root", "Password");(Put your password)
		conn.setAutoCommit(false);
		
		Statement s=conn.createStatement();
		s.execute("INSERT INTO BANK VALUES(107,'Sudhir',5000,7854879)");
		s.execute("INSERT INTO BANK VALUES(108,'Raju',6000,7589456)");
		
		conn.commit();
		conn.close();
		System.out.println("Transaction hasn benn insertaed sucessfully");

	}

}

package com.nit.crud;

import java.sql.SQLException;

public class UserDriver {

	public static void main(String[] args) {
		
		UserDao dao=new UserDao();
//		try {
//		try {
//			dao.insertUser(104, "Ashif", 6357, "badu1202@gmail.com");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}catch(ClassNotFoundException e) {
//			
//		}
		
		
//		try {
//		try {
//			dao.updateUser("Ankita", 2536, "anu143@gmail.com",104);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}catch(ClassNotFoundException e) {
//		
//		}
//		
//		try {
//			try {
//				dao.deleteUser(104);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			}catch(ClassNotFoundException e) {
//			
//			}

		try {
			dao.fetchUser();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

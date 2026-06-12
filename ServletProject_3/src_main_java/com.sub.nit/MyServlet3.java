package com.sub.nit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Submit")
public class MyServlet3 extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("I am in Service method");
		System.out.println("My Name is RajbalaKumari");
		System.out.println("I am Working As a Devloper");
		System.out.println("Thank Yo....");
		
		
		
		PrintWriter out=resp.getWriter();
		out.println("I am in Service method");
		out.println("My Name is RajbalaKumari");
		out.println("I am Working As a Devloper");
		out.println("Thank Yo....");
		
	}
}

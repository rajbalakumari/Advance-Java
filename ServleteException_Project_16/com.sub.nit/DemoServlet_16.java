package com.sub.nit;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class DemoServlet_16 extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//int a=10;
	//int b=0;
	//int c=a/b;
	//System.out.println(c);
	  
	resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
}
}

package com.sub.nit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/submit1")
public class MyServlet_6 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String password = req.getParameter("password");

		
		System.out.println("----- Student Details -----");
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Mobile: " + mobile);
		System.out.println("Address: " + address);
		System.out.println("Password: " + password);
		System.out.println("---------------------------");

		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Form Submitted Successfully</h2>");
		out.println("Name: " + name + "<br>");
		out.println("Email: " + email + "<br>");
		out.println("Mobile: " + mobile + "<br>");
		out.println("Address: " + address + "<br>");
		out.println("Password: " + password + "<br>");
	}
}

package com.sub.nit;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class MyServlet_8 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String email=req.getParameter("email");
    	String paswd=req.getParameter("password");
    	PrintWriter out=resp.getWriter();
    	
    	if(email.equals("sb@gmail.com") && paswd.equals("sb123"))
    		
    	{
    		System.out.println("Login Sucessfull...");
    		System.out.println("Wlcome Login Page...."+email);
    		
    		out.println("Login Succesful..");
    		out.println("Welcome Login Page...."+email);
    		
    		HttpSession session=req.getSession();
    		session.setAttribute("name","Subham Behera");
    		session.setAttribute("email","sb@gmail.com");
    		session.setAttribute("mob",76235);
    		
    		RequestDispatcher rd=req.getRequestDispatcher("/welcome.jsp");
    		rd.forward(req, resp);
    	}
    	else {
    		resp.setContentType("text/html");
    	    out.println("Email id and password did not match");
    	    out.println("\nLogin Failed");
    		RequestDispatcher rd=req.getRequestDispatcher("/index.html");
    		rd.include(req, resp);
    	}
    	
       	
    	
    }
}

package com.sub.nit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet_info_12 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	ServletConfig config=getServletConfig();
    	String name=config.getInitParameter("name");
    	
    	
    	
    	ServletContext context=getServletContext();
    	String company = context.getInitParameter("company");
    	
    	
    	PrintWriter out=resp.getWriter();
    	out.println("Name From Config is "+name);
    	out.println("Company From Context is "+company);
    	
    }
}

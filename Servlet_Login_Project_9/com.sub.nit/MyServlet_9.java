package com.sub.nit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Login")
public class MyServlet_9 extends HttpServlet {

    // 🔹 For GET request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.println("<h2>This is GET Method</h2>");
        out.println("<p>Please submit the login form.</p>");
    }

    // 🔹 For POST request (Login logic)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String paswd = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        if (email.equals("raj@gmail.com") && paswd.equals("rj123")) {

            System.out.println("Login Successful...");
            System.out.println("Welcome Login Page...." + email);

            HttpSession session = req.getSession();
            session.setAttribute("name", "RajBala kumari");
            session.setAttribute("email", "sb@gmail.com");
            session.setAttribute("mob", 76235);

            RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
            rd.forward(req, resp);

        } else {

            resp.setContentType("text/html");
            out.println("<h3>Email id and password did not match</h3>");
            out.println("<h3>Login Failed</h3>");

            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
    }
}

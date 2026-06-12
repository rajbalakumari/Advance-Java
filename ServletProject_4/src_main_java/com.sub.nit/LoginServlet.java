package com.sub.nit;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db";
    private static final String USER = "root";
    private static final String PASS = "Root";//(chnage here Password)

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ✅ VERY IMPORTANT
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int roll = Integer.parseInt(req.getParameter("roll"));
        String name = req.getParameter("name");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM students WHERE roll_no=? AND LOWER(name)=LOWER(?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roll);
            ps.setString(2, name);

            ResultSet rs = ps.executeQuery();

            // ✅ FULL HTML + CSS START
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Result</title>");

            out.println("<style>");
            out.println("body {margin:0; font-family:Segoe UI; background:linear-gradient(135deg,#2196f3,#0d47a1); height:100vh; display:flex; justify-content:center; align-items:center;}");
            out.println(".card {background:white; padding:30px; border-radius:15px; text-align:center; box-shadow:0 10px 30px rgba(0,0,0,0.3); width:300px;}");
            out.println(".success {color:green;}");
            out.println(".error {color:red;}");
            out.println("a {display:inline-block; margin-top:15px; padding:10px 20px; background:#2196f3; color:white; text-decoration:none; border-radius:8px;}");
            out.println("a:hover {background:#0d47a1;}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='card'>");

            if (rs.next()) {
                out.println("<h2 class='success'>Login Successful ✅</h2>");
                out.println("<h3>Welcome " + rs.getString("name") + "</h3>");
            } else {
                out.println("<h2 class='error'>Invalid Login ❌</h2>");
            }

            out.println("<a href='index.html'>Go Home</a>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            // ✅ END

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

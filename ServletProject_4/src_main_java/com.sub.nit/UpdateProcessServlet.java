package com.sub.nit;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateProcess")
public class UpdateProcessServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db";
    private static final String USER = "root";
    private static final String PASS = "Root";//(Change here password)

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // ✅ Get parameters
        int roll = Integer.parseInt(req.getParameter("roll"));
        String name = req.getParameter("name");
        double per = Double.parseDouble(req.getParameter("per"));
        String fname = req.getParameter("fname");
        String mname = req.getParameter("mname");
        String mail = req.getParameter("mail");
        String ph = req.getParameter("ph");

        // ✅ VALIDATION
        if (name == null || name.trim().isEmpty()) {
            out.println("<h3 style='color:red;text-align:center;'>Name cannot be empty ❌</h3>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // ✅ FIXED QUERY (correct column names)
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, percentage=?, fname=?, mother_name=?, mail_id=?, ph_no=? WHERE roll_no=?"
            );

            // ✅ Set values
            ps.setString(1, name);
            ps.setDouble(2, per);
            ps.setString(3, fname);
            ps.setString(4, mname);
            ps.setString(5, mail);
            ps.setString(6, ph);
            ps.setInt(7, roll); // ⭐ IMPORTANT

            int i = ps.executeUpdate();

            // 💎 UI RESPONSE
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Update Result</title>");

            out.println("<style>");
            out.println("body{margin:0;font-family:Segoe UI;background:linear-gradient(135deg,#11998e,#38ef7d);display:flex;justify-content:center;align-items:center;height:100vh;}");
            out.println(".card{background:white;padding:30px;border-radius:15px;text-align:center;box-shadow:0 10px 30px rgba(0,0,0,0.3);}");
            out.println(".success{color:green;}");
            out.println(".error{color:red;}");
            out.println("a{display:inline-block;margin-top:15px;padding:10px 20px;background:#11998e;color:white;text-decoration:none;border-radius:8px;}");
            out.println("a:hover{background:#0e7c6b;}");
            out.println("</style>");

            out.println("</head><body>");
            out.println("<div class='card'>");

            if (i > 0) {
                out.println("<h2 class='success'>Updated Successfully ✅</h2>");
            } else {
                out.println("<h2 class='error'>Update Failed ❌</h2>");
            }

            out.println("<a href='view'>View Students</a>");
            out.println("</div></body></html>");

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

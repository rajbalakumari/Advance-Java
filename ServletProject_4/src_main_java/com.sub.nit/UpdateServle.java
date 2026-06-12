package com.sub.nit;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db";
    private static final String USER = "root";
    private static final String PASS = "Root";(Chnage here Password)

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int roll = Integer.parseInt(req.getParameter("roll"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE roll_no=?");
            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // 💎 PREMIUM UI
                out.println("<!DOCTYPE html>");
                out.println("<html><head><title>Update Student</title>");

                out.println("<style>");
                out.println("body{margin:0;font-family:Segoe UI;background:linear-gradient(135deg,#36d1dc,#5b86e5);display:flex;justify-content:center;align-items:center;height:100vh;}");
                out.println(".card{background:white;padding:25px;border-radius:15px;width:350px;box-shadow:0 10px 30px rgba(0,0,0,0.3);}");
                out.println("h2{text-align:center;}");
                out.println("input{width:100%;padding:8px;margin:6px 0;border-radius:6px;border:1px solid #ccc;}");
                out.println("button{width:100%;padding:10px;background:#5b86e5;color:white;border:none;border-radius:8px;}");
                out.println("button:hover{background:#3f6fd1;}");
                out.println("</style>");

                out.println("</head><body>");
                out.println("<div class='card'>");
                out.println("<h2>✏ Update Student</h2>");

                out.println("<form action='updateProcess' method='post'>");

                out.println("Roll: <input type='text' name='roll' value='"+rs.getInt(1)+"' readonly>");
                out.println("Name: <input type='text' name='name' value='"+rs.getString(2)+"'>");
                out.println("Percentage: <input type='text' name='per' value='"+rs.getDouble(3)+"'>");
                out.println("Father: <input type='text' name='fname' value='"+rs.getString(4)+"'>");
                out.println("Mother: <input type='text' name='mname' value='"+rs.getString(5)+"'>");
                out.println("Email: <input type='text' name='mail' value='"+rs.getString(6)+"'>");
                out.println("Phone: <input type='text' name='ph' value='"+rs.getString(7)+"'>");

                out.println("<button type='submit'>Update</button>");
                out.println("</form>");

                out.println("</div></body></html>");

            } else {
                out.println("<h2 style='color:red;text-align:center;'>Student Not Found ❌</h2>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

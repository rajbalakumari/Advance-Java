package com.sub.nit;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db";
    private static final String USER = "root";
    private static final String PASS = "Root";//(Change here Password)

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ✅ IMPORTANT
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            // 💎 PREMIUM UI START
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Students</title>");

            out.println("<style>");
            out.println("body {margin:0; font-family:Segoe UI; background:linear-gradient(135deg,#667eea,#764ba2);}");
            out.println(".container {width:90%; margin:40px auto; background:white; padding:20px; border-radius:15px; box-shadow:0 10px 30px rgba(0,0,0,0.3);}");
            out.println("h2 {text-align:center; margin-bottom:20px;}");
            out.println("table {width:100%; border-collapse:collapse;}");
            out.println("th, td {padding:12px; text-align:center;}");
            out.println("th {background:#667eea; color:white;}");
            out.println("tr:nth-child(even) {background:#f2f2f2;}");
            out.println("tr:hover {background:#ddd;}");
            out.println("a.btn {padding:6px 12px; background:#28a745; color:white; text-decoration:none; border-radius:6px;}");
            out.println("a.btn:hover {background:#1e7e34;}");
            out.println(".home {display:block; width:120px; margin:20px auto; text-align:center; padding:10px; background:#667eea; color:white; text-decoration:none; border-radius:8px;}");
            out.println(".home:hover {background:#5a67d8;}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");
            out.println("<h2>📋 Student List</h2>");

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Roll</th>");
            out.println("<th>Name</th>");
            out.println("<th>Percentage</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("roll_no") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getDouble("percentage") + "</td>");

                // 👉 UPDATE BUTTON
                out.println("<td>");
                out.println("<a class='btn' href='update?roll=" + rs.getInt("roll_no") + "'>Update</a>");
                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<a class='home' href='index.html'>🏠 Home</a>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            // 💎 PREMIUM UI END

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

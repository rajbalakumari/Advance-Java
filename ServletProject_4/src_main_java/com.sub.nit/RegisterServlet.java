package com.sub.nit;

import java.io.*;

import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db";
    private static final String USER = "root";
    private static final String PASS = "Root";//(Chnage here password)

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

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

            // ✅ CHECK DUPLICATE ROLL
            PreparedStatement check = con.prepareStatement(
                "SELECT roll_no FROM students WHERE roll_no=?");
            check.setInt(1, roll);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body style='text-align:center;'>");
                out.println("<h2 style='color:red;'>Roll Number Already Exists ❌</h2>");
                out.println("<a href='index.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

            // ✅ INSERT QUERY (correct column names)
            String sql = "INSERT INTO students(roll_no, name, percentage, fname, mother_name, mail_id, ph_no) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setDouble(3, per);
            ps.setString(4, fname);
            ps.setString(5, mname);
            ps.setString(6, mail);
            ps.setString(7, ph);

            int i = ps.executeUpdate();

            // 💎 UI RESPONSE
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register Result</title>");

            out.println("<style>");
            out.println("body {margin:0; font-family:Segoe UI; background:linear-gradient(135deg,#00c6ff,#0072ff); height:100vh; display:flex; justify-content:center; align-items:center;}");
            out.println(".card {background:white; padding:30px; border-radius:15px; text-align:center; box-shadow:0 10px 30px rgba(0,0,0,0.3); width:320px;}");
            out.println(".success {color:green;}");
            out.println(".error {color:red;}");
            out.println("a {display:inline-block; margin-top:15px; padding:10px 20px; background:#0072ff; color:white; text-decoration:none; border-radius:8px;}");
            out.println("a:hover {background:#0056cc;}");
            out.println("</style>");

            out.println("</head><body>");
            out.println("<div class='card'>");

            if (i > 0) {
                out.println("<h2 class='success'>Registered Successfully ✅</h2>");
                out.println("<p>Welcome " + name + "</p>");
            } else {
                out.println("<h2 class='error'>Registration Failed ❌</h2>");
            }

            out.println("<a href='index.html'>Go Home</a>");
            out.println("</div></body></html>");

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

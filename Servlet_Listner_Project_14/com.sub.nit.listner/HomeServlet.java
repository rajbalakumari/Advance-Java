package com.sub.nit.listner;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Create session (login)
        HttpSession session = req.getSession();

        // Increase total visits
        Integer visits = (Integer) getServletContext().getAttribute("totalVisits");
        if (visits == null) visits = 0;
        visits++;
        getServletContext().setAttribute("totalVisits", visits);

        // Get active users
        Integer active = (Integer) getServletContext().getAttribute("activeUsers");
        if (active == null) active = 0;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Welcome User...</h2>");
        out.println("<h3>Active Users: " + active + "</h3>");
        out.println("<h3>Total Visits: " + visits + "</h3>");

        // Logout button
        out.println("<form action='logout' method='post'>");
        out.println("<button type='submit'>Logout</button>");
        out.println("</form>");

        out.println("</body></html>");
    }
}

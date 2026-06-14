package com.sub.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        String name = "";

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {

                    // Decode back to original
                    name = URLDecoder.decode(c.getValue(), "UTF-8");
                }
            }
        }

        if (!name.equals("")) {
            out.println("<h1>Welcome : " + name + "</h1>");
        } else {
            out.println("<h1>No user found!</h1>");
        }
    }
}

package com.sub.nit;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class MyServlet_11 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");

        //Encode to handle spaces
        name = URLEncoder.encode(name, "UTF-8");

        Cookie cookie = new Cookie("user", name);
        cookie.setMaxAge(60 * 60); // 1 hour

        resp.addCookie(cookie);

        resp.sendRedirect("welcome");
    }
}

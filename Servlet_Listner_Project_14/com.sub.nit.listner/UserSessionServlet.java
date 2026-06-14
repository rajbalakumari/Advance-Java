package com.sub.nit.listner;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionServlet implements HttpSessionListener {

    private static int activeUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeUsers++;
        System.out.println("Session Created... Active Users: " + activeUsers);

        se.getSession().getServletContext().setAttribute("activeUsers", activeUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeUsers--;
        System.out.println("Session Destroyed... Active Users: " + activeUsers);

        se.getSession().getServletContext().setAttribute("activeUsers", activeUsers);
    }
}

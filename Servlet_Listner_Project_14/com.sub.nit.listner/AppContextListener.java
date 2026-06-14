package com.sub.nit.listner;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application Started...");
        
        sce.getServletContext().setAttribute("activeUsers", 0);
        sce.getServletContext().setAttribute("totalVisits", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application Closed...");
    }
}

package com.sb.bookws.listener;

import com.sb.bookws.dao.AuthorDao;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AuthorDao authordao = new AuthorDao();
        sce.getServletContext().setAttribute("authordao", authordao);
        System.out.println("11111111111111111111111111111111111111Initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("22222222222222222222222222Destroyed");
    }
}

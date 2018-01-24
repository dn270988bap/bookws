package com.sb.bookws.listener;

import com.sb.bookws.configuration.Init;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Init init = new Init();
                        
        for (Map.Entry<String, Object> pair : init.initialization().entrySet()){
            sce.getServletContext().setAttribute(pair.getKey(), pair.getValue());
        }        
        System.out.println("11111111111111111111111111111111111111Initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("2222222222222222222222222222222222222222Destroyed");
    }
}

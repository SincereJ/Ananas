package com.ananas.mn.core.spring;

import com.ananas.mn.core.context.AnanasContext;
import com.ananas.mn.core.context.ContextFactory;
import com.ananas.mn.core.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component("AnanasContextListener")
public class AnanasContextListener extends ContextLoaderListener implements ServletContextListener{

    private AnanasContext ananasContext;
    protected transient final Log log = Log.getLogger(AnanasContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

        ServletContext servletContext = event.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        ContextHolder.setApplicationContext(applicationContext);
        ananasContext = (AnanasContext) ContextFactory.getContext();
        initialize(ContextHolder.getApplicationContext());
    }

    public void initialize(ApplicationContext applicationContext){
        ananasContext.init();

        ananasContext.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        destroy();
    }

    public void destroy(){
        ananasContext.stop();
    }
}

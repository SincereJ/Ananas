package com.ananas.mn.core.spring;

import com.ananas.mn.core.context.AnanasContext;
import com.ananas.mn.core.log.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class AnanasContextListener extends ContextLoaderListener{

    private AnanasContext ananasContext = new AnanasContext();
    protected transient final Log log = Log.getLogger(AnanasContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
    	super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		ContextHolder.setApplicationContext(ctx);
       
		System.out.println("----------start-------------");
		
        initialize(ctx);
        
        System.out.println("----------end----------------");
    }

    public void initialize(ApplicationContext applicationContext){
        ananasContext.init();

        ananasContext.start();
    }

}

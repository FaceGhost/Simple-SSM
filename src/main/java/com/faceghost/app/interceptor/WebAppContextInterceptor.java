package com.faceghost.app.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author faceghost.com/profile/java_world
 *
 */
public class WebAppContextInterceptor implements ServletContextListener{

	 private static final Logger log = Logger.getLogger(WebAppContextInterceptor.class);

	    public static ApplicationContext WEB_APP_CONTEXT = null;

	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
	        if(WEB_APP_CONTEXT != null) {
	            log.info("Spring Context Started ...");

	        }
	    }
	    @Override
	    public void contextDestroyed(ServletContextEvent sce) {

	    }
}

package cl.usm.tdsw.anizooft.config;


import javax.servlet.ServletContext;

import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

public class CustomContextLoaderListener extends ContextLoaderListener {

    @Override
    protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext configurableWebApplicationContext) {

        super.customizeContext(servletContext, configurableWebApplicationContext);
        //this.springContextLoaderSupport.customizeContext(servletContext, configurableWebApplicationContext);
    }
}
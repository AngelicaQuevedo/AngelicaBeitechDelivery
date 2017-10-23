package com.angelica.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RestServiceConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/API/*" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter() };
        return singleton;
    }
}

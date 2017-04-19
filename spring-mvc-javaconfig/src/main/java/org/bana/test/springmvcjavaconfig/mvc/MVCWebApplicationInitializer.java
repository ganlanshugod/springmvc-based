package org.bana.test.springmvcjavaconfig.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MVCWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MVCRootConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/springmvc/*" };
	}
	
	
}

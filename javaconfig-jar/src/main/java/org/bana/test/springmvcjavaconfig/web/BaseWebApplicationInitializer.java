package org.bana.test.springmvcjavaconfig.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.bana.test.springmvcjavaconfig.web.servlet.DispatcherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseWebApplicationInitializer implements WebApplicationInitializer {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		LOG.info("初始化一个元素组件");
		Dynamic addServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet());
		addServlet.addMapping("/mvc/*");
	}

}

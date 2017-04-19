package org.bana.test.springmvcjavaconfig.web;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@HandlesTypes(WebApplicationInitializer.class)
public class CustomServletContainerInitializer implements ServletContainerInitializer {
	
	public CustomServletContainerInitializer() {
		LOG.info("实例化了这个类，。。。 instance");
		System.out.println("实例化了这个类，。。。 instance");
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomServletContainerInitializer.class);
	
	public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
		LOG.info("启动了，startUp");
		System.out.println("启动了，startUp");
		for (Class<?> c : classes){
			System.out.println(c.getName());
		}
		
		List<WebApplicationInitializer> initializers = new LinkedList<WebApplicationInitializer>();

		if (classes != null) {
			for (Class<?> waiClass : classes) {
				// Be defensive: Some servlet containers provide us with invalid classes,
				// no matter what @HandlesTypes says...
				if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
						WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
					try {
						initializers.add((WebApplicationInitializer) waiClass.newInstance());
					}
					catch (Throwable ex) {
						throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
					}
				}
			}
		}

		if (initializers.isEmpty()) {
			servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
			return;
		}

		servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
		for (WebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
}
package org.bana.test.springmvcjavaconfig.web;

import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(Filter.class)
public class CustomWarServletContainerInitializer  implements ServletContainerInitializer
{

	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("CustomWarServletContainerInitializer 启动了，startUp");
		for (Class<?> c : classes){
			System.out.println(c.getName());	
		}
	}

}

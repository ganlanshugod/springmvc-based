package org.bana.test.springmvcjavaconfig.config.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceC {

	@Autowired
	private BeanA beanA;
	
	@Autowired
	private BeanB beanB;
	
	public void sayHello(String name){
		beanA.sayHello(name);
		beanB.sayHello(name);
	}
	
}

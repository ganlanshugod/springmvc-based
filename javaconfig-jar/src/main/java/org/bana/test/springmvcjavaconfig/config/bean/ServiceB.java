package org.bana.test.springmvcjavaconfig.config.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceB {

	@Autowired
	private BeanA beanA;
	
	private BeanB beanB;
	
	public ServiceB(BeanB beanB) {
		this.beanB = beanB;
	}
	
	public void sayHello(String name){
		beanA.sayHello(name);
		beanB.sayHello(name);
	}
	
}

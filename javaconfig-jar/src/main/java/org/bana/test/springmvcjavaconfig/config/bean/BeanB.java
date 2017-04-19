package org.bana.test.springmvcjavaconfig.config.bean;

public class BeanB {

	public String sayHello(String name){
		System.out.println("Bean B : hello " + name);
		return "helloB" + name;
	}
}

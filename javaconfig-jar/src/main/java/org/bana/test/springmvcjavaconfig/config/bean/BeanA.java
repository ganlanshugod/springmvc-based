package org.bana.test.springmvcjavaconfig.config.bean;

public class BeanA {

	public String sayHello(String name){
		System.out.println("Bean A : hello " + name);//
		return "helloA" + name;
	}
}

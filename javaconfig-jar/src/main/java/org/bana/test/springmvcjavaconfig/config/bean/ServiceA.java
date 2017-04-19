package org.bana.test.springmvcjavaconfig.config.bean;

public class ServiceA {

	private BeanA beanA;
	
	private BeanB beanB;
	
	
	public void sayHello(String name){
		beanA.sayHello(name);
		beanB.sayHello(name);
	}

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
	}

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}
	
}

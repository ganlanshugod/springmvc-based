package org.bana.test.springmvcjavaconfig.config.bean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/spring-bean.xml"})
public class BeanXmlTest {
	
	@Autowired
	private ServiceA serviceA;
	@Autowired
	private ServiceB serviceB;
	@Autowired
	private BeanA beanA;
	@Autowired
	private BeanB beanB;
	
	@Autowired
	private ServiceC thisIsServiceC;

	@Test
	public void testServiceA() {
		serviceA.sayHello("liuwenjie");
		System.out.println(BeanConfig.countA);
		System.out.println(BeanConfig.countB);
		assertTrue(beanA == serviceA.getBeanA());
		assertTrue(beanB != serviceA.getBeanB());
	}

	@Test
	public void testServiceB(){
		serviceB.sayHello("liuwenjie");
	}
	
	@Test
	public void testServiceC(){
		thisIsServiceC.sayHello("liuwenjie");
	}
}

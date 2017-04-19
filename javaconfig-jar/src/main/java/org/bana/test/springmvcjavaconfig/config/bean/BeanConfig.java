package org.bana.test.springmvcjavaconfig.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan//增加此标签，SpringApplicationContextHolder的@@Component标签才起作用
public class BeanConfig {
	public static Integer countA = 0;
	public static Integer countB = 0;

	@Bean
	public BeanA beanA(){
		countA ++;
		return new BeanA();
	}

	
	@Bean @Scope("prototype") public BeanB beanB(){
		countB ++;
		return new BeanB();
	}
	
	@Bean public ServiceA serviceA(BeanA beanA,BeanB beanB){
		ServiceA serviceA = new ServiceA();
		serviceA.setBeanA(beanA);
		serviceA.setBeanB(beanB);
		return serviceA;
	}
	
	@Bean public ServiceB serviceA(BeanB beanB){//看这种的其实也是可以的
		System.out.println("走的serviceA的方法");
		ServiceB serviceA = new ServiceB(beanB);
		return serviceA;
	}
	
	@Bean public ServiceB serviceB(BeanB beanB){
		System.out.println("走的serviceB的方法");
		ServiceB serviceB = new ServiceB(beanB);
		return serviceB;
	}
	
	@Bean public ServiceC useCService(){
		return new ServiceC();
	}
	
	/**
	 * 注掉此配置后，代开类上的@ComponetScan标签一样可以满足要求
	 */
	@Bean public SpringApplicationContextHolder applicationContextHolder(){
		return new SpringApplicationContextHolder();
	}
}

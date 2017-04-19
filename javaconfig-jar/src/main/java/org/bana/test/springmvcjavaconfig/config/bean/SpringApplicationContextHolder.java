package org.bana.test.springmvcjavaconfig.config.bean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: SpringApplicationContextHolder 
 * @Description: bean 配置文件的管理方法
 *  
 */
@Component
public class SpringApplicationContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;
	
	/**
	 * 获取bean实例
	 * @param beanId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId){
		checkApplicationContext();
		return (T)applicationContext.getBean(beanId);
	}
	
	public static <T> T getBean(Class<T> clazz) {  
		checkApplicationContext();
		return (T) applicationContext.getBean(clazz);  
	}
	
	private static void checkApplicationContext() {  
		if (applicationContext == null) {  
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");  
		}  
	}  

	/**
	 * @Description: 属性 applicationContext 的get方法 
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @Description: 属性 applicationContext 的set方法 
	 * @param applicationContext 
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContextHolder.applicationContext = applicationContext;
	}
	
}

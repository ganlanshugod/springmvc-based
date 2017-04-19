package org.bana.test.springmvcjavaconfig.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.bana.test.springmvcjavaconfig.mvc")
public class MVCRootConfig extends WebMvcConfigurerAdapter{

	@Bean //视图解析器
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	//配置静态资源处理
    @Override //相当于<mvc:default-servlet-handler/>
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//将静态资源的请求转发到servlet容器中默认的servlet上
    }
    
    @Bean //声明interceptor
    public DemoInteceptor demoInteceptor(){
    	return new DemoInteceptor();
    }
    
    @Override //注册interceptor
    public void addInterceptors(InterceptorRegistry registry) {
    	InterceptorRegistration addInterceptor = registry.addInterceptor(demoInteceptor());
//    	addInterceptor.addPathPatterns("/");
    	addInterceptor.excludePathPatterns("/helloworld");
    }
	
    @Override //增加默认跳转到对应视图的映射路径
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/demo/*").setViewName("demo1");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }
    
}

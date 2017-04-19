package org.bana.test.springmvcjavaconfig.mvc;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@RequestMapping(value="/restHello")
	public HelloPojo getHello(String name){
		HelloPojo pojo = new HelloPojo();
		pojo.setName(name);
		pojo.setValue("value");
		pojo.setSize(10);
		return pojo;
	}
	
	@RequestMapping("/restShow")
	public String showHello(HelloPojo helloPojo,@ModelAttribute("msg")String msg){
		System.out.println(msg);
		System.out.println(helloPojo);
		return "success";
	}
	
	@RequestMapping("/resterror")
	public String restError(){
		System.out.println("restError");
		throw new IllegalArgumentException("异常数据内容");
	}
}

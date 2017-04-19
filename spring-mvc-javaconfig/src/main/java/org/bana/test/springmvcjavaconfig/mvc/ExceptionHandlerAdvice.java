package org.bana.test.springmvcjavaconfig.mvc;

import java.util.Iterator;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //可以对Controller进行全局的处理
//@RestControllerAdvice(annotations=RestController.class)//可以实现只过滤rest的接口方法
public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception exception,WebRequest request){
		System.out.println("ExceptionHandlerAdvice  exception");
		Iterator<String> headerNames = request.getHeaderNames();
		while(headerNames.hasNext()){
			String headName = headerNames.next();
			System.out.println(headName + " = " + request.getHeader(headName));
		}
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public ExceptionResponse exception(Exception exception,WebRequest request){
//		System.out.println("ExceptionHandlerAdvice  exception");
//		return ExceptionResponse.create(500, exception.getMessage());
//	}
	
	@ModelAttribute
	public void addAtttibutes(Model model){
		System.out.println("ExceptionHandlerAdvice addAtttibutes...");
		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		System.out.println("ExceptionHandlerAdvice initBinder...");
		webDataBinder.setDisallowedFields("name");
		String[] requiredFields = webDataBinder.getRequiredFields();
		String[] allowedFields = webDataBinder.getAllowedFields();
		System.out.println("allowedFields.." + allowedFields);
		System.out.println("requiredFields.. " + requiredFields);
//		webDataBinder.getBindingResult()
	}
}

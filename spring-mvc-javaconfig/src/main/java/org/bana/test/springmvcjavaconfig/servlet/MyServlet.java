package org.bana.test.springmvcjavaconfig.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foo")  
public class MyServlet extends HttpServlet{  
	private static final long serialVersionUID = 7553954622208115710L;

	//...  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/foo do get");
		resp.getOutputStream().write("sucess".getBytes());
	}
} 
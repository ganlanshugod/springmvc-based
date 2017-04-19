package org.bana.test.springmvcxml.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomServlet  extends HttpServlet{

	private static final long serialVersionUID = -862141756348542116L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/doo do get");
		resp.getOutputStream().write("doo sucess".getBytes());
	}

}

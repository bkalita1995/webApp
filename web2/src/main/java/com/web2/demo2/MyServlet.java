package com.web2.demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;

@Singleton
@WebServlet("/add")
public class MyServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int number1 = Integer.parseInt(req.getParameter("number1"));
		int number2 = Integer.parseInt(req.getParameter("number2"));
		
		int sum = number1 + number2;
		
		PrintWriter out = resp.getWriter();
		
		out.println(sum);
	}

}

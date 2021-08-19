package com.web2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;
import com.web2.Entity.Student;

@Singleton
@WebServlet("/remove")
public class Remove extends HttpServlet{
	private static final long serialVersionUID = -2062992834278242238L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo");
		EntityManager emanager = emFactory.createEntityManager();
		emanager.getTransaction().begin();
		PrintWriter pw = resp.getWriter();
		
		int roll_no = Integer.parseInt(req.getParameter("rollno"));
		
		Student student = emanager.find(Student.class, roll_no);		
		emanager.remove(student);
		
		pw.println("Roll No " + student.getRoll_no() + " SuccesFully Removed");
		
		emanager.getTransaction().commit();
		emFactory.close();
		emanager.close();
	}

}

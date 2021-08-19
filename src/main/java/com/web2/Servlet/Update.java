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
@WebServlet("/update")
public class Update extends HttpServlet{
	private static final long serialVersionUID = 5127587652923948189L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		int roll_no = Integer.parseInt(req.getParameter("rollno"));
		String fname= req.getParameter("fname");
		String lname = req.getParameter("lname");
		PrintWriter pw = resp.getWriter();
		
		Student student = eManager.find(Student.class, roll_no);
		student.setFname(fname);
		student.setLname(lname);
		
		eManager.persist(student);
		
		pw.println("Data SuccessFull Updated");
		
		
		
		eManager.getTransaction().commit();
		emFactory.close();
		eManager.close();
		
		
		
	}

}

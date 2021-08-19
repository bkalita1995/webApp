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
@WebServlet("/insertSearch")
public class InsertFind extends HttpServlet{
	private static final long serialVersionUID = 6069880752852836309L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		Student student = null;
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		PrintWriter pw = resp.getWriter();
		
		student = eManager.find(Student.class, rollno);
		
		
		try {		
		pw.println("Roll No: "+student.getRoll_no());
		pw.println("First Name: "+student.getFname());
		pw.println("Last Name: "+student.getLname());
		}
		
		catch(Exception e){
			pw.println("Sorry! No Data Exist");
			
		}
		
		eManager.getTransaction().commit();
		eManager.close();
		emFactory.close();
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		int rollno = Integer.parseInt(req.getParameter("roll_no"));
		String f_name = req.getParameter("fname");
		String l_name = req.getParameter("lname");
		
		Student student = new Student();
		
		student.setRoll_no(rollno);
		student.setFname(f_name);
		student.setLname(l_name);
		
		eManager.persist(student);
		
		PrintWriter pw = resp.getWriter();
		pw.println("Data Successfully Saved");
		
		
		
		eManager.getTransaction().commit();
		eManager.close();
		emFactory.close();
		
	}
}

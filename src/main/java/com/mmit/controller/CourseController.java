package com.mmit.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmit.controller.service.CourseService;
import com.mmit.entity.Course;






@WebServlet({"/course-add","/courses","/course-edit","/course-delete"})
public class CourseController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseService courseService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		EntityManagerFactory EMF=null;
		Object obj=getServletContext().getAttribute("emf");//application scope
		if(obj==null) {
			EMF=Persistence.createEntityManagerFactory("jpa-student-assignment");
			getServletContext().setAttribute("emf", EMF);
		}else {
			EMF=(EntityManagerFactory) obj;
		}
		courseService=new CourseService(EMF.createEntityManager());
		
	}
	@Override
		public void destroy() {
			EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
			if(emf!=null && emf.isOpen()) {
				emf.close();
			}
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		if("/course-add".equals(action)) {
			String courseid=req.getParameter("courseid");
			String name=req.getParameter("coursename");
			String fees=req.getParameter("fees");
			String duration=req.getParameter("duration");
			String level=req.getParameter("level");
			
			//create object
			
			
			Course c=(courseid==null || courseid.equals("") ? new Course():courseService.findById(Integer.parseInt(courseid)));
			c.setName(name);
			c.setFees(Integer.parseInt(fees));
			c.setDuration(duration);
			c.setLevel(level);
			//sent to request
			req.setAttribute("course", c);
			//save to db
			courseService.save(c);
			
			//redirect
			
			resp.sendRedirect(req.getContextPath().concat("/courses"));
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		
		if("/course-add".equals(path)||"/course-edit".equals(path)) {
			//get data from db
			
			List<Course> list=courseService.findAll();
			
			//set data to req
			req.setAttribute("course",list);
			
		 if("/course-edit".equals(path)) {
			//get id from request 
			String courseId=req.getParameter("courseid");
			
			//get data from db
			Course course=courseService.findById(Integer.parseInt(courseId));
			
			//set data to req
			
			req.setAttribute("course", course);
			
		 }
		//forward page
			
			getServletContext().getRequestDispatcher("/course-add.jsp").forward(req, resp);
			
		}else if("/courses".equals(path)) {
		//get items from db
		List<Course> list=courseService.findAll();
		
		//add item to req
		req.setAttribute("course",list);
		//forward
		getServletContext().getRequestDispatcher("/course.jsp").forward(req,resp);
	}else if("/course-delete".equals(path)) {
		String id=req.getParameter("courseid");
		
		courseService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath().concat("/courses"));
	}
	
	}
	}

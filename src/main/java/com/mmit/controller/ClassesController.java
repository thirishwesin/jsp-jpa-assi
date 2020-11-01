package com.mmit.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmit.controller.service.ClassesService;
import com.mmit.entity.Classes;
import com.mmit.entity.Course;
@WebServlet({"/classes-add","/classes","/class-edit","/class-delete"})
public class ClassesController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private ClassesService classService;
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
		classService=new ClassesService(EMF.createEntityManager());
		
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
		String path=req.getServletPath();
		if("/classes-add".equals(path)) {
			String cid=req.getParameter("classid");
			String name=req.getParameter("classname");
			String sdate=req.getParameter("sdate");
			LocalDate ldate = LocalDate.parse(sdate);
			
			//create object
			
			Classes c=(cid==null || cid.equals("") ? new Classes():classService.findById(Integer.parseInt(cid)));
			c.setName(name);
			c.setStart_date(ldate);
			//add to db
			
			ClassesService.save(c);
			//set to request
			req.setAttribute("classes",c);
			//redirect page
			
			resp.sendRedirect(req.getContextPath().concat("/classes"));
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if("/classes".equals(path)) {
			List<Classes> list=classService.findAll();
			//set to request
			
			req.setAttribute("classes",list);
			//forward
			getServletContext().getRequestDispatcher("/classes.jsp").forward(req,resp);
		
		}else if("/classes-add".equals(path)||"/class-edit".equals(path)) {
			//get data from db
			
			List<Classes> list=classService.findAll();
			
			//set data to req
			req.setAttribute("classes",list);
			
		 if("/class-edit".equals(path)) {
			//get id from request 
			String classId=req.getParameter("classid");
			
			//get data from db
			
			Classes c=classService.findById(Integer.parseInt(classId));
			
			//set data to req
			
			req.setAttribute("classes", c);
			
		 }
		//forward page
			
			getServletContext().getRequestDispatcher("/classes-add.jsp").forward(req, resp);
			
		}else if("/class-delete".equals(path)){
			String id=req.getParameter("classid");
			
			classService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath().concat("/classes"));
			
	
	}
	}
	

}

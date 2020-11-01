package com.mmit.controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.entity.Course;

public class CourseService {
	
	private static EntityManager em;
	public CourseService(EntityManager em) {
		this.em=em;
	}
	public void save(Course c) {
		em.getTransaction().begin();
		if(c.getId()==0)
		em.persist(c);
		else
			em.merge(c);
		em.getTransaction().commit();
		
	}
	public List<Course> findAll() {
		
		TypedQuery< Course> query=em.createNamedQuery("Course.getAll", Course.class);
		List<Course> list=query.getResultList();
		
		return list;
	}
	public Course findById(int id) {
		
		return em.find(Course.class, id);
	}
	public void delete(int id) {
		em.getTransaction().begin();
		Course c=em.find(Course.class,id);
		em.remove(c);
		em.getTransaction().commit();
		
	}

}

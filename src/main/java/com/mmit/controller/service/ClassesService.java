package com.mmit.controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.entity.Classes;

public class ClassesService {

	private static EntityManager em;
	public ClassesService(EntityManager em) {
		this.em=em;
	}
	public static void save(Classes c) {
		em.getTransaction().begin();
		if(c.getId()==0)
			em.persist(c);
			else
				em.merge(c);
		em.getTransaction().commit();
		
	}
	public List<Classes> findAll() {
		TypedQuery<Classes> query=em.createNamedQuery("Classes.getAll", Classes.class);
		List<Classes> list=query.getResultList();
		return list;
	}
	public Classes findById(int id) {
		
		return em.find(Classes.class, id);
	}
	public void delete(int id) {
		em.getTransaction().begin();
		
		Classes c=em.find(Classes.class,id);
		em.remove(c);
		em.getTransaction().commit();
		
		
	}

}

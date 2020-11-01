package com.mmit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@NamedQuery(name="Student.getAll",query="SELECT s FROM Student s")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	@OneToMany(mappedBy = "student")
	List<Registration> reg;
	
	public List<Registration> getReg() {
		return reg;
	}

	public void setReg(List<Registration> reg) {
		this.reg = reg;
	}

	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
   
}

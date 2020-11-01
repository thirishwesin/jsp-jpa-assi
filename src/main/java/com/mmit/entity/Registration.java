package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Registration
 *
 */
@Entity
@NamedQuery(name="Registration.getAll",query="SELECT r FROM Registration r")
public class Registration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;
	@ManyToOne
	@JoinColumn(name = "classes_id", referencedColumnName = "id")
	private Classes classes;
	private LocalDate reg_date;
	private int paid_amt;
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}

	public int getPaid_amt() {
		return paid_amt;
	}

	public void setPaid_amt(int paid_amt) {
		this.paid_amt = paid_amt;
	}
	
   
}

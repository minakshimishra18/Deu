package com.demo.deu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeDuration")
public class EmployeeDuration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String empDuration;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmpDuration() {
		return empDuration;
	}


	public void setEmpDuration(String empDuration) {
		this.empDuration = empDuration;
	}


	@Override
	public String toString() {
		return "EmployeeDuration [id=" + id + ", empDuration=" + empDuration + "]";
	}


	public EmployeeDuration(int id, String empDuration) {
		super();
		this.id = id;
		this.empDuration = empDuration;
	}
	public EmployeeDuration()
{}
	}

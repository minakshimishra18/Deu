package com.demo.deu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departmentType")
public class DepartmentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String depType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepType() {
		return depType;
	}
	public void setDepType(String depType) {
		this.depType = depType;
	}
	@Override
	public String toString() {
		return "DepartmentType [id=" + id + ", depType=" + depType + "]";
	}
	public DepartmentType(int id, String depType) {
		super();
		this.id = id;
		this.depType = depType;
	}
	
    public DepartmentType() {}
}

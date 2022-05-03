package com.demo.deu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designation")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String desType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesType() {
		return desType;
	}
	public void setDesType(String desType) {
		this.desType = desType;
	}
	@Override
	public String toString() {
		return "Designation [id=" + id + ", desType=" + desType + "]";
	}
	public Designation(int id, String desType) {
		super();
		this.id = id;
		this.desType = desType;
	}
	public Designation()
{}
}

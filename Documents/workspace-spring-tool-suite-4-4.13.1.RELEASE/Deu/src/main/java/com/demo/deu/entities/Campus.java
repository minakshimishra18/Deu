package com.demo.deu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "campus")
public class Campus {
	
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "campus_id")
	private int id;

	@Column(name = "campus_name")
	private String name;

	@Column(name = "campus_location")
	private String location;
     
	
	
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

	@Override
	public String toString() {
		return "Campus [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	public Campus(int id, String name, String location, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Campus()
	{
		
	}

	
}

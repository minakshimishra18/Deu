package com.demo.deu.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="academic_profile")
public class AcademicProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String profileName;
	
		
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	@Override
	public String toString() {
		return "AcademicProfile [id=" + id + ", profileName=" + profileName + "]";
	}
	public AcademicProfile(int id, String profileName) {
		super();
		this.id = id;
		this.profileName = profileName;
	}
	 public AcademicProfile() {}
}

package com.demo.deu.entities;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="student", uniqueConstraints = @UniqueConstraint(columnNames = {"phoneNumber", "userName"}))
@EntityListeners(AuditingEntityListener.class)
public class Student  {
	
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;
	
	
	@NotBlank(message = "Name is required.")
    private String name;
	

	
	@NotBlank(message = "Name is required.")
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{7,20}$", message = "Enter a valid user name between 7 to 20.")
    private String userName;
	
	
	@NotBlank(message = "Password is required.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "provide valid format. example. Aa1@123")
    private String password;
	
	
	@Size(min=3 , max=11, message = "size sould be between 3 to 11.")
	@NotBlank(message = "PhoneNumber is required.")
	@Digits(message = "only digits are required, size has to be between 3 to 11", fraction = 8, integer = 11)
    private String phoneNumber;
	
	
	@NotBlank(message = "Campus is required.")
    private String campus;
	
	
	@NotBlank(message = "Department is required.")
    private String department;
	
	
	@NotBlank(message = "Course is required.")
	private String course;
	
	
	@NotBlank(message = "Academicprofile is required.")
     private String academicProfile;
	
	@CreatedDate
    private LocalDateTime created;
    
    @LastModifiedDate
    private LocalDateTime updated;
    
    
    @OneToOne(mappedBy = "student")
    private AcademicReportCard academicReportCard;
    
    
	public AcademicReportCard getAcademicReportCard() {
		return academicReportCard;
	}

	public void setAcademicReportCard(AcademicReportCard academicReportCard) {
		this.academicReportCard = academicReportCard;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAcademicProfile() {
		return academicProfile;
	}

	public void setAcademicProfile(String academicProfile) {
		this.academicProfile = academicProfile;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
     
  
		

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", campus=" + campus + ", department=" + department + ", course="
				+ course + ", academicProfile=" + academicProfile + ", created=" + created + ", updated=" + updated
				+ ", academicReportCard=" + academicReportCard + "]";
	}
	
	

		public Student(UUID id, @NotBlank(message = "Name is required.") String name,
			@NotBlank(message = "Name is required.") @Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{7,20}$", message = "Enter a valid user name between 7 to 20.") String userName,
			@NotBlank(message = "Password is required.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "provide valid format. example. Aa1@123") String password,
			@Size(min = 3, max = 11, message = "size sould be between 3 to 11.") @NotBlank(message = "PhoneNumber is required.") @Digits(message = "only digits are required, size has to be between 3 to 11", fraction = 8, integer = 11) String phoneNumber,
			@NotBlank(message = "Campus is required.") String campus,
			@NotBlank(message = "Department is required.") String department,
			@NotBlank(message = "Course is required.") String course,
			@NotBlank(message = "Academicprofile is required.") String academicProfile, LocalDateTime created,
			LocalDateTime updated, AcademicReportCard academicReportCard) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.campus = campus;
		this.department = department;
		this.course = course;
		this.academicProfile = academicProfile;
		this.created = created;
		this.updated = updated;
		this.academicReportCard = academicReportCard;
	}

		public Student() {}
	
}
	
	
	



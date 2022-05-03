package com.demo.deu.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Employee", uniqueConstraints = @UniqueConstraint(columnNames = {"phoneNumber", "userName"}))
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	@NotBlank(message = "Name is required.")
	private String employeeName;
	
	@NotBlank(message = "Username is required.")
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{7,20}$", message = "Enter a valid user name between 7 to 20.")
	private String userName;
	
	@NotBlank(message = "Password is required.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Size should be between 7 to 20. provide valid format. example. Aa1@123")
    private String password;
	
	@NotBlank(message = "Phonenumber is required.")
	@Size(min=3 , max=11 , message = "size should be between 3 to 11.")
	@Digits(message = "only digits are required", fraction = 8, integer = 10)
	private String phoneNumber;
	
	@NotBlank(message = "Designation is required.")
	private String designation;
	
	@NotBlank(message = "Salary is required.")
	private String salary;
	
	@NotBlank(message ="Employee Duration is required.")
	private String employeeDuration;
	
	
	@NotBlank(message ="Department type is required.")
	private String departmentType;
	

	
	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmployeeDuration() {
		return employeeDuration;
	}

	public void setEmployeeDuration(String employeeDuration) {
		this.employeeDuration = employeeDuration;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", employeeName=" + employeeName + ", userName=" + userName + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", designation=" + designation + ", salary=" + salary
				+ ", employeeDuration=" + employeeDuration + ", departmentType=" + departmentType + "]";
	}

	
	public Employee(int empid, @NotBlank(message = "name is required.") String employeeName,
			@NotBlank(message = "username is required.") String userName,
			@NotBlank(message = "password is required.") String password,
			@NotBlank(message = "phonenumber is required.") @Size(min = 3, max = 11, message = "size should be between 3 to 11.") @Digits(message = "only digits are required", fraction = 8, integer = 10) String phoneNumber,
			@NotBlank(message = "designation is required.") String designation,
			@NotBlank(message = "salary is required.") String salary,
			@NotBlank(message = "employeeduration is required.") String employeeDuration,
			@NotBlank(message = "employeeduration is required.") String departmentType) {
		super();
		this.empid = empid;
		this.employeeName = employeeName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.salary = salary;
		this.employeeDuration = employeeDuration;
		this.departmentType = departmentType;
	}

	public Employee() {}

}

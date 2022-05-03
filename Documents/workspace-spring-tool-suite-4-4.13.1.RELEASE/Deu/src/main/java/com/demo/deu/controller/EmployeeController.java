package com.demo.deu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Employee;
import com.demo.deu.repo.DepartmentTypeRepo;
import com.demo.deu.repo.DesignationRepo;
import com.demo.deu.repo.EmployeeDurationrepo;
import com.demo.deu.repo.EmployeeRepo;
import com.demo.deu.repo.SalaryRepo;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DesignationRepo designationRepo;
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	private EmployeeDurationrepo employeeDurationrepo;
	

	
	@Autowired
	private DepartmentTypeRepo departmentTypeRepo;
	
	@PostMapping("/employee")

	public ResponseEntity<Message> addEmployee(@Valid @RequestBody Employee employee) {
		Message response = new Message();
		Employee verifPhonenumber = employeeRepo.findByPhoneNumber(employee.getPhoneNumber());
    	Employee verifyUserName= employeeRepo.findByUserName(employee.getUserName());
        if(verifPhonenumber==null && verifyUserName==null) {
        	boolean departmentType = departmentTypeRepo.existsByDepType(employee.getDepartmentType());
    		boolean designation=designationRepo.existsByDesType(employee.getDesignation());
    		boolean salary = salaryRepo.existsByEmpSalary(employee.getSalary());
    		boolean employeeDuration = employeeDurationrepo.existsByEmpDuration(employee.getEmployeeDuration());
    		System.out.println(salary);
    		if(departmentType==true && designation==true &&salary==true&& employeeDuration==true)
    		{
		
		employeeRepo.save(employee);
		response.setMessage("Employee registered Successfully");
		return ResponseEntity.ok().body(response);
         
    		} 
    		else  
    		{
    			response.setMessage("fill the details according to description.")  ;  		
    		}
        }
        
        else {
        	response.setMessage("Student exists already.");
    		return ResponseEntity.badRequest().body(response);

        }
        
		return ResponseEntity.badRequest().body(response);
        }
	@PostMapping("/loginEmployee")
	public ResponseEntity<Message> loginEmployee(@RequestBody Employee employee) {
		Message response = new Message();
		employee.setPhoneNumber(employee.getPhoneNumber());
		employee.setPassword(employee.getPassword());
		if (employeeRepo.existsByPhoneNumber(employee.getPhoneNumber()) == true
				&& employeeRepo.existsByPassword(employee.getPassword()) == true) {
			response.setMessage("student logged in successfully.");
			return ResponseEntity.ok().body(response);
		} else {
			response.setMessage("enter your details correctly");
			return ResponseEntity.badRequest().body(response);
		}

	}

}

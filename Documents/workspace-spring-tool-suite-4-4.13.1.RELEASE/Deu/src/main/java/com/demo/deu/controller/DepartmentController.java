package com.demo.deu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Department;
import com.demo.deu.repo.DepartmentRepo;

@RestController
@RequestMapping(value="/dep")
public class DepartmentController {
	
    @Autowired
	private DepartmentRepo departmentRepo;
    
    
	@PostMapping("/department")
	public ResponseEntity<Message> addDepartment( @RequestBody Department department) {
		Message response = new Message();
		departmentRepo.save(department);
		response.setMessage("Department details updated successfully.");
		return ResponseEntity.ok().body(response);
           
	}

	
}

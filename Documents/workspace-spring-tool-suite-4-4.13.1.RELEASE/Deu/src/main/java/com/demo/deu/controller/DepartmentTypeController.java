package com.demo.deu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.DepartmentType;
import com.demo.deu.repo.DepartmentTypeRepo;

@RestController
public class DepartmentTypeController {
	
	@Autowired
	private DepartmentTypeRepo departmentTypeRepo;

	@PostMapping("/depType")
	public ResponseEntity<Message> addDepType(@RequestBody DepartmentType departmentType){
		Message response= new Message();
		
		departmentTypeRepo.save(departmentType);
		response.setMessage("department type details saved successfully.");
		return ResponseEntity.ok().body(response);
	}
	
}

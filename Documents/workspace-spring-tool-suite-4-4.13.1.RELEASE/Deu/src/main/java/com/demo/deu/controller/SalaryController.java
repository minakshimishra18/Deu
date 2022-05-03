package com.demo.deu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Salary;
import com.demo.deu.repo.SalaryRepo;

@RestController
public class SalaryController {
	
	@Autowired
	private SalaryRepo salaryRepo;
		
	@PostMapping("/saveSalary")
	public ResponseEntity<Message> addSalary(@RequestBody Salary salary){
	Message response= new Message();
	
	salaryRepo.save(salary);
   response.setMessage("salary saved successfully");
   return ResponseEntity.ok().body(response);
}
}
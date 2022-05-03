package com.demo.deu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.EmployeeDuration;
import com.demo.deu.repo.EmployeeDurationrepo;

@RestController
public class EmployeeDurationController {
	
	
      @Autowired
        private EmployeeDurationrepo employeeDurationrepo;
	
	
	@PostMapping("/saveDuration")
	public ResponseEntity<Message> addDuration(@RequestBody EmployeeDuration employeeDuration)
	{
		Message response = new Message();
		 employeeDurationrepo.save(employeeDuration);
		response.setMessage("Employee duration details saved successfully.");
		return ResponseEntity.ok().body(response);
	}	
	
}

package com.demo.deu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Designation;
import com.demo.deu.repo.DesignationRepo;

@RestController
public class DesignationController {

	
	@Autowired
	private DesignationRepo designationRepo;
	
	@PostMapping("/saveDes")
	public ResponseEntity<Message> addDes(@RequestBody Designation designation)
	{
		Message response = new Message();
		designationRepo.save(designation);
		response.setMessage("Designation details savess successfully");
		return ResponseEntity.ok().body(response);
	}
}

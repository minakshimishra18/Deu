package com.demo.deu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Campus;
import com.demo.deu.repo.CampusRepo;


@RestController
@RequestMapping(value= "/cam")
public class CampusController {

	@Autowired
	private CampusRepo campusRepo;
	
	@PostMapping("/campus")
	public ResponseEntity<Message> addCampus(@RequestBody Campus campus) {
		
		Message response = new Message();
		
         campusRepo.save(campus);
         response.setMessage("Campus details updated successfully.");
		
		return ResponseEntity.ok().body(response);

	}

	
}

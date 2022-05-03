package com.demo.deu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.AcademicProfile;
import com.demo.deu.repo.AcademicProfileRepo;

@RestController
@RequestMapping(value="/aci")
public class AcademicProfileController {

	
	@Autowired
	private AcademicProfileRepo academicProfileRepo;
	
	
	@PostMapping("/academicProfile")
	public ResponseEntity<Message> addAcademicProfile( @RequestBody AcademicProfile academicProfile) {
		Message response = new Message();
	    academicProfileRepo.save(academicProfile);
		response.setMessage("AcademicProfile details updated successfully.");
		return ResponseEntity.ok().body(response);


}
}

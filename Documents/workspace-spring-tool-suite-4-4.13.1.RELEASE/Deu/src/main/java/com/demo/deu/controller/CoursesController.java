package com.demo.deu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deu.customresponse.Message;
import com.demo.deu.entities.Courses;
import com.demo.deu.repo.CoursesRepo;

@RestController
@RequestMapping(value="/cour")
public class CoursesController {
	
	@Autowired
	private CoursesRepo coursesRepo;
	
	
	@PostMapping("/course")
	public ResponseEntity<Message> addCourse( @RequestBody Courses courses){
		Message response = new Message();
        coursesRepo.save(courses);
		response.setMessage("Courses details updated successfully.");
		return ResponseEntity.ok().body(response);

	}

	

}

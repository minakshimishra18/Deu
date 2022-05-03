package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Courses;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Integer>{

	boolean existsByCourseName(String courseName);

}

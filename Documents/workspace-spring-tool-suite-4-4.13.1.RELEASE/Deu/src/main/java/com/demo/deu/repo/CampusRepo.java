package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Campus;
import com.demo.deu.entities.Student;

@Repository
public interface CampusRepo extends JpaRepository<Campus, Integer>{

	boolean existsByName(String name);


}

package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.AcademicProfile;

@Repository
public interface AcademicProfileRepo extends JpaRepository<AcademicProfile, Integer> {


	boolean existsByProfileName(String profileName);
			
			
			
			



}

package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Designation;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Integer>{


	boolean existsByDesType(String desType);


}

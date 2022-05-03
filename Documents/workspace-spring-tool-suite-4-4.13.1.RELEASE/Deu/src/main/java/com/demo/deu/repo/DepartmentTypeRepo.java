package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.DepartmentType;

@Repository
public interface DepartmentTypeRepo extends JpaRepository<DepartmentType, Integer>{

	boolean existsByDepType(String depType);

}

package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	
	boolean existsByDepartmentName(String departmentName);
}

package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.EmployeeDuration;

@Repository
public interface EmployeeDurationrepo extends JpaRepository<EmployeeDuration, Integer> {


	boolean existsByEmpDuration(String empDuration);

}

package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Integer> {


	boolean existsByEmpSalary(String empSalary);

}

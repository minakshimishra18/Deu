package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{


	boolean existsByPassword(String password);

	boolean existsByPhoneNumber(String phoneNumber);

	Employee findByPhoneNumber(String phoneNumber);

	Employee findByUserName(String userName);

}

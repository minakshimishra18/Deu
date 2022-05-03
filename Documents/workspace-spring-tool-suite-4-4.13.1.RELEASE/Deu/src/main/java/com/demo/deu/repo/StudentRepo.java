package com.demo.deu.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.deu.entities.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, UUID> {

	boolean existsByPassword(String password);

	boolean existsByPhoneNumber(String phoneNumber);


	Student findByPhoneNumber(String phoneNumber);

	Student findByUserName(String userName);

	
	

}

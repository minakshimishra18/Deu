package com.demo.deu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.deu.entities.AcademicReportCard;


@Repository
public interface AttachmentRepo extends JpaRepository<AcademicReportCard, String> {


}
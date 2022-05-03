package com.demo.deu.service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.deu.entities.AcademicReportCard;


public interface AttachmentServiceInter {

	
	AcademicReportCard saveFile(MultipartFile file) throws Exception;
	AcademicReportCard getAttachment(String fileId) throws Exception;
     
     
}
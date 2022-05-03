package com.demo.deu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.demo.deu.entities.AcademicReportCard;
import com.demo.deu.repo.AttachmentRepo;


@Service
public class AttachmentService  implements AttachmentServiceInter {
	
	
	@Autowired
	private AttachmentRepo attachmentRepo;

	@Override
    public AcademicReportCard saveFile(MultipartFile file) throws Exception 
	{
       String fileName= StringUtils.cleanPath(file.getOriginalFilename());
       try {
         if (fileName.contains("..")) {
             throw new Exception("File contains invalid path sequence" + fileName);
         }
         AcademicReportCard attachment=
                 new AcademicReportCard(fileName
                 , file.getContentType()
                 , file.getBytes());

         return  attachmentRepo.save(attachment);
         }catch (Exception e)
       {

           throw new Exception("file could not be saved "+ fileName);
       }
    }
	
    @Override
    public AcademicReportCard getAttachment(String fileId) throws Exception {
		return attachmentRepo.findById(fileId).orElseThrow(
                ()-> new Exception("File not found with Id : "+ fileId));	

          
    }
}
	
	
	
	
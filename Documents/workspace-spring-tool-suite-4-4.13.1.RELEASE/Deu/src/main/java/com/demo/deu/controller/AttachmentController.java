package com.demo.deu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.demo.deu.customresponse.ResponseAttachment;
import com.demo.deu.entities.AcademicReportCard;
import com.demo.deu.entities.Student;
import com.demo.deu.repo.StudentRepo;
import com.demo.deu.service.AttachmentService;
import com.demo.deu.service.DeuServiceImpl;



@RestController
public class AttachmentController {
	
	@Autowired
	private DeuServiceImpl deuServiceImpl;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AttachmentService attachmentService;

	@PostMapping("/upload")
     public ResponseAttachment upload(@RequestParam("file")MultipartFile file) throws Exception {		
           AcademicReportCard attachment=null;
           String downloadUrl="";
   	      AcademicReportCard attachment1=new AcademicReportCard();

        String phoneNumber = deuServiceImpl.getphoneNumber();
	   	Student student = studentRepo.findByPhoneNumber(phoneNumber);
	   	attachment1.setStudent(student);
	   	
        System.out.println(attachment1);
        attachment=attachmentService.saveFile(file);
        downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath() .path("/download/").path(attachment.getId()).toUriString();
        return  new ResponseAttachment(attachment.getFileName(), downloadUrl , file.getContentType(), file.getSize());
    }
	
	
	 @GetMapping("/download/{fileId}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
		 AcademicReportCard attachment=null;
	        attachment=attachmentService.getAttachment(fileId);
	        return  ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(attachment.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION
	                ,"attachment; filename=\""+attachment.getFileName()
	                +"\"").body(new ByteArrayResource(attachment.getData()));
	    }
	 
	}
	
	
	
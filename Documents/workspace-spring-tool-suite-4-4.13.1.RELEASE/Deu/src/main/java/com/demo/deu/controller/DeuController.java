package com.demo.deu.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.deu.customresponse.Message;
import com.demo.deu.customresponse.TokenResponse;
import com.demo.deu.entities.Cache;
import com.demo.deu.entities.Student;
import com.demo.deu.repo.AcademicProfileRepo;
import com.demo.deu.repo.CampusRepo;
import com.demo.deu.repo.CoursesRepo;
import com.demo.deu.repo.DepartmentRepo;
import com.demo.deu.repo.EmployeeRepo;
import com.demo.deu.repo.StudentRepo;
import com.demo.deu.service.DeuService;
import com.demo.deu.service.DeuServiceImpl;
import com.demo.deu.service.JwtUtil;

@EnableCaching
@RestController
@RequestMapping(value = "/uni")
public class DeuController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private DeuService deuService;
	
     @Autowired
     private JwtUtil jwtUtil;
	
     @Autowired
     private AcademicProfileRepo academicProfileRepo;
	
	 @Autowired
	 private StudentRepo studentRepo;

	 @Autowired
	 private EmployeeRepo employeeRepo;

     @Autowired
     private DeuServiceImpl deuServiceImpl;
     
     @Autowired
     private CampusRepo campusRepo;
 
     @Autowired
     private CoursesRepo coursesRepo;
     
     @Autowired
     private DepartmentRepo departmentRepo;
     
     static Map<String, Object> inmemorydataMap = new HashMap<>();
 
	@PostMapping("/student")
	public ResponseEntity<Message> addStudent(@Valid @RequestBody Student student) {
		try {
			Message response = new Message();
	    	Student verifPhonenumber = studentRepo.findByPhoneNumber(student.getPhoneNumber());
	    	Student verifyUserName= studentRepo.findByUserName(student.getUserName());
	        if(verifPhonenumber==null && verifyUserName==null) 
	        {
	    		boolean academicProfile = academicProfileRepo.existsByProfileName(student.getAcademicProfile());
	    		boolean campus=campusRepo.existsByName(student.getCampus());
	    		boolean courses = coursesRepo.existsByCourseName(student.getCourse());
	    		boolean department = departmentRepo.existsByDepartmentName(student.getDepartment());
	    		System.out.println(academicProfile);
	    		if(academicProfile==true && campus==true &&courses==true&& department==true)
	    		{
					 studentRepo.save(student);
					 response.setMessage("Student details updated successfully.");
					 return ResponseEntity.ok().body(response);
	    		} 
	    		else 
	    		{
	    			response.setMessage("fill the details according to description.")  ;  		
	    		}
	    		
	        }
	        else 
	        {
	        	response.setMessage("Student exists already.");
	    		return ResponseEntity.badRequest().body(response);

	        }
	        
			return ResponseEntity.badRequest().body(response);
		}
		catch (Exception e) {
			return ResponseEntity.ok(new Message(e.getLocalizedMessage()));
		}
		
        }
	
	
    @PostMapping("/checkOtp")
	public ResponseEntity<Message>  checkOtp(@RequestBody Cache cache)
	{
		Message message =new Message();
		Cache otp =(Cache) inmemorydataMap.get("otp");
		if(otp.getOtp().matches(cache.getOtp()) && cache.getExpiryTime().getTime()>System.currentTimeMillis())
		{
			
			message.setMessage("Otp verified successfully");
	
			return ResponseEntity.ok().body(message);

          }
		
		else 
		{
			message.setMessage("enter valid otp.");
		       return ResponseEntity.badRequest().body(message);

		}
		
	}
    
	 @PostMapping("/loginstudent")
	 public ResponseEntity<?> loginStudent(@RequestBody Student student) {
	 TokenResponse response = new TokenResponse();
		 try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNumber(), ""));

				
			String token="Error";
			TokenResponse tmessage= new TokenResponse ();
		    student.setPhoneNumber(student.getPhoneNumber());
		    student.setPassword(student.getPassword());
		if (studentRepo.existsByPhoneNumber(student.getPhoneNumber()) == true
				&& studentRepo.existsByPassword(student.getPassword()) == true) {
			final UserDetails userDetails =deuServiceImpl.loadUserByUsername(String.valueOf(student.getPhoneNumber())); 
			token = jwtUtil.generateToken(userDetails);
			System.out.println(token);
				
				
			response.setMessage("login successfully");
			response.setToken(token);
				return ResponseEntity.ok().body(response);
			
		} 
		 
		 
		 
		else {
			response.setMessage("enter your details correctly");
			return ResponseEntity.badRequest().body(response);
	
		}
		
		 }
		catch (Exception e) {
			
			//return ResponseEntity.ok(e.getLocalizedMessage());
			response.setMessage("Enter your details correctly.");
				return ResponseEntity.badRequest().body(response);
		}
		 
	}
	

		@GetMapping("/hello")
	   public String getValue() {
		
		return "hello-world";
	}

	
	   @RequestMapping(value = "studentdetails", method = RequestMethod.GET)
		public ResponseEntity<List<Student>> getCustomerDetails() 
		{
			List<Student> students=new ArrayList<Student>();
			
			studentRepo.findAll().forEach(students1 ->students.add(students1));
            return ResponseEntity.ok().body(students);
		}
	   
	   
	   
		@GetMapping("/Otp")
	    @Cacheable(value = "saveInCache")
	    public ResponseEntity<?>  generateOtp()
	    {
			String otp = deuService.getOtp();
			System.out.println(otp);
			Cache cache = new Cache();
			cache.setOtp(otp);
			String phoneNumber = deuServiceImpl.getphoneNumber();
		   	Student student = studentRepo.findByPhoneNumber(phoneNumber);
		   	System.out.println(phoneNumber);
			inmemorydataMap.put("otp", cache);
			return ResponseEntity.ok().body(otp);
	    }
		
		
		@GetMapping("/add-cache")
	    public ResponseEntity<?>  addCashedData()
	    {
			inmemorydataMap.put("user", "vRaju");
			inmemorydataMap.put("class", "Eleven");
			return ResponseEntity.ok().body("success");
	    }
		
		
		@GetMapping("/all-cache")
	    public ResponseEntity<?>  getAllCashedData()
	    {
			String phoneNumber = deuServiceImpl.getphoneNumber();
		   	Student student = studentRepo.findByPhoneNumber(phoneNumber);
			return ResponseEntity.ok().body(inmemorydataMap);
	    }
		
				
}  
	    
	    

	    	 
	    	 
	    	 
	    	 
	          
	     
	



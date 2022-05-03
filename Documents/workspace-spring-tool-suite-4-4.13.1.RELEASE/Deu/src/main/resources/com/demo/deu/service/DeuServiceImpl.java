package com.demo.deu.service;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.demo.deu.entities.Student;
import com.demo.deu.repo.StudentRepo;


@Service
public class DeuServiceImpl implements DeuService, UserDetailsService {
	
	
	@Autowired
	private StudentRepo studentRepo;


	@Override
	public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException 
	{
		Student student = studentRepo.findByPhoneNumber(phonenumber);
        return  new org.springframework.security.core.userdetails.User(String.valueOf(student.getPhoneNumber()), "", new ArrayList<>());
	}

	// generating otp of 4 digits.
	
	@Override
	public String getOtp() 
	{
		 Random rnd = new Random();
		 int number = rnd.nextInt(9999);

		 System.out.println("OTP in service: "+String.format("%04d", number)); 
		 String otp=String.format("%04d", number);
		 return otp;
		
	}

	       
	   
	
	public String getphoneNumber()
	{
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String phoneNumber = null;
        
        if(principal instanceof UserDetails)
        {
        	phoneNumber = ((UserDetails)principal).getUsername();
        }
        else
        {
        	phoneNumber = principal.toString();
          }
        System.out.println(phoneNumber);
        return (phoneNumber);
    }

}

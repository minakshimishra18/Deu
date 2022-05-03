package com.demo.deu.security;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.deu.CustomAuthAccessPoint;
import com.demo.deu.service.DeuServiceImpl;
import com.demo.deu.service.JwtFilter;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private JwtFilter jFilter;
	
	@Autowired
	private CustomAuthAccessPoint entryPoint;
	
	
	
	@Autowired
	private DeuServiceImpl deuServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(deuServiceImpl);
		
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()

        .authorizeRequests().antMatchers("/download/{fileId}","/uni/add-cache","/uni/otp","/saveDuration","/saveSalary","/saveDes","/depType","/cam/campus","/aci/academicProfile","/dep/department","/cour/course","/uni","/uni/show/student","/hello","/uni/student","/uni/employee", "/uni/loginstudent", "/loginemployee" , "/getToken","/uni/studentdetails" ,"/emp/employee").permitAll().anyRequest()
		.authenticated().and().httpBasic().authenticationEntryPoint(entryPoint).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {



    }

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}



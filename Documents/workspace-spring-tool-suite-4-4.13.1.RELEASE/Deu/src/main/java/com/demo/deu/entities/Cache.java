package com.demo.deu.entities;

import java.util.Date;

public class Cache {

	String otp;
	
	
	Date expiryTime =new Date(System.currentTimeMillis()+(1000*60*5));


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public Date getExpiryTime() {
		return expiryTime;
	}


	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	};
	
	
	@Override
	public String toString() {
		return "Cache [otp=" + otp + ", expiryTime=" + expiryTime + "]";
	}


	public Cache(String otp, Date expiryTime) {
		super();
		this.otp = otp;
		this.expiryTime = expiryTime;
	}


	public Cache()
{}
	}

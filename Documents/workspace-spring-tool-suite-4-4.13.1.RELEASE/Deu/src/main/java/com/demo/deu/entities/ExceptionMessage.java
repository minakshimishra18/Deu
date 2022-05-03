package com.demo.deu.entities;

public class ExceptionMessage {
	 private	String message = "Name is required" ;

	 public ExceptionMessage(String message) {
	 	super();
	 	this.message = message;
	 }
	    
	 public ExceptionMessage() {

	 }

	 public String getMessage() {
	 	return message;
	 }


}

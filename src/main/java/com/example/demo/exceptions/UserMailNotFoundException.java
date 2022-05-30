package com.example.demo.exceptions;

public class UserMailNotFoundException extends RuntimeException{
	
	public UserMailNotFoundException(String desc) {
		super(desc);
	}

}

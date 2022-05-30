package com.example.demo.exceptions;

public class RomNotFoundException extends RuntimeException {
	public RomNotFoundException(String desc) {
		super(desc);
	}

}

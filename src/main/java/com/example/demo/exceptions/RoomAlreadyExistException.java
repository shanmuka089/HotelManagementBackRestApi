package com.example.demo.exceptions;

public class RoomAlreadyExistException extends RuntimeException{
	
	public RoomAlreadyExistException(String desc) {
		super(desc);
	}

}

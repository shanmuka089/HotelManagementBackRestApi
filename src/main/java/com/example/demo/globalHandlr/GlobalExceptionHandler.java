package com.example.demo.globalHandlr;

import java.time.LocalDate;

import javax.security.auth.login.CredentialException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.JwtTokenMalformedException;
import com.example.demo.exceptions.RoomAlreadyExistException;
import com.example.demo.exceptions.UserAlreadyFoundException;
import com.example.demo.exceptions.UserMailNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RoomAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(RoomAlreadyExistException ex){
		ErrorResponse error=new ErrorResponse();
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(JwtTokenMalformedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(JwtTokenMalformedException ex){
		ErrorResponse error=new ErrorResponse();
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CredentialException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CredentialException ex){
		ErrorResponse error=new ErrorResponse();
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(BadCredentialsException e){
		ErrorResponse error=new ErrorResponse();
		error.setMessage("*you try to sign in with bad credentials");
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserMailNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(UserMailNotFoundException e){
		ErrorResponse error=new ErrorResponse();
		error.setMessage("*you try to sign in with bad credentials");
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserAlreadyFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(UserAlreadyFoundException e){
		ErrorResponse error=new ErrorResponse();
		error.setMessage("*the user is already found with these user name");
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setDate(LocalDate.now());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	

}

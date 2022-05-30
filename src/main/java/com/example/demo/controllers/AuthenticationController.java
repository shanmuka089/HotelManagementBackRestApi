package com.example.demo.controllers;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UserMailNotFoundException;
import com.example.demo.globalHandlr.ErrorResponse;
import com.example.demo.models.ChangePasswordToken;
import com.example.demo.models.JwtUtil;
import com.example.demo.models.UserForgotRequest;
import com.example.demo.models.UserRegistration;
import com.example.demo.models.UserResponseToken;
import com.example.demo.repositories.UserRegistrationRepository;
import com.example.demo.services.UserRegistrationService;



@RestController
public class AuthenticationController {
	
	static org.apache.logging.log4j.Logger log=LogManager.getLogger(AuthenticationController.class);
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRegistrationRepository regRepo;
	
	@Autowired
	private UserRegistrationService userService;
	
	@PostMapping("/signIn")
	public ResponseEntity<UserResponseToken> signIn( @Valid @RequestBody UserRegistration request){
		Authentication auth=null;
		log.info("authentication object initializing in try block");
		auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		log.info("calling generateToken method for generating the token");
		String token=jwtUtil.generateToken(auth);
		User user=(User)auth.getPrincipal();
		List<String> user_roles=user.getAuthorities().stream().map(
				authority->authority.getAuthority()).collect(Collectors.toList());
		log.info("creating user response object to pass the jwt token and roles to the user");
		UserResponseToken response=new UserResponseToken(token,user_roles);
		System.out.println(user_roles);
		log.info(request.getUsername()+" try to sign your application");
		return new ResponseEntity<UserResponseToken>(response,HttpStatus.OK);
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@Valid @RequestBody UserRegistration user) {
		System.out.println(user);
		userService.saveUser(user);
		
		log.info("new user "+user.getUsername()+" registered successfully");
		return new ResponseEntity<String>("data saved successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/get-user")
	public ResponseEntity<UserForgotRequest> getUser(@Valid @RequestBody UserForgotRequest request){
		Optional<UserRegistration> user;
		try {
			log.info("initialising user object by using username");
			user=regRepo.findByusername(request.getUsername());
			if(user.isEmpty())
				throw new UsernameNotFoundException("user not found with these username");
		}catch(Exception ex) {
			log.info("initialising user object by using mail");
			user=regRepo.findByusermail(request.getUsername());
			if(user.isEmpty())
				throw new UserMailNotFoundException("user not found with entered email");
		}
		UserForgotRequest req=new UserForgotRequest();
		log.info("set the username of forgotRequest object is "+user.get().getUsername());
		req.setUsername(user.get().getUsername());
		return new ResponseEntity<UserForgotRequest>(req,HttpStatus.OK);
	}
	
	@PostMapping("/change-user-pass")
	public ResponseEntity<ChangePasswordToken> passwordChange(@Valid @RequestBody ChangePasswordToken changePasswordToken){
		userService.changePassword(changePasswordToken);
		log.info("inside password change method to change the password");
		return new ResponseEntity<ChangePasswordToken>(changePasswordToken,HttpStatus.OK);
	}

}

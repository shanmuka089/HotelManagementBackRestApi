package com.example.demo.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.UserAlreadyFoundException;
import com.example.demo.models.ChangePasswordToken;
import com.example.demo.models.Roles;
import com.example.demo.models.UserRegistration;
import com.example.demo.repositories.UserRegistrationRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	public void saveUser(UserRegistration user) {
		Optional<UserRegistration> regUser = userRepo.findByusername(user.getUsername());
		if (!regUser.isEmpty()) {
			throw new UserAlreadyFoundException("user already exists");
		}
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getSelectedRoles());
		String[] roles = user.getSelectedRoles();
		Set<Roles> set_roles = new HashSet<>();
			for(String role:roles) {
				Roles user_roles = new Roles();
				user_roles.setRole(role);
				user_roles.setUser(user);
				set_roles.add(user_roles);
			}
			user.setRoles(set_roles);
			userRepo.save(user);
	}

	public void changePassword(ChangePasswordToken passwordToken) {
		String username = passwordToken.getUsername();
		String password = passwordToken.getPassword();
		password = encoder.encode(password);
		userRepo.changePassword(username, password);
	}
}

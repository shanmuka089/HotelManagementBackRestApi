package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.UserMailNotFoundException;
import com.example.demo.models.Roles;
import com.example.demo.models.UserRegistration;
import com.example.demo.repositories.UserRegistrationRepository;

@Service
public class UserAuthenticationService implements UserDetailsService{

	@Autowired
	private UserRegistrationRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserRegistration userReg;
				try {
						userReg=repo.findByusername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
				}catch(UsernameNotFoundException ex) {
					userReg=repo.findByusermail(username).orElseThrow(()->new UserMailNotFoundException("userMail not found"));
				}
				List<Roles> userRoles=userReg.getRoles().stream().collect(Collectors.toList());
				List<GrantedAuthority> grantedAuthorities=userRoles.stream().map(role->{
					System.out.println(role.getRole());
					return new SimpleGrantedAuthority(role.getRole());
				}).collect(Collectors.toList());
		return User.withUsername(userReg.getUsername()).password(userReg.getPassword()).authorities(grantedAuthorities).build();
	}

}

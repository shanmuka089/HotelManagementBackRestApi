package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.CustomersDetailsModel;
import com.example.demo.models.UserRegistration;
import com.example.demo.repositories.UserRegistrationRepository;

@Service
public class CustomerService {
	
	@Autowired
	private UserRegistrationRepository regRepo;
	
	
	public List<CustomersDetailsModel> getAllCustomers(){
			List<UserRegistration> userList=regRepo.findAll();
			List<CustomersDetailsModel> customersList=userList.stream().map(user->{
				String[] roles=user.getSelectedRoles();
				String username=user.getUsername();
				String usermail=user.getUsermail();
				int userId=user.getUserId();
				CustomersDetailsModel details=new CustomersDetailsModel();
				details.setUserId(userId);
				details.setSelectedRoles(roles);
				details.setMail(usermail);
				details.setUsername(username);
				return details;
			}).collect(Collectors.toList());
			return customersList;
	}
	
	public void deleteCustomerById(int id) {
		if(regRepo.existsById(id)) {
			regRepo.deleteById(id);
		}else {
			throw new UsernameNotFoundException("the user may not be exist");
		}
	}

}

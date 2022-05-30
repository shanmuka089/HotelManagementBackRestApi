package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer>{

	Optional<UserRegistration> findByusername(String name);
	
	Optional<UserRegistration> findByusermail(String mail);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE USERS SET PASSWORD=:password WHERE USERNAME=:name",nativeQuery = true)
	void changePassword(String name,String password);
}

package com.CRUD.Operations.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Operations.Entity.SignUp_DTO;
import com.CRUD.Operations.Repository.SignUp_Repository;
import com.CRUD.Operations.Service.SignUp_Service;

@RestController
@RequestMapping("/E_Commerce")
public class SignUp_Controller {

	@Autowired
	SignUp_Service signUp_Service;
	
	@Autowired
	SignUp_Repository signUp_Repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/User_Signup")
	public ResponseEntity<?> UserSignup(@RequestBody SignUp_DTO signUp_dto) {
		if(signUp_Repo.existsByUserName(signUp_dto.getUserName())) {
			return ResponseEntity.ok(Map.of("message","UserName already exists"));
		}
		if(signUp_Repo.existsByPhoneNumber(signUp_dto.getPhoneNumber())) {
			return ResponseEntity.ok(Map.of("message","Phone number already exists:: Try with another number"));
		}
		if(signUp_Repo.existsByEmail(signUp_dto.getEmail())) {
			return ResponseEntity.ok(Map.of("message","Email already registered"));
		}
		signUp_dto.setPassword(passwordEncoder.encode(signUp_dto.getPassword()));
		return ResponseEntity.ok(signUp_Service.user_SignUp(signUp_dto));
	}
}

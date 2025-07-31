package com.CRUD.Operations.TestController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.CRUD.Operations.Controller.SignUp_Controller;
import com.CRUD.Operations.Entity.SignUp_DTO;
import com.CRUD.Operations.Repository.SignUp_Repository;
import com.CRUD.Operations.Service.SignUp_Service;

@WebMvcTest(SignUp_Controller.class)
public class SignUp_Test_Controller {
	
	
	@Autowired
	SignUp_Controller signup_Controller;
	
	@MockBean
	SignUp_Service signup_Service;
	
	@MockBean
	SignUp_Repository signup_repo;
	
	@Test
	public void testSuccessfulSignup() {
		
		SignUp_DTO dto=new SignUp_DTO();
		dto.setUserName("liya");
		dto.setEmail("liya@gmail.com");
		dto.setPhoneNumber(900026372);
		dto.setPassword("liya@1");
		
//		when(signup_repo.existsByUserName("liya")).thenReturn(false);
//		when(signup_repo.existsByEmail("liya@gmail.com")).thenReturn(false);
//		when(signup_repo.existsByPhoneNumber(900026372)).thenReturn(false);
		
		when(signup_Service.user_SignUp(dto)).thenReturn("User Registered successfully");
		ResponseEntity<?> response=signup_Controller.UserSignup(dto);
		assertThat(response.getBody()).isEqualTo("User Registered successfully");
		
	}
	
	@Test
	public void testByUserName() {
		SignUp_DTO dto=new SignUp_DTO();
		dto.setUserName("sravanthi");
		dto.setEmail("sravani@gmail.com");
		dto.setPhoneNumber(7238388338L);
		dto.setPassword("srav@1");
		
		when(signup_repo.existsByUserName("sravanthi")).thenReturn(true);
		ResponseEntity<?> response=signup_Controller.UserSignup(dto);
		assertThat(response.getBody()).isEqualTo(Map.of("message","UserName already exists"));
	}

	@Test
	public void testByEmail() {
		SignUp_DTO dto=new SignUp_DTO();
		dto.setUserName("baby");
		dto.setEmail("baby@gmail.com");
		dto.setPassword("baby@1");
		dto.setPhoneNumber(888888888);
		when(signup_repo.existsByEmail("baby@gmail.com")).thenReturn(true);
		ResponseEntity<?> response=signup_Controller.UserSignup(dto);
		assertThat(response.getBody()).isEqualTo(Map.of("message","Email already registered"));
		
	}
	@Test
	public void testByphoneNumber() {
		SignUp_DTO dto=new SignUp_DTO();
		dto.setUserName("srav");
		dto.setEmail("srav@gmail.com");
		dto.setPhoneNumber(9999999999L);
		dto.setPassword("Srav@1");
		when(signup_repo.existsByPhoneNumber(9999999999L)).thenReturn(true);
		ResponseEntity<?>response=signup_Controller.UserSignup(dto);
		assertThat(response.getBody()).isEqualTo(Map.of("message","Phone number already exists:: Try with another number"));
			
	
	}
}

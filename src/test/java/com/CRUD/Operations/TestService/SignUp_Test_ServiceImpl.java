package com.CRUD.Operations.TestService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.CRUD.Operations.Entity.SignUp_DTO;
import com.CRUD.Operations.Repository.SignUp_Repository;
import com.CRUD.Operations.Service.SignUp_Service;

@SpringBootTest
public class SignUp_Test_ServiceImpl {

	@Autowired
	SignUp_Repository signUp_repo;
	
	@Autowired
	SignUp_Service signUp_Service;
	
	@MockBean
	PasswordEncoder passwordEncoder;
	
	@Test
	public void SignUp_Success_Service_Test() {
		SignUp_DTO dto=new SignUp_DTO();
		dto.setUserName("maya");
		dto.setEmail("maya@gmail.com");
		dto.setPhoneNumber(974364644L);
		dto.setPassword("maya@1");
		
		String response = signUp_Service.user_SignUp(dto);
		assertThat(response).isEqualTo("maya is saved into the database");
	}
}

package com.CRUD.Operations.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.Operations.Entity.SignUp;
import com.CRUD.Operations.Entity.SignUp_DTO;
import com.CRUD.Operations.Repository.SignUp_Repository;
import com.CRUD.Operations.Service.SignUp_Service;
@Service
public class SignUp_Service_Implementation implements SignUp_Service{

	@Autowired
	SignUp_Repository signUp_Repo;
	
	@Override
	public String user_SignUp(SignUp_DTO signUp_dto) {
		// TODO Auto-generated method stub
		SignUp signUp=new SignUp();
		signUp.setId(signUp_dto.getId());
		signUp.setUserName(signUp_dto.getUserName());
		signUp.setPhoneNumber(signUp_dto.getPhoneNumber());
		signUp.setEmail(signUp_dto.getEmail());
		signUp.setPassword(signUp_dto.getPassword());
		
		
		 signUp_Repo.save(signUp);
		 
		 return signUp.getUserName()+" is saved into the database";
				
	}

}
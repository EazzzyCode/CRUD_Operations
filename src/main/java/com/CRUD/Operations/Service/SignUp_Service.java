package com.CRUD.Operations.Service;

import org.springframework.stereotype.Service;

import com.CRUD.Operations.Entity.SignUp_DTO;

@Service
public interface SignUp_Service {

	String user_SignUp (SignUp_DTO sinUp_dto);
}

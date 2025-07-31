package com.CRUD.Operations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.Operations.Entity.SignUp;

@Repository
public interface SignUp_Repository extends JpaRepository<SignUp, Integer> {
	boolean existsByUserName(String userName);
	boolean existsByPhoneNumber(long phoneNumber);
	boolean existsByEmail(String email);
}

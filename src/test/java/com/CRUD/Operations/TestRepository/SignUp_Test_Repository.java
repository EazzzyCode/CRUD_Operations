package com.CRUD.Operations.TestRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.CRUD.Operations.Entity.SignUp;
import com.CRUD.Operations.Repository.SignUp_Repository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EntityScan(basePackages = "com.CRUD.Operations.Entity")

public class SignUp_Test_Repository {

	@Autowired
	SignUp_Repository signUp_Repo;
	
	@Test
	public void ExistsByUserNameTest() {
		SignUp signUp=new SignUp();
		signUp.setUserName("sravani");
		signUp.setEmail("srav@gmail.com");
		signUp.setPhoneNumber(9908023685L);
		signUp.setPassword("Srav@1");
		
		signUp_Repo.save(signUp);
		boolean exists=signUp_Repo.existsByUserName("sravani");
		assertThat(exists).isEqualTo(true);
	}
	
	@Test
	public void ExistByEmail() {
	
		SignUp signUp=new SignUp();
		signUp.setUserName("teju");
		signUp.setEmail("teju@gmail.com");
		signUp.setPhoneNumber(374783323L);
		signUp.setPassword("Teju@1");
		
		signUp_Repo.save(signUp);
		boolean exists=signUp_Repo.existsByEmail("teju@gmail.com");
				assertThat(exists).isEqualTo(true);
		
		
	}

	@Test
	public void ExistsByPhoneNumber() {
		SignUp signUp=new SignUp();
		signUp.setUserName("lalli");
		signUp.setEmail("lalli@gmail.com");
		signUp.setPhoneNumber(9384474748L);
		signUp.setPassword("Lalli@1");
		
		signUp_Repo.save(signUp);
	boolean exists= signUp_Repo.existsByPhoneNumber(9384474748L);
	assertThat(exists).isEqualTo(true);
	}
}

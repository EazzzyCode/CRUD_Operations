package com.CRUD.Operations.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SignUp_DTO {

	private int id;
	private String userName;
	private long phoneNumber;
	private String email;
	private String password;
}

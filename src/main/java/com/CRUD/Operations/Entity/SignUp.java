package com.CRUD.Operations.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column	@NotNull(message = "User_name not be null")
	private String userName;
	@Column	@NotNull(message = "email not be null")
	private String email;
	@Column	@NotNull(message = "phoneNumber not be null")
	private long phoneNumber;
	@Column	@NotNull(message = "password not be null")
	private String password;
	
	
	
}

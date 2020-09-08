package com.emysilva.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String email;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String confPassword;
	private String contact;
}

package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginReq {

	@Email
	private String email;
	private String password;

	public LoginReq(String email, String password) {
		this.email = email;
		this.password = password;
	}
}

package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpReq {

	private String email;
	private String name;
	private String nickname;
	private String password;

	public SignUpReq(String email, String name, String nickname, String password) {
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}
}

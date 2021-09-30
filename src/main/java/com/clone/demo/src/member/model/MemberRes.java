package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRes {

	private String jwt;
	private Long memberId;

	public MemberRes(String jwt, Long memberId) {
		this.jwt = jwt;
		this.memberId = memberId;
	}
}

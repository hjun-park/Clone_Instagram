package com.clone.demo.src.member.model;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLoginRes {
	private String jwt;
	private Long memberId;

	public PostLoginRes(String jwt, Long memberId) {
		this.jwt = jwt;
		this.memberId = memberId;
	}
}


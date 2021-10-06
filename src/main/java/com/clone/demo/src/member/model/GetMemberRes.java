package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMemberRes {

	private String nickname;
	private String intro;
	private String link;

}

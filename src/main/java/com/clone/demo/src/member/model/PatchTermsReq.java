package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchTermsReq {

	private int termsNumber;

	public PatchTermsReq(int termsNumber) {
		this.termsNumber = termsNumber;
	}
}

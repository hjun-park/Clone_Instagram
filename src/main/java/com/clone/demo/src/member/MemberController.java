package com.clone.demo.src.member;


import com.clone.demo.config.BaseException;
import com.clone.demo.config.BaseResponse;
import com.clone.demo.src.member.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

//	// TODO: JWT 검증은 Interceptor 계층해서 수행할 것
//	// LINK: https://goddaehee.tistory.com/154
//	public MemberController(MemberService memberService, JwtService jwtService) {
//		this.memberService = memberService;
//		this.jwtService = jwtService;
//	}

	// 01. 회원 로그인
	@PostMapping("/login")
	public BaseResponse<MemberRes> login(@RequestBody LoginReq loginReq) {
		try {
			MemberRes result = memberService.login(loginReq);
			return new BaseResponse<>(result);
		} catch(BaseException exception) {
			return new BaseResponse<>(exception.getStatus());
		}
	}

	// 02. 회원 가입
	@PostMapping("/signup")
	public BaseResponse<MemberRes> signup(@Valid @RequestBody SignUpReq signUpReq) {
		try {
			MemberRes result = memberService.join(signUpReq);
			return new BaseResponse<>(result);
		} catch(BaseException exception) {
			return new BaseResponse<>(exception.getStatus());
		}
	}

	// 03. 회원가입 - 생년월일 설정
	// >> pt1: DateTimeFormat을 사용하여 Date값을 입력받음
	// TODO: 비효율적 ( birthDate만 입력받는데 ? )
	// TODO: 변경감지가 안 되는 이유는 ?
	@PostMapping("/signup/birthdate")
	public BaseResponse<Long> patchBirthDate(@RequestBody PatchBirthDateReq patchBirthDateReq) {
		try {
			Long resultId = memberService.setBirthDate(patchBirthDateReq.getBirthDate());
			return new BaseResponse<>(resultId);
		} catch(BaseException exception) {
			return new BaseResponse<>(exception.getStatus());
		}
	}

	// 04. 회원가입 - 약관내용 설정
	@PostMapping("/signup/terms")
	public BaseResponse<Long> patchTerms(@RequestBody PatchTermsReq patchTermsReq) {
		try {
			Long resultId = memberService.setTerms(patchTermsReq.getTermsNumber());
			return new BaseResponse<>(resultId);
		} catch(BaseException exception) {
			return new BaseResponse<>(exception.getStatus());
		}
	}


}

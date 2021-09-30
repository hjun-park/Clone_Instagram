package com.clone.demo.src.member;

import com.clone.demo.config.BaseException;
import com.clone.demo.src.member.model.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface MemberService {

	// 01. 회원 정보 조회
	Optional<Member> find(Long memberId);

	// 02. 회원 정보 저장
	MemberRes join(SignUpReq signUpReq) throws BaseException;

	// 02-1. 회원 생년월일 저장 (JWT 검증)
	Long setBirthDate(LocalDate date) throws BaseException;

	// 02-2. 회원 약관 동의 내용 저장
	Long setTerms(int termNumber) throws BaseException;

	// 03. 회원 정보 수정
	void edit(Long memberId, Member member);

	// 04. 회원 정보 삭제
	void modifyStatusToDelete(Long memberId);

	// 05. 회원 로그인
	MemberRes login(LoginReq loginReq) throws BaseException;

}

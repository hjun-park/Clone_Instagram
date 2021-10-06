package com.clone.demo.src.member;

import com.clone.demo.config.BaseException;
import com.clone.demo.config.BaseResponseStatus;
import com.clone.demo.config.BaseStatus;
import com.clone.demo.config.secret.Secret;
import com.clone.demo.src.member.model.*;
import com.clone.demo.utils.AES128;
import com.clone.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static com.clone.demo.config.BaseResponseStatus.*;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final JwtService jwtService;

	@Override
	public Optional<Member> find(Long memberId) {
		return memberRepository.findById(memberId);
	}


	@Override
	public void edit(Long memberId, Member member) {
		Member findMember = memberRepository.getById(memberId);
		findMember.setMember(member);
	}

	@Override
	public void modifyStatusToDelete(Long memberId) {
		Member findMember = memberRepository.getById(memberId);
		findMember.setStatusToDelete(BaseStatus.Deleted);
	}

	@Override
	@Transactional
	public MemberRes login(LoginReq loginReq) throws BaseException {

		String email = loginReq.getEmail();
		String password = loginReq.getPassword();

		// DB로부터 암호 가져와 복호화
		Member member = memberRepository.findMemberByEmail(email);
		System.out.println("member = " + member);

		String findPassword;
		try {
			findPassword = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(member.getPassword());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new BaseException(PASSWORD_DECRYPTION_ERROR);
		}

		// password 확인
		if (password.equals(findPassword)) {
			// 유저 ID와 JWT를 만들어서 반환
			Long memberId = member.getId();
			String jwt = jwtService.createJwt(memberId);
			return new MemberRes(jwt, memberId);

		} else {
			throw new BaseException(FAILED_TO_LOGIN);
		}

	}

	@Override
	public GetMemberRes findMemberProfile(String username) throws BaseException {
		return null;
	}

	@Override
	public Long modifyMemberProfile(String username) throws BaseException {
		return null;
	}

	@Override
	@Transactional
	public MemberRes join(SignUpReq signUpReq) throws BaseException {
		String encryptedPwd;
		try {
			encryptedPwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(signUpReq.getPassword());
		} catch (Exception ignored) {
			throw new BaseException(PASSWORD_ENCRYPTION_ERROR);
		}

		System.out.println("encryptedPwd = " + encryptedPwd);
		try {
			// 새로운 멤버 저장
			Member buildMember = Member.builder()
				.email(signUpReq.getEmail())
				.name(signUpReq.getName())
				.nickname(signUpReq.getNickname())
				.password(encryptedPwd)
				.build();

			Member savedMember = memberRepository.save(buildMember);

			// JWT 토큰 생성
			String jwt = jwtService.createJwt(savedMember.getId());
			return new MemberRes(jwt, savedMember.getId());

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new BaseException(DATABASE_ERROR);
		}

	}

	@Override
	@Transactional
	public Long setBirthDate(LocalDate date) throws BaseException {
		Long memberId =  jwtService.getUserIdx();

		Optional<Member> findMember = memberRepository.findById(memberId);

		if (findMember.isPresent()) {
			Member member = findMember.get();
			System.out.println("date = " + date);
			member.setBirthDate(date);
			return memberId;
		} else { // TODO: DB 에러가 아니라 검색된 유저가 없는 경우로 에러코드 변경
			throw new BaseException(DATABASE_ERROR);
		}


	}

	@Override
	@Transactional
	public Long setTerms(int termNumber) throws BaseException {
		Long memberId = jwtService.getUserIdx();

		Optional<Member> findMember = memberRepository.findById(memberId);

		if (findMember.isPresent()) {
			Member member = findMember.get();
			member.setTerm(termNumber);
			return memberId;
		} else {
			throw new BaseException(DATABASE_ERROR);
		}

	}


}

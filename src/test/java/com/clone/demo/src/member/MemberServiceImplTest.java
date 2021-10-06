package com.clone.demo.src.member;

import com.clone.demo.src.member.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

	@PersistenceContext
	private EntityManager em;

	// 생년월일 수정 테스트
//	@Test
//	public void modifyBirthDate() throws Exception {
//	    //given
//		Member member = em.find(Member.class, 3);
//		System.out.println("Member = " + member);
//
//		@DateTimeFormat(pattern = "yyyy-MM-dd")
//		Date date = new Date();
//
//
//	    //when
//		member.setBirthDate("1996-10-22");
//
//
//	    //then
//	}


}

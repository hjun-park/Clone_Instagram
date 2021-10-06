package com.clone.demo.src.member;

import com.clone.demo.src.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findMemberByEmail(String email);

}

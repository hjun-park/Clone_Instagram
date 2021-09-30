package com.clone.demo.src.member;

import com.clone.demo.src.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberRepositoryImpl {

	@PersistenceContext
	private final EntityManager em;

	private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();


}

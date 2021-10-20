package com.clone.demo.src.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

// PostRepositoryCustom 인터페이스를 상속받은 클래스 (실제 querydsl 관련코드)
@Repository
public class PostRepositoryImpl implements PostRepositoryCustom  {

	private final JPAQueryFactory queryFactory;

	public PostRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}


}

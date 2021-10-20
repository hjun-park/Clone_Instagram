package com.clone.demo.src.post;


import com.clone.demo.src.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository: 스프링 데이터 JPA
//PostRepositoryCustom: 사용자 정의 리포지토리(querydsl)
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {


}

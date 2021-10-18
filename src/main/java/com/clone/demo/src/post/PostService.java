package com.clone.demo.src.post;

import com.clone.demo.config.BaseException;
import com.clone.demo.src.post.model.GetMemberPostRes;
import com.clone.demo.src.post.model.GetPostDetailRes;

import java.util.List;

public interface PostService {

	// 01. 게시글 작성
	Long newPost(String content) throws BaseException;

	// 02. 게시글 수정
	void editPost(Long postId, String content) throws BaseException;

	// 03. 게시글 삭제
	void statusToDeletePost(Long postId) throws BaseException;

	// 04. 특정 유저 게시글 조회
	List<GetMemberPostRes> findPosts(Long memberId) throws BaseException;

	// 05 게시글 상세 조회
	GetPostDetailRes viewPost(Long postId) throws BaseException;
}

package com.clone.demo.src.post;

import com.clone.demo.config.BaseException;
import com.clone.demo.config.BaseResponseStatus;
import com.clone.demo.config.BaseStatus;
import com.clone.demo.src.post.model.GetMemberPostRes;
import com.clone.demo.src.post.model.GetPostDetailRes;
import com.clone.demo.src.post.model.Post;
import com.clone.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.clone.demo.config.BaseResponseStatus.DATABASE_ERROR;
import static com.clone.demo.config.BaseResponseStatus.INVALID_JWT;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

	private final PostRepository postRepository;
	private final JwtService jwtService;

	@Override
	public Long newPost(String content) throws BaseException {
		return null;
	}

	@Override
	public void editPost(Long postId, String content) throws BaseException {
		Optional<Post> post = postRepository.findById(postId);
		Long memberId = jwtService.getUserIdx();

		// >> pt4. Optional 수정하는 방법
		if(post.isPresent()) {
			Post findPost = post.get();

			if (memberId.equals(findPost.getMember().getId())) {
				log.info("memberId: {}", memberId);
				findPost.setContent(content);
			} else {
				throw new BaseException(INVALID_JWT);
			}
		} else {
			// TODO: 내용추가 : code 추가
			throw new BaseException(DATABASE_ERROR);
		}
	}

	@Override
	public void statusToDeletePost(Long postId) throws BaseException {
		Long memberId = jwtService.getUserIdx();
		Optional<Post> post = postRepository.findById(postId);

		if(post.isPresent()) {
			Post findPost = post.get();

			if (memberId.equals(findPost.getMember().getId())) {
				log.info("memberId: {}", memberId);
				findPost.setStatusTo(BaseStatus.Deleted);
			} else {
				throw new BaseException(INVALID_JWT);
			}
		} else {
			// TODO: 내용추가 : code 추가
			throw new BaseException(DATABASE_ERROR);
		}

	}

	@Override
	public List<GetMemberPostRes> findPosts(Long memberId) throws BaseException {
		find
	}

	@Override
	public GetPostDetailRes viewPost(Long postId) throws BaseException {
		return null;
	}
}

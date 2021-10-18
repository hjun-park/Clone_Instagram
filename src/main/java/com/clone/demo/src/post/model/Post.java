package com.clone.demo.src.post.model;

import com.clone.demo.config.BaseStatus;
import com.clone.demo.src.member.model.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "POST")
public class Post {
	@Id	@GeneratedValue
	private Long id;

	// >> pt3. memberId 외래키를 객체로 매핑 ( 단방향 )
	// 우선 단반향 관계 매핑 (member에서 post를 참조하므로 member -> post)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;

	private String content;

	@Enumerated(EnumType.STRING)
	private BaseStatus status;

	@Builder
	public Post(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	// 양방향 연관관계
	@OneToMany(mappedBy = "post")
	private List<PostImage> postImages = new ArrayList<>();

	public void setContent(String content) {
		this.content = content;
	}

	public void setStatusTo(BaseStatus status) {
		this.status = status;
	}

	@Builder
	public Post(Long id, Member member, String content) {
		this.id = id;
		this.member = member;
		this.content = content;
	}
}

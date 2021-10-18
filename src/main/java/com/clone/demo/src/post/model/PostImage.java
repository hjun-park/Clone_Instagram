package com.clone.demo.src.post.model;

import com.clone.demo.config.BaseStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "POST_IMAGE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage {

	@Id	@GeneratedValue
	private Long postingImageId;
	private String postingImageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postingId")
	private Post post;

	@Enumerated(EnumType.STRING)
	private BaseStatus status;


}

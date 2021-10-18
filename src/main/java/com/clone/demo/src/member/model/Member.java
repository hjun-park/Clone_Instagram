package com.clone.demo.src.member.model;

import com.clone.demo.config.BaseEntity;
import com.clone.demo.config.BaseStatus;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;

@Getter	@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicInsert	// !!!!!!!! DB기본값 적용시키기 위한 설정 [ https://goodteacher.tistory.com/369 ]
@Table(name = "MEMBER")
public class Member { //extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String imageUrl;

	@NotBlank
	private String name;

	@Past
	private LocalDate birthDate;

	private String nickname;

	private String link;

	private String intro;

	@NotBlank
	private String email;

	private String phone;

	private String gender;

	private int agreeToTerms;

	@NotBlank
	private String password;

	private Boolean isSecure;

	@Enumerated(EnumType.STRING)
	private BaseStatus status;

	public void setMember(Member member) {
		this.imageUrl = member.getImageUrl();
		this.birthDate = member.getBirthDate();
		this.nickname = member.getNickname();
		this.link = member.getLink();
		this.intro = member.getIntro();
		this.gender = member.getGender();
	}

	public void setBirthDate(LocalDate date) {
		this.birthDate = date;
	}

	public void setTerm(int termNumber) {
		this.agreeToTerms = termNumber;
	}

	public void setStatusToDelete(BaseStatus status) {
		this.status = status;
	}

	@Builder
	public Member(long id, String imageUrl, String name, LocalDate birthDate, String nickname, String link, String intro, String email, String phone, String gender, int agreeToTerms, String password, Boolean isSecure) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.name = name;
		this.birthDate = birthDate;
		this.nickname = nickname;
		this.link = link;
		this.intro = intro;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.agreeToTerms = agreeToTerms;
		this.password = password;
		this.isSecure = isSecure;
	}
}

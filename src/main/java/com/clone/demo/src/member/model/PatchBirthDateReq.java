package com.clone.demo.src.member.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchBirthDateReq {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	public PatchBirthDateReq(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}

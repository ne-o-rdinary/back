package com.example.demo.domain.dto.answer;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AnswerRequestDto {

	@NotNull
	private Long questionId;

	@NotNull
	private String answer;

	public AnswerRequestDto(Long questionId, String answer) {
		this.questionId = questionId;
		this.answer = answer;
	}

}

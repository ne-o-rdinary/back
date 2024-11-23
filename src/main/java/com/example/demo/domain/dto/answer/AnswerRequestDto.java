package com.example.demo.domain.dto.answer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class AnswerRequestDto {

	@NotNull
	@Min(value = 0, message = "적합하지 않은 ID 타입입니다.")
	private Long questionId;

	@NotNull
	@Pattern(regexp = "^[^0-9]+$", message = "답변은 문자만 입력 가능합니다.")
	private String answer;

	public AnswerRequestDto(Long questionId, String answer) {
		this.questionId = questionId;
		this.answer = answer;
	}

}

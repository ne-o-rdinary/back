package com.example.demo.domain.dto.answer;

import lombok.Getter;

@Getter
public class AnswerResponseDto {

	private String question;

	private String answer;

	public AnswerResponseDto(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

}

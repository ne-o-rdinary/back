package com.example.demo.domain.dto.answer;

import lombok.Getter;

@Getter
public class AnswerResponseDto {

	private int imageIndex;

	private String question;

	private String answer;

	public AnswerResponseDto(int imageIndex, String question, String answer) {
		this.imageIndex = imageIndex;
		this.question = question;
		this.answer = answer;
	}

}

package com.example.demo.domain.dto.answer;

import com.example.demo.domain.entity.answer.Answer;

public class AnswerCreateResponseDto {

	private Long answerId;

	public AnswerCreateResponseDto(Answer answer) {
		this.answerId = answer.getId();
	}
}

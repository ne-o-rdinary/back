package com.example.demo.domain.dto.answer;

import com.example.demo.domain.entity.answer.Answer;
import lombok.Getter;

@Getter
public class AnswerCreateResponseDto {

	private String uuid;

	public AnswerCreateResponseDto(String uuid) {
		this.uuid = uuid;
	}
}

package com.example.demo.controller.answer;

import com.example.demo.base.ApiResponse;
import com.example.demo.domain.dto.answer.AnswerCreateResponseDto;
import com.example.demo.domain.dto.answer.AnswerRequestDto;
import com.example.demo.service.answer.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

	private final AnswerService answerService;

	@PostMapping()
	@Operation(summary = "답변 저장 API", description = "답변을 저장하는 API")
	public ResponseEntity<ApiResponse<AnswerCreateResponseDto>> createAnswer(
		@Valid @RequestBody AnswerRequestDto dto) {

		AnswerCreateResponseDto answerCreateResponseDto = answerService.createAnswer(dto);

		return ResponseEntity.ok(ApiResponse.onSuccess(answerCreateResponseDto));
	}
}

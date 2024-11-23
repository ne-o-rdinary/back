package com.example.demo.controller.answer;

import com.example.demo.base.ApiResponse;
import com.example.demo.domain.dto.answer.AnswerCreateResponseDto;
import com.example.demo.domain.dto.answer.AnswerRequestDto;
import com.example.demo.domain.dto.answer.AnswerResponseDto;
import com.example.demo.service.answer.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

	private final AnswerService answerService;

	@PostMapping()
	@Operation(summary = "답변 저장 API", description = "답변을 저장하는 API")
	public ApiResponse<AnswerCreateResponseDto> createAnswer(
		@Valid @RequestBody AnswerRequestDto dto) {

		AnswerCreateResponseDto answerCreateResponseDto = answerService.createAnswer(dto);

		return ApiResponse.onSuccess(answerCreateResponseDto);
	}

	@GetMapping("/{uuid}")
	@Operation(summary = "질문/답변 조회 API", description = "질문/답변 조회하는 API")
	public ApiResponse<AnswerResponseDto> getAnswer(@PathVariable String uuid) {
		AnswerResponseDto answerResponseDto = answerService.getAnswer(uuid);

		return ApiResponse.onSuccess(answerResponseDto);
	}
}

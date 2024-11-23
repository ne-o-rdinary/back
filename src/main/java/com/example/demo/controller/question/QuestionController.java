package com.example.demo.controller.question;

import com.example.demo.base.ApiResponse;
import com.example.demo.domain.dto.question.QuestionResponseDTO;
import com.example.demo.domain.entity.question.Question;
import com.example.demo.service.question.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    @Operation(summary = "랜덤 질문 조회 API", description = "질문 중 하나를 랜덤으로 반환하는 API")
    @Parameters({
            @Parameter(name = "questionCategory", description = "질문 카테고리(회고 / 계획")
    })
    public ApiResponse<QuestionResponseDTO.questionResultDTO> getQuestion(@RequestParam String questionCategory) {
        QuestionResponseDTO.questionResultDTO qr = questionService.getRandomQuestion(questionCategory);
        return ApiResponse.onSuccess(qr);
    }
}

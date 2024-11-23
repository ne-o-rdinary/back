package com.example.demo.domain.dto.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class QuestionResponseDTO {
    private Long questionId;
    private String question;
    public QuestionResponseDTO(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }
}

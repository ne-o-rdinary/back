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
    private int imageIndex;
    public QuestionResponseDTO(Long questionId, String question, int imageIndex) {
        this.questionId = questionId;
        this.question = question;
        this.imageIndex = imageIndex;
    }
}

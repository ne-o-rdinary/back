package com.example.demo.repository.question_answer;

import com.example.demo.domain.entity.question_answer.QuestionAnswer;

public interface QuestionAnswerQuery {

	QuestionAnswer findByUUID(String uuid);

}

package com.example.demo.repository.question;

import com.example.demo.domain.enums.QuestionCategory;
import java.util.List;

public interface QuestionQuery {

	List<Long> findIdByQuestionCategory(QuestionCategory category);

}

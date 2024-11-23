package com.example.demo.repository.question;

import com.example.demo.domain.entity.question.Question;
import com.example.demo.domain.enums.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Long countByQuestionCategoryIs(QuestionCategory questionCategory);
}

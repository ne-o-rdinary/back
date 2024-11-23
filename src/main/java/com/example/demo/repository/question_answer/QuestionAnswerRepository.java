package com.example.demo.repository.question_answer;

import com.example.demo.domain.entity.question_answer.QuestionAnswer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

	Optional<QuestionAnswer> findBy(String uuid);
}

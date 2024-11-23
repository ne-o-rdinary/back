package com.example.demo.repository.answer;

import com.example.demo.domain.entity.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

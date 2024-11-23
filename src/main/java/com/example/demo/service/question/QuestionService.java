package com.example.demo.service.question;

import com.example.demo.domain.dto.question.QuestionResponseDTO;
import com.example.demo.domain.entity.question.Question;
import com.example.demo.domain.enums.QuestionCategory;
import com.example.demo.repository.answer.AnswerRepository;
import com.example.demo.repository.question.QuestionRepository;
import com.example.demo.repository.question_answer.QuestionAnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final QuestionAnswerRepository questionAnswerRepository;

    public QuestionResponseDTO.questionResultDTO getRandomQuestion(String category) {

        Long questionCount;

        if (category.equals("회고")) {
            questionCount = questionRepository.countByQuestionCategoryIs(QuestionCategory.RETROSPECT);
        }
        else {
            questionCount = questionRepository.countByQuestionCategoryIs(QuestionCategory.PLAN);
        }

        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);
        Long randomInt = rand.nextLong(questionCount) + 1;

        Question q = questionRepository.findById(randomInt).orElseThrow();

        return QuestionResponseDTO.questionResultDTO.builder()
                .questionId(q.getId())
                .question(q.getQuestion())
                .build();
    }
}

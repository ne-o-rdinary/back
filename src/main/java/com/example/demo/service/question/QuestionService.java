package com.example.demo.service.question;

import com.example.demo.base.code.status.exception.ErrorStatus;
import com.example.demo.base.code.status.exception.GeneralException;
import com.example.demo.domain.dto.question.QuestionResponseDTO;
import com.example.demo.domain.entity.question.Question;
import com.example.demo.domain.enums.QuestionCategory;
import com.example.demo.repository.answer.AnswerRepository;
import com.example.demo.repository.question.QuestionQuery;
import com.example.demo.repository.question.QuestionRepository;
import com.example.demo.repository.question_answer.QuestionAnswerRepository;
import java.util.List;
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

    private final QuestionRepository questionRepository;
    private final QuestionQuery questionQuery;


    public QuestionResponseDTO getRandomQuestion(QuestionCategory category) {

        List<Long> questions = questionQuery.findIdByQuestionCategory(category);

        Random random = new Random();
        Long randomNumber = questions.get(random.nextInt(questions.size()));

        Question q = questionRepository.findById(randomNumber).orElseThrow(() -> new GeneralException(
            ErrorStatus.QUESTION_NOT_FOUND.getReasonHttpStatus()));

        return QuestionResponseDTO.builder()
            .questionId(q.getId())
            .question(q.getQuestion())
            .build();
    }
}

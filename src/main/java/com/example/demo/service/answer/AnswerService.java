package com.example.demo.service.answer;

import com.example.demo.base.code.status.exception.ErrorStatus;
import com.example.demo.base.code.status.exception.GeneralException;
import com.example.demo.domain.dto.answer.AnswerCreateResponseDto;
import com.example.demo.domain.dto.answer.AnswerRequestDto;
import com.example.demo.domain.dto.answer.AnswerResponseDto;
import com.example.demo.domain.entity.answer.Answer;
import com.example.demo.domain.entity.question.Question;
import com.example.demo.domain.entity.question_answer.QuestionAnswer;
import com.example.demo.repository.answer.AnswerRepository;
import com.example.demo.repository.question.QuestionRepository;
import com.example.demo.repository.question_answer.QuestionAnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {

	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final QuestionAnswerRepository questionAnswerRepository;

	@Transactional
	public AnswerCreateResponseDto createAnswer(AnswerRequestDto dto) {

		Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(
			() -> new GeneralException(ErrorStatus.QUESTION_NOT_FOUND.getReasonHttpStatus()));

		Answer answer = new Answer(dto.getAnswer());
		answerRepository.save(answer);

		QuestionAnswer questionAnswer = new QuestionAnswer(question, answer);
		questionAnswerRepository.save(questionAnswer);

		return new AnswerCreateResponseDto(answer);
	}

	@Transactional(readOnly = true)
	public AnswerResponseDto getAnswer(Long answerId) {
		Answer answer = answerRepository.findById(answerId).orElseThrow(
			() -> new GeneralException(ErrorStatus.ANSWER_NOT_FOUND.getReasonHttpStatus()));

		return new AnswerResponseDto(answer.getAnswer());
	}
}

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
import com.example.demo.repository.question_answer.QuestionAnswerQuery;
import com.example.demo.repository.question_answer.QuestionAnswerRepository;
import java.util.UUID;
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
	private final QuestionAnswerQuery questionAnswerQuery;

	@Transactional
	public AnswerCreateResponseDto createAnswer(AnswerRequestDto dto) {

		Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(
			() -> new GeneralException(ErrorStatus.QUESTION_NOT_FOUND.getReasonHttpStatus()));

		Answer answer = new Answer(dto.getAnswer());
		answerRepository.save(answer);

		String uuid = UUID.randomUUID().toString();

		QuestionAnswer questionAnswer = new QuestionAnswer(question, answer, uuid);
		questionAnswerRepository.save(questionAnswer);

		return new AnswerCreateResponseDto(questionAnswer.getUuid());
	}

	@Transactional(readOnly = true)
	public AnswerResponseDto getAnswer(String uuid) {
		QuestionAnswer questionAnswer = questionAnswerQuery.findByUUID(uuid);
		if (questionAnswer == null) {
			throw new GeneralException(ErrorStatus.QUESTION_ANSWER_NOT_FOUND.getReasonHttpStatus());
		}

		return new AnswerResponseDto(questionAnswer.getQuestion().getQuestion(),
			questionAnswer.getAnswer().getAnswer());
	}
}

package com.example.demo.repository.question_answer;

import com.example.demo.base.code.status.exception.ErrorStatus;
import com.example.demo.base.code.status.exception.GeneralException;
import com.example.demo.domain.entity.question_answer.QQuestionAnswer;
import com.example.demo.domain.entity.question_answer.QuestionAnswer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionAnswerQueryImpl implements QuestionAnswerQuery{

	private final JPAQueryFactory jpaQueryFactory;


	@Override
	public QuestionAnswer findByUUID(String uuid) {
		QQuestionAnswer questionAnswer = QQuestionAnswer.questionAnswer;

		QuestionAnswer result =  jpaQueryFactory.selectFrom(questionAnswer)
			.where(questionAnswer.uuid.eq(uuid)).fetchOne();

		if(result == null) {
			throw new GeneralException(ErrorStatus.ANSWER_NOT_FOUND.getReasonHttpStatus());
		}
		return result;
	}
}

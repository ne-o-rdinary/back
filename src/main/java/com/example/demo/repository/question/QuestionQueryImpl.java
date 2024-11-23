package com.example.demo.repository.question;

import com.example.demo.domain.entity.question.QQuestion;
import com.example.demo.domain.enums.QuestionCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionQueryImpl implements QuestionQuery {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Long> findIdByQuestionCategory(QuestionCategory category) {
		QQuestion question = QQuestion.question1;

		return jpaQueryFactory
			.select(question.id).from(question)
			.where(question.questionCategory.eq(category))
			.fetch();
	}
}

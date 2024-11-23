package com.example.demo.domain.entity.question_answer;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.domain.entity.answer.Answer;
import com.example.demo.domain.entity.question.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "questionAnswer")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id")
	private Answer answer;

	public QuestionAnswer(Question question, Answer answer) {
		this.question = question;
		this.answer = answer;
	}
}

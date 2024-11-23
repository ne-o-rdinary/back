package com.example.demo.domain.entity.question;

import com.example.demo.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String question;

	public Question(String question) {
		this.question = question;
	}
}

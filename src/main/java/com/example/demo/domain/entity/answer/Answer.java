package com.example.demo.domain.entity.answer;

import com.example.demo.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "answer")
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseEntity {

	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String answer;

	public Answer(String answer) {
		this.answer = answer;
	}
}

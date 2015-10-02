package pl.etestownik.controller.quiz.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;

public class QuizForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9051250656837125101L;
/*
	@Getter @Setter
	private String quizName;
*/	
	@Getter @Setter
	private Quiz quiz = new Quiz();// tak było w spring w praktyce, strona 163, żeby pózniej nie było, ze chujowo

	@Getter @Setter
	private String questionString;

	@Getter @Setter
	private List<String> answersString;
}

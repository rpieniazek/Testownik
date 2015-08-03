package pl.etestownik.controller.quiz.form;

import java.util.ArrayList;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;

public class QuizForm {
	
	@Getter @Setter
	private Quiz quiz;
	
	@Getter @Setter
	private Question  question;
	
	@Getter @Setter
	private ArrayList<Answer> answers;
}

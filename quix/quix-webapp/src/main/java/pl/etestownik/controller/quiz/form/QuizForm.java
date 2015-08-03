package pl.etestownik.controller.quiz.form;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.quiz.Quiz;

public class QuizForm {
	
	@Getter @Setter
	private Quiz quiz;
	
	@Getter @Setter
	private String  question;
	
	@Getter @Setter
	private Set<String> answer;
}

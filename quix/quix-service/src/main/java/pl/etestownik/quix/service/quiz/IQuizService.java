package pl.etestownik.quix.service.quiz;

import java.util.List;

import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;

public interface IQuizService {

	public void save(Quiz quiz);
	
	public void delete(Quiz quiz);
	
	public void update(Quiz entity);
	
	public Quiz getById (long id);
	
	public List<Quiz> findAll();
	
	public void setDetails(Quiz quiz, String name, String subject, String institution);
	
	public void addQuestion(Quiz quiz, String question, String codedAnswers);



}

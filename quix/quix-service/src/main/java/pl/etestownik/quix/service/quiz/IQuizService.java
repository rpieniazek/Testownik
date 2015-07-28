package pl.etestownik.quix.service.quiz;

import java.util.List;

import pl.etestownik.quix.model.quiz.Quiz;

public interface IQuizService {

	public void save(Quiz quiz);

	public void delete(Quiz quiz);
	
	public List<Quiz> findAll();
}

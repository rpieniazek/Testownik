package pl.etestownik.repo.quiz.impl;

import java.util.List;

import pl.etestownik.quix.model.quiz.Quiz;

public interface IQuizRepo {

	public void save(Quiz quiz );

	public void delete(Quiz quiz);
	
	public List<Quiz> findAll();
}

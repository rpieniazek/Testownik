package pl.etestownik.quix.service.quiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.repo.quiz.IQuizRepo;
import pl.etestownik.quix.service.quiz.IQuizService;

public class QuizService implements IQuizService{

	@Autowired
	private IQuizRepo quizRepo;

	public void save(Quiz quiz) {
		quizRepo.save(quiz);
		
	}

	public void delete(Quiz quiz) {
		quizRepo.delete(quiz);
		
	}

	public List<Quiz> findAll() {
		return quizRepo.findAll();
	}

}

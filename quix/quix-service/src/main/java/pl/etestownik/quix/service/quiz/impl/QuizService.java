package pl.etestownik.quix.service.quiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.quiz.IQuizService;

public class QuizService implements IQuizService{

	@Autowired
	private IBaseRepo<Quiz> quizRepo;
	
	@Autowired
	private IBaseRepo<Question> questionRepo;
	
	@Autowired
	private IBaseRepo<Answer> anwerRepo;
	
	@Autowired
	private IBaseRepo<Content> contentRepo;
	
	public void save(Quiz quiz) {
		quizRepo.save(quiz);
	//	questionRepo.save(entity);??
	}

	public void delete(Quiz quiz) {
		quizRepo.delete(quiz);
	}

	public List<Quiz> findAll() {
		return quizRepo.findAll();
	}
	
	public void update(Quiz entity) {
		quizRepo.update(entity);
	}

	public Quiz getById(long id) {
		return quizRepo.getById(id);
	}

}

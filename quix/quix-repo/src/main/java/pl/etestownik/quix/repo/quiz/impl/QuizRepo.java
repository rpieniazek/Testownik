package pl.etestownik.quix.repo.quiz.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;


@Repository
public class QuizRepo implements IBaseRepo<Quiz> {

	@Autowired
	SessionFactory session;
	
	public void save(Quiz quiz) {
		session.getCurrentSession().save(quiz);
		session.getCurrentSession().flush();
	}

	public void delete(Quiz quiz) {
		session.getCurrentSession().delete(quiz);
	}

	@SuppressWarnings("unchecked")
	public List<Quiz> findAll() {
		return session.getCurrentSession().createCriteria(Quiz.class).list();
	}

	@Override
	public void update(Quiz entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public Quiz getById(long id) {
		return (Quiz) session.getCurrentSession().get(Quiz.class, id);
	}
}
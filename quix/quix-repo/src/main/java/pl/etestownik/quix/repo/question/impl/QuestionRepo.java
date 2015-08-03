package pl.etestownik.quix.repo.question.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

@Repository
public class QuestionRepo implements IBaseRepo<Question> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(Question entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Question entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(Question entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public Question getById(long id) {
		return (Question) session.getCurrentSession().get(Question.class, id);
	}

	@Override
	public List<Question> findAll() {
		return session.getCurrentSession().createCriteria(Question.class).list();
	}

}

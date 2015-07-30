package pl.etestownik.quix.repo.answer.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

@Repository
public class AnswerRepo implements IBaseRepo<Answer> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(Answer entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Answer entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(Answer entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public Answer getById(long id) {
		return (Answer) session.getCurrentSession().get(Answer.class, id);
	}

	@Override
	public List<Answer> findAll() {
		return session.getCurrentSession().createCriteria(Answer.class).list();
	}

}

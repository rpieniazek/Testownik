package pl.etestownik.quix.repo.content.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
public class ContentRepo implements IBaseRepo<Content> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(Content entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Content entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(Content entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public Content getById(long id) {
		return (Content) session.getCurrentSession().get(Content.class, id);
	}

	@Override
	public List<Content> findAll() {
		return session.getCurrentSession().createCriteria(Content.class).list();
	}
	
}

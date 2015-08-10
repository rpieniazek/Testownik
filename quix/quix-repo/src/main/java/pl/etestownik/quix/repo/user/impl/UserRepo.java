package pl.etestownik.quix.repo.user.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

@Repository
public class UserRepo implements IBaseRepo<User> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(User entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(User entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(User entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public User getById(long id) {
		return (User) session.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return session.getCurrentSession().createCriteria(User.class).list();
	}

}

package pl.etestownik.quix.repo.user.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

public class UserRoleRepo implements IBaseRepo<UserRole> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(UserRole entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(UserRole entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(UserRole entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public UserRole getById(long id) {
		return (UserRole) session.getCurrentSession().get(UserRole.class, id);
	}

	@Override
	public List<UserRole> findAll() {
		return session.getCurrentSession().createCriteria(UserRole.class).list();
	}
	
}

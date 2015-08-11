package pl.etestownik.quix.repo.user.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

@Repository
public class VerificationTokenRepo implements IBaseRepo<VerificationToken> {

	@Autowired
	SessionFactory session;
	
	@Override
	public void save(VerificationToken entity) {
		session.getCurrentSession().save(entity);
	}

	@Override
	public void delete(VerificationToken entity) {
		session.getCurrentSession().delete(entity);	
	}

	@Override
	public void update(VerificationToken entity) {
		session.getCurrentSession().update(entity);
	}

	@Override
	public VerificationToken getById(long id) {
		return (VerificationToken) session.getCurrentSession().get(VerificationToken.class, id);
	}

	@Override
	public List<VerificationToken> findAll() {
		return session.getCurrentSession().createCriteria(VerificationToken.class).list();
	}
	
}

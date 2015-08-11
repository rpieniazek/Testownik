package pl.etestownik.quix.repo.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.user.IVerificationTokenRepo;

@Repository
public class VerificationTokenRepo implements IVerificationTokenRepo {

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

	@Transactional
	@Override
	public VerificationToken getByToken(String token) {
		Criteria criteria = session.getCurrentSession().createCriteria(VerificationToken.class);
		criteria.add(Restrictions.eq("token",token));
		return (VerificationToken) criteria.uniqueResult(); 
	}
	
}

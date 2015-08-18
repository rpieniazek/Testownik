package pl.etestownik.quix.repo.user.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.repo.user.IUserRepo;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {

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
	@Transactional
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

	@Transactional
	@Override
	public User getByUsername(String username) {
		
		return (User) session.getCurrentSession()
		.createQuery("from User u left join fetch u.userRole where u.username=:usr")
		.setString("usr", username)
		.uniqueResult();
		/*return (User) session.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.uniqueResult();*/
		
	}

}

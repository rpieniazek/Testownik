package pl.etestownik.quix.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.user.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IBaseRepo<User> userRepo;
	
	@Override
	@Transactional
	public void save(User user) {
		userRepo.save(user);
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	@Override
	@Transactional
	public void update(User entity) {
		userRepo.update(entity);		
	}
	
	@Override
	public User getById(long id) {
		return userRepo.getById(id);
	}

	@Override
	public List<User> findAll() {
		return  userRepo.findAll();
	}

}

package pl.etestownik.quix.service.user;

import java.util.List;

import pl.etestownik.quix.model.user.User;

public interface IUserService {

	public void save(User user);
	
	public void delete(User user);
	
	public void update(User entity);
	
	public User getById (long id);
	
	public List<User> findAll();
	
}

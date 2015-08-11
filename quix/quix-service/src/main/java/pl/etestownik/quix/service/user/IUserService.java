package pl.etestownik.quix.service.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import pl.etestownik.quix.model.user.User;

public interface IUserService extends UserDetailsService {

	public void save(User user);
	
	public void delete(User user);
	
	public void update(User entity);
	
	public User getById (long id);
	
	public List<User> findAll();
	
}

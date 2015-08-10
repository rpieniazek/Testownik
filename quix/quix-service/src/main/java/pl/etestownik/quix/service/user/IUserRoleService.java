package pl.etestownik.quix.service.user;

import java.util.List;

import pl.etestownik.quix.model.user.UserRole;

public interface IUserRoleService {

public void save(UserRole userRole);
	
	public void delete(UserRole userRole);
	
	public void update(UserRole userRole);
	
	public UserRole getById (long id);
	
	public List<UserRole> findAll();
	
}

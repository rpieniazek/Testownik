package pl.etestownik.quix.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.user.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService {

	@Autowired
	private IBaseRepo<UserRole> userRoleRepo;
	
	@Override
	@Transactional
	public void save(UserRole userRole) {
		userRoleRepo.save(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleRepo.delete(userRole);
	}
	
	@Override
	public void update(UserRole entity) {
		userRoleRepo.update(entity);		
	}
	
	@Override
	public UserRole getById(long id) {
		return userRoleRepo.getById(id);
	}

	@Override
	public List<UserRole> findAll() {
		return  userRoleRepo.findAll();
	}
	
}

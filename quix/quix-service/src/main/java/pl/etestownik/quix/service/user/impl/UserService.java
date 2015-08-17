package pl.etestownik.quix.service.user.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.repo.user.IUserRepo;
import pl.etestownik.quix.service.user.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	
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

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException 
	{
		User user = userRepo.getByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("User not registered.");
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user));
	}
	
	@Transactional
	private Collection<? extends GrantedAuthority> getAuthorities(User user)
	{
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(UserRole role: user.getUserRole())
		{
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

}

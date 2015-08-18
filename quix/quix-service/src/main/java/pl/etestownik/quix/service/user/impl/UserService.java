package pl.etestownik.quix.service.user.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.mail.IMailService;
import pl.etestownik.quix.service.user.IUserService;
import pl.etestownik.quix.service.user.IVerificationTokenService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
	private IVerificationTokenService verificationTokenService;
	
	/*
	 * to się da do i18n
	 */
	private static String subject = "Weryfikacja konta: ";
	private static String body_1 = "Aby zakończyć rejestrację kliknij w poniższy link:\n";
	private static String address = "http://localhost:8070/verify?token="; // beka
	private static String body_2 = "\nTwój link straci ważność ";
	
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
	
	/*
	 * Trzeba w tym mailu pozmieniać jak już domena będzie, bo na locala wysyłać
	 * to fail ;v I gdzieś na zewnątrz treść maila ogarnąć
	 */
	public void sendVerificationToken(User receiver) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken(token,
				receiver);
		verificationTokenService.save(verificationToken);
		String expirationDate = new SimpleDateFormat("dd.MM.yyyy 'o' HH:mm").format(new Date(verificationToken.getExpireDate()));
		mailService.sendMail(receiver.getEmail(), subject, body_1 + address
				+ token + body_2 + expirationDate);
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

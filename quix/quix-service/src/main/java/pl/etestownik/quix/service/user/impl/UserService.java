package pl.etestownik.quix.service.user.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.mail.IMailService;
import pl.etestownik.quix.service.user.IUserService;
import pl.etestownik.quix.service.user.IVerificationTokenService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IBaseRepo<User> userRepo;
	
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

}

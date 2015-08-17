package pl.etestownik.quix.service.user.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.repo.user.IVerificationTokenRepo;
import pl.etestownik.quix.service.user.IVerificationTokenService;

@Service
public class VerificationTokenService implements IVerificationTokenService {

	@Autowired
	private IVerificationTokenRepo verificationTokenRepo;
	
	@Override
	@Transactional
	public void save(VerificationToken verificationToken) {
		verificationToken.setExpireDate(calculateDate());
		verificationTokenRepo.save(verificationToken);
	}
	
	/*
	 * ustala, o której godzinie zostaną przedawnione tokeny co 24h serwis
	 * będzie usuwał wszystkie dane użuytkownikó z przedawnionym tokenem na
	 * wstepie przyjąłem, że czystka będzie o 3:01
	 */
	private long calculateDate() {
		Calendar cal = Calendar.getInstance();

		/*
		 * jeżeli token został utworzony (użytkownik się zarejestrował) po
		 * godzinie 3:00 to dajemy mu czas aż do pierwszej 3:00 po 24h (więc jak
		 * user się zarejestruje o 4:00 to dostaje 47h)
		 */
		if (cal.get(Calendar.HOUR_OF_DAY) >= 3) {
			cal.add(Calendar.DATE, 2);
			cal.set(Calendar.HOUR_OF_DAY, 3);
			cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND,0);
			cal.set(Calendar.MILLISECOND,0);

		}
		/*
		 * jeżeli token został utworzony (użytkownik się zarejestrował) przed
		 * godziną 3:00 to dajemy mu czas 24h + różnica do 3:00 
		 */
		else {
			cal.add(Calendar.DATE, 1);
			cal.set(Calendar.HOUR_OF_DAY, 3);
			cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND,0);
			cal.set(Calendar.MILLISECOND,0);
		}
		
		return cal.getTimeInMillis();
	}

	@Transactional
	@Override
	public void delete(VerificationToken verificationToken) {
		verificationTokenRepo.delete(verificationToken);
	}
	
	@Override
	public void update(VerificationToken entity) {
		verificationTokenRepo.update(entity);		
	}
	
	@Override
	public VerificationToken getById(long id) {
		return verificationTokenRepo.getById(id);
	}

	@Override
	public List<VerificationToken> findAll() {
		return  verificationTokenRepo.findAll();
	}

	@Transactional
	@Override
	public VerificationToken getByToken(String token) {
		return verificationTokenRepo.getByToken(token);
	}
	
}

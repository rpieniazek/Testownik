package pl.etestownik.quix.service.user;

import java.util.List;

import pl.etestownik.quix.model.user.VerificationToken;

public interface IVerificationTokenService {
	
	public void save(VerificationToken token);
	
	public void delete(VerificationToken token);
	
	public void update(VerificationToken token);
	
	public VerificationToken getById (long id);
	
	public List<VerificationToken> findAll();
	
	public VerificationToken getByToken(String token);
	
}

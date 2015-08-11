package pl.etestownik.quix.repo.user;

import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

public interface IVerificationTokenRepo extends IBaseRepo<VerificationToken> {
	
	public VerificationToken getByToken(String token);
	
}

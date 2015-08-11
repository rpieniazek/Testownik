package pl.etestownik.quix.service.user.impl;

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
		verificationTokenRepo.save(verificationToken);
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

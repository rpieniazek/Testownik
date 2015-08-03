package pl.etestownik.quix.service.answer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.answer.IAnswerService;

@Service
public class AnswerService implements IAnswerService {

	
	@Autowired
	private IBaseRepo<Answer> anwerRepo;
	
	@Override
	@Transactional
	public void save(Answer answer) {
		anwerRepo.save(answer);
	}

	@Override
	public void delete(Answer answer) {
		anwerRepo.delete(answer);
	}
	
	@Override
	public void update(Answer entity) {
		anwerRepo.update(entity);		
	}
	
	@Override
	public Answer getById(long id) {
		return anwerRepo.getById(id);
	}

	@Override
	public List<Answer> findAll() {
		return  anwerRepo.findAll();
	}


}

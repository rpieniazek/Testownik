package pl.etestownik.quix.service.question.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.question.IQuestionService;
@Service
public class QuestionService implements IQuestionService {

	@Autowired
	private IBaseRepo<Question> questionRepo;

	@Transactional
	public void save(Question question) {
		questionRepo.save(question);
	}

	@Override
	public void delete(Question question) {
		questionRepo.delete(question);
	}
	@Override
	public void update(Question question){
		questionRepo.update(question);
	}
	
	@Override
	public Question getById (long id){
		return questionRepo.getById(id);
	}
	  
	@Override
	public List<Question> findAll() {
		return questionRepo.findAll();
	}

}

package pl.etestownik.quix.service.answer;

import java.util.List;

import pl.etestownik.quix.model.answer.Answer;

public interface IAnswerService {
	
	public void save(Answer answer);
	
	public void delete(Answer answer);
	
	public void update(Answer entity);
	
	public Answer getById (long id);
	
	public List<Answer> findAll();
}

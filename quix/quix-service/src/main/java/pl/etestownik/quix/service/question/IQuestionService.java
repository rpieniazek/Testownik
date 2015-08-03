package pl.etestownik.quix.service.question;

import java.util.List;

import pl.etestownik.quix.model.question.Question;

public interface IQuestionService {
	
	public void save(Question question);
	
	public void delete(Question question);
	
	public void update(Question entity);
	
	public Question getById (long id);
	
	public List<Question> findAll();
}

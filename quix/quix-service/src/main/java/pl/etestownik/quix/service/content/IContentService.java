package pl.etestownik.quix.service.content;

import java.util.List;

import pl.etestownik.quix.model.content.Content;

public interface IContentService {
	
	public void save(Content content);
	
	public void update(Content content);
	
	public Content getById (long id);
	
	public void delete(Content content);
	
	public List<Content> findAll();
}

package pl.etestownik.quix.service.content.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.content.IContentService;

@Service
public class ContentService implements IContentService {
	
	@Autowired
	private IBaseRepo<Content> contentRepo;
	
	@Override
	@Transactional
	public void save(Content content) {
		contentRepo.save(content);
	}
	
	@Override
	public void update(Content content) {
		contentRepo.update(content);		
	}
	
	@Override
	public Content getById(long id) {
		return contentRepo.getById(id);
	}
	
	@Override
	@Transactional
	public void delete(Content content) {
		contentRepo.delete(content);
	}

	@Override
	public List<Content> findAll() {
		return contentRepo.findAll();
	}

}

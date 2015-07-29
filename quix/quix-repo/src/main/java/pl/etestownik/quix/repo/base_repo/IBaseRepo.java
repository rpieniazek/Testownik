package pl.etestownik.quix.repo.base_repo;

import java.util.List;

public interface IBaseRepo<T> {

	public void save(T entity);

	public void delete(T entity);
	
	public void update(T entity);
	
	public T getById (long id);
	
	public List<T> findAll();
	
}

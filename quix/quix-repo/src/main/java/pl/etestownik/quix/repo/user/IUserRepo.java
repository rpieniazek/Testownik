package pl.etestownik.quix.repo.user;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;

public interface IUserRepo extends IBaseRepo<User>{
	public User getByUsername(String username);
}

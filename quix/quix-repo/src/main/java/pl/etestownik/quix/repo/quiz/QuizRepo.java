package pl.etestownik.quix.repo.quiz;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.repo.quiz.impl.IQuizRepo;


@Repository
public class QuizRepo implements IQuizRepo {

	@Autowired
	SessionFactory session;
	
	public void save(Quiz quiz) {
		session.getCurrentSession().save(quiz);
	}

	public void delete(Quiz quiz) {
		session.getCurrentSession().delete(quiz);
	}

	public List<Quiz> findAll() {
		return session.getCurrentSession().createCriteria(Quiz.class).list();
	}
}
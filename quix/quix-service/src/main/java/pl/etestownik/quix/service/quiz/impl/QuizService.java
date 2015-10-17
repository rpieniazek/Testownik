package pl.etestownik.quix.service.quiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.repo.base_repo.IBaseRepo;
import pl.etestownik.quix.service.quiz.IQuizService;


@Service
public class QuizService implements IQuizService {

	@Autowired
	private IBaseRepo<Quiz> quizRepo;

	@Autowired
	private IBaseRepo<Question> questionRepo;

	@Autowired
	private IBaseRepo<Answer> anwerRepo;

	@Autowired
	private IBaseRepo<Content> contentRepo;

	@Transactional
	public void save(Quiz quiz) {
		quizRepo.save(quiz);
	}

	public void delete(Quiz quiz) {
		quizRepo.delete(quiz);
	}

	public void update(Quiz entity) {
		quizRepo.update(entity);
	}

	public Quiz getById(long id) {
		return quizRepo.getById(id);
	}

	public List<Quiz> findAll() {
		return quizRepo.findAll();
	}

	@Override
	public void setDetails(Quiz quiz, String name, String subject,
			String institution) {
		quiz.setName(name);
		quiz.setSubject(subject);
		quiz.setInstitution(institution);
	}

	@Override
	public void addQuestion(Quiz quiz, String question, String codedAnswers) {
		Question q = new Question(question);
		System.out.println("HUEHUEHE");
		System.out.println(codedAnswers);
		String[] answerData = codedAnswers.split("\\[\\^\\$\\&\\]");
		for (int i = 0; i < answerData.length - 1; i+=2) {
			if (answerData[i] != null && !answerData[i].isEmpty()) {
				Answer a = new Answer(answerData[i]);
				a.setCorrect(Boolean.valueOf(answerData[i + 1]));
				q.getAnswers().add(a);
			}
		}
		quiz.getQuestions().add(q);
	}
}

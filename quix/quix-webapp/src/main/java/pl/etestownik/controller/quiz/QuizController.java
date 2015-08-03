package pl.etestownik.controller.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.controller.quiz.form.QuizForm;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.service.content.IContentService;
import pl.etestownik.quix.service.question.IQuestionService;
import pl.etestownik.quix.service.quiz.IQuizService;


@Controller
public class QuizController {
	
	@Autowired
	private IQuizService quizService;
	
	@Autowired 
	IQuestionService questionService;
	
	@Autowired 
	IContentService contentService;
	
	@ModelAttribute("quizForm")
	public QuizForm form(){
		return new QuizForm();
	}
	
	@RequestMapping(value = { "/quiz/new" }, method = RequestMethod.GET)
	public String newQuiz(Model model) {
		return "add-quiz";
	}

	@RequestMapping(value = { "/quiz/save" }, method = {RequestMethod.POST, RequestMethod.GET})
	public String saveQuiz(QuizForm quizForm) {
		
		//zapisujemy pytanie: 
		//to cos chujowe jest chyba, trzeba zapisywac osobno kazda encje, bo wywala blad, 
		//ze Content nie jest zapisany
		//Czy da sie to zrobić jakoś lepiej? - w stylu Quiz.setQuestion itd. i potem tylko saveQuiz?
		Content questionContent =quizForm.getQuestion().getContent();	
		contentService.save(questionContent);// zapisujemy najpierw content pytania
		Question question = quizForm.getQuestion();
		question.setContent(questionContent);
		questionService.save(question);
		
		// teraz zapisujemy pytania: 
		
		//question.setContent(questionContent);
		List<Answer> answers = quizForm.getAnswers();
		
		//Content answerContent = new Content();
		
//		for(Answer string :quizForm.getAnswer()){
//			answerContent.setText(string);
//		}
//		questionContent.setText(quizForm.getQuestion());
		
		//quizService.save(quiz.get);
		return "add-quiz";
	}
}

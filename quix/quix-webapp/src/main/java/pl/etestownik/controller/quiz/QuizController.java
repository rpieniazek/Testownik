package pl.etestownik.controller.quiz;

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
import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.service.quiz.IQuizService;


@Controller
public class QuizController {
	
	@Autowired
	private IQuizService quizService;
	
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
		
		Content questionContent = new Content();
		Content answerContent = new Content();
		
		Question question = new Question(); 
		
		for(String string :quizForm.getAnswer()){
			answerContent.setText(string);
		}
		questionContent.setText(quizForm.getQuestion());
		
		//quizService.save(quiz.get);
		return "add-quiz";
	}
}

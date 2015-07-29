package pl.etestownik.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.service.quiz.IQuizService;


@Controller
public class QuizController {
	
	@Autowired
	private IQuizService quizService;

	@RequestMapping(value = { "/quiz/new" }, method = {RequestMethod.POST, RequestMethod.GET})
	public String newQuiz(@ModelAttribute("quiz") Quiz quiz){
		return "add-quiz";
	}

	@RequestMapping(value = { "/quiz/save" }, method = {RequestMethod.POST, RequestMethod.GET})
	public String saveQuiz(@ModelAttribute("quiz") Quiz quiz){
		quizService.save(quiz);
		return "add-quiz";
	}
}

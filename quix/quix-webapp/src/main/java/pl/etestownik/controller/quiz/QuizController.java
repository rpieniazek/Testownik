package pl.etestownik.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.quix.service.quiz.IQuizService;


@Controller
public class QuizController {
	
	@Autowired
	private IQuizService quizService;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.POST)
	public String basicForm(){
		return "index";
	}
}

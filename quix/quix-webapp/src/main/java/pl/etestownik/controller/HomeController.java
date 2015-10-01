package pl.etestownik.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.etestownik.controller.quiz.form.QuizForm;

@Controller
@Log4j
public class HomeController {
	
	@RequestMapping(value = { "admin", "/admin/" })
	public String home() {
		return "pages/admin/index";
	}

	@RequestMapping(value = { "", "/" })
	public String landingPage() {
		log.debug("HomeController reached!");
		return "pages/index";
	}
	
	

	
}

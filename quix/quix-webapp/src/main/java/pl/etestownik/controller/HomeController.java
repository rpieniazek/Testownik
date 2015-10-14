package pl.etestownik.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import pl.etestownik.controller.quiz.form.QuizForm;

@Controller

public class HomeController {
	
	@RequestMapping(value = { "admin", "/admin/" })
	public String home() {
		return "admin/index";
	}

	@RequestMapping(value = { "/", "" },method = RequestMethod.GET)
	public String landingPage() {

		return "index";
	}
	
	

	
}

package pl.etestownik.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class HomeController {

	@RequestMapping(value = { "admin", "/admin/" })
	public String home() {
		return "/admin/index";
	}

	@RequestMapping(value = { "", "/" })
	public String landingPage() {
		return "index";
	}
	
}

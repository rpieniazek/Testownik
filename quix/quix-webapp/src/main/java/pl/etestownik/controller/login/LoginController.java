package pl.etestownik.controller.login;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.etestownik.quix.model.user.User;

@Controller
public class LoginController {

	
	
	@ModelAttribute(value = "user")
	public User user()
	{
		return new User();
	}
	
	@RequestMapping(value = { "/login", "/login/" }, method = RequestMethod.GET)
	public ModelAndView loginTo(Model model, @RequestParam(value = "err", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Zła nazwa użytkownika lub hasło!");
		}

		if (logout != null) {
			modelAndView.addObject("msg", "Wylogowano pomyślnie.");
		}
		modelAndView.setViewName("login");

		return modelAndView;
	}
}

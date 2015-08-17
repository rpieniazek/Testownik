package pl.etestownik.controller.login;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.etestownik.quix.model.user.User;

@Controller
public class LoginController {

	
	
	@ModelAttribute(value = "user")
	public User user()
	{
		return new User();
	}
	
	@RequestMapping(value = { "/login", "/login/" }, method = RequestMethod.GET)
	public String loginTo(Model model)
	{
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String afterLogin(@RequestParam(value = "error", required = false) String error, 
			User user, BindingResult result)
	{		
		return "index";
	}
}

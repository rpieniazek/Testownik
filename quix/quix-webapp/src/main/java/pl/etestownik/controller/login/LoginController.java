package pl.etestownik.controller.login;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@RequestMapping(value={"/login", "login"} ,method = RequestMethod.GET)
	
	public String login(ModelMap model, Principal principal){
		principal.getName();
		
		return "login";
	}
}

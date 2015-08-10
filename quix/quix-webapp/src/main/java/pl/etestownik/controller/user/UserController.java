package pl.etestownik.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.service.user.IUserRoleService;
import pl.etestownik.quix.service.user.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserRoleService userRoleService;
	
	@ModelAttribute("user")
	public User user(){
		return new User();
	}
	
	//przy ładowaniue url
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	private String loadPage(Model model){
		return "register";
	}
	
	//po submicie
	@RequestMapping(value = { "/registered" }, method = {RequestMethod.POST, RequestMethod.GET} )
	private String onRegistered(User user){
		userService.save(user);
		UserRole userRole = new UserRole(user, "ROLE_USER");
		userRoleService.save(userRole);
		return "index";
	}
	
}

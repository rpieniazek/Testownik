package pl.etestownik.controller.user;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.service.user.IUserRoleService;
import pl.etestownik.quix.service.user.IUserService;

@Controller
@RequestMapping(value = { "/register" })
class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	// przy ładowaniue url
	@RequestMapping(method = RequestMethod.GET)
	private String loadPage(Model model) {
		return "register";
	}

	// po submicie
	@RequestMapping(method = RequestMethod.POST)
	private String onRegistered(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "kupa";
		} else {
			userService.save(user);
			UserRole userRole = new UserRole(user, "ROLE_USER");
			userRoleService.save(userRole);
			return "index";	
		}
	}

}

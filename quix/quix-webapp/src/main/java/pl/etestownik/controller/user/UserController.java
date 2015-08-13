package pl.etestownik.controller.user;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.UserRole;
import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.service.mail.IMailService;
import pl.etestownik.quix.service.user.IUserRoleService;
import pl.etestownik.quix.service.user.IUserService;
import pl.etestownik.quix.service.user.IVerificationTokenService;

@Controller
@RequestMapping(value = { "/register" })
class UserController {

	@ModelAttribute(value = "user")
	public User user() {
		return new User();
	}

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;

	// przy ładowaniue url
	@RequestMapping(method = RequestMethod.GET)
	private String loadPage(Model model) {
		return "register";
	}

	// po submicie
	@RequestMapping(method = RequestMethod.POST)
	private String onRegistered(@Valid User user, BindingResult result) {
		System.out.println("Has errors=" + result.hasErrors());
		if (result.hasErrors()) {
			return "register";
		} else {
			try {
				userService.save(user);
				userService.sendVerificationToken(user);
				UserRole userRole = new UserRole(user, "ROLE_USER");
				userRoleService.save(userRole);
				return "thx4register";
			} catch (Exception e) {
				e.printStackTrace();
				return "register";
			}
		}
	}
}

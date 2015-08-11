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

	private static String subject = "Weryfikacja konta: ";
	private static String body = "Aby zakończyć rejestrację kliknij w poniższy link:\n";
	private static String address = "localhost:8070/verify?token="; // beka

	@ModelAttribute(value = "user")
	public User user() {
		return new User();
	}

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;

	@Autowired
	private IVerificationTokenService verificationTokenService;

	@Autowired
	private IMailService mailService;

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
				sendVerificationToken(user);
				userService.save(user);
				UserRole userRole = new UserRole(user, "ROLE_USER");
				userRoleService.save(userRole);
				return "index";
			} catch (Exception e) {
				e.printStackTrace();
				return "register";
			}
		}
	}

	/*
	 * Trzeba w tym mailu pozmieniać jak już domena będzie, bo na locala wysyłać
	 * to fail ;v I gdzieś na zewnątrz treść maila ogarnąć
	 */
	private void sendVerificationToken(User receiver) {
		String token = UUID.randomUUID().toString();
		mailService.sendMail(receiver.getEmail(), subject, body + address
				+ token);
		VerificationToken verificationToken = new VerificationToken(token,
				receiver);
		verificationTokenService.save(verificationToken);
	}

}

package pl.etestownik.controller.verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.etestownik.quix.model.user.User;
import pl.etestownik.quix.model.user.VerificationToken;
import pl.etestownik.quix.service.user.IUserService;
import pl.etestownik.quix.service.user.IVerificationTokenService;

@Controller
public class VerifyController {

	@Autowired
	private IVerificationTokenService verificationTokenService;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	private String verificationProcess(@RequestParam("token") String token) {

		VerificationToken verificationToken = verificationTokenService
				.getByToken(token);
		/*
		 * podany token nie istnieje
		 */
		if (verificationToken == null) {
			System.out.println("Błędny token");
			return "index";
		}
		/*
		 * przedawniony token ta sytuacja nie powinna zajść, bo teoretycznie w
		 * momencie przedawnienia wszystkie dane związane z tokenem (sam token,
		 * user, user_role) zostaną usunięte
		 */
		else if (verificationToken.getExpireDate() - System.currentTimeMillis() < 0) {
			System.out.println("Przestarzały token");
			return "index";
		}
		/*
		 * wszystko gra, zmieniamy enabled usera i usuwamy token, żeby potem nie
		 * wywaliło nam aktywnego usera
		 */
		else {
			User user = verificationToken.getUser();
			user.setEnabled(true);
			userService.update(user);
			verificationTokenService.delete(verificationToken);
			return "index";
		}
	}

}

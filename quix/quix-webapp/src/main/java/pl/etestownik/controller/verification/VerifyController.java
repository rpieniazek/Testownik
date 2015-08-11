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
	
	@RequestMapping(value = "/verify",method = RequestMethod.GET)
	private String verificationProcess(@RequestParam("token") String token){
		
		VerificationToken verificationToken = verificationTokenService.getByToken(token);
		if(verificationToken == null){
			System.out.println("Błędny token");
			return "index";
		}
		else if(verificationToken.getExpireDate() - System.currentTimeMillis() < 0){
			System.out.println("Przestarzały token");
			return "index";
		}
		else{
			User user = verificationToken.getUser();
			user.setEnabled(true);
			userService.update(user);
			return "index";
		}
	}
	
}

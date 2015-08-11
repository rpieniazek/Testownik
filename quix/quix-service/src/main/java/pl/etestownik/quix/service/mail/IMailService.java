package pl.etestownik.quix.service.mail;

public interface IMailService {

	public void sendMail(String to, String subject, String body);
	
  //public void sendPreConfiguredMail(String message);

}

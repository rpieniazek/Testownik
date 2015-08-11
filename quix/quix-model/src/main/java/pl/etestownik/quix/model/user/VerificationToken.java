package pl.etestownik.quix.model.user;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "verification_tokens")
public class VerificationToken {

	@Id
	@Getter
	@GeneratedValue
	private Long id;

	@Getter
	@Setter
	private String token;

	@Getter
	@Setter
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	@Getter
	@Setter
	private Long expireDate;

	public VerificationToken() {
		expireDate = calculateDate();
	}

	public VerificationToken(String vToken, User usr) {
		this();
		token = vToken;
		user = usr;
	}

	/*
	 * ustala, o której godzinie zostaną przedawnione tokeny co 24h serwis
	 * będzie usuwał wszystkie dane użuytkownikó z przedawnionym tokenem na
	 * wstepie przyjąłem, że czystka będzie o 3:01
	 */
	private long calculateDate() {
		Calendar cal = Calendar.getInstance();

		/*
		 * jeżeli token został utworzony (użytkownik się zarejestrował) po
		 * godzinie 3:00 to dajemy mu czas aż do pierwszej 3:00 po 24h (więc jak
		 * user się zarejestruje o 4:00 to dostaje 47h)
		 */
		if (cal.get(Calendar.HOUR) >= 3) {
			cal.add(Calendar.DATE, 2);
			cal.set(Calendar.HOUR, 3);
		}
		/*
		 * jeżeli token został utworzony (użytkownik się zarejestrował) przed
		 * godziną 3:00 to dajemy mu czas 24h + różnica do 3:00 
		 */
		else {
			cal.add(Calendar.DATE, 1);
			cal.set(Calendar.HOUR, 3);
		}
		
		return cal.getTimeInMillis();
	}
}

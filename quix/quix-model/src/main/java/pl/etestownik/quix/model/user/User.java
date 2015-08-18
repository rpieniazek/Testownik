package pl.etestownik.quix.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.ws.soap.Addressing;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

	/*
	 * Uznałem, że username nie będzie kluczem głównym bo np. damy opcję zmiany
	 * loginu czy coś Poza tym w repo bym nie mógł interfejsu podciągnąć ->
	 * findById... :D
	 */
	@Getter
	@Setter
	@GeneratedValue
	@Id
	private long id;

	@Getter
	@Setter
	@Size(min = 4, max = 20, message = "Nazwa użytkownika musi mieć od 4 do 20 znaków")
	@Column(unique=true)
	private String username;

	@Getter
	@Setter
	@Size(min = 4, max = 20, message = "Hasło musi mieć od 4 do 20 znaków")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", 
		message = "Hasło musi się składać z przynajmniej jednej cyfry i dużej litery")
	private String password;

	@Getter
	@Setter
	@Column(name = "email", unique = true)
//	@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$", 
//		message = "Nieprawidłowy format adresu e-mail")
	private String email;

	@Getter
	@Setter
	private boolean enabled;

	@Getter
	@Setter
	private long registrationDate;

	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserRole.class)
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {
		enabled = false;
		registrationDate = System.currentTimeMillis();
	}
}

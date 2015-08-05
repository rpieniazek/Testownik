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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {

	/*
	 * Uznałem, że username nie będzie kluczem głównym bo np. damy opcję zmiany loginu czy coś
	 * Poza tym w repo bym nie mógł interfejsu podciągnąć -> findById... :D
	 */
	@Getter
	@Setter
	@GeneratedValue
	@Id
	private long id;
	
	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	@Column(name="email",unique=true)
	private String email;
	
	@Getter
	@Setter
	private boolean enabled;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserRole.class)
	private Set userRole = new HashSet(0);
}

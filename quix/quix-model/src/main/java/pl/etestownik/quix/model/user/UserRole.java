package pl.etestownik.quix.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
/* uniqueConstraint - żeby nie było dwóch rekordów z tym samym userem i rolą */
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"username","role"}))
public class UserRole {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	@Column(name = "user_role_id")
	private Integer userRoleId;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	/*
	 * W gigsie/coopie role było enumem co w sumie jest sensowne, ale produkuje więcej kodu, więc jebać
	 * Najwyżej zmienimy ze Stringa na enumaratedValue czy coś
	 * role jako String był na mkyongu :D
	 */
	@Getter
	@Setter
	private String role;
	
	public UserRole()
	{
		
	}
	
	public UserRole(User user, String role){
		this.user = user;
		this.role = role;
	}
}

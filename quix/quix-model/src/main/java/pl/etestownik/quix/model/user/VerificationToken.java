package pl.etestownik.quix.model.user;

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
	
	private static final long EXPIRATION = 86400000;
	 
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

    public VerificationToken(){
    	expireDate = System.currentTimeMillis() + EXPIRATION;
    }
    
    public VerificationToken(String vToken, User usr){
    	this();
    	token = vToken;
    	user = usr;
    }
    
}

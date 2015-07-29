package pl.etestownik.quix.model.content;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.question.Question;

@Entity
@Table(name="contents")
public class Content {

	@Getter
	@GeneratedValue
	@Id
	@Column(name="id_content")
	private long Id;
	
	@Getter
	@Setter
	private Blob image;
	
	@Getter
	@Setter
	private String text;	
<<<<<<< HEAD
	
//	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
//	private Answer answer;
//	
//	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
//	private Question question;
=======
>>>>>>> bdfaec72ea60d4a593f72bb5318600753b7df19f
}

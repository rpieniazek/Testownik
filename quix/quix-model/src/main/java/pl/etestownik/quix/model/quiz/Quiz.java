package pl.etestownik.quix.model.quiz;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.question.Question;

@Entity
@Table(name="tests")
public class Quiz {


	@Getter
	@GeneratedValue
	@Id
	@Column(name="id_quiz")
	private long Id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String subject;
	
	@Getter
	@Setter
	private String institution;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "quiz", targetEntity = Question.class, cascade = CascadeType.ALL)
	private Set<Question> questions;

	public Quiz(){}
	//TODO: User
}

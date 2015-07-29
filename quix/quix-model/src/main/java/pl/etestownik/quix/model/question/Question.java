package pl.etestownik.quix.model.question;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.quiz.Quiz;

@Entity
@Table(name="questions")
public class Question {
	
	@GeneratedValue
	@Id
	@Getter
	@Column(name="id_question")
	private long Id;
	
	@Getter
	@Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_quiz")
	private Quiz quiz;
	
	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Content.class)
	@PrimaryKeyJoinColumn(name = "id_content")
	private Content content;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "question", targetEntity = Answer.class, cascade = CascadeType.ALL)
	private Set<Answer> answers;
}

package pl.etestownik.quix.model.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.question.Question;

@Entity
@Table(name="answers")
public class Answer {

	@Getter
	@GeneratedValue
	@Id
	@Column(name="id_answer")
	private long Id;
	
	@Getter
	@Setter
	private boolean isCorrect;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_question")
	private Question question;
	
	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_content")
	private Content content;
}

package pl.etestownik.quix.model.content;

import java.io.Serializable;
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
public class Content implements Serializable {
	
	private static final long serialVersionUID = 6678411629811535216L;

	public Content(){}

	public Content(String text){
		this.text = text;
	}

	public Content(Blob image){
		this.image = image;
	}

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
}

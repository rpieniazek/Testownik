package pl.etestownik.quix.model.quiz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tests")
public class Quiz {

	@Getter
	@GeneratedValue
	@Id
	private int Id;
	
	@Getter
	@Setter
	private String name;
}

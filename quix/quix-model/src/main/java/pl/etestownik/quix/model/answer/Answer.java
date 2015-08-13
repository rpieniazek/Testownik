package pl.etestownik.quix.model.answer;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import pl.etestownik.quix.model.content.Content;
import pl.etestownik.quix.model.question.Question;

import java.sql.Blob;

@Entity
@Table(name = "answers")
public class Answer {

    public Answer() {
    }

    public Answer(String text) {
        content = new Content(text);
    }

    public Answer(Blob image) {
        content.setImage(image);
    }

    public Answer(Content content) {
        this.content = content;
    }

    @Getter
    @GeneratedValue
    @Id
    @Column(name = "id_answer")
    private long Id;

    @Getter
    @Setter
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question")
    private Question question;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_content")
    private Content content;
}

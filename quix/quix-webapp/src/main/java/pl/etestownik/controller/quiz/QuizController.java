package pl.etestownik.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.etestownik.controller.quiz.form.QuizForm;
import pl.etestownik.quix.model.answer.Answer;
import pl.etestownik.quix.model.question.Question;
import pl.etestownik.quix.model.quiz.Quiz;
import pl.etestownik.quix.service.quiz.IQuizService;

import java.util.HashSet;
import java.util.Set;


@Controller
public class QuizController {

    @Autowired
    private IQuizService quizService;

    @ModelAttribute("quizForm")
    public QuizForm form() {
        return new QuizForm();
    }

    @RequestMapping(value = {"/admin/quiz/new"}, method = RequestMethod.GET)
    public String newQuiz(Model model) {
        return "/admin/add-quiz";
    }

    @RequestMapping(value = {"/admin/quiz/save"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String saveQuiz(QuizForm quizForm) {

        //ustawiam odpowiedzi
        Set<Answer> answers = new HashSet<>();
        for (String s : quizForm.getAnswersString())
            answers.add(new Answer(s));

        //ustawaiam pytanie
        Set<Question> questionsSet = new HashSet<>();
        Question question = new Question(quizForm.getQuestionString());
        question.setAnswers(answers);
        questionsSet.add(question);

        //dodaje do quizu pytanie ktore zawiera w sobie odpowiedzi
        quizForm.getQuiz().setQuestions(questionsSet);

        //zapisuje do bazy quiz, z pytaniem i odpowiedziami
        quizService.save(quizForm.getQuiz());
        return "/admin/add-quiz";
    }
}

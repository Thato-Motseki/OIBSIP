import java.util.ArrayList;
import java.util.List;

public class Exam {
    private final List<Question> questions = new ArrayList<>();

    public Exam() {
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"implements", "extends", "inherits", "super"},
                1));

        questions.add(new Question(
                "Which collection does not allow duplicate elements?",
                new String[]{"List", "ArrayList", "Set", "Queue"},
                2));

        questions.add(new Question(
                "Which method starts a Java program?",
                new String[]{"start()", "run()", "main()", "execute()"},
                2));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

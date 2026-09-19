import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExamFrame extends JFrame {
    private final String displayName;
    private final List<Question> questions;
    private final int[] answers;
    private int current = 0;
    private int secondsRemaining = 120;
    private Timer timer;

    private final JLabel questionLabel = new JLabel();
    private final JLabel timerLabel = new JLabel();
    private final JRadioButton[] options = {
            new JRadioButton(), new JRadioButton(), new JRadioButton(), new JRadioButton()
    };
    private final ButtonGroup group = new ButtonGroup();

    public ExamFrame(String displayName) {
        this.displayName = displayName;
        Exam exam = new Exam();
        questions = exam.getQuestions();
        answers = new int[questions.size()];

        setTitle("Online Examination System");
        setSize(650, 400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        for (JRadioButton option : options) {
            group.add(option);
        }

        JPanel top = new JPanel(new BorderLayout());
        top.add(new JLabel("Candidate: " + displayName), BorderLayout.WEST);
        top.add(timerLabel, BorderLayout.EAST);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        center.add(questionLabel);
        center.add(Box.createVerticalStrut(15));
        for (JRadioButton option : options) {
            center.add(option);
        }

        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");
        JButton submit = new JButton("Submit");

        previous.addActionListener(e -> saveAndShow(current - 1));
        next.addActionListener(e -> saveAndShow(current + 1));
        submit.addActionListener(e -> confirmSubmit());

        JPanel bottom = new JPanel();
        bottom.add(previous);
        bottom.add(next);
        bottom.add(submit);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                confirmClose();
            }
        });

        showQuestion();
        timer = new Timer(1000, e -> tick());
        timer.start();
    }

    private void showQuestion() {
        Question q = questions.get(current);
        questionLabel.setText((current + 1) + ". " + q.getText());

        group.clearSelection();
        int saved = answers[current];
        if (saved >= 0 && saved < options.length) {
            options[saved].setSelected(true);
        }

        for (int i = 0; i < options.length; i++) {
            options[i].setText(q.getOptions()[i]);
        }

        timerLabel.setText("Time: " + secondsRemaining + "s");
    }

    private void saveAnswer() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                answers[current] = i;
                return;
            }
        }
        answers[current] = -1;
    }

    private void saveAndShow(int index) {
        saveAnswer();
        if (index >= 0 && index < questions.size()) {
            current = index;
            showQuestion();
        }
    }

    private void tick() {
        secondsRemaining--;
        timerLabel.setText("Time: " + secondsRemaining + "s");

        if (secondsRemaining <= 0) {
            if (timer != null) timer.stop();
            submitExam(true);
        }
    }

    private void confirmSubmit() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Submit your exam?",
                "Confirm Submission",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            submitExam(false);
        }
    }

    private void submitExam(boolean automatic) {
        saveAnswer();
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (answers[i] == questions.get(i).getCorrectAnswer()) {
                score++;
            }
        }

        long used = 120L - secondsRemaining;
        new ResultFrame(displayName, score, questions.size(), used, automatic).setVisible(true);
        dispose();
    }

    private void confirmClose() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "The exam is still in progress. Close without submitting?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

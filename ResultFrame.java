import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {
    public ResultFrame(String displayName, int score, int total, long timeTaken, boolean automatic) {
        setTitle("Exam Results");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        int incorrect = total - score;

        panel.add(new JLabel("Candidate: " + displayName));
        panel.add(new JLabel("Score: " + score + " / " + total));
        panel.add(new JLabel("Correct: " + score));
        panel.add(new JLabel("Incorrect: " + incorrect));
        panel.add(new JLabel("Time taken: " + timeTaken + " seconds"
                + (automatic ? " (auto-submitted)" : "")));

        JButton logout = new JButton("Logout");
        logout.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(logout, BorderLayout.SOUTH);
    }
}

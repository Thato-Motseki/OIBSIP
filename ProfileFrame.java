import javax.swing.*;
import java.awt.*;

public class ProfileFrame extends JFrame {
    private final JTextField displayNameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public ProfileFrame(String username) {
        setTitle("Profile - " + username);
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("Display name:"));
        panel.add(displayNameField);
        panel.add(new JLabel("New password:"));
        panel.add(passwordField);

        JButton continueButton = new JButton("Continue to Exam");
        panel.add(new JLabel());
        panel.add(continueButton);

        continueButton.addActionListener(e -> {
            String displayName = displayNameField.getText().trim();
            if (displayName.isEmpty()) {
                displayName = username;
            }

            new ExamFrame(displayName).setVisible(true);
            dispose();
        });

        add(panel);
    }
}

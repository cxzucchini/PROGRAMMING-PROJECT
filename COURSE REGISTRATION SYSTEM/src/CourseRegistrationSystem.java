import javax.swing.*;
import java.awt.*;

public class CourseRegistrationSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton enrollButton;
    private JTextArea enrollmentConfirmationArea;

    public CourseRegistrationSystem() {
        // Set up the frame
        setTitle("Course Registration System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panels
        mainPanel.add(new EnrollmentPanel(this), "Enrollment");
        mainPanel.add(new CourseRegistrationPanel(this), "Registration");
        mainPanel.add(new ReceiptPanel(this), "Receipt");

        add(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel; // Add this method to access the mainPanel
    }

    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CourseRegistrationSystem system = new CourseRegistrationSystem();
            system.setVisible(true);
        });
    }
}
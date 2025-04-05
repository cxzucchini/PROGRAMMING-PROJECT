import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CourseRegistrationPanel extends JPanel {
    private JComboBox<String> courseComboBox;
    private JLabel availableSlotsLabel;
    private JButton registerButton;
    private JTextArea registrationConfirmationArea;
    private CourseRegistrationSystem mainFrame;

    // Sample data for courses and their available slots
    private Map<String, Integer> courses;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField nameField;
    private JButton enrollButton;

    public CourseRegistrationPanel(CourseRegistrationSystem mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(5, 1));

        // Initialize course data
        courses = new HashMap<>();
        courses.put("Mathematics", 5);
        courses.put("Physics", 3);
        courses.put("Chemistry", 0);
        courses.put("Biology", 2);

        add(new JLabel("Select Course:"));
        courseComboBox = new JComboBox<>(courses.keySet().toArray(new String[0]));
        availableSlotsLabel = new JLabel("Available Slots: " + getAvailableSlots((String) courseComboBox.getSelectedItem()));

        // Update available slots when course is selected
        courseComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                availableSlotsLabel.setText("Available Slots: " + getAvailableSlots(selectedCourse));
            }
        });

        registerButton = new JButton("Register");
        registrationConfirmationArea = new JTextArea(5, 30);
        registrationConfirmationArea.setEditable(false);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                int availableSlots = getAvailableSlots(selectedCourse);
                if (availableSlots > 0) {
                    // Register the student
                    courses.put(selectedCourse, availableSlots - 1);
                    registrationConfirmationArea.append("Registered for " + selectedCourse + ".\n");
                    availableSlotsLabel.setText("Available Slots: " + getAvailableSlots(selectedCourse));

                    // Get the enrollee's information from the EnrollmentPanel
                    EnrollmentPanel enrollmentPanel = (EnrollmentPanel) mainFrame.getMainPanel().getComponent(0);
                    String name = enrollmentPanel.getName();
                    String email = enrollmentPanel.getEmail();
                    String phone = enrollmentPanel.getPhone();
                    String address = enrollmentPanel.getAddress();
                    String age = enrollmentPanel.getAge(); // Get age

                    // Display the receipt with the enrollee's information
                    ReceiptPanel receiptPanel = (ReceiptPanel) mainFrame.getMainPanel().getComponent(2);
                    receiptPanel.displayReceipt(name, email, phone, address, age, selectedCourse); // Pass age

                    mainFrame.switchToPanel("Receipt");
                } else {
                    registrationConfirmationArea.append("No available slots for " + selectedCourse + ".\n");
                }
            }
        });

        add(courseComboBox);
        add(availableSlotsLabel);
        add(registerButton);
        add(new JScrollPane(registrationConfirmationArea));
    }

    private int getAvailableSlots(String course) {
        return courses.getOrDefault(course, 0);
    }
}
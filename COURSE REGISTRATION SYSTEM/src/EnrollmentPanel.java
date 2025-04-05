import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollmentPanel extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField ageField; // New field for age
    private JButton enrollButton;
    private JTextArea enrollmentConfirmationArea;
    private CourseRegistrationSystem mainFrame;

    public EnrollmentPanel(CourseRegistrationSystem mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(7, 1));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Age:")); // Label for age
        ageField = new JTextField(); // Text field for age
        add(ageField);

        enrollButton = new JButton("Enroll");
        enrollmentConfirmationArea = new JTextArea(3, 30);
        enrollmentConfirmationArea.setEditable(false);

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String age = ageField.getText(); // Get age input
                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !age.isEmpty()) {
                    enrollmentConfirmationArea.setText("Enrolled: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address + "\nAge: " + age);
                    mainFrame.switchToPanel("Registration");
                } else {
                    enrollmentConfirmationArea.setText("Please fill in all fields.");
                }
            }
        });

        add(enrollButton);
        add(enrollmentConfirmationArea);
    }

    // Getter methods for enrollee information
    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getAge() { // New getter for age
        return ageField.getText();
    }
}
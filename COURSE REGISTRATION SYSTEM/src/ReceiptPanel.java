import javax.swing.*;
import java.awt.*;

public class ReceiptPanel extends JPanel {
    private JTextArea receiptArea;
    private CourseRegistrationSystem mainFrame;

    public ReceiptPanel(CourseRegistrationSystem mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);
        add(new JScrollPane(receiptArea), BorderLayout.CENTER);
    }

    public void displayReceipt(String name, String email, String phone, String address, String age, String course) {
        String receiptContent = "Enrollment Confirmation\n";
        receiptContent += "Name: " + name + "\n";
        receiptContent += "Email: " + email + "\n";
        receiptContent += "Phone: " + phone + "\n";
        receiptContent += "Address: " + address + "\n";
        receiptContent += "Age: " + age + "\n"; // Display age
        receiptContent += "Course: " + course + "\n";
        receiptContent += "Thank you for enrolling!";
        receiptArea.setText(receiptContent);
    }
}
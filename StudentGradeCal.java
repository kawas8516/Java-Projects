import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCal {
    public StudentGradeCal() {
        // Create frame
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        // Create UI elements
        JLabel subject1Label = new JLabel("Subject 1 Score:");
        JTextField subject1Field = new JTextField();
        JLabel subject2Label = new JLabel("Subject 2 Score:");
        JTextField subject2Field = new JTextField();
        JLabel subject3Label = new JLabel("Subject 3 Score:");
        JTextField subject3Field = new JTextField();
        JButton calculateButton = new JButton("Calculate Grade");
        JLabel resultLabel = new JLabel("Grade: ", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(subject1Label);
        frame.add(subject1Field);
        frame.add(subject2Label);
        frame.add(subject2Field);
        frame.add(subject3Label);
        frame.add(subject3Field);
        frame.add(calculateButton);
        frame.add(resultLabel);

        // Add ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double score1 = Double.parseDouble(subject1Field.getText());
                    double score2 = Double.parseDouble(subject2Field.getText());
                    double score3 = Double.parseDouble(subject3Field.getText());
                    double average = (score1 + score2 + score3) / 3;

                    String grade;
                    if (average >= 90) {
                        grade = "A";
                    } else if (average >= 80) {
                        grade = "B";
                    } else if (average >= 70) {
                        grade = "C";
                    } else if (average >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    resultLabel.setText("Grade: " + grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentGradeCal();
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BasicCalculator {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        // Create UI elements
        JLabel number1Label = new JLabel("Number 1:");
        JTextField number1Field = new JTextField();
        JLabel number2Label = new JLabel("Number 2:");
        JTextField number2Field = new JTextField();

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        JLabel resultLabel = new JLabel("Result: ", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(number1Label);
        frame.add(number1Field);
        frame.add(number2Label);
        frame.add(number2Field);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(resultLabel);

        // Add ActionListeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    double result = number1 + number2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    double result = number1 - number2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    double result = number1 * number2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    if (number2 != 0) {
                        double result = number1 / number2;
                        resultLabel.setText("Result: " + result);
                    } else {
                        resultLabel.setText("Cannot divide by zero");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    public TemperatureConverterApp() {
        // Create frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Create UI elements
        JLabel celsiusLabel = new JLabel("Celsius:");
        JTextField celsiusField = new JTextField();
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        JTextField fahrenheitField = new JTextField();

        JButton toFahrenheitButton = new JButton("Convert to Fahrenheit");
        JButton toCelsiusButton = new JButton("Convert to Celsius");

        // Add UI elements to the frame
        frame.add(celsiusLabel);
        frame.add(celsiusField);
        frame.add(fahrenheitLabel);
        frame.add(fahrenheitField);
        frame.add(toFahrenheitButton);
        frame.add(toCelsiusButton);

        // Add ActionListeners to the buttons
        toFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = (celsius * 9/5) + 32;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toCelsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = (fahrenheit - 32) * 5/9;
                    celsiusField.setText(String.format("%.2f", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverterApp::new);
    }
}

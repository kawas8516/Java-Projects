import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterApp {
    private Map<String, Double> exchangeRates;

    public CurrencyConverterApp() {
        // Initialize exchange rates
        exchangeRates = new HashMap<>();
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 82.50);

        // Create frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Create UI elements
        JLabel amountLabel = new JLabel("Amount in USD:");
        JTextField amountField = new JTextField();
        JLabel currencyLabel = new JLabel("Convert to:");
        JComboBox<String> currencyComboBox = new JComboBox<>(new String[]{"EUR", "GBP", "INR"});
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Converted Amount: ", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(currencyLabel);
        frame.add(currencyComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        // Add ActionListener to the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                    double rate = exchangeRates.get(selectedCurrency);
                    double convertedAmount = amount * rate;
                    resultLabel.setText(String.format("Converted Amount: %.2f %s", convertedAmount, selectedCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverterApp::new);
    }
}

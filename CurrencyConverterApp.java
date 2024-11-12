import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONObject;

public class CurrencyConverterApp {
    private static final String API_KEY = System.getenv("CURRENCY_API_KEY"); // Use environment variable for API key
    private static final String API_URL = "https://api.freecurrencyapi.com/v1/latest";

    public CurrencyConverterApp() {
        // Create frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Create UI elements
        JLabel usdLabel = new JLabel("Amount in USD:");
        JTextField usdField = new JTextField();
        JLabel currencyLabel = new JLabel("Convert to:");
        String[] currencies = {"EUR", "GBP", "INR"};
        JComboBox<String> currencyComboBox = new JComboBox<>(currencies);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Converted Amount: ", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(usdLabel);
        frame.add(usdField);
        frame.add(currencyLabel);
        frame.add(currencyComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        // Add ActionListener to the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double usdAmount = Double.parseDouble(usdField.getText());
                    String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                    double exchangeRate = fetchExchangeRate(selectedCurrency);
                    if (exchangeRate != -1) {
                        double convertedAmount = usdAmount * exchangeRate;
                        resultLabel.setText(String.format("Converted Amount: %.2f %s", convertedAmount, selectedCurrency));
                    } else {
                        resultLabel.setText("Error fetching exchange rate");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    private double fetchExchangeRate(String targetCurrency) {
        try {
            String requestUrl = API_URL + "?apikey=" + API_KEY + "&currencies=" + targetCurrency;
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) { // Success
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();

                JSONObject json = new JSONObject(content.toString());
                JSONObject data = json.getJSONObject("data");
                return data.getDouble(targetCurrency);
            } else {
                System.out.println("Error: " + responseCode);
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverterApp::new);
    }
}

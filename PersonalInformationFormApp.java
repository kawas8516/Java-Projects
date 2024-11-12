import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInformationFormApp {
    public PersonalInformationFormApp() {
        // Create frame
        JFrame frame = new JFrame("Personal Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        // Create UI elements
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        JLabel countryLabel = new JLabel("Country:");
        JComboBox<String> countryComboBox = new JComboBox<>(new String[]{"USA", "UK", "India", "Australia", "Canada"});

        JButton submitButton = new JButton("Submit");

        // Add UI elements to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(genderLabel);
        frame.add(genderPanel);
        frame.add(countryLabel);
        frame.add(countryComboBox);
        frame.add(submitButton);

        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String age = ageField.getText().trim();
                String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "");
                String country = (String) countryComboBox.getSelectedItem();

                if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String message = String.format("Name: %s\nAge: %s\nGender: %s\nCountry: %s", name, age, gender, country);
                    JOptionPane.showMessageDialog(frame, message, "Personal Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalInformationFormApp::new);
    }
}

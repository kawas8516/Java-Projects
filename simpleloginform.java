import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpleloginform {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Create UI elements
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(messageLabel);

        // Add ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validate the username and password
                if (username.equals("admin") && password.equals("1234")) {
                    messageLabel.setText("Login successful");
                    messageLabel.setForeground(Color.GREEN);
                } else {
                    messageLabel.setText("Login failed");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}

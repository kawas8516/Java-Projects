import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleStopWatchApp {
    private Timer timer;
    private int elapsedTime;
    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    public SimpleStopWatchApp() {
        // Create frame
        JFrame frame = new JFrame("Simple Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 1));

        // Initialize stopwatch components
        elapsedTime = 0;
        timeLabel = new JLabel("00:00:00:00", JLabel.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        // Add components to frame
        frame.add(timeLabel);
        frame.add(buttonPanel);

        // Timer to update elapsed time
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 10;
                int hours = (elapsedTime / 3600000);
                int minutes = (elapsedTime / 60000) % 60;
                int seconds = (elapsedTime / 1000) % 60;
                int centiseconds = (elapsedTime / 10) % 100;
                timeLabel.setText(String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, centiseconds));
            }
        });

        // Add ActionListeners to buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                elapsedTime = 0;
                timeLabel.setText("00:00:00:00");
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleStopWatchApp::new);
    }
}

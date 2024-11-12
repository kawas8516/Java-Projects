import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotingPollApp {
    private int javaVotes = 0;
    private int pythonVotes = 0;
    private int cppVotes = 0;
    private boolean hasVoted = false;

    public VotingPollApp() {
        // Create frame
        JFrame frame = new JFrame("Voting Poll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1));

        // Create UI elements
        JLabel questionLabel = new JLabel("What is your favorite programming language?", JLabel.CENTER);
        JRadioButton javaButton = new JRadioButton("Java");
        JRadioButton pythonButton = new JRadioButton("Python");
        JRadioButton cppButton = new JRadioButton("C++");
        ButtonGroup languageGroup = new ButtonGroup();
        languageGroup.add(javaButton);
        languageGroup.add(pythonButton);
        languageGroup.add(cppButton);

        JButton voteButton = new JButton("Submit Vote");
        JLabel javaVotesLabel = new JLabel("Java Votes: 0", JLabel.CENTER);
        JLabel pythonVotesLabel = new JLabel("Python Votes: 0", JLabel.CENTER);
        JLabel cppVotesLabel = new JLabel("C++ Votes: 0", JLabel.CENTER);

        // Add UI elements to the frame
        frame.add(questionLabel);
        frame.add(javaButton);
        frame.add(pythonButton);
        frame.add(cppButton);
        frame.add(voteButton);
        frame.add(javaVotesLabel);
        frame.add(pythonVotesLabel);
        frame.add(cppVotesLabel);

        // Add ActionListener to the vote button
        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasVoted) {
                    JOptionPane.showMessageDialog(frame, "You have already voted.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (javaButton.isSelected()) {
                    javaVotes++;
                    javaVotesLabel.setText("Java Votes: " + javaVotes);
                } else if (pythonButton.isSelected()) {
                    pythonVotes++;
                    pythonVotesLabel.setText("Python Votes: " + pythonVotes);
                } else if (cppButton.isSelected()) {
                    cppVotes++;
                    cppVotesLabel.setText("C++ Votes: " + cppVotes);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a language to vote.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                hasVoted = true;
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VotingPollApp::new);
    }
}

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;

public class ColorPickerApp {
    private JPanel colorDisplayPanel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    public ColorPickerApp() {
        // Create frame
        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create UI elements
        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setBackground(new Color(0, 0, 0));
        colorDisplayPanel.setPreferredSize(new Dimension(400, 150));

        redSlider = new JSlider(0, 255, 0);
        greenSlider = new JSlider(0, 255, 0);
        blueSlider = new JSlider(0, 255, 0);

        redSlider.setMajorTickSpacing(50);
        redSlider.setPaintTicks(true);
        greenSlider.setMajorTickSpacing(50);
        greenSlider.setPaintTicks(true);
        blueSlider.setMajorTickSpacing(50);
        blueSlider.setPaintTicks(true);

        JPanel slidersPanel = new JPanel();
        slidersPanel.setLayout(new GridLayout(3, 1));
        slidersPanel.add(createLabeledSlider("Red: ", redSlider));
        slidersPanel.add(createLabeledSlider("Green: ", greenSlider));
        slidersPanel.add(createLabeledSlider("Blue: ", blueSlider));

        // Add ChangeListeners to sliders
        ChangeListener colorChangeListener = e -> {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            colorDisplayPanel.setBackground(new Color(red, green, blue));
        };

        redSlider.addChangeListener(colorChangeListener);
        greenSlider.addChangeListener(colorChangeListener);
        blueSlider.addChangeListener(colorChangeListener);

        // Add components to frame
        frame.add(colorDisplayPanel, BorderLayout.NORTH);
        frame.add(slidersPanel, BorderLayout.CENTER);

        // Set frame visibility
        frame.setVisible(true);
    }

    private JPanel createLabeledSlider(String label, JSlider slider) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel sliderLabel = new JLabel(label);
        panel.add(sliderLabel, BorderLayout.WEST);
        panel.add(slider, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorPickerApp::new);
    }
}

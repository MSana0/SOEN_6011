package ca.concordia.gamma;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GammaCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    public static final String VERSION = "1.0.0";

    public GammaCalculatorGUI() {
        setTitle("Gamma Function Calculator v" + VERSION);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLayout(new FlowLayout());

        add(new JLabel("Enter value for x:"));
        inputField = new JTextField(10);
        add(inputField);

        inputField.addActionListener(e -> calculateGamma());

        JButton calcButton = new JButton("Calculate Gamma(x)");
        add(calcButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        // Add KeyListener for Esc key
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();

        inputField.getAccessibleContext().setAccessibleName("Input value for x");
        inputField.getAccessibleContext().setAccessibleDescription("Enter a real number for x");
        calcButton.getAccessibleContext().setAccessibleName("Calculate Gamma Button");
        calcButton.getAccessibleContext().setAccessibleDescription("Calculates the Gamma function for the entered value");
    }

    private void calculateGamma() {
        try {
            double x = Double.parseDouble(inputField.getText());
            double result = GammaFunction.gamma(x);
            if (Double.isNaN(result)) {
                resultLabel.setText("Result: Gamma is not defined for this input.");
            } else {
                resultLabel.setText(String.format("Result: Gamma(%.2f) = %.6f", x, result));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid input. Please enter a real number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GammaCalculatorGUI().setVisible(true));
    }
}
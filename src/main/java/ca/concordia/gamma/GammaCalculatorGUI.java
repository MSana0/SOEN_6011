package ca.concordia.gamma;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GammaCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    /**
     *  Version: 1.0.0
     */

    public GammaCalculatorGUI() {
        setTitle("Gamma Function Calculator");
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

        calcButton.addActionListener(e -> calculateGamma());
    }

    private void calculateGamma() {
        try {
            double x = Double.parseDouble(inputField.getText());
            if (x <= 0 && GammaFunction.floor(x) == x) {
                resultLabel.setText("Result: Gamma undefined for non-positive integers.");
            } else {
                double result = GammaFunction.gamma(x);
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
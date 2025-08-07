import java.awt.*;
import javax.swing.*;

public class GammaCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

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
            if (x <= 0 && MyMath.floor(x) == x) {
                resultLabel.setText("Result: Gamma undefined for non-positive integers.");
            } else {
                double result = GammaFunc.gamma(x);
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
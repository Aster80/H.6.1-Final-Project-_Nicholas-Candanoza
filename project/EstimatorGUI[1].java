import javax.swing.*;
import java.awt.*;

public class EstimatorGUI extends JFrame {

    private JTextField lengthField, widthField, depthField, fenceLengthField;
    private JTextArea outputArea;

    public EstimatorGUI() {
        setTitle("Concrete Pad & Fence Estimator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7,2));

        add(new JLabel("Concrete Length (ft):"));
        lengthField = new JTextField();
        add(lengthField);

        add(new JLabel("Concrete Width (ft):"));
        widthField = new JTextField();
        add(widthField);

        add(new JLabel("Concrete Depth (ft):"));
        depthField = new JTextField();
        add(depthField);

        add(new JLabel("Fence Length (ft):"));
        fenceLengthField = new JTextField();
        add(fenceLengthField);

        JButton calcButton = new JButton("Calculate");
        add(calcButton);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea));

        calcButton.addActionListener(e -> calculate());

        setVisible(true);
    }

    private void calculate() {
        try {
            double l = Double.parseDouble(lengthField.getText());
            double w = Double.parseDouble(widthField.getText());
            double d = Double.parseDouble(depthField.getText());
            double f = Double.parseDouble(fenceLengthField.getText());

            double concrete = ConcreteEstimator.calculateConcrete(l, w, d);
            double fence = FenceEstimator.calculateFencePanels(f);

            outputArea.setText(
                "Concrete Needed (cubic yards): " + concrete + "\n" +
                "Fence Panels Needed: " + fence
            );

        } catch (Exception ex) {
            outputArea.setText("Please enter valid numbers.");
        }
    }
}
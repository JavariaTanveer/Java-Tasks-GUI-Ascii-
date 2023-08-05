import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task6 extends JFrame {
    private JTextField inputField;
    private JButton generateButton;
    private JTextArea resultTextArea;

    public task6() {
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        generateButton = new JButton("Generate Series");
        generateButton.setForeground(Color.WHITE);
        generateButton.setBackground(Color.BLUE);
        resultTextArea = new JTextArea(10, 20);
        resultTextArea.setEditable(false);
    }

    private void setupLayout() {
        getContentPane().setLayout(null);

        JLabel inputLabel = new JLabel("Enter a number: ");
        inputLabel.setBounds(10, 10, 100, 25);
        getContentPane().add(inputLabel);

        inputField.setBounds(120, 10, 100, 25);
        getContentPane().add(inputField);

        generateButton.setBounds(10, 40, 210, 30);
        getContentPane().add(generateButton);

        resultTextArea.setBounds(10, 80, 230, 74);
        getContentPane().add(resultTextArea);

        setSize(260, 196);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupListeners() {
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);
                        String series = generateFibonacciSeries(number);
                        resultTextArea.setText(series);
                    } catch (NumberFormatException ex) {
                        resultTextArea.setText("Invalid input");
                    }
                }
            }
        });
    }

    private String generateFibonacciSeries(int number) {
        StringBuilder seriesBuilder = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            seriesBuilder.append(fibonacci(i));
            if (i < number) {
                seriesBuilder.append(", ");
            }
        }
        return seriesBuilder.toString();
    }

    private int fibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task6().setVisible(true);
            }
        });
    }
}

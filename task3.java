import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task3 extends JFrame {
    private JTextField inputField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public task3() {
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        calculateButton = new JButton("Calculate Factorial");
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(Color.BLUE);
        resultLabel = new JLabel("Factorial Result: ");
    }

    private void setupLayout() {
        getContentPane().setLayout(null);

        JLabel inputTextLabel = new JLabel("Enter a number: ");
        inputTextLabel.setBounds(10, 10, 112, 25);
        getContentPane().add(inputTextLabel);

        inputField.setBounds(132, 10, 161, 24);
        getContentPane().add(inputField);

        calculateButton.setBounds(120, 46, 173, 25);
        getContentPane().add(calculateButton);

        resultLabel.setBounds(30, 82, 210, 25);
        getContentPane().add(resultLabel);

        setSize(430, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupListeners() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);
                        long factorial = calculateFactorial(number);
                        resultLabel.setText("Factorial Result: " + factorial);
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input");
                    }
                }
            }
        });
    }

    private long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task3().setVisible(true);
            }
        });
    }
}

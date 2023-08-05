import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task5 extends JFrame {
    private JTextField inputField;
    private JButton displayButton;
    private JTextArea resultTextArea;

    public task5() {
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        displayButton = new JButton("Display Numbers");
        displayButton.setBackground(Color.BLUE);
        displayButton.setForeground(Color.WHITE);
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

        displayButton.setBounds(10, 40, 210, 30);
        getContentPane().add(displayButton);

        resultTextArea.setBounds(10, 80, 230, 106);
        getContentPane().add(resultTextArea);

        setSize(260, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupListeners() {
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);
                        String numbers = generateEvenOddNumbers(number);
                        resultTextArea.setText(numbers);
                    } catch (NumberFormatException ex) {
                        resultTextArea.setText("Invalid input");
                    }
                }
            }
        });
    }

    private String generateEvenOddNumbers(int number) {
        StringBuilder numbersBuilder = new StringBuilder();
        generateEvenOddNumbersHelper(0, number, numbersBuilder);
        return numbersBuilder.toString();
    }

    private void generateEvenOddNumbersHelper(int start, int end, StringBuilder numbersBuilder) {
        if (start > end) {
            return;
        }

        if (start % 2 == 0) {
            numbersBuilder.append(start).append(" (Even)").append("\n");
        } else {
            numbersBuilder.append(start).append(" (Odd)").append("\n");
        }

        generateEvenOddNumbersHelper(start + 1, end, numbersBuilder);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task5().setVisible(true);
            }
        });
    }
}

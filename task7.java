import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task7 extends JFrame {
    private JTextField startField;
    private JTextField endField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public task7() {
        setTitle("Number Sum");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startField = new JTextField();
        startField.setBounds(135, 5, 52, 20);
        endField = new JTextField();
        endField.setBounds(135, 42, 52, 20);
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(197, 41, 77, 23);
        resultArea = new JTextArea();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startInput = startField.getText();
                int start = Integer.parseInt(startInput);

                String endInput = endField.getText();
                int end = Integer.parseInt(endInput);

                int sum = calculateNumberSum(start, end);
                resultArea.setText("Sum of numbers between " + start + " and " + end + ": " + sum);
            }
        });
        getContentPane().setLayout(null);
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 0, 284, 75);
        inputPanel.setLayout(null);
        JLabel lblEnterStartingNo = new JLabel("Enter starting no :");
        lblEnterStartingNo.setBounds(21, 8, 109, 14);
        inputPanel.add(lblEnterStartingNo);
        inputPanel.add(startField);
        JLabel lblEnterEndingNo = new JLabel("Enter ending no :");
        lblEnterEndingNo.setBounds(21, 45, 104, 14);
        inputPanel.add(lblEnterEndingNo);
        inputPanel.add(endField);
        inputPanel.add(calculateButton);

        getContentPane().add(inputPanel);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(0, 73, 284, 88);
        getContentPane().add(scrollPane);
    }

    private int calculateNumberSum(int start, int end) {
        if (start > end) {
            return 0;
        } else {
            return start + calculateNumberSum(start + 1, end);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task7().setVisible(true);
            }
        });
    }
}
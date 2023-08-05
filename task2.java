import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task2 extends JFrame {
    private JTextField inputField;
    private JButton convertButton;
    private JTextArea resultArea;

    public task2() {
        setTitle("ASCII Code Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputField = new JTextField();
        inputField.setBounds(76, 12, 97, 20);
        convertButton = new JButton("Convert");
        convertButton.setBounds(183, 11, 91, 23);
        resultArea = new JTextArea();
        resultArea.setBackground(Color.LIGHT_GRAY);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String asciiResult = convertToASCII(input);
                resultArea.setText(asciiResult);
            }
        });
        getContentPane().setLayout(null);
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 0, 284, 59);
        inputPanel.setLayout(null);
        JLabel label = new JLabel("Input:");
        label.setBounds(22, 15, 81, 14);
        inputPanel.add(label);
        inputPanel.add(inputField);
        inputPanel.add(convertButton);

        getContentPane().add(inputPanel);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(0, 56, 284, 105);
        getContentPane().add(scrollPane);
    }

    private String convertToASCII(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int asciiCode = (int) c;
            sb.append(c).append(": ").append(asciiCode).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task2().setVisible(true);
            }
        });
    }
}
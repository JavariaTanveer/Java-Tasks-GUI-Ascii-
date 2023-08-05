import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task4 extends JFrame {
    private JTextField inputField;
    private JButton generateButton;
    private JTextArea resultTextArea;

    public task4() {
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        generateButton = new JButton("Generate Series");
        generateButton.setBackground(Color.BLUE);
        generateButton.setForeground(Color.WHITE);
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

        generateButton.setBounds(45, 39, 175, 30);
        getContentPane().add(generateButton);

        resultTextArea.setBounds(10, 80, 256, 18);
        getContentPane().add(resultTextArea);

        setSize(292, 148);
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
                        String series = generateNumberSeries(number);
                        resultTextArea.setText(series);
                    } catch (NumberFormatException ex) {
                        resultTextArea.setText("Invalid input");
                    }
                }
            }
        });
    }

    private String generateNumberSeries(int number) {
        StringBuilder seriesBuilder = new StringBuilder();
        generateSeriesHelper(number, seriesBuilder);
        generateSeriesHelper(1, seriesBuilder);
        generateSeriesHelper(2, number, seriesBuilder);
        return seriesBuilder.toString();
    }

    private void generateSeriesHelper(int start, StringBuilder seriesBuilder) {
        for (int i = start; i >= 1; i--) {
            seriesBuilder.append(i).append(" ");
        }
    }

    private void generateSeriesHelper(int start, int end, StringBuilder seriesBuilder) {
        for (int i = start; i <= end; i++) {
            seriesBuilder.append(i).append(" ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task4().setVisible(true);
            }
        });
    }
}

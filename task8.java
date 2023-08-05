import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task8 extends JFrame {
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> productComboBox;
    private JTextField brandTextField;
    private JButton enterButton;
    private JLabel outputLabel;

    public task8() {
        setTitle("Clothing Category");
        setSize(413, 267);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        categoryComboBox = new JComboBox<>();
        categoryComboBox.setBounds(152, 50, 101, 20);
        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Men", "Kids", "Women"}));

        productComboBox = new JComboBox<>();
        productComboBox.setBounds(152, 81, 81, 20);
        productComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Shoes", "Dress", "Bags"}));

        brandTextField = new JTextField(15);
        brandTextField.setBounds(152, 8, 126, 20);
        outputLabel = new JLabel();
        outputLabel.setBounds(0, 116, 397, 67);
        getContentPane().setLayout(null);
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 0, 397, 116);
        inputPanel.setLayout(null);
        JLabel label = new JLabel("Select Category:");
        label.setBounds(25, 53, 117, 14);
        inputPanel.add(label);
        inputPanel.add(categoryComboBox);
        JLabel label_1 = new JLabel("Select Product:");
        label_1.setBounds(25, 81, 117, 14);
        inputPanel.add(label_1);
        inputPanel.add(productComboBox);
        JLabel lblEnterBrandName = new JLabel("Enter Brand Name :");
        lblEnterBrandName.setBounds(25, 11, 117, 14);
        inputPanel.add(lblEnterBrandName);
        inputPanel.add(brandTextField);

        getContentPane().add(inputPanel);
        getContentPane().add(outputLabel);
        
                enterButton = new JButton("Enter");
                enterButton.setBounds(278, 194, 95, 23);
                getContentPane().add(enterButton);
                
                        enterButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String category = (String) categoryComboBox.getSelectedItem();
                                String product = (String) productComboBox.getSelectedItem();
                                String brand = brandTextField.getText();
                                outputLabel.setText( category +" " + product + "'s from brand " + brand);
                            }
                        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task8().setVisible(true);
            }
        });
    }
}
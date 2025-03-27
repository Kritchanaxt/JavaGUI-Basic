import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField Example");
        JTextField textField = new JTextField();
        JButton button = new JButton("Submit");

        textField.setBounds(50, 50, 200, 30);
        button.setBounds(100, 100, 100, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                JOptionPane.showMessageDialog(frame, "You entered: " + text);
            }
        });

        frame.add(textField);
        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
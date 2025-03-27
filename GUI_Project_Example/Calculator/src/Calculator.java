import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        textField = new JTextField();
        textField.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/", "4", "5", "6", "*",
                "1", "2", "3", "-", "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this::buttonPressed);
            panel.add(button);
        }

        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buttonPressed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        if (command.matches("[0-9]")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }
}

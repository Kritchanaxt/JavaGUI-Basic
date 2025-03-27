import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        userLabel.setBounds(50, 30, 100, 30);
        passLabel.setBounds(50, 70, 100, 30);
        userField.setBounds(150, 30, 150, 30);
        passField.setBounds(150, 70, 150, 30);
        loginButton.setBounds(120, 120, 100, 30);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            JOptionPane.showMessageDialog(frame, "Welcome, " + username);
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe {
    private JFrame frame;
    private JButton[][] buttons = new JButton[3][3];
    private boolean playerX = true;

    public TicTacToe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(this::buttonPressed);
                frame.add(buttons[i][j]);
            }
        }

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buttonPressed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (!button.getText().equals("")) return;

        button.setText(playerX ? "X" : "O");
        playerX = !playerX;

        if (checkWinner()) {
            JOptionPane.showMessageDialog(frame, "We have a winner!");
            resetBoard();
        }
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().equals("") &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()))
                return true;
        }
        return false;
    }

    private void resetBoard() {
        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                btn.setText("");
            }
        }
    }
}
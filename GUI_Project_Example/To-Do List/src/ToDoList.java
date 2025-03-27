import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList {
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField inputField;

    public ToDoList() {
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        inputField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        addButton.addActionListener(e -> {
            if (!inputField.getText().isEmpty()) {
                listModel.addElement(inputField.getText());
                inputField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(addButton);
        panel.add(removeButton);

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Table Example");

        String[][] data = {
                {"1", "Alice", "A"},
                {"2", "Bob", "B"},
                {"3", "Charlie", "C"}
        };
        String[] columns = {"ID", "Name", "Grade"};

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
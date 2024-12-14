package copypasta;
import javax.swing.*;
import java.awt.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create a JComboBox with some items
        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JComboBox<String> comboBox = new JComboBox<>(items);

        // Set Google Sans font and padding for each item
        comboBox.setFont(new Font("Google Sans", Font.PLAIN, 14)); // Google Sans font
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            public void configureArrowButton() {
                super.configureArrowButton();
                // Set padding for the combo box
                comboBox.setRenderer(new javax.swing.DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        c.setFont(new Font("Google Sans", Font.PLAIN, 12)); // Set font
                        c.setPreferredSize(new Dimension(c.getPreferredSize().width + 20, 30)); // Padding of 10
                        return c;
                    }
                });
            }
        });

        // Add the combo box to the frame
        frame.add(comboBox);

        // Set the frame visibility
        frame.setVisible(true);
    }
}

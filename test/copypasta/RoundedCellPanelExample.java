package copypasta;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RoundedCellPanelExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the JFrame
            JFrame frame = new JFrame("Rounded Cells Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 200);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center the content with space

            // Create a panel to hold the "cells"
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Align cells horizontally

            // Add cells (JLabels) to the panel
            panel.add(createRoundedCell("1"));
            panel.add(createRoundedCell("Alice"));
            panel.add(createRoundedCell("A"));

            // Add the panel to the frame
            frame.add(panel);

            frame.setVisible(true);
        });
    }

    // Create a rounded cell (JLabel in this case)
    private static JPanel createRoundedCell(String text) {
        JPanel cell = new JPanel();
        cell.setBackground(new Color(174, 226, 200)); // Light background color
        cell.setPreferredSize(new Dimension(100, 40)); // Set size for each "cell"
        cell.setLayout(new BorderLayout());
        cell.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add a border

        JLabel label = new JLabel(text);
        label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        label.setHorizontalAlignment(JLabel.CENTER); // Center the text in the cell

        // Round the corners by overriding the panel's paintComponent
        cell.add(label, BorderLayout.CENTER);

        return cell;
    }
}

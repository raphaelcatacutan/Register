package copypasta;
import javax.swing.*;
import java.awt.*;

public class ScrollablePanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollable JPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 750);

        // Create a panel to act as the table
        JPanel table = new JPanel();
        table.setLayout(new FlowLayout(FlowLayout.LEFT));
        table.setOpaque(false);
        table.setPreferredSize(new Dimension(800, 1000)); // Larger height for scrollability

        // Add some sample components to the table
        for (int i = 0; i < 50; i++) {
            JLabel label = new JLabel("Item " + (i + 1));
            label.setPreferredSize(new Dimension(100, 30));
            label.setOpaque(true);
            label.setBackground(Color.LIGHT_GRAY);
            table.add(label);
        }

        // Wrap the panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        // Hide scrollbars
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        // Add the scrollable panel to the frame
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}

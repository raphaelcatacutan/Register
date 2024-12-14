package copypasta;
import javax.swing.*;
import java.awt.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the CardLayout panel
        JPanel viewsPanel = new JPanel(new CardLayout());

        // Create the different views
        JPanel viewStudents = new JPanel();
        viewStudents.setBackground(Color.BLUE);

        JPanel viewDashboard = new JPanel();
        viewDashboard.setBackground(Color.GREEN);

        // Add views to the panel
        viewsPanel.add(viewStudents, "viewStudents");
        viewsPanel.add(viewDashboard, "viewDashboard");

        // Create a button to switch views
        JButton switchButton = new JButton("Switch Views");
        switchButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) viewsPanel.getLayout();
            cl.show(viewsPanel, "viewDashboard"); // Switch to the next card
        });

        // Add everything to the frame
        frame.setLayout(new BorderLayout());
        frame.add(viewsPanel, BorderLayout.CENTER);
        frame.add(switchButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

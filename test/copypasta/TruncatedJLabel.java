
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TruncatedJLabel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the JFrame
            JFrame frame = new JFrame("Truncated Text in JLabel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            // Create a JLabel with long text
            String longText = "This is a very long piece of text that won't fit in the label.";
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(150, 30));
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setOpaque(true);
            label.setBackground(new Color(220, 220, 220));
            label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            label.setText(longText);

            // Add the label to the frame
            frame.add(label);

            // Display the frame
            frame.setVisible(true);
        });
    }
}
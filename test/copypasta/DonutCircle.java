import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DonutCircle {

    // Method that creates and returns a JPanel with the donut circle
    public static JPanel createDonutCircle(int outerRadius, int innerRadius, int x, int y, int[] values, String text, 
                                            List<String> flowTextLabels, List<Color> flowTextColors) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Cast to Graphics2D for better control
                Graphics2D g2d = (Graphics2D) g;

                // Set anti-aliasing for smoother edges
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Calculate the total sum of the values
                int total = 0;
                for (int value : values) {
                    total += value;
                }

                // Define the start angle
                int startAngle = 0;

                // Set the colors (using a simple color scheme)
                Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA};

                // Draw each section based on the values
                for (int i = 0; i < values.length; i++) {
                    // Calculate the sweep angle for this section
                    int sweepAngle = (int) (360.0 * values[i] / total);

                    // Set the color for the current section
                    g2d.setColor(colors[i % colors.length]); // Cycle through colors if there are more than 6 segments

                    // Draw the section (arc)
                    g2d.fillArc(x - outerRadius, y - outerRadius, outerRadius * 2, outerRadius * 2, startAngle, sweepAngle);

                    // Update the starting angle for the next section
                    startAngle += sweepAngle;
                }

                // Draw the inner circle (cut out the hole of the donut)
                g2d.setColor(Color.WHITE); // Inner circle color (background color)
                g2d.fillOval(x - innerRadius, y - innerRadius, innerRadius * 2, innerRadius * 2);

                // Set the text properties for the center text
                g2d.setColor(Color.BLACK); // Text color
                g2d.setFont(new Font("Arial", Font.BOLD, 20)); // Font and size

                // Get the text to display
                FontMetrics metrics = g2d.getFontMetrics();
                int textWidth = metrics.stringWidth(text);
                int textHeight = metrics.getHeight();

                // Draw the text in the center of the donut
                g2d.drawString(text, x - textWidth / 2, y + textHeight / 4);

                // Draw the flow text with dots below the donut
                int startX = 10; // X position for the first label and dot
                int startY = y + outerRadius + 40; // Y position for the flow text labels (below the donut)

                // Calculate the vertical offset for the dots to be vertically centered with the text height
                int dotRadius = 10; // Radius of the colored dots
                FontMetrics labelMetrics = g2d.getFontMetrics();  // Get font metrics for the flow text labels
                int labelHeight = labelMetrics.getHeight(); // Height of the flow text labels
                int dotCenterY = startY + (labelHeight - dotRadius) / 2; // Vertically center the dot

                for (int i = 0; i < flowTextLabels.size(); i++) {
                    // Draw the dot
                    g2d.setColor(flowTextColors.get(i));
                    g2d.fillOval(startX, dotCenterY - 30, dotRadius, dotRadius);

                    // Move the X position to the right for the label
                    startX += dotRadius + 10;

                    // Draw the label next to the dot
                    g2d.setColor(Color.BLACK); // Label color
                    g2d.drawString(flowTextLabels.get(i), startX, startY + labelHeight / 2 - 25);

                    // Move the X position to the right after the label
                    startX += labelMetrics.stringWidth(flowTextLabels.get(i)) + 20;
                }
            }
        };

        // Return the created JPanel
        return panel;
    }

    public static void main(String[] args) {
        // Set up the JFrame
        JFrame frame = new JFrame("Donut Circle");

        // Example with an array of values representing the sections
        int[] values = {1, 2, 3};  // Example values (1/6, 2/6, and 3/6 of the donut)

        // Example text for the center
        String text = "Total: 6";

        // Example flow text labels and colors for the dots
        List<String> flowTextLabels = new ArrayList<>();
        flowTextLabels.add("Male");
        flowTextLabels.add("Female");
        flowTextLabels.add("Other");

        List<Color> flowTextColors = new ArrayList<>();
        flowTextColors.add(Color.BLUE);  // Male
        flowTextColors.add(Color.PINK);  // Female
        flowTextColors.add(Color.GRAY);  // Other

        // Create the donut with the flow text
        JPanel donutPanel = createDonutCircle(100, 50, 150, 150, values, text, flowTextLabels, flowTextColors);
        donutPanel.setBackground(Color.ORANGE);
        donutPanel.setOpaque(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(donutPanel);
        frame.setVisible(true);
    }
}

package copypasta;

import javax.swing.*;
import java.awt.*;

public class PanelWithBackgroundImage {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Panel with Background Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);  // Frame size

        // Get the panel with layered pane
        JPanel layeredPanel = createLayeredPanel();

        // Add the layered panel to the frame
        frame.add(layeredPanel);
        frame.setVisible(true);
    }

    // Method to create the panel containing the layered pane
    public static JPanel createLayeredPanel() {
        // Create the background panel (fixed size to give the illusion of overflowing image)
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Raphael\\Downloads\\9sj2rrsv.png");  // Replace with your image path

                // Get Graphics2D object from the Graphics object
                Graphics2D g2d = (Graphics2D) g;

                // Set rendering hints for better image scaling quality
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  // Smooth scaling
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Smooth edges

                // Draw the image scaled to the panel size without pixelation
                g2d.drawImage(backgroundImage.getImage(), 0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), this);
            }
        };

        // Set the background panel layout, no need to set preferred size as we want to prevent resizing
        backgroundPanel.setLayout(null);
        backgroundPanel.setOpaque(false);  // Ensure the panel itself is transparent, only the image is visible

        // Create the foreground panel (content area)
        JPanel foregroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Fill the panel background with green color
                g.setColor(new Color(250, 247, 227));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Set the layout for the foreground panel and size
        foregroundPanel.setLayout(null);
        foregroundPanel.setPreferredSize(new Dimension(300, 300));  // Content panel size
        
        // Add components to the foreground panel (optional)
        JLabel label = new JLabel("This is a panel with a background image");
        label.setBounds(50, 100, 300, 50);
        foregroundPanel.add(label);

        // Use a JLayeredPane for proper layering of components
        JLayeredPane layeredPane = new JLayeredPane();
        
        // Set the background panel to a lower layer (layer 0)
        backgroundPanel.setBounds(100, 100, 600, 600);  // Keep fixed size for image panel
        layeredPane.add(backgroundPanel, JLayeredPane.PALETTE_LAYER);  // Lower layer
        
        // Set the foreground panel to a higher layer (layer 1)
        foregroundPanel.setBounds(150, 150, 300, 300);  // Foreground panel size
        layeredPane.add(foregroundPanel, JLayeredPane.DEFAULT_LAYER);  // Higher layer

        // Create the outer panel that contains the layered pane
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(layeredPane, BorderLayout.CENTER);

        return outerPanel;
    }
}

package copypasta;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.border.DropShadowBorder;

public class Canvas extends JXPanel {

    public Canvas() {
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
        this.setBorder(shadow);
        
        // Set a smaller size for the panel
        this.setPreferredSize(new Dimension(150, 150)); // Smaller size to view the border
        this.setBackground(Color.WHITE);  // Set a background color to distinguish the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Create a round shape (circle)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set the clipping area to be circular
        g2d.setClip(0, 0, getWidth(), getHeight());
        
        // Draw the round shape with shadow
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        // Create a frame to hold the Canvas panel
        JFrame frame = new JFrame("Canvas with Drop Shadow Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);  // Frame size (larger than the panel to center it)
        frame.setLayout(null);  // Disable layout manager for manual centering

        // Create an instance of the Canvas panel
        Canvas canvas = new Canvas();

        // Manually center the canvas in the frame
        int x = (frame.getWidth() - canvas.getPreferredSize().width) / 2;
        int y = (frame.getHeight() - canvas.getPreferredSize().height) / 2;
        canvas.setBounds(x, y, canvas.getPreferredSize().width, canvas.getPreferredSize().height);

        // Add the Canvas panel to the frame
        frame.add(canvas);

        // Display the frame
        frame.setVisible(true);
    }
}

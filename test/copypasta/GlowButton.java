package copypasta;


import com.jhlabs.image.GaussianFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GlowButton extends JButton {
    private final int width;
    private final int height;
    private final Color buttonColor;
    private final Color glowColor = Color.BLACK;
    private final float glowAlpha = 1.0f;
    private final int glowSize = 16;
    private final int cornerRadius;
    private final Color hoverColor;
    private boolean isHovered = false;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("Glow Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(600, 700));

        // Example 1: GlowButton with hover effect
        GlowButton button1 = new GlowButton(100, 40, Color.GREEN, 13, Color.CYAN);
        button1.setBounds(50, 50, 260, 160); // Adjust position and size for the button
        button1.setLayout(null);
        button1.setText("Hover Me!");
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GlowButton(int width, int height, Color background, int cornerRadius, Color hoverColor) {
        this.width = width;
        this.height = height;
        this.buttonColor = background;
        this.cornerRadius = cornerRadius;
        this.hoverColor = hoverColor;
        
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setContentAreaFilled(false); // To avoid default button rendering
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        BufferedImage glowImage = generateGlow(width, height, glowSize, glowColor, glowAlpha);
        int x = (getWidth() - glowImage.getWidth()) / 2;
        int y = (getHeight() - glowImage.getHeight()) / 2;
        g2d.drawImage(glowImage, x, y, this);

        // Draw the button with hover effect color
        g2d.setColor(isHovered ? hoverColor : buttonColor);
        g2d.fillRoundRect((getWidth() - width) / 2, (getHeight() - height) / 2, width + 3, height + 3, cornerRadius, cornerRadius);
        g2d.dispose();
        this.repaint();
    }

    public BufferedImage generateGlow(int width, int height, int size, Color glow, float alpha) {
        BufferedImage source = createCompatibleImage(width, height);
        Graphics2D g2d = source.createGraphics();
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
        return generateGlow(source, size, glow, alpha);
    }

    public BufferedImage generateGlow(BufferedImage imgSource, int size, Color color, float alpha) {
        int imgWidth = (int) Math.round(imgSource.getWidth() + (size * 2.5));
        int imgHeight = (int) Math.round(imgSource.getHeight() + (size * 2.5));
        BufferedImage imgMask = createCompatibleImage(imgWidth, imgHeight);
        Graphics2D g2 = imgMask.createGraphics();
        int x = Math.round((imgWidth - imgSource.getWidth()) / 2f);
        int y = Math.round((imgHeight - imgSource.getHeight()) / 2f);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillRoundRect(x, y, imgSource.getWidth() - 3, imgSource.getHeight() - 3, cornerRadius, cornerRadius);
        g2.dispose();
        BufferedImage imgGlow = generateBlur(imgMask, size, color, alpha);
        return applyMask(imgGlow, imgMask, AlphaComposite.DST_OUT);
    }

    public BufferedImage generateBlur(BufferedImage imgSource, int size, Color color, float alpha) {
        GaussianFilter filter = new GaussianFilter(size);
        BufferedImage imgBlur = createCompatibleImage(imgSource.getWidth(), imgSource.getHeight());
        Graphics2D g2 = imgBlur.createGraphics();
        g2.drawImage(imgSource, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, alpha));
        g2.setColor(color);
        g2.fillRect(0, 0, imgSource.getWidth(), imgSource.getHeight());
        g2.dispose();
        return filter.filter(imgBlur, null);
    }

    public BufferedImage createCompatibleImage(int width, int height) {
        return createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }

    public BufferedImage createCompatibleImage(int width, int height, int transparency) {
        BufferedImage image = getGraphicsConfiguration().createCompatibleImage(width, height, transparency);
        image.coerceData(true);
        return image;
    }

    public GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public BufferedImage applyMask(BufferedImage sourceImage, BufferedImage maskImage, int method) {
        BufferedImage maskedImage = new BufferedImage(maskImage.getWidth(), maskImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D mg = maskedImage.createGraphics();
        int x = (maskImage.getWidth() - sourceImage.getWidth()) / 2;
        int y = (maskImage.getHeight() - sourceImage.getHeight()) / 2;
        mg.drawImage(sourceImage, x, y, null);
        mg.setComposite(AlphaComposite.getInstance(method));
        mg.drawImage(maskImage, 0, 0, null);
        mg.dispose();
        return maskedImage;
    }
}

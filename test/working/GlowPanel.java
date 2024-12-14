package working;

import com.jhlabs.image.GaussianFilter;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GlowPanel extends JPanel {
    private final int width;
    private final int height;
    private final Color panelColor;
    private final Color glowColor = Color.BLACK;
    private final float glowAlpha = 1.0f;
    private final int glowSize = 16;
    private final int cornerRadius;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("Glow Panel Examples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(600, 700));

        // Example 1: GlowPanel with a JLabel
        GlowPanel panel1 = new GlowPanel(200, 100, Color.BLUE, 13);
        panel1.setBounds(50, 50, 260, 160); // Adjust position and size for the panel
        panel1.setLayout(null);
        JLabel label1 = new JLabel("Example 1");
        label1.setBounds(50, 30, 100, 30);
        panel1.add(label1);
        frame.add(panel1);

        // Example 2: GlowPanel with a JButton
        GlowPanel panel2 = new GlowPanel(150, 150, Color.GREEN, 2);
        panel2.setBounds(350, 50, 230, 230); // Adjust position and size for the panel
        panel2.setLayout(null);
        JButton button2 = new JButton("Click Me!");
        button2.setBounds(40, 60, 80, 30);
        panel2.add(button2);
        frame.add(panel2);

        // Example 3: GlowPanel with multiple components
        GlowPanel panel3 = new GlowPanel(300, 200, Color.ORANGE, 50);
        panel3.setBounds(100, 350, 350, 250); // Adjust position and size for the panel
        panel3.setLayout(null);
        JLabel label3 = new JLabel("Enter your name:");
        label3.setBounds(30, 30, 120, 30);
        JTextField textField3 = new JTextField();
        textField3.setBounds(160, 30, 150, 30);
        JButton button3 = new JButton("Submit");
        button3.setBounds(120, 100, 100, 30);
        panel3.add(label3);
        panel3.add(textField3);
        panel3.add(button3);
        frame.add(panel3);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GlowPanel(int width, int height, Color background, int cornerRadius) {
        this.width = width;
        this.height = height;
        this.panelColor = background;
        this.cornerRadius = cornerRadius;
        setOpaque(false);
        setPreferredSize(new Dimension(width + glowSize * 2, height + glowSize * 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        BufferedImage glowImage = generateGlow(width, height, glowSize, glowColor, glowAlpha);
        int x = (getWidth() - glowImage.getWidth()) / 2;
        int y = (getHeight() - glowImage.getHeight()) / 2;
        g2d.drawImage(glowImage, x, y, this);
        g2d.setColor(panelColor);
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

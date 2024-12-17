package views.components;

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
import javax.swing.JPanel;

public class BetterPanel extends JPanel {
    private final int width;
    private final int height;
    private final Color panelColor;
    private final Color glowColor = Color.BLACK;
    private float glowAlpha = 0.09f;
    private int glowSize = 6;
    private final int cornerRadius;
    private boolean shouldGlow = true;
    private Color borderColor = Color.ORANGE;

    private BufferedImage cachedGlowImage = null; // Cache for glow image
    private final GraphicsConfiguration graphicsConfig;

    public BetterPanel(int width, int height, Color background, int cornerRadius) {
        this(width, height, background, cornerRadius, 0.09f, true, Color.ORANGE);
    }

    public BetterPanel(int width, int height, Color background, int cornerRadius, float glowOpacity) {
        this(width, height, background, cornerRadius, glowOpacity, true, Color.ORANGE);
    }

    public BetterPanel(int width, int height, Color background, int cornerRadius, float glowOpacity, Color borderColor) {
        this(width, height, background, cornerRadius, glowOpacity, true, borderColor);
    }

    public BetterPanel(int width, int height, Color background, int cornerRadius, boolean shouldGlow) {
        this(width, height, background, cornerRadius, 0.09f, shouldGlow, Color.ORANGE);
    }

    private BetterPanel(int width, int height, Color background, int cornerRadius, float glowOpacity, boolean shouldGlow, Color borderColor) {
        this.width = width;
        this.height = height;
        this.panelColor = background;
        this.cornerRadius = cornerRadius;
        this.glowAlpha = glowOpacity;
        this.shouldGlow = shouldGlow;
        this.borderColor = borderColor;

        if (!shouldGlow) glowSize = 0;

        graphicsConfig = GraphicsEnvironment.getLocalGraphicsEnvironment()
                                            .getDefaultScreenDevice()
                                            .getDefaultConfiguration();

        setOpaque(false);
        setPreferredSize(new Dimension(width + glowSize * 2, height + glowSize * 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (shouldGlow) {
            if (cachedGlowImage == null) {
                cachedGlowImage = generateGlow(width, height, glowSize, glowColor, glowAlpha);
            }
            int x = (getWidth() - cachedGlowImage.getWidth()) / 2;
            int y = (getHeight() - cachedGlowImage.getHeight()) / 2;
            g2d.drawImage(cachedGlowImage, x, y, this);
        }

        g2d.setColor(panelColor);
        g2d.fillRoundRect((getWidth() - width) / 2, (getHeight() - height) / 2, width, height, cornerRadius, cornerRadius);

        if (!borderColor.equals(Color.ORANGE)) {
            g2d.setColor(borderColor);
            g2d.drawRoundRect((getWidth() - width) / 2, (getHeight() - height) / 2, width, height, cornerRadius, cornerRadius);
        }

        g2d.dispose();
    }

    private BufferedImage generateGlow(int width, int height, int size, Color color, float alpha) {
        BufferedImage imgGlow = createCompatibleImage(width + size * 2, height + size * 2);
        Graphics2D g2 = imgGlow.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(color);
        g2.fillRoundRect(size, size, width, height, cornerRadius, cornerRadius);

        g2.dispose();
        return new GaussianFilter(size).filter(imgGlow, null);
    }

    private BufferedImage createCompatibleImage(int width, int height) {
        return graphicsConfig.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }
}

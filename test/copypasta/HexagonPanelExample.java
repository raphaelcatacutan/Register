package copypasta;
import javax.swing.*;
import java.awt.*;

public class HexagonPanelExample {
    public static JPanel createHexagonPanel(int radius, String imagePath, Color color) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(color);

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;

                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();

                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;

                g2d.drawImage(image, imageX, imageY, this);
            }
        };
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLayout(new BorderLayout());

        JPanel hexagonPanel = createHexagonPanel(20, "C:\\Users\\Raphael\\Downloads\\option.png", Color.BLUE);
        frame.add(hexagonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

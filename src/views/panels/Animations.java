package views.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animations {
    public static void animateColorChange(JPanel panel, Color startColor, Color endColor) {
        final int totalSteps = 5;
        new Timer(10, new ActionListener() {
            private int steps = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                float ratio = steps / (float) totalSteps;
                if (ratio > 1) {
                    ((Timer) e.getSource()).stop();
                } else {
                    int r = (int) (startColor.getRed() + ratio * (endColor.getRed() - startColor.getRed()));
                    int g = (int) (startColor.getGreen() + ratio * (endColor.getGreen() - startColor.getGreen()));
                    int b = (int) (startColor.getBlue() + ratio * (endColor.getBlue() - startColor.getBlue()));
                    panel.setBackground(new Color(r, g, b));
                    steps++;
                }
            }
        }).start();
    }
}

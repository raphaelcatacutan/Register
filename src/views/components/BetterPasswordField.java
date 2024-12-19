package views.components;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class BetterPasswordField extends BetterPanel {
    public JPasswordField passwordField;

    public BetterPasswordField(int width, int height, Color background, int cornerRadius, float glowOpacity, Color borderColor, int fontSize, String iconPath, String hintText) {
        super(width, height, background, cornerRadius, glowOpacity, borderColor);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        passwordField = new JPasswordField();
        passwordField.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true");

        if (iconPath != null) {
            Icon exampleIcon = new ImageIcon(iconPath);
            JLabel iconLabel = new JLabel(exampleIcon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));
            this.add(iconLabel, BorderLayout.WEST);
        }
        
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setOpaque(false);

        this.add(passwordField, BorderLayout.CENTER);
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }
}

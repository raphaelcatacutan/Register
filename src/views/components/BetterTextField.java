package views.components;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BetterTextField extends BetterPanel {
    public JTextField textField;
    private JLabel iconLabel; // JLabel to hold the icon
    
    
    public BetterTextField(int width, int height, Color background, int cornerRadius, float glowOpacity, Color borderColor, int fontSize, String iconPath, String hintText) {
        super(width, height, background, cornerRadius, glowOpacity, borderColor);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        textField = new JTextField();
        
        if (iconPath != null) {
            Icon exampleIcon = new ImageIcon(iconPath);
            iconLabel = new JLabel(exampleIcon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8)); 
            this.add(iconLabel, BorderLayout.WEST); 
        }

        textField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, hintText);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setOpaque(false);
        textField.setFont(new Font("Google Sans", Font.PLAIN, fontSize));

        this.requestFocus();
        this.add(textField, BorderLayout.CENTER);
    }
}

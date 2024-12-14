package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BetterTextField extends BetterPanel {
    public JTextField textField;
    private JLabel iconLabel; // JLabel to hold the icon
    
    public BetterTextField(int width, int height, Color background, int cornerRadius, float glowOpacity, Color borderColor, int fontSize, String iconPath, String hintText) {
        super(width, height, background, cornerRadius, glowOpacity, borderColor);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        textField = new JTextField();
        textField.setText(hintText);
        textField.setForeground(Color.GRAY);
        
        if (iconPath != null) {
            Icon exampleIcon = new ImageIcon(iconPath);
            iconLabel = new JLabel(exampleIcon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8)); 
            this.add(iconLabel, BorderLayout.WEST); 
        }

        // Add focus listeners for hint text functionality
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hintText) || hintText == null) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(hintText);
                    textField.setForeground(Color.GRAY);
                }
                if (textField.getParent() != null) {
                    textField.getParent().requestFocusInWindow();
                }
            }
        });

        // Style the text field
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setOpaque(false);
        textField.setFont(new Font("Google Sans", Font.PLAIN, fontSize));

        this.requestFocus();
        this.add(textField, BorderLayout.CENTER);
    }
}

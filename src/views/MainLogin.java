/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import utils.StaticVars;
import views.components.BetterPanel;
import views.components.BetterPasswordField;
import views.components.BetterTextField;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public class MainLogin extends javax.swing.JPanel {

    /**
     * Creates new form MainLogin
     */
    public MainLogin() {
        initComponents();
        
        add(createInfoPanel());
        add(createFadingImagePanel());
    }

    private JPanel createFadingImagePanel() {
        JPanel panel = new JPanel() {
            private BufferedImage backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(getClass().getResource("/assets/image/plm.jpg"));
                } catch (IOException e) {
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g;

                    int panelWidth = getWidth();
                    int panelHeight = getHeight();
                    g2d.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, null);

                    int fadeStartX = panelWidth;
                    int fullWhiteX = panelWidth * 30 / 100;

                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(0, 0, fullWhiteX, panelHeight);

                    for (int x = fullWhiteX; x <= fadeStartX; x++) {
                        float opacity = Math.max(0.0f, 1.0f - (float) (x - fullWhiteX) / (fadeStartX - fullWhiteX));

                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(x, 0, 1, panelHeight);
                    }

                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                }
            }
        };
        
        panel.setBounds(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
        return panel;
    }

    private JPanel createInfoPanel() {
        int width = 400;
        int height = 550;
        
        JPanel glowPanel = new JPanel();
            glowPanel.setLayout(null);
            glowPanel.setOpaque(false);
            glowPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            glowPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
            glowPanel.setBounds(100, 100, width + 30, height + 30);
        
        JLabel title1 = new JLabel("Welcome! Let's");
            title1.setFont(new java.awt.Font("Google Sans", 0, 30));
            title1.setBorder(BorderFactory.createEmptyBorder(50, 5, 0, 100));
            title1.setAlignmentX(Component.LEFT_ALIGNMENT);
            title1.setOpaque(false);
            title1.setBackground(Color.red);
            glowPanel.add(title1);
            
        JLabel title2 = new JLabel("Sign in");
            title2.setFont(new java.awt.Font("Google Sans Medium", 0, 70));
            title2.setBorder(BorderFactory.createEmptyBorder(-10, 5, 10, 100));
            title2.setAlignmentX(Component.LEFT_ALIGNMENT);
            title2.setOpaque(false);
            title2.setBackground(Color.red);
            title2.setForeground(new Color(41, 79, 116));
            glowPanel.add(title2);
        
        JLabel label1 = new JLabel("Email:");
            label1.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label1.setAlignmentX(Component.LEFT_ALIGNMENT);
            label1.setOpaque(false);
            label1.setBackground(Color.red);
        BetterTextField betterTextField = new BetterTextField(
            width - 100, 35, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Username: plm"
        );
            betterTextField.setOpaque(false);
            JTextField textfield1 = betterTextField.textField;
            textfield1.setForeground(Color.black);
        JPanel fieldPanel1 = new JPanel();
            fieldPanel1.setLayout(new BorderLayout());
            fieldPanel1.setOpaque(false);
            fieldPanel1.add(label1, BorderLayout.PAGE_START);
            fieldPanel1.add(betterTextField, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel1);
            
        JLabel label2 = new JLabel("Password:");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        BetterPasswordField betterPasswordFiled = new BetterPasswordField(
            width - 100, 35, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Password: plm"
        );
            betterPasswordFiled.setOpaque(false);
            JTextField textfield2 = betterPasswordFiled.passwordField;
            textfield2.setForeground(Color.black);
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(betterPasswordFiled, BorderLayout.PAGE_END);
            fieldPanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            glowPanel.add(fieldPanel2);
            
        JPanel button1 = new BetterPanel(130, 35, new Color(173, 204, 255), 10, 0.5f);
            JLabel button1Label = new JLabel("Login Account");
            button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button1.add(button1Label);
            button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            glowPanel.add(button1);
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if ("plm".equals(textfield1.getText()) && "plm".equals(textfield2.getText())) {
                        StaticVars.mainCardLayout.show(StaticVars.mainForm.getContentPane(), "mainView");
                        textfield1.setText("");
                        textfield2.setText("");
                    }
                    else {
                        final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR, 
                            "You input the wrong username or passworld. Please try again.", 
                            "Invalid Credentials", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                    }
                }
            });
            
        return glowPanel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public class StudentsList extends javax.swing.JPanel {

    /**
     * Creates new form StudentsList
     */
    public StudentsList() {
        initComponents();
        
        add(createActionsPanel());
        add(createGridPanel(), BorderLayout.CENTER);
    }
    
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, "C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png", "Search");
        
        JPanel button1 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Search Student");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel button2Label = new JLabel("Add Student");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        actionsPanel.add(Box.createHorizontalStrut(95));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private JPanel createGridPanel() {
        JPanel gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(850, 1000));
        gridPanel.setOpaque(false);
        gridPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        gridPanel.add(createGridRecord(1));
        gridPanel.add(createGridRecord(2));
        gridPanel.add(createGridRecord(3));
        gridPanel.add(createGridRecord(4));
        gridPanel.add(createGridRecord(5));
        gridPanel.add(createGridRecord(6));
        gridPanel.add(createGridRecord(7));
        
        return gridPanel;
    }

    private JPanel createGridRecord(int a) {
        JPanel glowPanel = new BetterPanel(245, 125, Color.WHITE, 20, 0.07f);
        glowPanel.setLayout(null);
        glowPanel.setOpaque(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/image/example image.png"));
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            JLabel image = new JLabel();
            image.setIcon(scaledIcon);
            image.setBounds(25, 25, 60, 60); 
            glowPanel.add(image);
            
        JTextArea label1 = new JTextArea(2, 20);
            label1.setText("Catacutan, Raphael James Casdasdassadas dasdsadada dadasdasdasdasd.");
            label1.setWrapStyleWord(true);
            label1.setLineWrap(true);
            label1.setOpaque(false);
            label1.setEditable(false);
            label1.setFocusable(false);
            label1.setBackground(Color.orange);
            label1.setFont(new java.awt.Font("Google Sans Medium", 0, 15));
            label1.setBounds(95, 23, 140, 40); 
            label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            glowPanel.add(label1);
            
        JLabel label2 = new JLabel("202334103");
            label2.setFont(new java.awt.Font("Google Sans", 0, 13));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.blue);
            label2.setBounds(95, 63, 140, 20); 
            glowPanel.add(label2);
            
        JPanel column3 = new BetterPanel(65, 18, new Color(255, 200, 200), 15, 0.5f);
            column3.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel column3Label = new JLabel();
            column3Label.setText("BSCS");
            column3Label.setFont(new Font("Google Sans", Font.PLAIN, 10));
            column3Label.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            column3.add(column3Label);
            column3.setBounds(85, 83, 80, 30); 
            glowPanel.add(column3);
            
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
            }
        });
        glowPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        glowPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
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

        lblStudents = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 120));
        setMaximumSize(new java.awt.Dimension(1030, 720));
        setMinimumSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStudents.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblStudents.setText("Students List ");
        add(lblStudents);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStudents;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.*;
import javax.swing.*;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public final class ViewSettings extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ViewSettings() {
        initComponents();   
        
        add(createActionsPanel());
        add(createTablePanel());
        add(createTablePanel());
        add(createTablePanel());
    }
    
    private JPanel createActionsPanel() {
        JPanel actions = new JPanel();
            actions.setLayout(new FlowLayout(FlowLayout.LEFT));
            actions.setPreferredSize(new Dimension(850, 200));
            
        JLabel label4 = new JLabel();
            label4.setPreferredSize(new Dimension(692, 33));
            label4.setFont(new Font("Google Sans", Font.PLAIN, 14));
            label4.setOpaque(false);
            label4.setBackground(new Color(250, 250, 250));
            label4.setText("About the Project");
            label4.setHorizontalAlignment(SwingConstants.LEFT);
        JPanel button4 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
            JLabel button4Label = new JLabel("Visit Page");
            button4Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button4Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button4Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button4.add(button4Label);
            button4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel actionsPanel4 = new JPanel();
            actionsPanel4.setLayout(new BoxLayout(actionsPanel4, BoxLayout.X_AXIS));
            actionsPanel4.setOpaque(false);
            actionsPanel4.setAlignmentX(Component.LEFT_ALIGNMENT);
            actionsPanel4.add(label4);
            actionsPanel4.add(Box.createHorizontalStrut(5));
            actionsPanel4.add(button4);
        actions.add(actionsPanel4);
        
        JLabel label3 = new JLabel();
            label3.setPreferredSize(new Dimension(525, 33));
            label3.setFont(new Font("Google Sans", Font.PLAIN, 14));
            label3.setOpaque(false);
            label3.setBackground(new Color(250, 250, 250));
            label3.setText("Database Management");
            label3.setHorizontalAlignment(SwingConstants.LEFT);
        JPanel button3_1 = new BetterPanel(135, 30, new Color(173, 204, 255), 10, 0.5f);
            JLabel button3_1Label = new JLabel("Backup Database");
            button3_1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button3_1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button3_1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button3_1.add(button3_1Label);
            button3_1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel button3_2 = new BetterPanel(135, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel button3_2Label = new JLabel("Restore Database");
            button3_2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button3_2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button3_2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button3_2.add(button3_2Label);
            button3_2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button3_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel actionsPanel3 = new JPanel();
            actionsPanel3.setLayout(new BoxLayout(actionsPanel3, BoxLayout.X_AXIS));
            actionsPanel3.setOpaque(false);
            actionsPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
            actionsPanel3.add(label3);
            actionsPanel3.add(button3_1);
            actionsPanel3.add(Box.createHorizontalStrut(5));
            actionsPanel3.add(button3_2);
        actions.add(actionsPanel3);
        
        JLabel label1 = new JLabel();
            label1.setPreferredSize(new Dimension(420, 33));
            label1.setFont(new Font("Google Sans", Font.PLAIN, 14));
            label1.setOpaque(false);
            label1.setBackground(new Color(250, 250, 250));
            label1.setText("New School Year");
            label1.setHorizontalAlignment(SwingConstants.LEFT);
        BetterTextField textField1 = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 2024-2025");
        JPanel button1 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel button1Label = new JLabel("Add Year");
            button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button1.add(button1Label);
            button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel actionsPanel1 = new JPanel();
            actionsPanel1.setLayout(new BoxLayout(actionsPanel1, BoxLayout.X_AXIS));
            actionsPanel1.setOpaque(false);
            actionsPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
            actionsPanel1.add(label1);
            actionsPanel1.add(textField1);
            actionsPanel1.add(Box.createHorizontalStrut(5));
            actionsPanel1.add(button1);
        actions.add(actionsPanel1);
        
        JLabel label2 = new JLabel();
            label2.setPreferredSize(new Dimension(420, 33));
            label2.setFont(new Font("Google Sans", Font.PLAIN, 14));
            label2.setOpaque(false);
            label2.setBackground(new Color(250, 250, 250));
            label2.setText("New Semester");
            label2.setHorizontalAlignment(SwingConstants.LEFT);
        BetterTextField textField2 = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 1, 2, 3");
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel button2Label = new JLabel("Add Semester");
            button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button2.add(button2Label);
            button2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel actionsPanel2 = new JPanel();
            actionsPanel2.setLayout(new BoxLayout(actionsPanel2, BoxLayout.X_AXIS));
            actionsPanel2.setOpaque(false);
            actionsPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
            actionsPanel2.add(label2);
            actionsPanel2.add(textField2);
            actionsPanel2.add(Box.createHorizontalStrut(5));
            actionsPanel2.add(button2);
        actions.add(actionsPanel2);
        
        actions.setOpaque(false);
        return actions;
    }
    
    private JPanel createTablePanel() {
        JPanel table = new BetterPanel(260, 370, new Color(250, 250, 250), 30, 0.2f);
        table.setOpaque(false);
        table.setLayout(new BoxLayout(table, BoxLayout.Y_AXIS));
        table.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        JLabel label = new JLabel();
            label.setMinimumSize(new Dimension(692, 33));
            label.setFont(new Font("Google Sans", Font.PLAIN, 16));
            label.setOpaque(false);
            label.setBackground(Color.GREEN);
            label.setText("School Years");
            label.setHorizontalAlignment(SwingConstants.LEFT);
            
        table.add(label);
        table.add(createYearsPanel(1));
        table.add(createYearsPanel(2));
        table.add(createYearsPanel(3));
        table.add(createYearsPanel(4));
        table.add(createYearsPanel(4));
        table.add(createYearsPanel(4));
        
        return table;
    }
    
    private JPanel createYearsPanel(int a) {
        JPanel recordPanel = new BetterPanel(200, 33, Color.WHITE, 10, 0.1f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(200, 33));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(17, 30, 10, 10));
        column1.setText("Full Name");
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        recordPanel.add(column1);
        recordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        return recordPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDashboard = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 80));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1040, 720));
        setMinimumSize(new java.awt.Dimension(1040, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1040, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblDashboard.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblDashboard.setText("Settings");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

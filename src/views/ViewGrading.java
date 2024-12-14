/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public final class ViewGrading extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ViewGrading() {
        initComponents();   
        
        add(createComboBoxes());
        add(createActionsPanel());
        add(createTablePanel());
    }
    
    public static JPanel createComboBoxes() {
        JPanel comboBoxes = new JPanel();
        comboBoxes.setLayout(new BoxLayout(comboBoxes, BoxLayout.X_AXIS));
        comboBoxes.setOpaque(false);
        comboBoxes.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBoxes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel label1 = new JLabel("School Year");
            label1.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label1.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label1.setAlignmentX(Component.LEFT_ALIGNMENT);
            label1.setOpaque(false);
            label1.setBackground(Color.red);
        JComboBox comboBox1 = new JComboBox();
            comboBox1.addItem("Male");
            comboBox1.addItem("Female");
            comboBox1.setPreferredSize(new Dimension(200, 30));
        JPanel fieldPanel1 = new JPanel();
            fieldPanel1.setLayout(new BorderLayout());
            fieldPanel1.setOpaque(false);
            fieldPanel1.add(label1, BorderLayout.PAGE_START);
            fieldPanel1.add(comboBox1, BorderLayout.PAGE_END);
            fieldPanel1.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel1);
            
        JLabel label2 = new JLabel("Semester");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        JComboBox comboBox2 = new JComboBox();
            comboBox2.addItem("Male");
            comboBox2.addItem("Female");
            comboBox2.setPreferredSize(new Dimension(200, 30));
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(comboBox2, BorderLayout.PAGE_END);
            fieldPanel2.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel2);
            
        JLabel label3 = new JLabel("Subject");
            label3.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label3.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label3.setAlignmentX(Component.LEFT_ALIGNMENT);
            label3.setOpaque(false);
            label3.setBackground(Color.red);
        JComboBox comboBox3 = new JComboBox();
            comboBox3.addItem("Male");
            comboBox3.addItem("Female");
            comboBox3.setPreferredSize(new Dimension(200, 30));
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(comboBox3, BorderLayout.PAGE_END);
            fieldPanel3.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel3);
            
        JLabel label4 = new JLabel("Block Sequence");
            label4.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label4.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label4.setAlignmentX(Component.LEFT_ALIGNMENT);
            label4.setOpaque(false);
            label4.setBackground(Color.red);
        JComboBox comboBox4 = new JComboBox();
            comboBox4.addItem("Male");
            comboBox4.addItem("Female");
            comboBox4.setPreferredSize(new Dimension(200, 30));
        JPanel fieldPanel4 = new JPanel();
            fieldPanel4.setLayout(new BorderLayout());
            fieldPanel4.setOpaque(false);
            fieldPanel4.add(label4, BorderLayout.PAGE_START);
            fieldPanel4.add(comboBox4, BorderLayout.PAGE_END);
            fieldPanel4.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel4);
        
        return comboBoxes;
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
        
        JLabel button2Label = new JLabel("Save Changes");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        actionsPanel.add(Box.createHorizontalStrut(310));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private JPanel createTablePanel() {
        JPanel table = new JPanel();
        table.setOpaque(false);
        table.setLayout(new BoxLayout(table, BoxLayout.PAGE_AXIS));
        table.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 0));
        
        // Titles
        JPanel title = new BetterPanel(820, 30, new Color(250, 247, 227), 10, 0.2f);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(500, 33));
        column1.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(205, 220, 220));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText("Full Name");
        column1.setHorizontalAlignment(SwingConstants.CENTER);
        column1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column2 = new JLabel();
        column2.setPreferredSize(new Dimension(150, 33));
        column2.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column2.setOpaque(false);
        column2.setBackground(new Color(220, 220, 220));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("Grade");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        column2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column3 = new JLabel();
        column3.setPreferredSize(new Dimension(150, 33));
        column3.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column3.setOpaque(false);
        column3.setBackground(new Color(220, 220, 220));
        column3.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column3.setText("Remarks");
        column3.setHorizontalAlignment(SwingConstants.CENTER);
        column3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        title.add(column1);
        title.add(column2);
        title.add(column3);
        
        table.add(title);
        table.add(createTableRecord(1));
        table.add(createTableRecord(2));
        table.add(createTableRecord(3));
        table.add(createTableRecord(4));
        table.add(createTableRecord(4));
        table.add(createTableRecord(4));
        table.add(createTableRecord(4));
        
        return table;
    }
    
    private JPanel createTableRecord(int a) {
        JPanel recordPanel = new BetterPanel(790, 50, Color.WHITE, 10, 0.05f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        recordPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        
        JLabel column1 = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png");
        Image originalImage = originalIcon.getImage(); 
        Image resizedImage = originalImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        column1.setPreferredSize(new Dimension(485, 53));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 30, 10, 10));
        column1.setText("Full Name");
        column1.setIcon(resizedIcon);
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        JComboBox column2 = new JComboBox();
            column2.addItem("Male");
            column2.addItem("Female");
            column2.setPreferredSize(new Dimension(150, 30));
            
        JPanel separator = new JPanel();
            separator.setPreferredSize(new Dimension(40, 20));
            separator.setOpaque(false);
        
        JPanel column3 = new BetterPanel(55, 20, new Color(255, 200, 200), 15, 0.5f);
        column3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel column3Label = new JLabel();
        column3Label.setText("Inactive");
        column3Label.setFont(new Font("Google Sans", Font.PLAIN, 11));
        column3Label.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
        column3.add(column3Label);
        
        recordPanel.add(column1);
        recordPanel.add(column2);
        recordPanel.add(separator);
        recordPanel.add(column3);
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
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 120));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1040, 720));
        setMinimumSize(new java.awt.Dimension(1040, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1040, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblDashboard.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblDashboard.setText("Grading");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

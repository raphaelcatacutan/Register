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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import views.components.BetterPanel;
import views.components.BetterTextField;
import static views.MainView.mainViewCardLayout;

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
        add(createTablePanel(), BorderLayout.CENTER);
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
    
    private JPanel createTablePanel() {
        JPanel table = new JPanel();
        table.setOpaque(false);
        table.setLayout(new BoxLayout(table, BoxLayout.PAGE_AXIS));
        
        // Titles
        JPanel title = new BetterPanel(775, 30, new Color(250, 247, 227), 10, 0.2f);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(205, 33));
        column1.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(205, 220, 220));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText("Full Name");
        column1.setHorizontalAlignment(SwingConstants.CENTER);
        column1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column2 = new JLabel();
        column2.setPreferredSize(new Dimension(160, 33));
        column2.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column2.setOpaque(false);
        column2.setBackground(new Color(220, 220, 220));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("Email");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        column2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column3 = new JLabel();
        column3.setPreferredSize(new Dimension(70, 33));
        column3.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column3.setOpaque(false);
        column3.setBackground(new Color(220, 220, 220));
        column3.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column3.setText("Status");
        column3.setHorizontalAlignment(SwingConstants.CENTER);
        column3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column4 = new JLabel();
        column4.setPreferredSize(new Dimension(100, 33));
        column4.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column4.setOpaque(false);
        column4.setBackground(new Color(220, 220, 220));
        column4.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column4.setText("Course");
        column4.setHorizontalAlignment(SwingConstants.CENTER);
        column4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column5 = new JLabel();
        column5.setPreferredSize(new Dimension(110, 33));
        column5.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column5.setOpaque(false);
        column5.setBackground(new Color(220, 220, 220));
        column5.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column5.setText("Date Started");
        column5.setHorizontalAlignment(SwingConstants.CENTER);
        column5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel column6 = new JLabel();
        column6.setPreferredSize(new Dimension(110, 33));
        column6.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column6.setOpaque(false);
        column6.setBackground(new Color(220, 220, 220));
        column6.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column6.setText("Data Graduated");
        column6.setHorizontalAlignment(SwingConstants.CENTER);
        column6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        title.add(column1);
        title.add(column2);
        title.add(column4);
        title.add(column5);
        title.add(column6);
        title.add(column3);
        
        add(title); // Add outside the scroll
        table.add(createTableRecord(1));
        table.add(createTableRecord(2));
        table.add(createTableRecord(3));
        table.add(createTableRecord(4));
        table.add(createTableRecord(5));
        table.add(createTableRecord(6));
        table.add(createTableRecord(7));
        
        return table;
    }

    private JPanel createTableRecord(int a) {
        JPanel recordPanel = new BetterPanel(760, 50, Color.WHITE, 10, 0.05f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel column1 = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png");
        Image originalImage = originalIcon.getImage(); 
        Image resizedImage = originalImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        column1.setPreferredSize(new Dimension(190, 53));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText("Full Name");
        column1.setIcon(resizedIcon);
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel column2 = new JLabel();
        column2.setPreferredSize(new Dimension(160, 53));
        column2.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column2.setOpaque(false);
        column2.setBackground(new Color(220, 220, 220));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("Email");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel column3 = new BetterPanel(55, 20, new Color(255, 200, 200), 15, 0.5f);
        column3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel column3Label = new JLabel();
        column3Label.setText("Inactive");
        column3Label.setFont(new Font("Google Sans", Font.PLAIN, 11));
        column3Label.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
        column3.add(column3Label);
        
        JLabel column4 = new JLabel();
        column4.setPreferredSize(new Dimension(100, 53));
        column4.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column4.setOpaque(false);
        column4.setBackground(new Color(250, 250, 250));
        column4.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column4.setText("Course");
        column4.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel column5 = new JLabel();
        column5.setPreferredSize(new Dimension(110, 53));
        column5.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column5.setOpaque(false);
        column5.setBackground(new Color(250, 250, 250));
        column5.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column5.setText(String.valueOf(a));
        column5.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel column6 = new JLabel();
        column6.setPreferredSize(new Dimension(110, 53));
        column6.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column6.setOpaque(false);
        column6.setBackground(new Color(250, 250, 250));
        column6.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column6.setText("Data Graduated");
        column6.setHorizontalAlignment(SwingConstants.CENTER);
        
        recordPanel.add(column1);
        recordPanel.add(column2);
        recordPanel.add(column4);
        recordPanel.add(column5);
        recordPanel.add(column6);
        recordPanel.add(column3);
        recordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        recordPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                column1.setForeground(Color.red);
                column2.setForeground(Color.red);
                column3Label.setForeground(Color.red);
                column4.setForeground(Color.red);
                column5.setForeground(Color.red);
                column6.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                column1.setForeground(Color.black);
                column2.setForeground(Color.black);
                column3Label.setForeground(Color.black);
                column4.setForeground(Color.black);
                column5.setForeground(Color.black);
                column6.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
            }
        });
        
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

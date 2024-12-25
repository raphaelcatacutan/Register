/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import database.DBAdd;
import database.DBReadMd;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import models.SchoolYear;
import models.Semester;
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
public final class ViewSettings extends javax.swing.JPanel {
    JPanel yearListPanel;
    JPanel semesterListPanel;
    
    public void refreshData() {
        java.util.List<SchoolYear> schoolYears = DBReadMd.readSchoolYears();
        yearListPanel.removeAll();
        JLabel label = new JLabel();
            label.setMinimumSize(new Dimension(692, 40));
            label.setFont(new Font("Google Sans", Font.PLAIN, 16));
            label.setOpaque(false);
            label.setBackground(Color.GREEN);
            label.setText("School Years");
            label.setHorizontalAlignment(SwingConstants.LEFT);
            
        yearListPanel.add(label);
        for (SchoolYear schoolYear: schoolYears) {
            yearListPanel.add(createYearsPanel(schoolYear));
            yearListPanel.revalidate();
        }
        
        
        java.util.List<Semester> semesters = DBReadMd.readSemesters();
        semesterListPanel.removeAll();
        JLabel label2 = new JLabel();
            label2.setMinimumSize(new Dimension(692, 40));
            label2.setFont(new Font("Google Sans", Font.PLAIN, 16));
            label2.setOpaque(false);
            label2.setBackground(Color.GREEN);
            label2.setText("Semesters");
            label2.setHorizontalAlignment(SwingConstants.LEFT);
            
        semesterListPanel.add(label2);
        for (Semester semester: semesters) {
            semesterListPanel.add(createSemesterPanel(semester));
            semesterListPanel.revalidate();
        }
    }
    
    /**
     * Creates new form NewJPanel
     */
    public ViewSettings() {
        initComponents();   
        
        add(createActionsPanel());
        add(createYearsTablePanel());
        add(createSemesterTablePanel());
    }
    
    private JPanel createActionsPanel() {
        JPanel actions = new JPanel();
            actions.setLayout(new FlowLayout(FlowLayout.LEFT));
            actions.setPreferredSize(new Dimension(850, 120));
            
        JLabel aboutLabel = new JLabel();
            aboutLabel.setPreferredSize(new Dimension(692, 33));
            aboutLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
            aboutLabel.setOpaque(false);
            aboutLabel.setBackground(new Color(250, 250, 250));
            aboutLabel.setText("About the Project");
            aboutLabel.setHorizontalAlignment(SwingConstants.LEFT);
        JPanel aboutButton = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
            JLabel aboutButtonLabel = new JLabel("Visit Page");
            aboutButtonLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
            aboutButtonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            aboutButtonLabel.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            aboutButton.add(aboutButtonLabel);
            aboutButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            aboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel aboutPanel = new JPanel();
            aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.X_AXIS));
            aboutPanel.setOpaque(false);
            aboutPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            aboutPanel.add(aboutLabel);
            aboutPanel.add(Box.createHorizontalStrut(5));
            aboutPanel.add(aboutButton);
//        actions.add(aboutPanel);
        
        JLabel databaseLabel = new JLabel();
            databaseLabel.setPreferredSize(new Dimension(525, 33));
            databaseLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
            databaseLabel.setOpaque(false);
            databaseLabel.setBackground(new Color(250, 250, 250));
            databaseLabel.setText("Database Management");
            databaseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        JPanel databaseButton1 = new BetterPanel(135, 30, new Color(173, 204, 255), 10, 0.5f);
            JLabel databaseButton1Label = new JLabel("Backup Database");
            databaseButton1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            databaseButton1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            databaseButton1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            databaseButton1.add(databaseButton1Label);
            databaseButton1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            databaseButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel databaseButton2 = new BetterPanel(135, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel databaseButton2Label = new JLabel("Restore Database");
            databaseButton2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            databaseButton2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            databaseButton2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            databaseButton2.add(databaseButton2Label);
            databaseButton2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            databaseButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel databasePanel = new JPanel();
            databasePanel.setLayout(new BoxLayout(databasePanel, BoxLayout.X_AXIS));
            databasePanel.setOpaque(false);
            databasePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            databasePanel.add(databaseLabel);
            databasePanel.add(databaseButton1);
            databasePanel.add(Box.createHorizontalStrut(5));
            databasePanel.add(databaseButton2);
//        actions.add(databasePanel);
        
        JLabel yearLabel = new JLabel();
            yearLabel.setPreferredSize(new Dimension(420, 33));
            yearLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
            yearLabel.setOpaque(false);
            yearLabel.setBackground(new Color(250, 250, 250));
            yearLabel.setText("New School Year");
            yearLabel.setHorizontalAlignment(SwingConstants.LEFT);
        BetterTextField yearTextfieldPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 2024-2025");
        JPanel yearButton = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel yearButtonLabel = new JLabel("Add Year");
            yearButtonLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
            yearButtonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            yearButtonLabel.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            yearButton.add(yearButtonLabel);
            yearButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel yearPanel = new JPanel();
            yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.X_AXIS));
            yearPanel.setOpaque(false);
            yearPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            yearPanel.add(yearLabel);
            yearPanel.add(yearTextfieldPanel);
            yearPanel.add(Box.createHorizontalStrut(5));
            yearPanel.add(yearButton);
        actions.add(yearPanel);
        yearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newYear = yearTextfieldPanel.textField.getText();
                if (newYear.isEmpty()) return;
                DBAdd.addSchoolYear(newYear);
                refreshData();
                yearTextfieldPanel.textField.setText("");
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "Data has been successfully saved to the database", 
                            "Success", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
            }
        });
        
        JLabel semesterLabel = new JLabel();
            semesterLabel.setPreferredSize(new Dimension(420, 33));
            semesterLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
            semesterLabel.setOpaque(false);
            semesterLabel.setBackground(new Color(250, 250, 250));
            semesterLabel.setText("New Semester");
            semesterLabel.setHorizontalAlignment(SwingConstants.LEFT);
        BetterTextField semesterTextfieldPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 1, 2, 3");
        JPanel semesterButton = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel semesterButtonLabel = new JLabel("Add Semester");
            semesterButtonLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
            semesterButtonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            semesterButtonLabel.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            semesterButton.add(semesterButtonLabel);
            semesterButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            semesterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel semesterPanel = new JPanel();
            semesterPanel.setLayout(new BoxLayout(semesterPanel, BoxLayout.X_AXIS));
            semesterPanel.setOpaque(false);
            semesterPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            semesterPanel.add(semesterLabel);
            semesterPanel.add(semesterTextfieldPanel);
            semesterPanel.add(Box.createHorizontalStrut(5));
            semesterPanel.add(semesterButton);
        actions.add(semesterPanel);
        semesterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newSemester = semesterTextfieldPanel.textField.getText();
                if (newSemester.isEmpty()) return;
                DBAdd.addSemester(newSemester);
                refreshData();
                semesterTextfieldPanel.textField.setText("");
                
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "Data has been successfully saved to the database", 
                            "Success", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
            }
        });
        
        JLabel passwordLabel = new JLabel();
            passwordLabel.setPreferredSize(new Dimension(110, 33));
            passwordLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
            passwordLabel.setOpaque(false);
            passwordLabel.setBackground(new Color(250, 250, 250));
            passwordLabel.setText("Reset Password");
            passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        BetterPasswordField passTextfieldOldPasswordPanel = new BetterPasswordField(180, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 1, 2, 3");
        BetterPasswordField passTextfieldNewPassword1Panel = new BetterPasswordField(180, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 1, 2, 3");
        BetterPasswordField passTextfieldNewPassword2Panel = new BetterPasswordField(180, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, "Example: 1, 2, 3");
        JPanel passwordButton = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
            JLabel passwordButtonLabel = new JLabel("Add Semester");
            passwordButtonLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
            passwordButtonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            passwordButtonLabel.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            passwordButton.add(passwordButtonLabel);
            passwordButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            passwordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
            passwordPanel.setOpaque(false);
            passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            passwordPanel.add(passwordLabel);
            passwordPanel.add(passTextfieldOldPasswordPanel);
            passwordPanel.add(Box.createHorizontalStrut(5));
            passwordPanel.add(passTextfieldNewPassword1Panel);
            passwordPanel.add(passTextfieldNewPassword2Panel);
            passwordPanel.add(Box.createHorizontalStrut(5));
            passwordPanel.add(passwordButton);
//        actions.add(passwordPanel);
        
        actions.setOpaque(false);
        return actions;
    }
    
    private JPanel createYearsTablePanel() {
        yearListPanel = new BetterPanel(300, 450, new Color(250, 250, 250), 30, 0.2f);
            yearListPanel.setOpaque(false);
            yearListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
            yearListPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
       
        JLabel label = new JLabel();
            label.setMinimumSize(new Dimension(692, 40));
            label.setFont(new Font("Google Sans", Font.PLAIN, 16));
            label.setOpaque(false);
            label.setBackground(Color.GREEN);
            label.setText("School Years");
            label.setHorizontalAlignment(SwingConstants.LEFT);
            
        yearListPanel.add(label);
        
        return yearListPanel;
    }
    
    private JPanel createYearsPanel(SchoolYear sy) {
        JPanel recordPanel = new BetterPanel(230, 33, Color.WHITE, 10, 0.1f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(200, 33));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(15, 30, 10, 10));
        column1.setText(sy.getSyear());
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        recordPanel.add(column1);
        recordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        return recordPanel;
    }

    private JPanel createSemesterTablePanel() {
        semesterListPanel = new BetterPanel(300, 450, new Color(250, 250, 250), 30, 0.2f);
        semesterListPanel.setOpaque(false);
            semesterListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
            semesterListPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        JLabel label = new JLabel();
            label.setMinimumSize(new Dimension(692, 33));
            label.setFont(new Font("Google Sans", Font.PLAIN, 16));
            label.setOpaque(false);
            label.setBackground(Color.GREEN);
            label.setText("School Years");
            label.setHorizontalAlignment(SwingConstants.LEFT);
            
        semesterListPanel.add(label);
        
        return semesterListPanel;
    }
    
    private JPanel createSemesterPanel(Semester sem) {
        JPanel recordPanel = new BetterPanel(230, 33, Color.WHITE, 10, 0.1f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(200, 33));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(15, 30, 10, 10));
        column1.setText(sem.getSemester());
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

        lblDashboard.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblDashboard.setText("Year and Semester                                                                                                                     ");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

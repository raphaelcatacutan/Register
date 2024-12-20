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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import raven.datetime.component.date.DatePicker;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public class SubjectsList extends javax.swing.JPanel {

    /**
     * Creates new form StudentsList
     */
    public SubjectsList() {
        initComponents();
        
        add(createActionsPanel());
        add(createSubjectListPanel());
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        rightPanel.setPreferredSize(new Dimension(570, 570));
        rightPanel.add(createInfoPanel());
        rightPanel.add(createScheduleActionsPanel());
        rightPanel.add(createScheduleGridPanel());
        
        add(rightPanel);
    }
    
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, "C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png", "Search");
        
        JPanel button1 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Search Subject");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel button2Label = new JLabel("Add Subject");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        actionsPanel.add(Box.createHorizontalStrut(500));
//        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
//        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private JPanel createSubjectListPanel() {
        JPanel table = new JPanel();
        table.setOpaque(true);
        table.setLayout(new BoxLayout(table, BoxLayout.PAGE_AXIS));
        
        table.add(createSubjectRecord(1));
        table.add(createSubjectRecord(2));
        table.add(createSubjectRecord(3));
        table.add(createSubjectRecord(4));
        table.add(createSubjectRecord(5));
        table.add(createSubjectRecord(6));
        table.add(createSubjectRecord(7));
        
        return table;
    }

    private JPanel createSubjectRecord(int a) {
        JPanel recordPanel = new BetterPanel(200, 50, Color.WHITE, 10, 0.06f);
            recordPanel.setLayout(new BorderLayout(0, 0));
            recordPanel.setBorder(BorderFactory.createEmptyBorder(14, 15, 15, 15));
        
        JTextArea subjectLabel = new JTextArea(2, 20);
            subjectLabel.setText("Catacutan, Raphael James Casdasdassadas dasdsadada dadasdasdasdasd. a dad jaskdl adklasjdlasdhsajkd aksdajsdhak,dhaskhakashdaksdhakd asasj");
            subjectLabel.setWrapStyleWord(true);
            subjectLabel.setLineWrap(true);
            subjectLabel.setOpaque(false);
            subjectLabel.setEditable(false);
            subjectLabel.setFocusable(false);
            subjectLabel.setBackground(Color.orange);
            subjectLabel.setFont(new java.awt.Font("Google Sans", 0, 12));
        
        recordPanel.add(subjectLabel);
        recordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        recordPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                subjectLabel.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                subjectLabel.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Subject Record Click");
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subInfoPanel");
            }
        });
        
        subjectLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                subjectLabel.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                subjectLabel.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Subject Record Click");
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subInfoPanel");
            }
        });
        
        return recordPanel;
    }
    
    private JPanel createInfoPanel() {
        JPanel glowPanel = new BetterPanel(545, 280, new Color(250, 250, 250), 30, 0.2f);
            glowPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            glowPanel.setOpaque(false);
            glowPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        JLabel label1 = new JLabel("Subject Code:");
            label1.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label1.setAlignmentX(Component.LEFT_ALIGNMENT);
            label1.setOpaque(false);
            label1.setBackground(Color.red);
        BetterTextField betterTextField1 = new BetterTextField(
            130, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField1.setOpaque(false);
            JTextField textfield1 = betterTextField1.textField;
            textfield1.setForeground(Color.black);
        JPanel fieldPanel1 = new JPanel();
            fieldPanel1.setLayout(new BorderLayout());
            fieldPanel1.setOpaque(false);
            fieldPanel1.add(label1, BorderLayout.PAGE_START);
            fieldPanel1.add(betterTextField1, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel1);
            
        JLabel label3 = new JLabel("Units");
            label3.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label3.setAlignmentX(Component.LEFT_ALIGNMENT);
            label3.setOpaque(false);
            label3.setBackground(Color.red);
        BetterTextField betterTextField3 = new BetterTextField(
            70, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField3.setOpaque(false);
            JTextField textField3 = betterTextField3.textField;
            textField3.setForeground(Color.black);
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(betterTextField3, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel3); 
            
        JLabel label4 = new JLabel("Curriculum");
            label4.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label4.setAlignmentX(Component.LEFT_ALIGNMENT);
            label4.setOpaque(false);
            label4.setBackground(Color.red);
        BetterTextField betterTextField4 = new BetterTextField(
            70, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField4.setOpaque(false);
            JTextField textField4 = betterTextField4.textField;
            textField4.setForeground(Color.black);
        JPanel fieldPanel4 = new JPanel();
            fieldPanel4.setLayout(new BorderLayout());
            fieldPanel4.setOpaque(false);
            fieldPanel4.add(label4, BorderLayout.PAGE_START);
            fieldPanel4.add(betterTextField4, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel4);
            
        JLabel label2 = new JLabel("Description:");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        BetterTextField betterTextField2 = new BetterTextField(
            400, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField2.setOpaque(false);
            JTextField textField2 = betterTextField2.textField;
            textField2.setForeground(Color.black);
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(betterTextField2, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel2);
            
        UIManager.put("ComboBox.buttonBackground", new Color(224, 224, 224));
        UIManager.put("ComboBox.buttonHoverArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonPressedArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonArrowColor", Color.gray);
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("Component.focusedBorderColor", new Color(217, 217, 217));
        
        JLabel label6 = new JLabel("Gender:");
            label6.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label6.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label6.setAlignmentX(Component.LEFT_ALIGNMENT);
            label6.setOpaque(false);
            label6.setBackground(Color.red);
        JComboBox comboBox6 = new JComboBox();
            comboBox6.addItem("Male");
            comboBox6.addItem("Female");
            comboBox6.setPreferredSize(new Dimension(300, 32));
        JPanel fieldPanel6 = new JPanel();
            fieldPanel6.setLayout(new BorderLayout());
            fieldPanel6.setOpaque(false);
            fieldPanel6.add(label6, BorderLayout.PAGE_START);
            fieldPanel6.add(comboBox6, BorderLayout.PAGE_END);
            fieldPanel6.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel6);
            
        JLabel label7 = new JLabel("Status:");
            label7.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label7.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label7.setAlignmentX(Component.LEFT_ALIGNMENT);
            label7.setOpaque(false);
            label7.setBackground(Color.red);
        JComboBox comboBox7 = new JComboBox();
            comboBox7.addItem("Active");
            comboBox7.addItem("Inactive");
            comboBox7.setPreferredSize(new Dimension(125, 30));
        JPanel fieldPanel7 = new JPanel();
            fieldPanel7.setLayout(new BorderLayout());
            fieldPanel7.setOpaque(false);
            fieldPanel7.add(label7, BorderLayout.PAGE_START);
            fieldPanel7.add(comboBox7, BorderLayout.PAGE_END);
            fieldPanel7.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));
            glowPanel.add(fieldPanel7);
            
        JLabel label10 = new JLabel("Date Started:");
            label10.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label10.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label10.setAlignmentX(Component.LEFT_ALIGNMENT);
            label10.setOpaque(false);
            label10.setBackground(Color.red);
        JPanel dateField10 = new BetterPanel(170, 30, new Color(250, 250, 250), 10, 0.05f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField10 = new JFormattedTextField();
            formattedTextField10.setBorder(null);
            formattedTextField10.setOpaque(false);
            DatePicker datePicker10 = new DatePicker();
            datePicker10.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            datePicker10.now();
            datePicker10.setEditor(formattedTextField10);
            datePicker10.setCloseAfterSelected(true);
            datePicker10.setEditorValidation(false);
            datePicker10.setAnimationEnabled(false);
            dateField10.setLayout(new BorderLayout());
            dateField10.add(formattedTextField10, BorderLayout.CENTER);
            dateField10.add(formattedTextField10);
            dateField10.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 15));
        JPanel fieldPanel10 = new JPanel();
            fieldPanel10.setLayout(new BorderLayout());
            fieldPanel10.setOpaque(false);
            fieldPanel10.add(label10, BorderLayout.PAGE_START);
            fieldPanel10.add(dateField10, BorderLayout.PAGE_END);
            fieldPanel10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            glowPanel.add(fieldPanel10);
            
        JLabel label11 = new JLabel("Date Graduated:");
            label11.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label11.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label11.setAlignmentX(Component.LEFT_ALIGNMENT);
            label11.setOpaque(false);
            label11.setBackground(Color.red);
        JPanel dateField11 = new BetterPanel(170, 30, new Color(250, 250, 250), 10, 0.05f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField12 = new JFormattedTextField();
            formattedTextField12.setBorder(null);
            formattedTextField12.setOpaque(false);
            DatePicker datePicker11 = new DatePicker();
            datePicker11.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            datePicker11.now();
            datePicker11.setEditor(formattedTextField12);
            datePicker11.setCloseAfterSelected(true);
            datePicker11.setEditorValidation(false);
            datePicker11.setAnimationEnabled(false);
            dateField11.setLayout(new BorderLayout());
            dateField11.add(formattedTextField12, BorderLayout.CENTER);
            dateField11.add(formattedTextField12);
            dateField11.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 15));
        JPanel fieldPanel11 = new JPanel();
            fieldPanel11.setLayout(new BorderLayout());
            fieldPanel11.setOpaque(false);
            fieldPanel11.add(label11, BorderLayout.PAGE_START);
            fieldPanel11.add(dateField11, BorderLayout.PAGE_END);
            fieldPanel11.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            glowPanel.add(fieldPanel11);
        
        return glowPanel;
    }
    
    private JPanel createScheduleActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JLabel lblTitle = new javax.swing.JLabel();
            lblTitle.setFont(new java.awt.Font("Google Sans", 0, 20)); // NOI18N
            lblTitle.setText("Course Grades");
        
        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, getClass().getResource("/assets/icons/app (1).png").toString(), "Search");
        
        JPanel button1 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Filter Course");
            button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button1Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (1).png")));
            button1.add(button1Label);
            button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        actionsPanel.add(lblTitle);
        actionsPanel.add(Box.createHorizontalStrut(0));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        
        return actionsPanel;
    }
    
    private JPanel createScheduleGridPanel() {
        JPanel table = new JPanel();
        table.setOpaque(false);
        table.setLayout(new FlowLayout(FlowLayout.LEFT));
        table.setPreferredSize(new Dimension(545, 500));
        
        table.add(createScheduleRecordPanel(1));
        table.add(createScheduleRecordPanel(2));
        table.add(createScheduleRecordPanel(3));
        table.add(createScheduleRecordPanel(4));
        table.add(createScheduleRecordPanel(5));
        table.add(createScheduleRecordPanel(5));
        table.add(createScheduleRecordPanel(5));
        table.add(createScheduleRecordPanel(5));
        
        return table;
    }

    private JPanel createScheduleRecordPanel(int a) {
        JPanel recordPanel = new BetterPanel(240, 70, Color.WHITE, 10, 0.05f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(120, 73));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText("<html>Interdisiplinaryong Pagbasa at Pagsulat<html>");
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel column2 = new JLabel();
        column2.setPreferredSize(new Dimension(55, 73));
        column2.setFont(new Font("Google Sans Medium", Font.PLAIN, 15));
        column2.setOpaque(false);
        column2.setBackground(new Color(250, 250, 250));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("5.00");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        
        boolean result = Math.random() < 0.5;
        JPanel column3 = new BetterPanel(40, 20, result ? new Color(255, 200, 200) : new Color(174, 226, 200), 15, 0.5f);
        column3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel column3Label = new JLabel();
        column3Label.setText(result ? "Failed" : "Passed");
        column3Label.setFont(new Font("Google Sans", Font.PLAIN, 9));
        column3Label.setBorder(BorderFactory.createEmptyBorder(6, 10, 10, 10));
        column3.add(column3Label);
        
        
        recordPanel.add(column1);
        recordPanel.add(column2);
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

        lblStudents = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 120));
        setMaximumSize(new java.awt.Dimension(1030, 720));
        setMinimumSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStudents.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblStudents.setText("Subjects List");
        add(lblStudents);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStudents;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatClientProperties;
import database.DBDelete;
import database.DBReadMd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import models.Course;
import models.Employee;
import models.Grades;
import models.Student;
import models.Subject;
import raven.datetime.component.date.DatePicker;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import utils.StaticVars;
import views.components.BetterPanel;
import views.components.BetterTextField;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public class EmployeesInfo extends javax.swing.JPanel {
    public JLabel lblIconLabel;
    public JTextField txfFirstName; 
    public JTextField txfLastName; 
    public JTextField txfEmail; 
    public JTextField txfAddress; 
    public JTextField txfPhoneNumber; 

    public JComboBox<String> cbxSex; 
    public JComboBox<String> cbxStatus;

    public DatePicker dtpBirthday; 
    public DatePicker dtpStarted; 
    public DatePicker dtpResigned; 
    
    
    public Employee selectedEmployee;
    
    public void refreshView() {
        if (selectedEmployee != null) {
            lblIconLabel.setText((String.valueOf(selectedEmployee.getLastname().charAt(0)) + String.valueOf(selectedEmployee.getFirstname().charAt(0))).toUpperCase());
            txfFirstName.setText(selectedEmployee.getFirstname());
            txfLastName.setText(selectedEmployee.getLastname());
            txfAddress.setText(selectedEmployee.getAddress());
            txfEmail.setText(selectedEmployee.getEmail());
            txfPhoneNumber.setText(String.valueOf(selectedEmployee.getCpNum()));
            
            cbxSex.setSelectedIndex("M".equals(selectedEmployee.getGender()) ? 0 : 1);
            cbxStatus.setSelectedIndex("A".equals(selectedEmployee.getStatus()) ? 0 : 1);
            System.out.println(selectedEmployee.getBday());
            
            if (selectedEmployee.getBday() != null) dtpBirthday.setSelectedDate(new java.sql.Date(selectedEmployee.getBday().getTime()).toLocalDate());
            if (selectedEmployee.getDateStarted() != null) dtpStarted.setSelectedDate(new java.sql.Date(selectedEmployee.getDateStarted().getTime()).toLocalDate());
            if (selectedEmployee.getDateResigned()!= null) dtpResigned.setSelectedDate(new java.sql.Date(selectedEmployee.getDateResigned().getTime()).toLocalDate());

        } else {
            System.out.println("Clearing");
            
            lblIconLabel.setText("X");
            txfFirstName.setText("");
            txfLastName.setText("");
            txfAddress.setText("");
            txfEmail.setText("");
            txfPhoneNumber.setText("");
            
            cbxSex.setSelectedIndex(-1);
            cbxStatus.setSelectedIndex(-1);
            
            dtpBirthday.clearSelectedDate();
            dtpStarted.clearSelectedDate();
            dtpResigned.clearSelectedDate();
        }
    }
    
    /**
     * Creates new form EmployeesInfo
     */
    public EmployeesInfo() {
        initComponents();
        
        add(createActionsPanel());
        add(createInfoPanel());
//        add(createSearchPanel());
//        add(createTablePanel());
    }
    
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        actionsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        
        JLabel lblTitle = new javax.swing.JLabel();
        lblTitle.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblTitle.setText("Employee Information");
        
        JLabel lblBack = new javax.swing.JLabel();
        lblBack.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (2).png"))); // NOI18N
        lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hello");
                ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empListPanel");
            }
         });
        
        JPanel button1 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        JPanel button2 = new BetterPanel(115, 30, new Color(255, 201, 207), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Save Changes");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (1).png")));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String firstName = txfFirstName.getText();
                String lastName = txfLastName.getText();
                String address = txfAddress.getText();
                String email = txfEmail.getText();
                String phoneNumber = txfPhoneNumber.getText();

                char sex = cbxSex.getSelectedIndex() == 0 ? 'M' : 'F';
                String status = cbxStatus.getSelectedIndex() == 0 ? "A" : "I";
                
                Date bday = Date.from(dtpBirthday.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dateStarted = Date.from(dtpStarted.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dateResigned = Date.from(dtpResigned.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                
                if (selectedEmployee != null) {
//                    DBUpdate.updateStudent(studentNumber, 
//                        lastName, 
//                        firstName, 
//                        email, 
//                        sex , 
//                        courseCode,
//                        phoneNumber, 
//                        address, 
//                        bday,
//                        status, 
//                        dateStarted, 
//                        dateGraduated);
                
                } else {
//                    DBAdd.addStudent(studentNumber, 
//                        lastName, 
//                        firstName, 
//                        email, 
//                        sex , 
//                        courseCode,
//                        phoneNumber, 
//                        address, 
//                        bday,
//                        status, 
//                        dateStarted, 
//                        dateGraduated);
                }
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "Data has been successfully saved to the database", 
                            "Success", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                
            }
         });
        
        JLabel button2Label = new JLabel("Delete Student");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (1).png")));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedEmployee == null) {
                    final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "You can't delete this employee as it hasn't"
                                    + "\nbeen added to the database yet.", 
                            "Invalid Action", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                } else {
                    final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR, 
                            "Are you sure you want to employee this student?"
                                    + "\nThis action is irreversible", 
                            "Delete Employee", SimpleModalBorder.YES_NO_OPTION, (controller, action) -> {
                        if (action == SimpleModalBorder.YES_OPTION) {
//                            DBDelete.deleteStudent(String.valueOf(selectedStudent.getStudentNo()));
                            ViewEmployees.empListPanel.refreshData(false);
                            ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empListPanel");
                        }
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                }
                
            }
         });

        actionsPanel.add(lblBack);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(lblTitle);
        actionsPanel.add(Box.createHorizontalStrut(270));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private JPanel createInfoPanel() {
        JPanel glowPanel = new BetterPanel(770, 260, new Color(250, 250, 250), 30, 0.2f);
        glowPanel.setLayout(null);
        glowPanel.setOpaque(false);
        
        
        
        Random rand = new Random();
        int r = rand.nextInt(156) + 100; 
        int g = rand.nextInt(156) + 100; 
        int b = rand.nextInt(156) + 100;
        Color randomDarkColor = new Color(r, g, b);

       JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                 super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int diameter = Math.min(getWidth(), getHeight());  
                g2d.setColor(randomDarkColor);
                g2d.fillOval(0, 0, diameter, diameter); 
            }
        };

        circlePanel.setOpaque(false);
        circlePanel.setPreferredSize(new Dimension(120, 120));
        circlePanel.setBounds(40, 30, 120, 120); 
        circlePanel.setLayout(new BorderLayout());

        lblIconLabel = new JLabel("X", SwingConstants.CENTER);
        lblIconLabel.setFont(new Font("Google Sans Medium", Font.BOLD, 40));
        lblIconLabel.setForeground(Color.BLACK);
        circlePanel.add(lblIconLabel);
        glowPanel.add(circlePanel);
        
        JPanel forms = new JPanel();
        forms.setBackground(Color.RED);
        forms.setOpaque(false);
        forms.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        forms.setBounds(180, 25, 570, 215); 
        glowPanel.add(forms);
        
        JLabel label2 = new JLabel("First Name:");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        BetterTextField betterTextField2 = new BetterTextField(
            190, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField2.setOpaque(false);
            txfFirstName = betterTextField2.textField;
            txfFirstName.setForeground(Color.black);
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(betterTextField2, BorderLayout.PAGE_END);
            forms.add(fieldPanel2);
            
        JLabel label3 = new JLabel("Last Name:");
            label3.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label3.setAlignmentX(Component.LEFT_ALIGNMENT);
            label3.setOpaque(false);
            label3.setBackground(Color.red);
        BetterTextField betterTextField3 = new BetterTextField(
            190, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField3.setOpaque(false);
            txfLastName = betterTextField3.textField;
            txfLastName.setForeground(Color.black);
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(betterTextField3, BorderLayout.PAGE_END);
            forms.add(fieldPanel3); 
            
        JLabel label5 = new JLabel("Email:");
            label5.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label5.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label5.setAlignmentX(Component.LEFT_ALIGNMENT);
            label5.setOpaque(false);
            label5.setBackground(Color.red);
        BetterTextField betterTextField5 = new BetterTextField(
            140, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField5.setOpaque(false);
            txfEmail = betterTextField5.textField;
            txfEmail.setForeground(Color.black);
        JPanel fieldPanel5 = new JPanel();
            fieldPanel5.setLayout(new BorderLayout());
            fieldPanel5.setOpaque(false);
            fieldPanel5.add(label5, BorderLayout.PAGE_START);
            fieldPanel5.add(betterTextField5, BorderLayout.PAGE_END);
            forms.add(fieldPanel5);
            
        JLabel label4 = new JLabel("Address:");
            label4.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label4.setAlignmentX(Component.LEFT_ALIGNMENT);
            label4.setOpaque(false);
            label4.setBackground(Color.red);
        BetterTextField betterTextField4 = new BetterTextField(
            390, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField4.setOpaque(false);
            txfAddress = betterTextField4.textField;
            txfAddress.setForeground(Color.black);
        JPanel fieldPanel4 = new JPanel();
            fieldPanel4.setLayout(new BorderLayout());
            fieldPanel4.setOpaque(false);
            fieldPanel4.add(label4, BorderLayout.PAGE_START);
            fieldPanel4.add(betterTextField4, BorderLayout.PAGE_END);
            forms.add(fieldPanel4);
               
        JLabel label12 = new JLabel("Phone Number:");
            label12.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label12.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label12.setAlignmentX(Component.LEFT_ALIGNMENT);
            label12.setOpaque(false);
            label12.setBackground(Color.red);
        BetterTextField betterTextField12 = new BetterTextField(
            140, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField12.setOpaque(false);
            txfPhoneNumber = betterTextField12.textField;
            txfPhoneNumber.setForeground(Color.black);
        JPanel fieldPanel12 = new JPanel();
            fieldPanel12.setLayout(new BorderLayout());
            fieldPanel12.setOpaque(false);
            fieldPanel12.add(label12, BorderLayout.PAGE_START);
            fieldPanel12.add(betterTextField12, BorderLayout.PAGE_END);
            forms.add(fieldPanel12);
            
        UIManager.put("ComboBox.buttonBackground", new Color(224, 224, 224));
        UIManager.put("ComboBox.buttonHoverArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonPressedArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonArrowColor", Color.gray);
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("Component.focusedBorderColor", new Color(217, 217, 217));
        JLabel label6 = new JLabel("Gender:");
            label6.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
            label6.setAlignmentX(Component.LEFT_ALIGNMENT);
            label6.setOpaque(false);
            label6.setBackground(Color.red);
        cbxSex = new JComboBox();
            cbxSex.addItem("Male");
            cbxSex.addItem("Female");
            cbxSex.setPreferredSize(new Dimension(265, 30));
        JPanel fieldPanel6 = new JPanel();
            fieldPanel6.setLayout(new BorderLayout());
            fieldPanel6.setOpaque(false);
            fieldPanel6.add(label6, BorderLayout.PAGE_START);
            fieldPanel6.add(cbxSex, BorderLayout.PAGE_END);
            fieldPanel6.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            forms.add(fieldPanel6);
            
        JLabel label7 = new JLabel("Status:");
            label7.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
            label7.setAlignmentX(Component.LEFT_ALIGNMENT);
            label7.setOpaque(false);
            label7.setBackground(Color.red);
        cbxStatus = new JComboBox();
            cbxStatus.addItem("Active");
            cbxStatus.addItem("Inactive");
            cbxStatus.setPreferredSize(new Dimension(265, 30));
        JPanel fieldPanel7 = new JPanel();
            fieldPanel7.setLayout(new BorderLayout());
            fieldPanel7.setOpaque(false);
            fieldPanel7.add(label7, BorderLayout.PAGE_START);
            fieldPanel7.add(cbxStatus, BorderLayout.PAGE_END);
            fieldPanel7.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));
            forms.add(fieldPanel7);
            
        JLabel label9 = new JLabel("Birthday:");
            label9.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label9.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label9.setAlignmentX(Component.LEFT_ALIGNMENT);
            label9.setOpaque(false);
            label9.setBackground(Color.red);
        JPanel dateField9 = new BetterPanel(170, 28, new Color(250, 250, 250), 10, 0.2f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField9 = new JFormattedTextField();
            formattedTextField9.setBorder(null);
            formattedTextField9.setOpaque(false);
            dtpBirthday = new DatePicker();
            dtpBirthday.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            dtpBirthday.now();
            dtpBirthday.setEditor(formattedTextField9);
            dtpBirthday.setCloseAfterSelected(true);
            dtpBirthday.setEditorValidation(false);
            dtpBirthday.setAnimationEnabled(false);
            dateField9.setLayout(new BorderLayout());
            dateField9.add(formattedTextField9, BorderLayout.CENTER);
            dateField9.add(formattedTextField9);
            dateField9.setBorder(BorderFactory.createEmptyBorder(2, 15, 0, 15));
        JPanel fieldPanel9 = new JPanel();
            fieldPanel9.setLayout(new BorderLayout());
            fieldPanel9.setOpaque(false);
            fieldPanel9.add(label9, BorderLayout.PAGE_START);
            fieldPanel9.add(dateField9, BorderLayout.PAGE_END);
            fieldPanel9.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            forms.add(fieldPanel9);
            
        JLabel label10 = new JLabel("Date Started:");
            label10.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label10.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label10.setAlignmentX(Component.LEFT_ALIGNMENT);
            label10.setOpaque(false);
            label10.setBackground(Color.red);
        JPanel dateField10 = new BetterPanel(170, 28, new Color(250, 250, 250), 10, 0.2f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField10 = new JFormattedTextField();
            formattedTextField10.setBorder(null);
            formattedTextField10.setOpaque(false);
            dtpStarted = new DatePicker();
            dtpStarted.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            dtpStarted.now();
            dtpStarted.setEditor(formattedTextField10);
            dtpStarted.setCloseAfterSelected(true);
            dtpStarted.setEditorValidation(false);
            dtpStarted.setAnimationEnabled(false);
            dateField10.setLayout(new BorderLayout());
            dateField10.add(formattedTextField10, BorderLayout.CENTER);
            dateField10.add(formattedTextField10);
            dateField10.setBorder(BorderFactory.createEmptyBorder(2, 15, 0, 15));
        JPanel fieldPanel10 = new JPanel();
            fieldPanel10.setLayout(new BorderLayout());
            fieldPanel10.setOpaque(false);
            fieldPanel10.add(label10, BorderLayout.PAGE_START);
            fieldPanel10.add(dateField10, BorderLayout.PAGE_END);
            fieldPanel10.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            forms.add(fieldPanel10);
            
        JLabel label11 = new JLabel("Date Resigned:");
            label11.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label11.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label11.setAlignmentX(Component.LEFT_ALIGNMENT);
            label11.setOpaque(false);
            label11.setBackground(Color.red);
        JPanel dateField11 = new BetterPanel(168, 28, new Color(250, 250, 250), 10, 0.2f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField12 = new JFormattedTextField();
            formattedTextField12.setBorder(null);
            formattedTextField12.setOpaque(false);
            dtpResigned = new DatePicker();
            dtpResigned.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            dtpResigned.now();
            dtpResigned.setEditor(formattedTextField12);
            dtpResigned.setCloseAfterSelected(true);
            dtpResigned.setEditorValidation(false);
            dtpResigned.setAnimationEnabled(false);
            dateField11.setLayout(new BorderLayout());
            dateField11.add(formattedTextField12, BorderLayout.CENTER);
            dateField11.add(formattedTextField12);
            dateField11.setBorder(BorderFactory.createEmptyBorder(2, 15, 0, 15));
        JPanel fieldPanel11 = new JPanel();
            fieldPanel11.setLayout(new BorderLayout());
            fieldPanel11.setOpaque(false);
            fieldPanel11.add(label11, BorderLayout.PAGE_START);
            fieldPanel11.add(dateField11, BorderLayout.PAGE_END);
            fieldPanel11.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            forms.add(fieldPanel11);
        
        return glowPanel;
    }
    
    private JPanel createSearchPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JLabel lblTitle = new javax.swing.JLabel();
        lblTitle.setFont(new java.awt.Font("Google Sans", 0, 20)); // NOI18N
        lblTitle.setText("Course Schedule");
        
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
        actionsPanel.add(Box.createHorizontalStrut(240));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        
        return actionsPanel;
    }
    
    private JScrollPane createTablePanel() {
        JPanel gridPanel = new JPanel();
        gridPanel.setOpaque(false);
        gridPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JScrollPane scrollPane = new JScrollPane(gridPanel);
            scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setPreferredSize(new Dimension(820, 250));
            scrollPane.setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrollPane.getViewport().setOpaque(false);
            
        gridPanel.add(createGradesRecord(1));
        gridPanel.add(createGradesRecord(2));
        gridPanel.add(createGradesRecord(3));
        gridPanel.add(createGradesRecord(4));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        gridPanel.add(createGradesRecord(5));
        
        gridPanel.setPreferredSize(new Dimension(800, (gridPanel.getComponentCount() * (70 + 17)) / 3));
        SwingUtilities.invokeLater(() -> {
            scrollPane.getViewport().setViewPosition(new Point(0, 0));
        });
        return scrollPane;
    }

    private JPanel createGradesRecord(int a) {
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
        column2.setPreferredSize(new Dimension(100, 73));
        column2.setFont(new Font("Google Sans Medium", Font.PLAIN, 15));
        column2.setOpaque(false);
        column2.setBackground(new Color(250, 250, 250));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("8:00AM");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        
        recordPanel.add(column1);
        recordPanel.add(column2);
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

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 120));
        setMaximumSize(new java.awt.Dimension(1030, 720));
        setMinimumSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

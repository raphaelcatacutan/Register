/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatClientProperties;
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
import java.util.List;
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
import models.Subject;
import raven.datetime.component.date.DatePicker;
import views.components.BetterPanel;
import views.components.BetterTextField;
import database.*;
import java.awt.ScrollPane;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JScrollPane;
import models.College;
import models.Course;
import models.Schedule;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import utils.StaticVars;
import views.components.NumericField;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public class SubjectsList extends javax.swing.JPanel {
    Subject selectedSubject;
    
    JPanel subjectListPanel;
    JPanel scheduleListPanel;
    
    JTextField txfSubjectCode;
    JTextField txfUnits;
    JTextField txfCurriculum;
    JTextField txfDescription;
    JComboBox cbxCollege;
    JComboBox cbxStatus;
    DatePicker dtpDateStarted;
    DatePicker dtpDateGraduated;
    public List<College> displayedColleges;
    
    public void refreshData() {
        List<Subject> subjects = DBReadMd.readSubjects();
        displayedColleges = DBReadMd.readColleges();
        cbxCollege.removeAllItems();
        for (College college: displayedColleges) {
            cbxCollege.addItem(college.getDescription());
        }
        subjectListPanel.removeAll();
        for (Subject subject: subjects) {
            subjectListPanel.add(createSubjectRecord(subject));
        }
        txfSubjectCode.setText("");
        txfUnits.setText("");
        txfCurriculum.setText("");
        txfDescription.setText("");
        cbxCollege.setSelectedIndex(-1);
        cbxStatus.setSelectedIndex(-1);

        dtpDateStarted.clearSelectedDate();
        dtpDateGraduated.clearSelectedDate();
        txfSubjectCode.setEnabled(true);
    }
    
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
        rightPanel.setOpaque(false);
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
        JPanel button3 = new BetterPanel(115, 30, new Color(250, 247, 227), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Clear Form");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txfSubjectCode.setText("");
                txfUnits.setText("");
                txfCurriculum.setText("");
                txfDescription.setText("");
                cbxCollege.setSelectedIndex(-1);
                cbxStatus.setSelectedIndex(-1);
                
                dtpDateStarted.clearSelectedDate();
                dtpDateGraduated.clearSelectedDate();
                txfSubjectCode.setEnabled(true);
            }
        });
        
        JLabel button2Label = new JLabel("Save Subject");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String subjectCode = txfSubjectCode.getText();
                int units = Integer.parseInt(txfUnits.getText());
                String curriculum = txfCurriculum.getText();
                String description = txfDescription.getText();
                String collegeCode = cbxCollege.getSelectedIndex() == -1 ? null : displayedColleges.get(cbxCollege.getSelectedIndex()).getCollegeCode();
                
                String status = cbxStatus.getSelectedIndex() == 0 ? "A" : "I";
                
                Date dateStarted = Date.from(dtpDateStarted.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dateGraduated = Date.from(dtpDateGraduated.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                
                if (!txfSubjectCode.isEnabled()) {
                    System.out.println("Updating");
                    DBUpdate.updateSubject(subjectCode, description, units, curriculum, collegeCode, status, dateStarted, dateGraduated);
                    
                } else {
                    System.out.println("Adding");
                    System.out.println(DBAdd.addSubject(subjectCode, description, units, curriculum, collegeCode, status, dateStarted, dateGraduated));
                }
                refreshData();
                
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "Data has been successfully saved to the database", 
                            "Success", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
            }
        });
        
        JLabel button3Label = new JLabel("Add Schedule");
        button3Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button3Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button3Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button3.add(button3Label);
        button3.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // cant add if there's no subject
                Subject subject = DBReadMd.readSubjectByCode(txfSubjectCode.getText());
                if (subject == null) return;
                ViewSubjects.subInfoPanel.selectedSchedule = null;
                ViewSubjects.subInfoPanel.selectedSubject = subject;
                ViewSubjects.subInfoPanel.refreshData();
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subInfoPanel");
            }
        });
        

        actionsPanel.add(Box.createHorizontalStrut(400));
//        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button3);
        
        
        return actionsPanel;
    }
    
    private JScrollPane createSubjectListPanel() {
        subjectListPanel = new JPanel();
        subjectListPanel.setOpaque(false);
        subjectListPanel.setLayout(new BoxLayout(subjectListPanel, BoxLayout.PAGE_AXIS));
        subjectListPanel.setPreferredSize(new Dimension(220, 570));
        
        JScrollPane scrlStudentList = new JScrollPane(subjectListPanel);
            scrlStudentList.getHorizontalScrollBar().setUnitIncrement(10);
            scrlStudentList.getVerticalScrollBar().setUnitIncrement(10);
            scrlStudentList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrlStudentList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrlStudentList.setPreferredSize(new Dimension(220, 500));
            scrlStudentList.setOpaque(false);
            scrlStudentList.setBorder(BorderFactory.createEmptyBorder());
            scrlStudentList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrlStudentList.getViewport().setOpaque(false);
            
        
        return scrlStudentList;
    }

    private JPanel createSubjectRecord(Subject subject) {
        JPanel recordPanel = new BetterPanel(200, 50, Color.WHITE, 10, 0.06f);
            recordPanel.setLayout(new BorderLayout(0, 0));
            recordPanel.setBorder(BorderFactory.createEmptyBorder(14, 15, 15, 15));
        
        JTextArea subjectLabel = new JTextArea(2, 20);
            subjectLabel.setText(subject.getDescription());
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
            public void mouseClicked(MouseEvent e) {
                College college = DBReadMd.readCollegeByCode(subject.getCollegeCode());
                
                txfSubjectCode.setText(subject.getSubjectCode());
                txfUnits.setText(String.valueOf(subject.getUnits()));
                txfCurriculum.setText(subject.getCurriculum());
                txfDescription.setText(subject.getDescription());
                cbxCollege.setSelectedItem(college.getDescription());
                cbxStatus.setSelectedItem("A".equals(subject.getStatus())? "Active": "Inactive");
                
                if (subject.getDateOpened() != null) dtpDateStarted.setSelectedDate(new java.sql.Date(subject.getDateOpened().getTime()).toLocalDate());
                if (subject.getDateClosed() != null) dtpDateGraduated.setSelectedDate(new java.sql.Date(subject.getDateClosed().getTime()).toLocalDate());
                txfSubjectCode.setEnabled(false);
                
                List<Schedule> schedules = DBReadMd.readSchedules();
                scheduleListPanel.removeAll();
                for (Schedule schedule: schedules) {
                    System.out.println(schedule.getSubjectCode() + " " + subject.getSubjectCode());
                    if (!schedule.getSubjectCode().equals(subject.getSubjectCode())) continue;
                    scheduleListPanel.add(createScheduleRecordPanel(schedule));
                    scheduleListPanel.revalidate(); 
                    scheduleListPanel.repaint(); 
                    System.out.println("Adding " + schedule.getSubjectCode());
                }
            }
        });
        
        subjectLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                College college = DBReadMd.readCollegeByCode(subject.getCollegeCode());
                
                txfSubjectCode.setText(subject.getSubjectCode());
                txfUnits.setText(String.valueOf(subject.getUnits()));
                txfCurriculum.setText(subject.getCurriculum());
                txfDescription.setText(subject.getDescription());
                cbxCollege.setSelectedItem(college.getDescription());
                cbxStatus.setSelectedItem("A".equals(subject.getStatus())? "Active": "Inactive");
                
                if (subject.getDateOpened() != null) dtpDateStarted.setSelectedDate(new java.sql.Date(subject.getDateOpened().getTime()).toLocalDate());
                if (subject.getDateClosed() != null) dtpDateGraduated.setSelectedDate(new java.sql.Date(subject.getDateClosed().getTime()).toLocalDate());
                txfSubjectCode.setEnabled(false);
                
                List<Schedule> schedules = DBReadMd.readSchedules();
                scheduleListPanel.removeAll();
                for (Schedule schedule: schedules) {
                    System.out.println(schedule.getSubjectCode() + " " + subject.getSubjectCode());
                    if (!schedule.getSubjectCode().equals(subject.getSubjectCode())) continue;
                    scheduleListPanel.add(createScheduleRecordPanel(schedule));
                    scheduleListPanel.revalidate(); 
                    scheduleListPanel.repaint(); 
                    System.out.println("Adding " + schedule.getSubjectCode());
                }
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
            230, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField1.setOpaque(false);
            txfSubjectCode = betterTextField1.textField;
            txfSubjectCode.setForeground(Color.black);
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
            txfUnits = betterTextField3.textField;
            txfUnits.setForeground(Color.black);
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(betterTextField3, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel3); 
            NumericField.makeNumericOnly(txfUnits);
            
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
            txfCurriculum = betterTextField4.textField;
            txfCurriculum.setForeground(Color.black);
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
            430, 30, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField2.setOpaque(false);
            txfDescription = betterTextField2.textField;
            txfDescription.setForeground(Color.black);
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
        
        JLabel label6 = new JLabel("College:");
            label6.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label6.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label6.setAlignmentX(Component.LEFT_ALIGNMENT);
            label6.setOpaque(false);
            label6.setBackground(Color.red);
        cbxCollege = new JComboBox();
            cbxCollege.addItem("Male");
            cbxCollege.addItem("Female");
            cbxCollege.setPreferredSize(new Dimension(300, 32));
        JPanel fieldPanel6 = new JPanel();
            fieldPanel6.setLayout(new BorderLayout());
            fieldPanel6.setOpaque(false);
            fieldPanel6.add(label6, BorderLayout.PAGE_START);
            fieldPanel6.add(cbxCollege, BorderLayout.PAGE_END);
            fieldPanel6.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel6);
            
        JLabel label7 = new JLabel("Status:");
            label7.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label7.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label7.setAlignmentX(Component.LEFT_ALIGNMENT);
            label7.setOpaque(false);
            label7.setBackground(Color.red);
        cbxStatus = new JComboBox();
            cbxStatus.addItem("Active");
            cbxStatus.addItem("Inactive");
            cbxStatus.setPreferredSize(new Dimension(125, 30));
        JPanel fieldPanel7 = new JPanel();
            fieldPanel7.setLayout(new BorderLayout());
            fieldPanel7.setOpaque(false);
            fieldPanel7.add(label7, BorderLayout.PAGE_START);
            fieldPanel7.add(cbxStatus, BorderLayout.PAGE_END);
            fieldPanel7.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));
            glowPanel.add(fieldPanel7);
            
        JLabel label10 = new JLabel("Date Started:");
            label10.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label10.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            label10.setAlignmentX(Component.LEFT_ALIGNMENT);
            label10.setOpaque(false);
            label10.setBackground(Color.red);
        JPanel dateField10 = new BetterPanel(185, 30, new Color(250, 250, 250), 10, 0.05f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField10 = new JFormattedTextField();
            formattedTextField10.setBorder(null);
            formattedTextField10.setOpaque(false);
            dtpDateStarted = new DatePicker();
            dtpDateStarted.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            dtpDateStarted.now();
            dtpDateStarted.setEditor(formattedTextField10);
            dtpDateStarted.setCloseAfterSelected(true);
            dtpDateStarted.setEditorValidation(false);
            dtpDateStarted.setAnimationEnabled(false);
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
        JPanel dateField11 = new BetterPanel(185, 30, new Color(250, 250, 250), 10, 0.05f, new Color(220, 220, 224));
            JFormattedTextField formattedTextField12 = new JFormattedTextField();
            formattedTextField12.setBorder(null);
            formattedTextField12.setOpaque(false);
            dtpDateGraduated = new DatePicker();
            dtpDateGraduated.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
            dtpDateGraduated.now();
            dtpDateGraduated.setEditor(formattedTextField12);
            dtpDateGraduated.setCloseAfterSelected(true);
            dtpDateGraduated.setEditorValidation(false);
            dtpDateGraduated.setAnimationEnabled(false);
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
            lblTitle.setText("Schedules");
        
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
//        actionsPanel.add(Box.createHorizontalStrut(0));
//        actionsPanel.add(searchPanel);
//        actionsPanel.add(Box.createHorizontalStrut(5));
//        actionsPanel.add(button1);
        
        return actionsPanel;
    }
    
    private JPanel createScheduleGridPanel() {
        scheduleListPanel = new JPanel();
        scheduleListPanel.setOpaque(false);
        scheduleListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        scheduleListPanel.setPreferredSize(new Dimension(545, 200));
        
        return scheduleListPanel;
    }

    private JPanel createScheduleRecordPanel(Schedule schedule) {
        JPanel schedulePanel = new BetterPanel(240, 35, Color.WHITE, 10, 0.05f);
        schedulePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        System.out.println(schedule.getBlockNo());
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(240, 35));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText("<html>" + schedule.getRoom() + " - " + schedule.getTime() + " " + schedule.getDay()+ "</html>");
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        schedulePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewSubjects.subInfoPanel.selectedSchedule = schedule;
                ViewSubjects.subInfoPanel.refreshData();
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subInfoPanel");
            }
        });
        
        schedulePanel.add(column1);
        schedulePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        return schedulePanel;
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

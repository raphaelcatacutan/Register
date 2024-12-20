/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatClientProperties;
import database.DBReadMd;
import database.DBUpdate;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.*;
import models.Grades;
import models.Schedule;
import models.SchoolYear;
import models.Semester;
import models.Student;
import models.Subject;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public final class ViewGrading extends javax.swing.JPanel {
    JScrollPane scrlStudentList;
    JPanel grdStudentsList;
    JComboBox cbxSchoolYear;
    JComboBox cbxSemester;
    JComboBox cbxBlockNo;
    JComboBox cbxSubject;
    
    /**
     * Creates new form NewJPanel
     */
    public ViewGrading() {
        initComponents();   
        
        add(createComboBoxes());
//        add(createActionsPanel());
        add(createTablePanel());
    }
    
    public void refreshComboBox() {
        List<SchoolYear> schoolYears = DBReadMd.readSchoolYears();
        List<Semester> semesters = DBReadMd.readSemesters();

        cbxSchoolYear.removeAllItems();
        for (SchoolYear schoolYear: schoolYears) {
            cbxSchoolYear.addItem(schoolYear.getSyear());
        }

        cbxSemester.removeAllItems();
        for (Semester semester: semesters) {
            cbxSemester.addItem(semester.getSemester());
        }  
    }
    
    public void refreshData() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                List<Grades> grades = DBReadMd.readGrades(); 
                List<JPanel> gradesPanels = new ArrayList<>(); 
                
                for (Grades grade : grades) {
                    Student student = DBReadMd.readStudentById(grade.getStudentNo());
                    Subject subject = DBReadMd.readSubjectByCode((String) cbxSubject.getSelectedItem());
                    
                    if ((grade.getSyear() == null ? (String) cbxSchoolYear.getSelectedItem() != null : !grade.getSyear().equals((String) cbxSchoolYear.getSelectedItem())) ||
                            (grade.getSemester() == null ? (String) cbxSemester.getSelectedItem() != null : !grade.getSemester().equals((String) cbxSemester.getSelectedItem())) ||
                            (grade.getSubjectCode() == null ? subject.getSubjectCode() != null : !grade.getSubjectCode().equals(subject.getSubjectCode())) ||
                            (grade.getBlockNo() == null ? (String) cbxBlockNo.getSelectedItem() != null : !grade.getBlockNo().equals((String) cbxBlockNo.getSelectedItem()))) continue;
                    JPanel panel = createGradingRecord(grade, student.getLastname(), student.getFirstname());
                    gradesPanels.add(panel);  
                }

                grdStudentsList.removeAll();
                for (JPanel gradesPanel: gradesPanels) grdStudentsList.add(gradesPanel);
                grdStudentsList.setPreferredSize(new Dimension(800, (gradesPanels.size() * (50 + 28))));

                SwingUtilities.invokeLater(() -> {
                    scrlStudentList.getViewport().setViewPosition(new Point(0, 0));
                });

                return null;
            }
            
            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    grdStudentsList.revalidate(); 
                    grdStudentsList.repaint(); 
                });
            }
        };

        worker.execute();
    }
 
    public JPanel createComboBoxes() {
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
        cbxSchoolYear = new JComboBox();
            cbxSchoolYear.setPreferredSize(new Dimension(190, 30));
        JPanel fieldPanel1 = new JPanel();
            fieldPanel1.setLayout(new BorderLayout());
            fieldPanel1.setOpaque(false);
            fieldPanel1.add(label1, BorderLayout.PAGE_START);
            fieldPanel1.add(cbxSchoolYear, BorderLayout.PAGE_END);
            fieldPanel1.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel1);
            cbxSchoolYear.setSelectedIndex(-1);
            cbxSchoolYear.addActionListener(e -> {
                cbxSubject.removeAllItems();
                cbxBlockNo.removeAllItems();
                
                List<Schedule> schedules = DBReadMd.readSchedules();
                List<String> subjectCodes = new ArrayList<>();
                
                for (Schedule sched: schedules) {
                    if ((sched.getSemester() == null ? (String) cbxSemester.getSelectedItem() != null : !sched.getSemester().equals((String) cbxSemester.getSelectedItem())) || 
                            (sched.getSyear() == null ? (String) cbxSchoolYear.getSelectedItem() != null : !sched.getSyear().equals((String) cbxSchoolYear.getSelectedItem()))) continue;
                    Subject subject = DBReadMd.readSubjectByCode(sched.getSubjectCode());
                    if (subjectCodes.contains(subject.getSubjectCode())) continue;
                    cbxSubject.addItem(subject.getSubjectCode());
                    subjectCodes.add(subject.getSubjectCode());
                }
            });
            
        JLabel label2 = new JLabel("Semester");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        cbxSemester = new JComboBox();
            cbxSemester.setPreferredSize(new Dimension(190, 30));
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(cbxSemester, BorderLayout.PAGE_END);
            fieldPanel2.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            cbxSemester.setSelectedIndex(-1);
            comboBoxes.add(fieldPanel2);
            cbxSemester.addActionListener(e -> {
                cbxSubject.removeAllItems();
                cbxBlockNo.removeAllItems();
                
                List<Schedule> schedules = DBReadMd.readSchedules();
                List<String> subjectCodes = new ArrayList<>();
                
                for (Schedule sched: schedules) {
                    if ((sched.getSemester() == null ? (String) cbxSemester.getSelectedItem() != null : !sched.getSemester().equals((String) cbxSemester.getSelectedItem())) || 
                            (sched.getSyear() == null ? (String) cbxSchoolYear.getSelectedItem() != null : !sched.getSyear().equals((String) cbxSchoolYear.getSelectedItem()))) continue;
                    Subject subject = DBReadMd.readSubjectByCode(sched.getSubjectCode());
                    if (subjectCodes.contains(subject.getSubjectCode())) continue;
                    cbxSubject.addItem(subject.getSubjectCode());
                    subjectCodes.add(subject.getSubjectCode());
                }
            });
            
        JLabel label3 = new JLabel("Subject");
            label3.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label3.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label3.setAlignmentX(Component.LEFT_ALIGNMENT);
            label3.setOpaque(false);
            label3.setBackground(Color.red);
        cbxSubject = new JComboBox();
            cbxSubject.setPreferredSize(new Dimension(190, 30));
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(cbxSubject, BorderLayout.PAGE_END);
            fieldPanel3.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel3);
            cbxSubject.addActionListener(e -> {
                cbxBlockNo.removeAllItems();
                
                List<Schedule> schedules = DBReadMd.readSchedules();
                Subject subject = DBReadMd.readSubjectByCode((String) cbxSubject.getSelectedItem());
                
                for (Schedule sched: schedules) {
                    if (sched.getSubjectCode() == null ? subject.getSubjectCode() != null : !sched.getSubjectCode().equals(subject.getSubjectCode())) continue;
                    cbxBlockNo.addItem(sched.getBlockNo());
                }
            });
            
        JLabel label4 = new JLabel("Block Sequence");
            label4.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label4.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label4.setAlignmentX(Component.LEFT_ALIGNMENT);
            label4.setOpaque(false);
            label4.setBackground(Color.red);
        cbxBlockNo = new JComboBox();
            cbxBlockNo.setPreferredSize(new Dimension(190, 30));
        JPanel fieldPanel4 = new JPanel();
            fieldPanel4.setLayout(new BorderLayout());
            fieldPanel4.setOpaque(false);
            fieldPanel4.add(label4, BorderLayout.PAGE_START);
            fieldPanel4.add(cbxBlockNo, BorderLayout.PAGE_END);
            fieldPanel4.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            comboBoxes.add(Box.createHorizontalStrut(5));
            comboBoxes.add(fieldPanel4);
            cbxBlockNo.addActionListener(e -> {
                refreshData();
            });
            
                
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        JLabel button2Label = new JLabel("Save Changes");
            button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
            button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
            button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
            button2.add(button2Label);
            button2.setBorder(BorderFactory.createEmptyBorder(12, 10, 10, 10));
            button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//            comboBoxes.add(Box.createHorizontalStrut(15));
//            comboBoxes.add(button2);
        
        return comboBoxes;
    }
    
    // UI
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, "C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png", "Search");
        
        JPanel button1 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Search Student");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
        actionsPanel.add(Box.createHorizontalStrut(310));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        
        return actionsPanel;
    }
    
    private JScrollPane createTablePanel() {
        grdStudentsList = new JPanel();
        grdStudentsList.setOpaque(false);
        grdStudentsList.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Titles
        JPanel title = new BetterPanel(820, 30, new Color(250, 247, 227), 10, 0.2f);
            title.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel column1 = new JLabel();
            column1.setPreferredSize(new Dimension(500, 33));
            column1.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
            column1.setOpaque(false);
            column1.setBackground(new Color(205, 220, 220));
            column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
            column1.setText("Course");
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

            add(title);
        
        scrlStudentList = new JScrollPane(grdStudentsList);
            scrlStudentList.getHorizontalScrollBar().setUnitIncrement(10);
            scrlStudentList.getVerticalScrollBar().setUnitIncrement(10);
            scrlStudentList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrlStudentList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrlStudentList.setPreferredSize(new Dimension(820, 480));
            scrlStudentList.setOpaque(false);
            scrlStudentList.setBorder(BorderFactory.createEmptyBorder());
            scrlStudentList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrlStudentList.getViewport().setOpaque(false);
        
        grdStudentsList.setPreferredSize(new Dimension(800, (grdStudentsList.getComponentCount() * (50 + 17))));
        SwingUtilities.invokeLater(() -> {
            scrlStudentList.getViewport().setViewPosition( new Point(0, 0) );
        });
        
        return scrlStudentList;
    }
    
    private JPanel createGradingRecord(Grades grade, String lastName, String firstName) {
        JPanel recordPanel = new BetterPanel(790, 50, Color.WHITE, 10, 0.05f);
        recordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        recordPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        
        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(485, 53));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 14));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 30, 10, 10));
        column1.setText(lastName + ", " + firstName);
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        
        double gradeValue = grade.getGrade();
        
        JComboBox column2 = new JComboBox();
            column2.addItem("1.00");
            column2.addItem("1.25");
            column2.addItem("1.50");
            column2.addItem("1.75");
            column2.addItem("2.00");
            column2.addItem("2.25");
            column2.addItem("2.50");
            column2.addItem("2.75");
            column2.addItem("3.00");
            column2.addItem("5.00");
            column2.setPreferredSize(new Dimension(150, 30));
            column2.setSelectedItem(String.valueOf(gradeValue));
            column2.addActionListener(e -> {
                System.out.println("Updating");
                DBUpdate.updateGrades(
                        grade.getGradeId(), 
                        grade.getSemester(), 
                        grade.getSubjectCode(),
                        grade.getBlockNo(), 
                        Double.parseDouble((String) column2.getSelectedItem()));
            });
            
        JPanel separator = new JPanel();
            separator.setPreferredSize(new Dimension(40, 20));
            separator.setOpaque(false);
        
        recordPanel.add(column1);
        recordPanel.add(column2);
        recordPanel.add(separator);
        
        if (gradeValue > 0) {
            boolean result = gradeValue > 3.00;
            JPanel column3 = new BetterPanel(55, 20, result ? new Color(255, 200, 200) : new Color(174, 226, 200), 15, 0.5f);
            column3.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel column3Label = new JLabel();
            column3Label.setText(result ? "Failed" : "Passed");
            column3Label.setFont(new Font("Google Sans", Font.PLAIN, 11));
            column3Label.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
            column3.add(column3Label);
            recordPanel.add(column3);
        }
        
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
        lblDashboard.setText("Student Grading");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

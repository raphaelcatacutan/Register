/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatClientProperties;
import database.DBAdd;
import database.DBDelete;
import database.DBReadMd;
import database.DBUpdate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import models.College;
import models.Employee;
import models.Grades;
import models.Schedule;
import models.SchoolYear;
import models.Semester;
import models.Student;
import models.Subject;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import utils.StaticVars;
import views.components.BetterPanel;
import views.components.BetterTextField;
import views.components.NumericField;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public class SubjectsInfo extends javax.swing.JPanel {
    public Schedule selectedSchedule; 
    public Subject selectedSubject;
    
    JComboBox cbxYear;
    JComboBox cbxSemester;
    JComboBox cbxEmployee;
    JComboBox cbxCollege;
    JComboBox cbxType;
    JComboBox cbxDay;
    JTextField txfBlockNumber;
    JTextField txfTime;
    JTextField txfRoom;
    JTextField txfSeq;
    
    JPanel studentListPanel;
    
    List<Employee> listedEmployee;
    List<College> listedCollege;
    List<Student> listedStudents;
    List<SchoolYear> listedSchoolYear;
    List<Semester> listedSemester;
    List<Grades> listedGrades;
    
    public void refreshData() {
        listedEmployee = DBReadMd.readEmployees();
        listedCollege = DBReadMd.readColleges();
        listedStudents = DBReadMd.readStudents();
        listedSchoolYear = DBReadMd.readSchoolYears();
        listedSemester = DBReadMd.readSemesters();
        listedGrades = DBReadMd.readGrades();
        
        cbxEmployee.removeAllItems();
        cbxCollege.removeAllItems();
        cbxYear.removeAllItems();
        cbxSemester.removeAllItems();
        for (Employee employee: listedEmployee) cbxEmployee.addItem(employee.getLastname() + ", " + employee.getFirstname());
        for (College college: listedCollege) cbxCollege.addItem(college.getDescription());
        for (Semester semester: listedSemester) cbxSemester.addItem(semester.getSemester());
        for (SchoolYear year: listedSchoolYear) cbxYear.addItem(year.getSyear());
        if (selectedSchedule != null ){
            Employee employee = DBReadMd.readEmployeeById(selectedSchedule.getEmployeeId());
            College college = DBReadMd.readCollegeByCode(selectedSchedule.getCollegeCode());
            
            cbxYear.setSelectedItem(selectedSchedule.getSyear());
            cbxSemester.setSelectedItem(selectedSchedule.getSemester());
            cbxEmployee.setSelectedItem(employee.getLastname() + ", " + employee.getFirstname());
            cbxCollege.setSelectedItem(college.getDescription());
            cbxType.setSelectedItem(selectedSchedule.getType());
            cbxDay.setSelectedItem(selectedSchedule.getDay());
            txfBlockNumber.setText(selectedSchedule.getBlockNo());
            txfTime.setText(selectedSchedule.getTime());
            txfRoom.setText(selectedSchedule.getRoom());
            txfSeq.setText(String.valueOf(selectedSchedule.getSequenceNo()));
        } else {
            cbxYear.setSelectedItem(-1);
            cbxSemester.setSelectedItem(-1);
            cbxEmployee.setSelectedItem(-1);
            cbxCollege.setSelectedItem(-1);
            cbxType.setSelectedItem(-1);
            cbxDay.setSelectedItem(-1);
            txfBlockNumber.setText("");
            txfTime.setText("");
            txfRoom.setText("");
            txfSeq.setText("");
        }
        studentListPanel.removeAll();
        
        for (Student student: listedStudents) {
            boolean isCheck = false;
            for (Grades grade: listedGrades) {
                if (selectedSchedule == null) break;
                if (selectedSchedule.getBlockNo() == null ? grade.getBlockNo() != null : !selectedSchedule.getBlockNo().equals(grade.getBlockNo())) continue;
                if (!Objects.equals(grade.getStudentNo(), student.getStudentNo())) continue;
                isCheck = true;
                break;
            }
            studentListPanel.add(createStudent(student, isCheck));
            studentListPanel.add(Box.createVerticalStrut(5));
        }
    }
    /**
     * Creates new form StudentsList
     */
    public SubjectsInfo() {
        initComponents();
        
        add(createActionsPanel());
        add(createInfoPanel());
        add(createEnrollPanel());
    }
    
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
            actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
            actionsPanel.setOpaque(false);
            actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        JLabel lblTitle = new javax.swing.JLabel();
        lblTitle.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblTitle.setText("Schedule Information");
        
        JLabel lblBack = new javax.swing.JLabel();
        lblBack.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (2).png"))); // NOI18N
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subListPanel");
            }
         });
        lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
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
                String year = (String) cbxYear.getSelectedItem();
                String semester = (String) cbxSemester.getSelectedItem();
                String employee = listedEmployee.get(cbxEmployee.getSelectedIndex()).getEmployeeId();
                String collage = listedCollege.get(cbxCollege.getSelectedIndex()).getCollegeCode();
                String type = (String) cbxType.getSelectedItem();
                String day = (String) cbxDay.getSelectedItem();
                String blockNumber = txfBlockNumber.getText();
                String time = txfTime.getText();
                String room = txfRoom.getText();
                int seq = Integer.parseInt(txfSeq.getText());
                
                if (selectedSchedule != null) {
                    DBUpdate.updateSchedule(
                            selectedSchedule.getScheduleId(), 
                            semester, collage,  blockNumber, selectedSchedule.getSubjectCode(), 
                            day, time, room, type, seq, employee, year
                    );
                } else {
                    Subject subject = selectedSubject;
                    System.out.println(DBAdd.addSchedule(year, semester, collage, blockNumber,
                            subject.getSubjectCode(),
                            day, time, room, type, seq, employee));
                    
                    
                }
                
                
                // GRADES
                Component[] components = studentListPanel.getComponents();
                List<Grades> allGrades = DBReadMd.readGrades();
                int index = 0;
                for (Component c: components) {
                    JCheckBox checkBox;
                    try {
                        checkBox = (JCheckBox) c;
                    } catch (Exception i) {
                        continue;
                    }
                    String studentId = checkBox.getName();
                    System.out.println(studentId + " " + checkBox.getText());
                    boolean isSelected = checkBox.isSelected();
                    

                    Grades grade = null;
                    for (Grades gradei: allGrades) {
                        if (selectedSchedule == null) break;
                        if (gradei.getSyear() == null ? year != null : !gradei.getSyear().equals(year)) continue;
                        if (gradei.getSemester() == null ? semester != null : !gradei.getSemester().equals(semester)) continue;
                        if (gradei.getSubjectCode() == null ? selectedSchedule.getSubjectCode() != null : !gradei.getSubjectCode().equals(selectedSchedule.getSubjectCode())) continue;
                        if (String.valueOf(gradei.getStudentNo()) == null ? studentId != null : !String.valueOf(gradei.getStudentNo()).equals(studentId)) continue;
                        if (gradei.getBlockNo() == null ? blockNumber != null : !gradei.getBlockNo().equals(blockNumber)) continue;
                        grade = gradei;
                        break;
                    }
                    
                    
                    
                    if (isSelected) {
                        if (grade!= null) continue; // found in database already
                        DBAdd.addGrade(year, semester, Integer.parseInt(studentId), selectedSchedule.getSubjectCode(), blockNumber, 0.0);
                    } else {
                        if (grade == null) continue;
                        DBDelete.deleteGrades(grade.getGradeId());
                       
                    }
                    index++;
                }
                
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT, 
                            "Data has been successfully saved to the database", 
                            "Success", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                ViewSubjects.subListPanel.refreshData();
            }
        });
        
        JLabel button2Label = new JLabel("Delete Schedule");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (1).png")));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Delete `selectedStudent.getId`
                if (selectedSchedule == null) {
                    final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR, 
                            "You can't delete a data that hasn't been added to the database yet", 
                            "Invalid Action", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                    });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                    return;
                };
                DBDelete.deleteSchedule(selectedSchedule.getScheduleId());
                ViewSubjects.subListPanel.refreshData();
                ViewSubjects.viewSubjectsCardLayout.show(MainView.viewSubjects, "subListPanel");
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
        JPanel glowPanel = new BetterPanel(400, 550, new Color(250, 250, 250), 30, 0.2f);
            glowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            glowPanel.setOpaque(false); 
            glowPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            
        UIManager.put("ComboBox.buttonBackground", new Color(224, 224, 224));
        UIManager.put("ComboBox.buttonHoverArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonPressedArrowColor", Color.gray);
        UIManager.put("ComboBox.buttonArrowColor", Color.gray);
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("Component.focusedBorderColor", new Color(217, 217, 217));
        
        JLabel label6 = new JLabel("Year:");
            label6.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label6.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label6.setAlignmentX(Component.LEFT_ALIGNMENT);
            label6.setOpaque(false);
            label6.setBackground(Color.red);
        cbxYear = new JComboBox();
            cbxYear.setPreferredSize(new Dimension(165, 25));
        JPanel fieldPanel6 = new JPanel();
            fieldPanel6.setLayout(new BorderLayout());
            fieldPanel6.setOpaque(false);
            fieldPanel6.add(label6, BorderLayout.PAGE_START);
            fieldPanel6.add(cbxYear, BorderLayout.PAGE_END);
            fieldPanel6.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel6);
            
        JLabel label7 = new JLabel("Semester:");
            label7.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label7.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label7.setAlignmentX(Component.LEFT_ALIGNMENT);
            label7.setOpaque(false);
            label7.setBackground(Color.red);
        cbxSemester = new JComboBox();
            cbxSemester.setPreferredSize(new Dimension(161, 25));
        JPanel fieldPanel7 = new JPanel();
            fieldPanel7.setLayout(new BorderLayout());
            fieldPanel7.setOpaque(false);
            fieldPanel7.add(label7, BorderLayout.PAGE_START);
            fieldPanel7.add(cbxSemester, BorderLayout.PAGE_END);
            fieldPanel7.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel7);
            
        JLabel label8 = new JLabel("Employee/Professor:");
            label8.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label8.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label8.setAlignmentX(Component.LEFT_ALIGNMENT);
            label8.setOpaque(false);
            label8.setBackground(Color.red);
        cbxEmployee = new JComboBox();
            cbxEmployee.setPreferredSize(new Dimension(337, 25));
        JPanel fieldPanel8 = new JPanel();
            fieldPanel8.setLayout(new BorderLayout());
            fieldPanel8.setOpaque(false);
            fieldPanel8.add(label8, BorderLayout.PAGE_START);
            fieldPanel8.add(cbxEmployee, BorderLayout.PAGE_END);
            fieldPanel8.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel8);
            
        JLabel label9 = new JLabel("College:");
            label9.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label9.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
            label9.setAlignmentX(Component.LEFT_ALIGNMENT);
            label9.setOpaque(false);
            label9.setBackground(Color.red);
        cbxCollege = new JComboBox();
            cbxCollege.setPreferredSize(new Dimension(337, 25));
        JPanel fieldPanel9 = new JPanel();
            fieldPanel9.setLayout(new BorderLayout());
            fieldPanel9.setOpaque(false);
            fieldPanel9.add(label9, BorderLayout.PAGE_START);
            fieldPanel9.add(cbxCollege, BorderLayout.PAGE_END);
            fieldPanel9.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel9);
            
        JLabel label10 = new JLabel("Type:");
            label10.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label10.setBorder(BorderFactory.createEmptyBorder(-3, 0, 4, 0));
            label10.setAlignmentX(Component.LEFT_ALIGNMENT);
            label10.setOpaque(false);
            label10.setBackground(Color.red);
        cbxType = new JComboBox();
            cbxType.addItem("Online");
            cbxType.addItem("Onsite");
            cbxType.setPreferredSize(new Dimension(337, 26));
            cbxType.setSelectedIndex(-1);
        JPanel fieldPanel10 = new JPanel();
            fieldPanel10.setLayout(new BorderLayout());
            fieldPanel10.setOpaque(false);
            fieldPanel10.add(label10, BorderLayout.PAGE_START);
            fieldPanel10.add(cbxType, BorderLayout.PAGE_END);
            fieldPanel10.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel10);
            
        JLabel label11 = new JLabel("Day");
            label11.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label11.setBorder(BorderFactory.createEmptyBorder(-3, 0, 4, 0));
            label11.setAlignmentX(Component.LEFT_ALIGNMENT);
            label11.setOpaque(false);
            label11.setBackground(Color.red);
        cbxDay = new JComboBox();
            cbxDay.addItem("Sunday");
            cbxDay.addItem("Monday");
            cbxDay.addItem("Tuesday");
            cbxDay.addItem("Wednesday");
            cbxDay.addItem("Thursday");
            cbxDay.addItem("Friday");
            cbxDay.addItem("Saturday");
            cbxDay.setPreferredSize(new Dimension(337, 26));
            cbxDay.setSelectedIndex(-1);
        JPanel fieldPanel11 = new JPanel();
            fieldPanel11.setLayout(new BorderLayout());
            fieldPanel11.setOpaque(false);
            fieldPanel11.add(label11, BorderLayout.PAGE_START);
            fieldPanel11.add(cbxDay, BorderLayout.PAGE_END);
            fieldPanel11.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
            glowPanel.add(fieldPanel11);
            
        JLabel label1 = new JLabel("Block:");
            label1.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label1.setAlignmentX(Component.LEFT_ALIGNMENT);
            label1.setOpaque(false);
            label1.setBackground(Color.red);
        BetterTextField betterTextField1 = new BetterTextField(
            335, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField1.setOpaque(false);
            txfBlockNumber = betterTextField1.textField;
            txfBlockNumber.setForeground(Color.black);
        JPanel fieldPanel1 = new JPanel();
            fieldPanel1.setLayout(new BorderLayout());
            fieldPanel1.setOpaque(false);
            fieldPanel1.add(label1, BorderLayout.PAGE_START);
            fieldPanel1.add(betterTextField1, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel1);
            
        JLabel label2 = new JLabel("Time:");
            label2.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setOpaque(false);
            label2.setBackground(Color.red);
        BetterTextField betterTextField2 = new BetterTextField(
            335, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField2.setOpaque(false);
            txfTime = betterTextField2.textField;
            txfTime.setForeground(Color.black);
        JPanel fieldPanel2 = new JPanel();
            fieldPanel2.setLayout(new BorderLayout());
            fieldPanel2.setOpaque(false);
            fieldPanel2.add(label2, BorderLayout.PAGE_START);
            fieldPanel2.add(betterTextField2, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel2);
            
        JLabel label3 = new JLabel("Room:");
            label3.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label3.setAlignmentX(Component.LEFT_ALIGNMENT);
            label3.setOpaque(false);
            label3.setBackground(Color.red);
        BetterTextField betterTextField3 = new BetterTextField(
            335, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField3.setOpaque(false);
            txfRoom = betterTextField3.textField;
            txfRoom.setForeground(Color.black);
        JPanel fieldPanel3 = new JPanel();
            fieldPanel3.setLayout(new BorderLayout());
            fieldPanel3.setOpaque(false);
            fieldPanel3.add(label3, BorderLayout.PAGE_START);
            fieldPanel3.add(betterTextField3, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel3); 
            
        JLabel label4 = new JLabel("Sequence Number:");
            label4.setFont(new java.awt.Font("Google Sans Medium", 0, 12));
            label4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            label4.setAlignmentX(Component.LEFT_ALIGNMENT);
            label4.setOpaque(false);
            label4.setBackground(Color.red);
        BetterTextField betterTextField4 = new BetterTextField(
            335, 25, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, null, null
        );
            betterTextField4.setOpaque(false);
            txfSeq = betterTextField4.textField;
            txfSeq.setForeground(Color.black);
        JPanel fieldPanel4 = new JPanel();
            fieldPanel4.setLayout(new BorderLayout());
            fieldPanel4.setOpaque(false);
            fieldPanel4.add(label4, BorderLayout.PAGE_START);
            fieldPanel4.add(betterTextField4, BorderLayout.PAGE_END);
            glowPanel.add(fieldPanel4);
            NumericField.makeNumericOnly(txfSeq);
            
        return glowPanel;
    }
    
    private JPanel createEnrollPanel() {
        JPanel glowPanel = new BetterPanel(365, 550, new Color(250, 250, 250), 30, 0.2f);
            glowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            glowPanel.setOpaque(false); 
            glowPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            
        JLabel lblTitle = new javax.swing.JLabel();
        lblTitle.setFont(new java.awt.Font("Google Sans", 0, 20)); // NOI18N
        lblTitle.setText("Enroll Student");
        
        glowPanel.add(lblTitle);
        glowPanel.add(createStudentListPanel());
            
        return glowPanel;
    }
    
    private JScrollPane createStudentListPanel() {
        
        studentListPanel = new JPanel();
        studentListPanel.setOpaque(false);
        studentListPanel.setLayout(new BoxLayout(studentListPanel, BoxLayout.Y_AXIS));
        studentListPanel.setPreferredSize(new Dimension(305, 500));
        
        JScrollPane scrlStudentList = new JScrollPane(studentListPanel);
            scrlStudentList.getHorizontalScrollBar().setUnitIncrement(10);
            scrlStudentList.getVerticalScrollBar().setUnitIncrement(10);
            scrlStudentList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrlStudentList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrlStudentList.setPreferredSize(new Dimension(305, 450));
            scrlStudentList.setOpaque(false);
            scrlStudentList.setBorder(BorderFactory.createEmptyBorder());
            scrlStudentList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrlStudentList.getViewport().setOpaque(false);
            
        return scrlStudentList;
    }

    private JCheckBox createStudent(Student student, boolean isCheck) {
        JCheckBox checkBox = new JCheckBox(student.getLastname() + ", " + student.getFirstname()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(233, 233, 233));
                g2d.fillRect(0, getHeight() - 1, getWidth(), 1);
                g2d.dispose();
            }
            
        };
        checkBox.setName(String.valueOf(student.getStudentNo()));
        checkBox.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        checkBox.setMinimumSize(new Dimension(500, 40));
        checkBox.setMaximumSize(new Dimension(500, 40));
        checkBox.setPreferredSize(new Dimension(500, 40));
        checkBox.setSelected(isCheck);
        return checkBox;
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

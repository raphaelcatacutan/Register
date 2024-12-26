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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import models.College;
import models.Course;
import raven.datetime.component.date.DatePicker;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import utils.StaticVars;
import views.components.BetterPanel;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public final class ViewCourses extends javax.swing.JPanel {

    JPanel recordsTable;
    JScrollPane scrlEmployeeList;
    boolean isAdding;

    /**
     * Creates new form NewJPanel
     */
    public ViewCourses() {
        initComponents();
        add(createActionsPanel());
        add(createTablePanel());
    }

    public void refreshData() {
        java.util.List<Course> courses = DBReadMd.readCourses();
        recordsTable.removeAll();

        for (Course course : courses) {
            JPanel recordPanel = createTableRecord(course);

            recordsTable.add(recordPanel);
        }
        recordsTable.setPreferredSize(new Dimension(800, (recordsTable.getComponentCount() * (50 + 17))));
        SwingUtilities.invokeLater(() -> {
            scrlEmployeeList.getViewport().setViewPosition(new Point(0, 0));
            recordsTable.revalidate();
        });
    }

    // UI
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);

        JLabel button2Label = new JLabel("Add Course");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (2).png").toString()));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isAdding) {
                    return;
                }
                System.out.println("Adding new");
                isAdding = true;
                Component[] components = recordsTable.getComponents();
                recordsTable.add(createTableRecord(new Course()));
                for (Component component : components) {
                    recordsTable.add(component);
                }
                recordsTable.setPreferredSize(new Dimension(800, (recordsTable.getComponentCount() * (50 + 17))));
                SwingUtilities.invokeLater(() -> {
                    scrlEmployeeList.getViewport().setViewPosition(new Point(0, 0));
                    recordsTable.revalidate();
                });
            }
        });

        actionsPanel.add(Box.createHorizontalStrut(560));
        actionsPanel.add(button2);

        return actionsPanel;
    }

    private JScrollPane createTablePanel() {
        recordsTable = new JPanel();
        recordsTable.setOpaque(false);
        recordsTable.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Titles
        JPanel title = new BetterPanel(775, 30, new Color(250, 247, 227), 10, 0.2f);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel column1 = new JLabel();
        column1.setPreferredSize(new Dimension(170, 33));
        column1.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(205, 220, 220));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 0, 10, 10));
        column1.setText("    Course Name");
        column1.setHorizontalAlignment(SwingConstants.CENTER);
        column1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel column2 = new JLabel();
        column2.setPreferredSize(new Dimension(90, 33));
        column2.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column2.setOpaque(false);
        column2.setBackground(new Color(220, 220, 220));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText("Code");
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        column2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel column3 = new JLabel();
        column3.setPreferredSize(new Dimension(100, 33));
        column3.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column3.setOpaque(false);
        column3.setBackground(new Color(220, 220, 220));
        column3.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column3.setText("Status");
        column3.setHorizontalAlignment(SwingConstants.CENTER);
        column3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel column4 = new JLabel();
        column4.setPreferredSize(new Dimension(150, 33));
        column4.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column4.setOpaque(false);
        column4.setBackground(new Color(220, 220, 220));
        column4.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column4.setText("Date Started");
        column4.setHorizontalAlignment(SwingConstants.CENTER);
        column4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel column5 = new JLabel();
        column5.setPreferredSize(new Dimension(150, 33));
        column5.setFont(new Font("Google Sans Medium", Font.PLAIN, 12));
        column5.setOpaque(false);
        column5.setBackground(new Color(220, 220, 220));
        column5.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column5.setText("Data Closed");
        column5.setHorizontalAlignment(SwingConstants.CENTER);
        column5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        title.add(column1);
        title.add(column2);
        title.add(column4);
        title.add(column5);
        title.add(column3);

        add(title);

        scrlEmployeeList = new JScrollPane(recordsTable);
        scrlEmployeeList.getHorizontalScrollBar().setUnitIncrement(10);
        scrlEmployeeList.getVerticalScrollBar().setUnitIncrement(10);
        scrlEmployeeList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrlEmployeeList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrlEmployeeList.setPreferredSize(new Dimension(820, 565));
        scrlEmployeeList.setOpaque(false);
        scrlEmployeeList.setBorder(BorderFactory.createEmptyBorder());
        scrlEmployeeList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:$ScrollBar.thumbArc;"
                + "thumbInsets:0,0,0,0;"
                + "width:5;");
        scrlEmployeeList.getViewport().setOpaque(false);

        recordsTable.setPreferredSize(new Dimension(800, (recordsTable.getComponentCount() * (50 + 17))));
        SwingUtilities.invokeLater(() -> {
            scrlEmployeeList.getViewport().setViewPosition(new Point(0, 0));
        });

        return scrlEmployeeList;
    }

    private JPanel createTableRecord(Course course) {
        JPanel recordsPanel = new BetterPanel(770, 50, Color.WHITE, 10, 0.05f);
        recordsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField column1 = new JTextField();
        column1.setPreferredSize(new Dimension(170, 53));
        column1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column1.setOpaque(false);
        column1.setBackground(new Color(250, 250, 250));
        column1.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column1.setText(course.getDescription());
        column1.setHorizontalAlignment(SwingConstants.LEFT);
        column1.setCaretPosition(0);
        column1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "College Name");

        JTextField column2 = new JTextField();
        column2.setPreferredSize(new Dimension(60, 53));
        column2.setFont(new Font("Google Sans", Font.PLAIN, 12));
        column2.setOpaque(false);
        column2.setBackground(new Color(220, 220, 220));
        column2.setBorder(BorderFactory.createEmptyBorder(11, 10, 10, 10));
        column2.setText(course.getCourseCode());
        column2.setHorizontalAlignment(SwingConstants.CENTER);
        column2.setCaretPosition(0);
        column2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Code");
        if (course.getCourseCode() != null) {
            column2.setEnabled(false);
        }
        
        java.util.List<College> colleges = DBReadMd.readColleges();
        JComboBox column6 = new JComboBox();
            column6.setPreferredSize(new Dimension(100, 30));
            int index = 0;
            for (College college: colleges) {
                column6.addItem(college.getDescription());
                if (college.getCollegeCode().equals(course.getCollegeCode())) column6.setSelectedIndex(index);
                index++;
            }

        JComboBox column3 = new JComboBox();
            column3.addItem("Active");
            column3.addItem("Inactive");
            column3.setSelectedIndex("A".equals(course.getStatus()) ? 0 : 1);
            column3.setPreferredSize(new Dimension(80, 30));

        JPanel column4 = new BetterPanel(120, 28, new Color(250, 250, 250), 10, 0.2f, new Color(220, 220, 224));
        JFormattedTextField formattedTextField4 = new JFormattedTextField();
        formattedTextField4.setBorder(null);
        formattedTextField4.setOpaque(false);
        DatePicker dtp4 = new DatePicker();
        dtp4.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
        dtp4.now();
        dtp4.setEditor(formattedTextField4);
        dtp4.setCloseAfterSelected(true);
        dtp4.setEditorValidation(false);
        dtp4.setAnimationEnabled(false);
        column4.setLayout(new BorderLayout());
        column4.add(formattedTextField4, BorderLayout.CENTER);
        column4.add(formattedTextField4);
        column4.setBorder(BorderFactory.createEmptyBorder(2, 15, 0, 15));
        if (course.getDateOpened() != null) {
            dtp4.setSelectedDate(new java.sql.Date(course.getDateOpened().getTime()).toLocalDate());
        }

        JPanel column5 = new BetterPanel(120, 28, new Color(250, 250, 250), 10, 0.2f, new Color(220, 220, 224));
        JFormattedTextField formattedTextField5 = new JFormattedTextField();
        formattedTextField5.setBorder(null);
        formattedTextField5.setOpaque(false);
        DatePicker dtp5 = new DatePicker();
        dtp5.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now())); // TODO:
        dtp5.now();
        dtp5.setEditor(formattedTextField5);
        dtp5.setCloseAfterSelected(true);
        dtp5.setEditorValidation(false);
        dtp5.setAnimationEnabled(false);
        column5.setLayout(new BorderLayout());
        column5.add(formattedTextField5, BorderLayout.CENTER);
        column5.add(formattedTextField5);
        column5.setBorder(BorderFactory.createEmptyBorder(2, 15, 0, 15));
        if (course.getDateClosed() != null) {
            dtp5.setSelectedDate(new java.sql.Date(course.getDateClosed().getTime()).toLocalDate());
        }

        JLabel saveButton = new JLabel();
        saveButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        saveButton.setIcon(new ImageIcon(getClass().getResource("/assets/icons/diskette.png")));
        saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean addingNew = column2.isEnabled();
                if (column2.getText().isEmpty() || column2.getText().isBlank()) {
                    final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR,
                            "You need to add Course Code, Description, and College Code before adding to the database",
                            "Invalid Input", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                            });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                    return;
                }
                Date dateStarted = Date.from(dtp4.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dateClosed = Date.from(dtp5.getSelectedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                if (!addingNew) {
                    DBUpdate.updateCourse(
                            column2.getText(),
                            column1.getText(),
                            colleges.get(column6.getSelectedIndex()).getCollegeCode(),
                            dateStarted,
                            dateClosed,
                            column3.getSelectedIndex() == 0 ? "A" : "I");
                } else {
                    DBAdd.addCourse(
                            column2.getText(),
                            column1.getText(),
                            colleges.get(column6.getSelectedIndex()).getCollegeCode(),
                            dateStarted,
                            dateClosed,
                            column3.getSelectedIndex() == 0 ? "A" : "I");
                    isAdding = false;
                    column2.setEnabled(false);
                }
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT,
                        "Data is successfully saved to the database",
                        "Data saved", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                        });
                ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
            }
        });
        JLabel deleteButton = new JLabel();
        deleteButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        deleteButton.setIcon(new ImageIcon(getClass().getResource("/assets/icons/delete.png")));
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean addingNew = column2.isEnabled();
                if (!addingNew) {
                    if (column2.getText().isEmpty() || column2.getText().isBlank()) {
                        final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR,
                                "You need to add College Code before deleting to the database",
                                "Invalid Input", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                                });
                        ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                        return;
                    }
                    DBDelete.deleteCourse(column2.getText());
                    final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.DEFAULT,
                            "Data is successfully deleted to the database",
                            "Data saved", SimpleModalBorder.CANCEL_OPTION, (controller, action) -> {
                            });
                    ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
                } else {
                    isAdding = false;
                }
                recordsTable.remove(recordsPanel);
                recordsTable.setPreferredSize(new Dimension(800, (recordsTable.getComponentCount() * (50 + 17))));
                SwingUtilities.invokeLater(() -> {
                    scrlEmployeeList.getViewport().setViewPosition(new Point(0, 0));
                    recordsTable.revalidate();
                });
            }
        });

        recordsPanel.add(column1);
        recordsPanel.add(column2);
        recordsPanel.add(column4);
        recordsPanel.add(column5);
        recordsPanel.add(column3);
        recordsPanel.add(column6);
        recordsPanel.add(Box.createHorizontalStrut(10));
        recordsPanel.add(saveButton);
        recordsPanel.add(deleteButton);
        return recordsPanel;
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
        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 30, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1040, 720));
        setMinimumSize(new java.awt.Dimension(1040, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1040, 720));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblDashboard.setFont(new java.awt.Font("Google Sans Medium", 0, 24)); // NOI18N
        lblDashboard.setText("Courses");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

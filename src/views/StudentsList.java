/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatClientProperties;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import models.Student;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public class StudentsList extends javax.swing.JPanel {
    JScrollPane scrlStudentList;
    JPanel grdStudentList;
    JTextField txfSearch;
    
    /**
     * Creates new form StudentsList
     */
    public StudentsList() {
        initComponents();
        
        add(createActionsPanel());
        add(createGridPanel(), BorderLayout.CENTER);
    }
    
    public void refreshData(boolean withSearch) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                List<Student> students = DBReadMd.readStudents(); 
                
                if (!withSearch) txfSearch.setText("");

                Map<String, Color> courseColorMap = new HashMap<>();
                List<JPanel> studentsPanel = new ArrayList<>();
                for (Student student : students) {
                    String lastName = student.getLastname();
                    String firstName = student.getFirstname();
                    int studentNumber = student.getStudentNo();
                    String course = student.getCourseCode();
                    
                    String searchText = txfSearch.getText();
                    System.out.println(searchText);
                    if (withSearch) {
                        boolean numberMatch = false;
                        try {
                            numberMatch = studentNumber == Integer.parseInt(searchText);
                        } catch (NumberFormatException e) {
                            // If parsing fails, numberMatch remains false
                        }
                        boolean matched = lastName.startsWith(searchText) || 
                                firstName.startsWith(searchText) ||
                                numberMatch || 
                                (course == null ? searchText == null : course.equals(searchText));
                        System.out.println(matched);
                        if (!matched) continue; 
                    }

                    if (!courseColorMap.containsKey(course)) {
                        int r = (int) (Math.random() * 128 + 128);  
                        int g = (int) (Math.random() * 128 + 128);
                        int b = (int) (Math.random() * 128 + 128);
                        Color randomLightColor = new Color(r, g, b);
                        courseColorMap.put(course, randomLightColor);  
                    }

                    Color assignedColor = courseColorMap.get(course); 
                    JPanel panel = createGridRecord(lastName, firstName, studentNumber, course, assignedColor, student);
                    studentsPanel.add(panel);  
                }

                grdStudentList.removeAll();
                for (JPanel studentPanel: studentsPanel) grdStudentList.add(studentPanel);
                grdStudentList.setPreferredSize(new Dimension(800, (studentsPanel.size() * (125 + 28)) / 3));

                SwingUtilities.invokeLater(() -> {
                    scrlStudentList.getViewport().setViewPosition(new Point(0, 0));
                });

                return null;
            }
            
            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    grdStudentList.revalidate(); 
                    grdStudentList.repaint(); 
                });
            }
        };

        worker.execute();
    }
 
    // UI
    private JPanel createActionsPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, "C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png", "Search");
        txfSearch = searchPanel.textField;
        
        JPanel button1 = new BetterPanel(115, 30, new Color(173, 204, 255), 10, 0.5f);
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Search Student");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshData(true);
            }
        });
        
        JLabel button2Label = new JLabel("Add Student");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon("C:/Users/Raphael/Documents/Sync/Developments/Java/RegISTER/src/assets/icons/app (1).png"));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.studInfoPanel.selectedStudent = null;
                ViewStudents.studInfoPanel.refreshView();
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
            }
        });

        actionsPanel.add(Box.createHorizontalStrut(95));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private Component createGridPanel() {
        grdStudentList = new JPanel();
        grdStudentList.setOpaque(false);
        grdStudentList.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        scrlStudentList = new JScrollPane(grdStudentList);
            scrlStudentList.getHorizontalScrollBar().setUnitIncrement(10);
            scrlStudentList.getVerticalScrollBar().setUnitIncrement(10);
            scrlStudentList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrlStudentList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrlStudentList.setPreferredSize(new Dimension(820, 565));
            scrlStudentList.setOpaque(false);
            scrlStudentList.setBorder(BorderFactory.createEmptyBorder());
            scrlStudentList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrlStudentList.getViewport().setOpaque(false);
        
        return scrlStudentList;
    }

    private JPanel createGridRecord(String lastName, String firstName, int studentNumber, String course, Color courseColor, Student student) {
        JPanel glowPanel = new BetterPanel(245, 125, Color.WHITE, 20, 0.07f);
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
        circlePanel.setPreferredSize(new Dimension(60, 60));
        circlePanel.setBounds(25, 25, 60, 60);
        circlePanel.setLayout(new BorderLayout());

        JLabel letterLabel = new JLabel(
                (String.valueOf(lastName.charAt(0)) + String.valueOf(firstName.charAt(0))).toUpperCase(), 
                SwingConstants.CENTER);
        letterLabel.setFont(new Font("Google Sans Medium", Font.BOLD, 20));
        letterLabel.setForeground(Color.BLACK);

        circlePanel.add(letterLabel);
        glowPanel.add(circlePanel);

        JLabel label1 = new JLabel();
        label1.setText(lastName + ", " + firstName);
        label1.setOpaque(false);
        label1.setFocusable(false);
        label1.setBackground(Color.orange);
        label1.setFont(new java.awt.Font("Google Sans Medium", 0, 17));
        label1.setBounds(95, 30, 140, 20); 
        label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        glowPanel.add(label1);

        JLabel label2 = new JLabel(String.valueOf(studentNumber));
        label2.setFont(new java.awt.Font("Google Sans", 0, 13));
        label2.setAlignmentX(Component.LEFT_ALIGNMENT);
        label2.setOpaque(false);
        label2.setBackground(Color.blue);
        label2.setBounds(95, 50, 140, 20); 
        glowPanel.add(label2);

        JPanel column3 = new BetterPanel(65, 18, courseColor, 15, 0.5f);
        column3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel column3Label = new JLabel();
        column3Label.setText(course);
        column3Label.setFont(new Font("Google Sans", Font.PLAIN, 10));
        column3Label.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        column3.add(column3Label);
        column3.setBounds(85, 70, 80, 30); 
        glowPanel.add(column3);

        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
            }
        });

        glowPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        glowPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.studInfoPanel.selectedStudent = student;
                ViewStudents.studInfoPanel.refreshView();
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
            }
        });

        return glowPanel;
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

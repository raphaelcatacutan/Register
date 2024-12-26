/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import database.DBReadMd;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import models.Course;
import models.Employee;
import models.SchoolYear;
import models.Student;
import models.Subject;
import utils.StaticVars;
import views.components.BetterPanel;
import views.panels.NavigationPanel;

/**
 *
 * @author Raphael
 */
public final class ViewDashboard extends javax.swing.JPanel {

    JPanel pieGraphPanel;
    JLabel panel1Number;
    JLabel panel2Number;
    JLabel panel3Number;
    JLabel panel4Number;
    JLabel panel5Number;
    
    public void refreshData() {
        List<Student> students = DBReadMd.readStudents();
        List<Employee> employees = DBReadMd.readEmployees();
        List<Course> courses = DBReadMd.readCourses();
        List<Subject> subjects = DBReadMd.readSubjects();
        List<SchoolYear> schoolYears = DBReadMd.readSchoolYears();
        
        panel1Number.setText(String.valueOf(students.size()));        
        panel2Number.setText(String.valueOf(employees.size()));        
        panel3Number.setText(String.valueOf(courses.size()));        
        panel4Number.setText(String.valueOf(subjects.size()));        
        panel5Number.setText(String.valueOf(schoolYears.size()));
        
        int male = 0;
        int female = 0; 

        for (Student student: students) {
            if ("M".equals(student.getGender())) male++;
            else female++;
        }
        
        int total = male + female;
        int malePercentage = (int) ((double) male / total * 100);
        int femalePercentage = 100 - malePercentage;
        int[] values = {malePercentage, femalePercentage};
        String centralText = malePercentage + "%";
        List<String> labels = List.of("Male", "Female");
        List<Color> colors = List.of(new Color(0, 102, 204), new Color(223, 237, 247));

        // Rebuild and repaint the donut chart
        JPanel updatedDonutPanel = createDonutCircle(60, 25, 110, 70, values, centralText, labels, colors);
        updatedDonutPanel.setOpaque(false);
        
        JLabel pieGraphTitle = new JLabel("Sex Distribution");
        pieGraphTitle.setFont(new Font("Google Sans Medium", Font.PLAIN, 14));
        pieGraphTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        pieGraphTitle.setBackground(Color.green);
        pieGraphTitle.setOpaque(false);
        pieGraphPanel.removeAll(); // Assuming statisticsPanel contains the donut chart
        pieGraphPanel.add(pieGraphTitle);
        pieGraphPanel.add(updatedDonutPanel);
        pieGraphPanel.revalidate();
        pieGraphPanel.repaint();
    }
    /**
     * Creates new form NewJPanel
     */
    public ViewDashboard() {
        initComponents();   
        
        this.add(createQuickButtonPanel());
        this.add(addQuickNumbersPanel());
        this.add(addStatisticsPanel());
    }
    
    public JPanel createQuickButtonPanel() {
        JPanel glowPanel = new BetterPanel(770, 190, new Color(250, 247, 227), 30);
        glowPanel.setLayout(new BorderLayout());
        glowPanel.setOpaque(false);

        // Left Side
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setBackground(Color.orange);
        textPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));

        JLabel welcomeLabel = new JLabel("Welcome, Admin!");
        welcomeLabel.setFont(new Font("Google Sans Medium", Font.PLAIN, 30));
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeLabel.setBackground(Color.green);
        welcomeLabel.setOpaque(false);

        JLabel subtitleLabel = new JLabel("<html>Here's your quick overview for today! Manage<br> student info, grades, and more.</html>");
        subtitleLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
        subtitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitleLabel.setBackground(Color.red);
        subtitleLabel.setOpaque(false);
        subtitleLabel.setPreferredSize(new Dimension(300, 50)); 

        // Quick Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setOpaque(false);
        bottomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel button1 = new BetterPanel(100, 30, new Color(204, 194, 255), 10, 0.5f);
        JPanel button2 = new BetterPanel(100, 30, new Color(174, 226, 200), 10, 0.5f);

        JPanel button3 = new BetterPanel(100, 30, new Color(255, 216, 158), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Add Student");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewStudents.studInfoPanel.selectedStudent = null;
                ViewStudents.studInfoPanel.refreshView();
                ViewStudents.studListPanel.refreshData(false);
                ViewStudents.viewStudentsCardLayout.show(MainView.viewStudents, "studInfoPanel");
                MainView.mainViewCardLayout.show(StaticVars.viewPanel, "viewStudents");
                NavigationPanel.dashboardItem.setBackground(Color.WHITE);
                NavigationPanel.studentItem.setBackground(new Color(250, 247, 227));
                NavigationPanel.previousPanel = NavigationPanel.studentItem;
            }
        });
        
        JLabel button2Label = new JLabel("Add Employee");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewEmployees.empInfoPanel.selectedEmployee = null;
                ViewEmployees.empInfoPanel.refreshView();
                ViewEmployees.empListPanel.refreshData(false);
                ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empInfoPanel");
                MainView.mainViewCardLayout.show(StaticVars.viewPanel, "viewEmployees");
                NavigationPanel.dashboardItem.setBackground(Color.WHITE);
                NavigationPanel.employeesItem.setBackground(new Color(250, 247, 227));
                NavigationPanel.previousPanel = NavigationPanel.employeesItem;
            }
        });
        
        JLabel button3Label = new JLabel("Grade Students");
        button3Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button3Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button3.add(button3Label);
        button3.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainView.viewGrading.refreshData();
                MainView.mainViewCardLayout.show(StaticVars.viewPanel, "viewGrading");
                NavigationPanel.dashboardItem.setBackground(Color.WHITE);
                NavigationPanel.gradingItem.setBackground(new Color(250, 247, 227));
                NavigationPanel.previousPanel = NavigationPanel.gradingItem;
            }
        });

        bottomPanel.add(Box.createHorizontalStrut(-5));
        bottomPanel.add(button1);
        bottomPanel.add(Box.createHorizontalStrut(5));
        bottomPanel.add(button2);
        bottomPanel.add(Box.createHorizontalStrut(5));
        bottomPanel.add(button3);

        textPanel.add(welcomeLabel);
        textPanel.add(subtitleLabel);
        textPanel.add(Box.createVerticalStrut(-15));
        textPanel.add(bottomPanel);

        // Right Side
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/assets/image/a_1.png"));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(backgroundImage.getImage(), -20, 0, 450, 450, this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(400, 250));
        imagePanel.setOpaque(false);

        glowPanel.add(textPanel, BorderLayout.WEST);
        glowPanel.add(imagePanel, BorderLayout.EAST);

        return glowPanel;
    }

    public JPanel addQuickNumbersPanel() {
        // Quick Numbers Panel that contains 5 boxes
        JPanel quickNumberPanel = new JPanel();
        quickNumberPanel.setOpaque(false);
        quickNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        quickNumberPanel.setPreferredSize(new Dimension(800, 170));
        quickNumberPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Adding the Panels with some spacing
        quickNumberPanel.add(Box.createHorizontalStrut(3));
       
        
        JPanel panel1 = new BetterPanel(142, 157, new Color(231, 230, 251), 20, 0.2f);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setOpaque(false);
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));
        JPanel panel1Icon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(97, 81, 251));

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 20;
                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/icons/graduation (1).png"));
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panel1Icon.setPreferredSize(new Dimension(60, 50));
        panel1Icon.setMaximumSize(new Dimension(60, 50));
        panel1Icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1Icon.setOpaque(false);
        JLabel panel1Label = new JLabel("Total Students");
        panel1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panel1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1Label.setOpaque(false);
        panel1Number = new JLabel("25");
        panel1Number.setFont(new Font("Google Sans", Font.BOLD, 30));
        panel1Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1Number.setOpaque(false);
        panel1.add(panel1Icon);
        panel1.add(Box.createVerticalStrut(13));
        panel1.add(panel1Label);
        panel1.add(panel1Number);
        quickNumberPanel.add(panel1);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        
        
        JPanel panel2 = new BetterPanel(142, 157, new Color(249, 229, 234), 20, 0.2f);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setOpaque(false);
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));
        JPanel panel2Icon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(239, 43, 88));

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 20;
                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/icons/user (1).png"));
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panel2Icon.setPreferredSize(new Dimension(60, 50));
        panel2Icon.setMaximumSize(new Dimension(60, 50));
        panel2Icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2Icon.setOpaque(false);
        JLabel panel2Label = new JLabel("Total Employees");
        panel2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panel2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2Label.setOpaque(false);
        panel2Number = new JLabel("25");
        panel2Number.setFont(new Font("Google Sans", Font.BOLD, 30));
        panel2Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2Number.setOpaque(false);
        panel2.add(panel2Icon);
        panel2.add(Box.createVerticalStrut(13));
        panel2.add(panel2Label);
        panel2.add(panel2Number);
        quickNumberPanel.add(panel2);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        
        
        
        JPanel panel3 = new BetterPanel(142, 157, new Color(223, 237, 247), 20, 0.2f);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setOpaque(false);
        panel3.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));
        JPanel panel3Icon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(0, 128, 255));

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 20;
                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/icons/open-folder.png"));
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panel3Icon.setPreferredSize(new Dimension(60, 50));
        panel3Icon.setMaximumSize(new Dimension(60, 50));
        panel3Icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3Icon.setOpaque(false);
        JLabel panel3Label = new JLabel("Total Courses");
        panel3Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panel3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3Label.setOpaque(false);
        panel3Number = new JLabel("25");
        panel3Number.setFont(new Font("Google Sans", Font.BOLD, 30));
        panel3Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3Number.setOpaque(false);
        panel3.add(panel3Icon);
        panel3.add(Box.createVerticalStrut(13));
        panel3.add(panel3Label);
        panel3.add(panel3Number);
        quickNumberPanel.add(panel3);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        
        
        
        
        JPanel panel4 = new BetterPanel(142, 157, new Color(251, 237, 217), 20, 0.2f);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.setOpaque(false);
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));
        JPanel panel4Icon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(255, 165, 0));

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 20;
                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/icons/atom (1).png"));
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panel4Icon.setPreferredSize(new Dimension(60, 50));
        panel4Icon.setMaximumSize(new Dimension(60, 50));
        panel4Icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4Icon.setOpaque(false);
        JLabel panel4Label = new JLabel("Total Subjects");
        panel4Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panel4Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4Label.setOpaque(false);
        panel4Number = new JLabel("25");
        panel4Number.setFont(new Font("Google Sans", Font.BOLD, 30));
        panel4Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4Number.setOpaque(false);
        panel4.add(panel4Icon);
        panel4.add(Box.createVerticalStrut(13));
        panel4.add(panel4Label);
        panel4.add(panel4Number);
        quickNumberPanel.add(panel4);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        
        
        
        
        
        JPanel panel5 = new BetterPanel(142, 157, new Color(222, 255, 229), 20, 0.2f);
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        panel5.setOpaque(false);
        panel5.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));
        JPanel panel5Icon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(34, 193, 195));

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 20;
                int[] xPoints = new int[6];
                int[] yPoints = new int[6];

                for (int i = 0; i < 6; i++) {
                    xPoints[i] = (int) (centerX + radius * Math.sin(Math.toRadians(i * 60)));
                    yPoints[i] = (int) (centerY + radius * Math.cos(Math.toRadians(i * 60)));
                }

                g2d.fillPolygon(xPoints, yPoints, 6);

                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/icons/calendar (1).png"));
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panel5Icon.setPreferredSize(new Dimension(60, 50));
        panel5Icon.setMaximumSize(new Dimension(60, 50));
        panel5Icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel5Icon.setOpaque(false);
        JLabel panel5Label = new JLabel("Total School Years");
        panel5Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panel5Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel5Label.setOpaque(false);
        panel5Number = new JLabel("25");
        panel5Number.setFont(new Font("Google Sans", Font.BOLD, 30));
        panel5Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel5Number.setOpaque(false);
        panel5.add(panel5Icon);
        panel5.add(Box.createVerticalStrut(13));
        panel5.add(panel5Label);
        panel5.add(panel5Number);
        quickNumberPanel.add(panel5);

        return quickNumberPanel;
    }

    public JPanel addStatisticsPanel() {
        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.X_AXIS));
        statisticsPanel.setOpaque(false);

        // Bar Graph
        JPanel barGraphPane = new BetterPanel(520, 200, new Color(250, 250, 250), 30, 0.15f);
        barGraphPane.setLayout(new BorderLayout());
        barGraphPane.setOpaque(false);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setBackground(Color.orange);
        textPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));

        JLabel barGraphTitle = new JLabel("Student Population");
        barGraphTitle.setFont(new Font("Google Sans Medium", Font.PLAIN, 14));
        barGraphTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        barGraphTitle.setBackground(Color.green);
        barGraphTitle.setOpaque(false);

        // Bars
        JPanel bars = new JPanel();
        bars.setLayout(new BoxLayout(bars, BoxLayout.X_AXIS));
        bars.setOpaque(false);
        bars.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel level = new JPanel();
        level.setLayout(new BoxLayout(level, BoxLayout.Y_AXIS));
        level.setOpaque(false);

        JLabel barLabel1 = new JLabel("100");
        barLabel1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel1.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel2 = new JLabel("75");
        barLabel2.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel2.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel3 = new JLabel("50");
        barLabel3.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel3.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel4 = new JLabel("25");
        barLabel4.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel4.setForeground(new Color(151, 153, 160));

        level.add(barLabel1);
        level.add(Box.createVerticalStrut(17));
        level.add(barLabel2);
        level.add(Box.createVerticalStrut(17));
        level.add(barLabel3);
        level.add(Box.createVerticalStrut(17));
        level.add(barLabel4);

        bars.add(level);
        bars.add(Box.createHorizontalStrut(15));
            
        int[] data = {50, 80, 70, 90, 60, 100, 33, 41, 15, 90};
        String[] labels = {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027"};
        
        for (int i = 0; i < data.length; i++) {
            JPanel barWrapper = new JPanel();
            barWrapper.setLayout(new BoxLayout(barWrapper, BoxLayout.Y_AXIS));
            barWrapper.setOpaque(false);
            barWrapper.setPreferredSize(new Dimension(30, 150)); 
            barWrapper.setMaximumSize(new Dimension(30, 150)); 
            barWrapper.setMaximumSize(new Dimension(30, 150)); 

            barWrapper.add(Box.createVerticalGlue());

            JPanel bar = new BetterPanel(15, data[i], i == 3 ? new Color(198, 76, 248): new Color(233, 238, 255), 7, false);
            bar.setPreferredSize(new Dimension(18, data[i])); 
            bar.setMaximumSize(new Dimension(18, data[i])); 
            bar.setMaximumSize(new Dimension(18, data[i])); 
            barWrapper.add(bar);
            bar.setOpaque(false);
            bar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

            JLabel barLabel = new JLabel(labels[i]);
            barLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
            barLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            barLabel.setForeground(i == 3 ? new Color(198, 76, 248): new Color(151, 153, 160));
            
            barWrapper.add(Box.createVerticalStrut(5));
            barWrapper.add(barLabel);

            bars.add(barWrapper);
            bars.add(Box.createHorizontalStrut(15));
        }

        textPanel.add(barGraphTitle);
        textPanel.add(bars);

        barGraphPane.add(textPanel);
        statisticsPanel.add(barGraphPane);
        
        // Pie Graph
        pieGraphPanel = new BetterPanel(240, 200, new Color(250, 250, 250), 30, 0.15f);
        pieGraphPanel.setLayout(new BoxLayout(pieGraphPanel, BoxLayout.Y_AXIS));
        
        int[] values = {50, 50}; 

        String text = "50%";

        List<String> flowTextLabels = new ArrayList<>();
        flowTextLabels.add("Male");
        flowTextLabels.add("Female");

        List<Color> flowTextColors = new ArrayList<>();
        flowTextColors.add(new Color(42, 53, 255)); 
        flowTextColors.add(new Color(223, 237, 247)); 

        JPanel donutPanel = createDonutCircle(60, 25, 110, 70, values, text, flowTextLabels, flowTextColors);
        donutPanel.setOpaque(false);
        
        JLabel pieGraphTitle = new JLabel("Sex Distribution");
        pieGraphTitle.setFont(new Font("Google Sans Medium", Font.PLAIN, 14));
        pieGraphTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        pieGraphTitle.setBackground(Color.green);
        pieGraphTitle.setOpaque(false);
        
        pieGraphPanel.setBorder(BorderFactory.createEmptyBorder(25, 20, 0, 25));
        pieGraphPanel.add(pieGraphTitle);
        pieGraphPanel.add(donutPanel);
        statisticsPanel.add(pieGraphPanel);
        
        return statisticsPanel;
    }
    
    public static JPanel createDonutCircle(int outerRadius, int innerRadius, int x, int y, int[] values, String text, 
                                            List<String> flowTextLabels, List<Color> flowTextColors) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int total = 0;
                for (int value : values) {
                    total += value;
                }

                int startAngle = 0;

                for (int i = 0; i < values.length; i++) {
                    int sweepAngle = (int) (360.0 * values[i] / total);
                    g2d.setColor(flowTextColors.get(i));
                    g2d.fillArc(x - outerRadius, y - outerRadius, outerRadius * 2, outerRadius * 2, startAngle, sweepAngle);
                    startAngle += sweepAngle;
                }

                g2d.setColor(Color.WHITE);
                g2d.fillOval(x - innerRadius, y - innerRadius, innerRadius * 2, innerRadius * 2);

                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Google Sans", Font.PLAIN, 15));

                FontMetrics metrics = g2d.getFontMetrics();
                int textWidth = metrics.stringWidth(text);
                int textHeight = metrics.getHeight();

                g2d.drawString(text, x - textWidth / 2, y + textHeight / 4);

                int startX = 0; 
                int startY = y + outerRadius + 40;

                int dotRadius = 8;
                FontMetrics labelMetrics = g2d.getFontMetrics();  
                int labelHeight = labelMetrics.getHeight();
                int dotCenterY = startY + (labelHeight - dotRadius) / 2;

                for (int i = 0; i < flowTextLabels.size(); i++) {
                    g2d.setColor(flowTextColors.get(i));
                    g2d.fillOval(startX + 40, dotCenterY - 38, dotRadius, dotRadius);
                    
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Google Sans", Font.PLAIN, 13));
                    g2d.drawString(flowTextLabels.get(i), startX + 55, startY + labelHeight / 2 - 33);

                    startX += labelMetrics.stringWidth(flowTextLabels.get(i)) + 20;
                }
            }
        };

        return panel;
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
        lblDashboard.setText(" Dashboard");
        add(lblDashboard);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDashboard;
    // End of variables declaration//GEN-END:variables
}

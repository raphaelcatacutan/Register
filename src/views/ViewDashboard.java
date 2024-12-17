/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.listener.ModalCallback;
import raven.modal.option.BorderOption;
import raven.modal.option.Location;
import raven.modal.option.Option;
import utils.StaticVars;
import views.components.BetterPanel;
import views.components.SimpleMessageModal;

/**
 *
 * @author Raphael
 */
public final class ViewDashboard extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ViewDashboard() {
        initComponents();   
        
        this.add(createQuickButtonPanel());
        this.add(addQuickNumbersPanel());
        this.add(addStatisticsPanel());
    }
    
    public static JPanel createQuickButtonPanel() {
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
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String message = "Hello! I hope you're having a wonderful day.";
                
                final SimpleMessageModal simpleMessageModal = new SimpleMessageModal(SimpleMessageModal.Type.ERROR, message, "This is a modal custom message", SimpleModalBorder.YES_NO_OPTION, (controller, action) -> {
                    if (action == SimpleModalBorder.YES_OPTION) {
                        System.out.println("Hello");
                    }
                });
                
                ModalDialog.showModal(StaticVars.mainForm, simpleMessageModal);
            }
        });

        JPanel button3 = new BetterPanel(100, 30, new Color(255, 216, 158), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Add Student");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel button2Label = new JLabel("Add Employee");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel button3Label = new JLabel("Grade Students");
        button3Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button3Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button3.add(button3Label);
        button3.setBorder(BorderFactory.createEmptyBorder(21, 10, 10, 10));
        button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Raphael\\Downloads\\a.png");
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

    public static JPanel addQuickNumbersPanel() {
        // Quick Numbers Panel that contains 5 boxes
        JPanel quickNumberPanel = new JPanel();
        quickNumberPanel.setOpaque(false);
        quickNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        quickNumberPanel.setPreferredSize(new Dimension(800, 170));
        quickNumberPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // The 5 panels
        JPanel panel1 = createQuickNumberPanel("Total Students", "24142", new Color(231, 230, 251), new Color(97, 81, 251));
        JPanel panel2 = createQuickNumberPanel("Total Employees", "24142", new Color(249, 229, 234), new Color(239, 43, 88));
        JPanel panel3 = createQuickNumberPanel("Total Courses", "24142", new Color(223, 237, 247), new Color(0, 128, 255));
        JPanel panel4 = createQuickNumberPanel("Total Programs", "24142", new Color(251, 237, 217), new Color(255, 165, 0));
        JPanel panel5 = createQuickNumberPanel("School Years", "24142", new Color(222, 255, 229), new Color(34, 193, 195));

        // Adding the Panels with some spacing
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        quickNumberPanel.add(panel1);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        quickNumberPanel.add(panel2);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        quickNumberPanel.add(panel3);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        quickNumberPanel.add(panel4);
        quickNumberPanel.add(Box.createHorizontalStrut(3));
        quickNumberPanel.add(panel5);

        return quickNumberPanel;
    }

    public static JPanel addStatisticsPanel() {
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

        JLabel barLabel1 = new JLabel("1233");
        barLabel1.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel1.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel2 = new JLabel("1233");
        barLabel2.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel2.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel3 = new JLabel("2113");
        barLabel3.setFont(new Font("Google Sans", Font.PLAIN, 12));
        barLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        barLabel3.setForeground(new Color(151, 153, 160));
        
        JLabel barLabel4 = new JLabel("1233");
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
        String[] labels = {"2020", "2021", "2022", "2023", "2024", "2025", "2023", "2024", "2025", "2025"};
        
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
        JPanel pieGraphPanel = new BetterPanel(240, 200, new Color(250, 250, 250), 30, 0.15f);
        pieGraphPanel.setLayout(new BoxLayout(pieGraphPanel, BoxLayout.Y_AXIS));
        
        int[] values = {50, 50}; 

        String text = "20%";

        List<String> flowTextLabels = new ArrayList<>();
        flowTextLabels.add("Male");
        flowTextLabels.add("Female");

        List<Color> flowTextColors = new ArrayList<>();
        flowTextColors.add(new Color(42, 53, 255)); 
        flowTextColors.add(new Color(235, 235, 235)); 

        JPanel donutPanel = createDonutCircle(60, 25, 110, 70, values, text, flowTextLabels, flowTextColors);
        donutPanel.setOpaque(false);
        
        JLabel pieGraphTitle = new JLabel("Some statistics");
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
    
    private static JPanel createQuickNumberPanel(String label, String number, Color panelColor, Color iconColor) {
        JPanel panelGroup = new BetterPanel(142, 157, panelColor, 20, 0.2f);
        panelGroup.setLayout(new BoxLayout(panelGroup, BoxLayout.Y_AXIS));
        panelGroup.setOpaque(false);
        panelGroup.setBorder(BorderFactory.createEmptyBorder(30, 13, 10, 10));

        // Icon Panel
        JPanel panelIcon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(iconColor);

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

                ImageIcon imageIcon = new ImageIcon("C:\\Users\\Raphael\\Downloads\\option.png");
                Image image = imageIcon.getImage();
                int imageX = centerX - radius / 2 + 2;
                int imageY = centerY - radius / 2 + 2;
                g2d.drawImage(image, imageX, imageY, this);
            }
        };
        panelIcon.setPreferredSize(new Dimension(60, 50));
        panelIcon.setMaximumSize(new Dimension(60, 50));
        panelIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIcon.setOpaque(false);

        // Labels
        JLabel panelLabel = new JLabel(label);
        panelLabel.setFont(new Font("Google Sans", Font.PLAIN, 12));
        panelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLabel.setOpaque(false);

        JLabel panelNumber = new JLabel(number);
        panelNumber.setFont(new Font("Google Sans", Font.BOLD, 30));
        panelNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelNumber.setOpaque(false);

        panelGroup.add(panelIcon);
        panelGroup.add(Box.createVerticalStrut(13));
        panelGroup.add(panelLabel);
        panelGroup.add(panelNumber);

        return panelGroup;
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

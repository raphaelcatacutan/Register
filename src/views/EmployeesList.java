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
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import models.Employee;
import views.components.BetterPanel;
import views.components.BetterTextField;

/**
 *
 * @author Raphael
 */
public class EmployeesList extends javax.swing.JPanel {
    JTextField txfSearch;
    JPanel grdEmployeesList;
    JScrollPane scrlEmployeeList;
    
    /**
     * Creates new form StudentsList
     */
    public EmployeesList() {
        initComponents();
        
        add(createActionsPanel());
        add(createGridPanel(), BorderLayout.CENTER);
    }
    
    public void refreshData(boolean withSearch) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                List<Employee> employees = DBReadMd.readEmployees(); 
                
                if (!withSearch) txfSearch.setText("");

                List<JPanel> employeePanels = new ArrayList<>();
                for (Employee employee : employees) {
                    String lastName = employee.getLastname();
                    String firstName = employee.getFirstname();
                    String email = employee.getEmail();
                    String status = employee.getStatus();
                    
                    String searchText = txfSearch.getText();
                    System.out.println(searchText);
                    if (withSearch) {
                        boolean matched = lastName.startsWith(searchText) || 
                                firstName.startsWith(searchText);
                        System.out.println(matched);
                        if (!matched) continue; 
                    }

                    JPanel panel = createGridRecord(lastName, firstName, email, status, employee);
                    employeePanels.add(panel);  
                }

                grdEmployeesList.removeAll();
                for (JPanel employeePnael: employeePanels) grdEmployeesList.add(employeePnael);
                grdEmployeesList.setPreferredSize(new Dimension(800, (employeePanels.size() * (125 + 28)) / 3));

                SwingUtilities.invokeLater(() -> {
                    scrlEmployeeList.getViewport().setViewPosition(new Point(0, 0));
                });

                return null;
            }
            
            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    grdEmployeesList.revalidate(); 
                    grdEmployeesList.repaint(); 
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

        BetterTextField searchPanel = new BetterTextField(260, 32, Color.WHITE, 13, 0.04f, new Color(220, 220, 224), 12, getClass().getResource("/assets/icons/app (2).png").toString(), "Search");
        txfSearch = searchPanel.textField;
        
        JPanel button1 = new BetterPanel(130, 30, new Color(173, 204, 255), 10, 0.5f);
        JPanel button2 = new BetterPanel(115, 30, new Color(174, 226, 200), 10, 0.5f);
        
        JLabel button1Label = new JLabel("Search Employee");
        button1Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button1Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button1Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/magnifier.png").toString()));
        button1.add(button1Label);
        button1.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshData(true);
            }
        });
        
        JLabel button2Label = new JLabel("Add Employee");
        button2Label.setFont(new Font("Google Sans", Font.PLAIN, 12));
        button2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2Label.setIcon(new ImageIcon(getClass().getResource("/assets/icons/app (2).png").toString()));
        button2.add(button2Label);
        button2.setBorder(BorderFactory.createEmptyBorder(9, 10, 10, 10));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewEmployees.empInfoPanel.selectedEmployee = null;
                ViewEmployees.empInfoPanel.refreshView();
                ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empInfoPanel");
            }
        });

        actionsPanel.add(Box.createHorizontalStrut(62));
        actionsPanel.add(searchPanel);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button1);
        actionsPanel.add(Box.createHorizontalStrut(5));
        actionsPanel.add(button2);
        
        return actionsPanel;
    }
    
    private Component createGridPanel() {
        grdEmployeesList = new JPanel();
        grdEmployeesList.setOpaque(false);
        grdEmployeesList.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        scrlEmployeeList = new JScrollPane(grdEmployeesList);
            scrlEmployeeList.getHorizontalScrollBar().setUnitIncrement(10);
            scrlEmployeeList.getVerticalScrollBar().setUnitIncrement(10);
            scrlEmployeeList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            scrlEmployeeList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrlEmployeeList.setPreferredSize(new Dimension(820, 565));
            scrlEmployeeList.setOpaque(false);
            scrlEmployeeList.setBorder(BorderFactory.createEmptyBorder());
            scrlEmployeeList.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "thumbInsets:0,0,0,0;" +
                "width:5;");
            scrlEmployeeList.getViewport().setOpaque(false);
        
        grdEmployeesList.setPreferredSize(new Dimension(800, (grdEmployeesList.getComponentCount() * (125 + 17)) / 3));
        SwingUtilities.invokeLater(() -> {
            scrlEmployeeList.getViewport().setViewPosition( new Point(0, 0) );
        });
        return scrlEmployeeList;
    }
    
    private JPanel createGridRecord(String lastName, String firstName, String email, String status, Employee employee) {
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
                (String.valueOf(lastName.charAt(0)) + String.valueOf(firstName.charAt(0))).toUpperCase() , SwingConstants.CENTER);
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

        JLabel label2 = new JLabel(email);
        label2.setFont(new java.awt.Font("Google Sans", 0, 13));
        label2.setAlignmentX(Component.LEFT_ALIGNMENT);
        label2.setOpaque(false);
        label2.setBackground(Color.blue);
        label2.setBounds(95, 50, 140, 20); 
        glowPanel.add(label2);

        Color color = "A".equals(status) ? new Color(150, 255, 150) : new Color(255, 200, 200);
        JPanel column3 = new BetterPanel(65, 18, color, 15, 0.5f);
        column3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel column3Label = new JLabel();
        column3Label.setText("A".equals(status) ? "Active" : "Inactive");
        column3Label.setFont(new Font("Google Sans", Font.PLAIN, 10));
        column3Label.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        column3.add(column3Label);
        column3.setBounds(85, 70, 80, 30); 
        glowPanel.add(column3);

        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewEmployees.empInfoPanel.selectedEmployee = employee;
                ViewEmployees.empInfoPanel.refreshView();
                ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empInfoPanel");
            }
        });

        glowPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        glowPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewEmployees.empInfoPanel.selectedEmployee = employee;
                ViewEmployees.empInfoPanel.refreshView();
                ViewEmployees.viewEmployeesCardLayout.show(MainView.viewEmployees, "empInfoPanel");
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
        lblStudents.setText("Employees List");
        add(lblStudents);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStudents;
    // End of variables declaration//GEN-END:variables
}

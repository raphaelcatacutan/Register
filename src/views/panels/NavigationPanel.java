package views.panels;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.StaticVars;

public class NavigationPanel {
    public static JPanel previousPanel = null; 
    public static JPanel exitItem;
    public static JPanel dashboardItem;
    public static JPanel studentItem;
    public static JPanel employeesItem;
    public static JPanel subjectsItem;
    public static JPanel gradingItem;
    public static JPanel collegesItem;
    public static JPanel coursesItem;
    public static JPanel settingsItem;

    public static JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        dashboardItem = createNavItem("Dashboard", "/assets/icons/add.png");
        studentItem = createNavItem("Students", "/assets/icons/graduation.png");
        employeesItem = createNavItem("Employees", "/assets/icons/user.png");
        subjectsItem = createNavItem("Subjects", "/assets/icons/atom.png");
        gradingItem = createNavItem("Grading", "/assets/icons/paper.png");
        collegesItem = createNavItem("Colleges", "/assets/icons/college.png");
        coursesItem = createNavItem("Courses", "/assets/icons/folder.png");
        settingsItem = createNavItem("Year & Semester", "/assets/icons/calendar.png");
        
        JPanel space = new JPanel();
        JPanel exit = createNavItem("Exit Application", "/assets/icons/logout (1).png");
        JPanel logout = createNavItem("Logout", "/assets/icons/logout.png");
        
        navPanel.add(dashboardItem);
        navPanel.add(studentItem);
        navPanel.add(employeesItem);
        navPanel.add(gradingItem);
        navPanel.add(collegesItem);
        navPanel.add(coursesItem);
        navPanel.add(subjectsItem);
        navPanel.add(settingsItem);
        
        // Adding space for exit
        space.setMaximumSize(new Dimension(10, 150));
        space.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); 
        space.setBackground(new Color(255, 255, 255));
        navPanel.add(space);
        
        // Exit Button
        navPanel.add(logout);
        navPanel.add(exit);
        exitItem = exit;
        exit.repaint();
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(new Color(255, 201, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(Color.WHITE);
            }
        });
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StaticVars.mainCardLayout.show(StaticVars.mainForm.getContentPane(), "mainLogin");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setBackground(new Color(255, 201, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setBackground(Color.WHITE);
            }
        });
        
        // Default when launched
        previousPanel = dashboardItem;
        dashboardItem.setBackground(new Color(250, 247, 227));
        dashboardItem.repaint();
        
        return navPanel;
    }

    private static JPanel createNavItem(String title, String iconPath) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                super.paintComponent(g);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); 
        panel.setPreferredSize(new Dimension(500, 40));
        panel.setMinimumSize(new Dimension(500, 40));
        panel.setMaximumSize(new Dimension(500, 40));
        panel.setBackground(new Color(255, 255, 255));
        
        ImageIcon icon = new ImageIcon(NavigationPanel.class.getResource(iconPath));
        Image scaledImage = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel iconLabel = new JLabel(scaledIcon);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        titleLabel.setPreferredSize(new Dimension(500, 50));
        titleLabel.setMinimumSize(new Dimension(500, 50));
        
        panel.add(iconLabel);
        panel.add(titleLabel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (panel == exitItem) return;
                if (panel == previousPanel) return;
                if (previousPanel != null) {
                    previousPanel.setBackground(Color.WHITE);
                    // Animations.animateColorChange(previousPanel, previousPanel.getBackground(), new Color(255, 255, 255));
                }

                panel.setBackground(new Color(250, 247, 227));
                // Animations.animateColorChange(panel, panel.getBackground(), new Color(250, 247, 227));
                previousPanel = panel;
            }
        });
        

        return panel;
    }
   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Navigation Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 600);

            JPanel navPanel = createNavigationPanel();
            JScrollPane scrollPane = new JScrollPane(navPanel);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}

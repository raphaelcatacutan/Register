/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.CardLayout;

/**
 *
 * @author Raphael
 */
public class ViewSubjects extends javax.swing.JPanel {
    public static CardLayout viewSubjectsCardLayout;
    public static SubjectsInfo subInfoPanel;
    public static SubjectsList subListPanel;
    
    /**
     * Creates new form ViewStudents
     */
    public ViewSubjects() {
        initComponents();
        
        viewSubjectsCardLayout = (CardLayout) getLayout();
        subListPanel = new SubjectsList();
        subInfoPanel = new SubjectsInfo();
        
        add(subInfoPanel, "subInfoPanel");
        add(subListPanel, "subListPanel");
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
        setMaximumSize(new java.awt.Dimension(1030, 720));
        setMinimumSize(new java.awt.Dimension(1030, 720));
        setPreferredSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

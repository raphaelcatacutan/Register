
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import raven.popup.GlassPanePopup;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.popup.component.SimplePopupBorder;
import utils.StaticVars;
import views.MainView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Raphael
 */
public class Register extends JFrame{
    static JPanel view;
    public Register() {
        view = new MainView();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(view);
        setSize(view.getPreferredSize());
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)); 
        setResizable(false); 
        setLocationRelativeTo(null);
        setTitle("RegISTER");
        
        GlassPanePopup.install(this);

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FlatMacLightLaf.setup();
        UIManager.put("defaultFont", new Font("Google Sans", Font.PLAIN, 13));
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme");
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {
            }
            final Register register = new Register();
            StaticVars.mainForm = register;
            register.setVisible(true);
        });
    }
    
}

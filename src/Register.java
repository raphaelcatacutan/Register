
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import raven.popup.GlassPanePopup;
import utils.StaticVars;
import views.MainLogin;
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
    public Register() {
        getContentPane().setLayout(new java.awt.CardLayout());
        StaticVars.mainCardLayout = (CardLayout) getContentPane().getLayout();
        
        JPanel mainLogin = new MainLogin();
        JPanel mainView = new MainView();
        
        StaticVars.mainView = mainView;
        
        getContentPane().add(mainLogin, "mainLogin");
        getContentPane().add(mainView, "mainView");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getContentPane().getPreferredSize());
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)); 
        setResizable(false); 
        setLocationRelativeTo(null);
        
        try {
            Image icon = ImageIO.read(Register.class.getResource("/assets/image/seal.png"));

            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setTitle("RegISTER");
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
            
            GlassPanePopup.install(register);
            register.setVisible(true);
        });
    }
    
}

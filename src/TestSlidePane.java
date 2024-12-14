

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import net.miginfocom.swing.MigLayout;
import raven.datetime.component.date.DatePicker;

public class TestSlidePane extends JFrame {


    public TestSlidePane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 800));
        setLocationRelativeTo(null);
        setLayout(new MigLayout("wrap,al center", "[center]"));

        JComboBox comboCountry = new JComboBox();

        add(comboCountry);

        comboCountry.addItem("United States");
        comboCountry.addItem("Canada");
        comboCountry.addItem("Brazil");
        comboCountry.addItem("United Kingdom");
        comboCountry.addItem("France");
        comboCountry.addItem("Germany");
        comboCountry.addItem("Australia");
        comboCountry.addItem("Japan");
        comboCountry.addItem("China");
        comboCountry.addItem("India");

        add(comboCountry); 
        JFormattedTextField editor = new JFormattedTextField();
        editor.setBorder(null);
        editor.setOpaque(false);
        
        DatePicker datePicker = new DatePicker();
        datePicker.addDateSelectionListener(event -> {
            LocalDate date = datePicker.getSelectedDate();
            System.out.println(date);
        });

        datePicker.setDateSelectionAble((date) -> !date.isAfter(LocalDate.now()));
        datePicker.now();
        datePicker.setEditor(editor);
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditorValidation(false);
        datePicker.setAnimationEnabled(false);

        add(editor, "width 250");
        
    }

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put("defaultFont", new Font("Google Sans", Font.PLAIN, 13));
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme");
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            }
            new TestSlidePane().setVisible(true);
        });
    }
}

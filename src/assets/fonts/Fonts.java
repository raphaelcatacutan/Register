/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets.fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.InputStream;

/**
 *
 * @author Raphael
 */
public class Fonts {
    public static Font nunitoRegular;
    public static Font nunitoBold;

    static {
        try {
            // Load Nunito-Regular
            InputStream regularFontStream = Fonts.class.getResourceAsStream("/assets/fonts/Nunito-Regular.ttf");
            nunitoRegular = Font.createFont(Font.TRUETYPE_FONT, regularFontStream);

            // Load Nunito-Bold
            InputStream boldFontStream = Fonts.class.getResourceAsStream("/assets/fonts/Nunito-Bold.ttf");
            nunitoBold = Font.createFont(Font.TRUETYPE_FONT, boldFontStream);

            // Register the fonts
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(nunitoRegular);
            ge.registerFont(nunitoBold);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to load fonts");
        }
    }
}

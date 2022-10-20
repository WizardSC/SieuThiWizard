/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.MainSieuThiGUI;
import javax.swing.UIManager;

/**
 *^
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        new MainSieuThiGUI().setVisible(true);
//        new LoginGUI().setVisible(true);
//        new SplashScreenGUI().setVisible(true);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e)
        {
            
        }
    }
}

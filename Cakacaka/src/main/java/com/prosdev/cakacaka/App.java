package com.prosdev.cakacaka;

import com.prosdev.cakacaka.manager.SpringManager;
import com.prosdev.cakacaka.view.MainFrame;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
                        | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } finally {          
                    SpringManager.getINSTANCE();
                    MainFrame frame =new MainFrame();
                    frame.setVisible(true);
                    
                }
            }
        });
           
    }
}

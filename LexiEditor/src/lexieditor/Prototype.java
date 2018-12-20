/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexieditor;

/**
 *
 * @author Hardik Sharma
 */
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import static lexieditor.Edit.c;
import static lexieditor.Edit.choosemenu;
import static lexieditor.Edit.dp;
import static lexieditor.Edit.menuBar;
import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.BadLocationException;

class Prototype implements Cloneable {
   
   Prototype(){
       try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GUI Error");
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Edit edit = new Edit();
                } catch (BadLocationException ex) {
                    Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
}
  @Override
	public Object clone() throws CloneNotSupportedException{
		return new Prototype();	
	}
}


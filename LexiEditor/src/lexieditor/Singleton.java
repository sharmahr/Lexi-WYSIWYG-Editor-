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
import lexieditor.Edit;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



 class Singleton
{
private static Singleton o =new Singleton();
    private Singleton()
    {}
    
   public static Singleton getInstance(){
      return o;
   } 
    
void cut()
{
    Edit.pane.cut();
}

void copy()
{
    Edit.pane.copy();
}

void copyAll()
{
    String text = Edit.pane.getText().toString();
    Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = defaultToolkit.getSystemClipboard();
    clipboard.setContents(new StringSelection(text), null);
}

void paste()
{
    Edit.pane.paste();
   }
}


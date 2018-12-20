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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;


 class Edit {
    
    static JFrame frame,f2,f3,fontframe;
    static JTextPane pane;
    static JButton bim,set,button,button1;
    static Container cp;
     
   
    static Document doc; 
    static Style style;
    static StyleContext context;
    static StyledDocument document;
    static SimpleAttributeSet attributeSet;
     
    static JTextField a,b,size1;
    static JScrollPane scrollpane;
    static JLabel l1,x,y,size,label;
    static JComboBox combobox;
    static Canvas c;
    static JMenuBar menuBar;
    static JMenu file,edit,imgopt,fontopt,bcolor,tools,options;
    static JMenuItem load,print,save,Quit,about,fontsize,newfile,backgroundcolor,fontcolor,
            fontstyle,fontface,rotateimg,resizeimg,removeimg,insertimg,cut,copy,copyall,paste,undo,redo;
 
    static Color c1;
    static float zoomLevel = 1.0f;
    static float textSize = 12.0f;
    static String selectedFont = "Arial";

    static Object choosemenu;
    static DecoratorPattern dp;   
 
    
    
    Edit() throws BadLocationException{
       
        frame = new JFrame("TEXT EDITOR");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        cp = frame.getContentPane();  
        pane = new JTextPane();  
         
        attributeSet = new SimpleAttributeSet();  
      
        // Set the attributes before adding text 
        pane.setCharacterAttributes(attributeSet, true);  
        doc= pane.getStyledDocument();  
  
        JScrollPane scrollPane = new JScrollPane(pane);  
        cp.add(scrollPane, BorderLayout.CENTER);  
  
        frame.setSize(1500,1000); 
        frame.setVisible(true);  
        frame.setJMenuBar((new menuBar()).createMenuBar());
        
    }
}
    
public class LexiEditor {

   static Prototype p;
   
    @SuppressWarnings({"UseSpecificCatch", "Convert2Lambda"})
    
    public static void main(String[] args) {
         p = new Prototype();
    }
    
}

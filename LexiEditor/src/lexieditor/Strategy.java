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
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.ElementIterator;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

interface Photocanvas{
   void imageop();
}

public class Strategy {
    Photocanvas o;
    public Strategy(String s){
       InsertImage i = new InsertImage();
       i.imageop();
    }
    public Strategy(String s,Canvas c){
        switch(s){
            case "Insert Image": 
                o = new InsertImage();   
                break;
            case "Remove Image":  
                o = new RemoveImage();
                break; 
        }
        o.imageop();
   }
}
class InsertImage implements Photocanvas{

    @Override
    public void imageop() {
        File pictureFile = choosePictureFile();
			
			if (pictureFile == null) {
			
				Edit.pane.requestFocusInWindow();
				return;
			}
			
			ImageIcon icon = new ImageIcon(pictureFile.toString());			
			JButton picButton = new JButton(icon);
			picButton.setBorder(new LineBorder(Color.WHITE));
			picButton.setMargin(new Insets(0,0,0,0));
			picButton.setAlignmentY(.9f);
			picButton.setAlignmentX(.9f);
	                picButton.setName("PICTURE_ID_" + new Random().nextInt());
			Edit.pane.insertComponent(picButton);
			Edit.pane.requestFocusInWindow();
        
    }
        private File choosePictureFile() {
		
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
								"PNG, JPG & GIF Images", "png", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			if (chooser.showOpenDialog(Edit.frame) == JFileChooser.APPROVE_OPTION) {
			
				return chooser.getSelectedFile();
			}
			else {
				return null;
			}
		}
}

class RemoveImage implements Photocanvas{
     String pictureButtonName__;
    static final String ELEM = AbstractDocument.ElementNameAttribute;
    static final String COMP = StyleConstants.ComponentElementName;
   @Override
    public void imageop() {
      StyledDocument doc = (DefaultStyledDocument)Edit.pane.getDocument();
			ElementIterator iterator = new ElementIterator(doc);
			Element element;
			
			while ((element = iterator.next()) != null) {
			
				AttributeSet attrs = element.getAttributes();
			
				if (attrs.containsAttribute(ELEM, COMP)) {
                                    try {
							doc.remove(element.getStartOffset(), 1); // length = 1
						}
						catch (BadLocationException ex_) {
			
							throw new RuntimeException(ex_);
						}
					
				}
			}
	
			Edit.pane.requestFocusInWindow();
			pictureButtonName__ = null;
    }
}


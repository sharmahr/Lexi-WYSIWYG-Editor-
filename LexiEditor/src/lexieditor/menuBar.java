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
import javax.swing.undo.UndoManager;


public  class menuBar implements ActionListener{
   
    menuBar(){
        
    }
    public JMenuBar createMenuBar()
    {
        menuBar = new JMenuBar();
        Edit.file = new JMenu(" File");
        Edit.edit = new JMenu("     About");
        Edit.tools = new JMenu("     Tools");
        Edit.load = new JMenuItem("Load File");
        Edit.save = new JMenuItem("Save File");
        Edit.print = new JMenuItem("Print File");
        Edit.Quit = new JMenuItem("Quit");
        Edit.imgopt = new JMenu("     Image");
        Edit.fontopt = new JMenu("     Font");
        Edit.fontsize = new JMenuItem("Font Size");
        Edit.backgroundcolor = new JMenuItem("Background Color");
        Edit.newfile = new JMenuItem("New ");
        Edit.fontcolor = new JMenuItem("Font Color");
        Edit.fontstyle = new JMenuItem("Font Style");
        Edit.fontface = new JMenuItem("Font Face");
             
          
        Edit.removeimg = new JMenuItem("Remove Image");
        Edit.insertimg = new JMenuItem("Insert Image");
        Edit.copyall = new JMenuItem("Copy All");
        Edit.paste = new JMenuItem("Paste");
        Edit.cut = new JMenuItem("Cut");
        Edit.copy = new JMenuItem("Copy");
        Edit.options = new JMenu("    Options");
        Edit.undo = new JMenuItem("Undo");
        Edit.redo = new JMenuItem("Redo");
                         
                    
        
        Edit.about = new JMenuItem("About");
        
        
        Edit.load.addActionListener(this);
        Edit.save.addActionListener(this);
        Edit.Quit.addActionListener(this);
        Edit.about.addActionListener(this);
        Edit.fontsize.addActionListener(this);
   
        Edit.backgroundcolor.addActionListener(this);
        Edit.fontcolor.addActionListener(this);
        Edit.fontstyle.addActionListener(this);
        Edit.fontface.addActionListener(this);
            
        
        Edit.removeimg.addActionListener(this);
        Edit.insertimg.addActionListener(this);
        Edit.tools.addActionListener(this);
        Edit.print.addActionListener(this);
            
        Edit.newfile.addActionListener(this);
        Edit.cut.addActionListener(this);
        Edit.copy.addActionListener(this);
        Edit.copyall.addActionListener(this);
        Edit.paste.addActionListener(this);
            
            
        Edit.undo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.UNDO));
        Edit.redo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.REDO));

        menuBar.add(Edit.file);
       
        Edit.file.add(Edit.load);
        Edit.file.add(Edit.save);
        Edit.file.add(Edit.print);
        Edit.file.add(Edit.newfile);
        Edit.file.add(Edit.Quit);
        

        menuBar.add(Edit.edit);
        Edit.edit.add(Edit.about);
        
        menuBar.add(Edit.fontopt);
       
        Edit.fontopt.add(Edit.fontcolor);
        Edit.fontopt.add(Edit.fontstyle);
        Edit.fontopt.add(Edit.fontface);
        Edit.fontopt.add(Edit.fontsize);
        Edit.fontopt.add(Edit.backgroundcolor);
           
         
        menuBar.add(Edit.imgopt);
        Edit.imgopt.add(Edit.insertimg);
        Edit.imgopt.add(Edit.removeimg);
     
          
        menuBar.add(Edit.tools);
        Edit.tools.add(Edit.cut);
        Edit.tools.add(Edit.copy);
        Edit.tools.add(Edit.copyall);
        Edit.tools.add(Edit.paste);
       
        
        menuBar.add(Edit.options);
        Edit.options.add(Edit.undo);
        Edit.options.add(Edit.redo);
        

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        choosemenu = e.getSource();
         Singleton object = Singleton.getInstance();
        if(choosemenu == Edit.save){
            MenuBarClass menubarclass = new MenuBarClass("File");
        }
        if(choosemenu == Edit.load){
            MenuBarClass menubarclass = new MenuBarClass("File");
        }
         if(choosemenu == Edit.print){
            MenuBarClass menubarclass = new MenuBarClass("File");
        }
        if(choosemenu == Edit.Quit){
            MenuBarClass menubarclass = new MenuBarClass("File");
        }
          
        if(choosemenu == Edit.about){
            MenuBarClass menubarclass = new MenuBarClass("About");
        }
        
             
        
        // Strategy design pattern
        if(choosemenu == Edit.insertimg){
            Strategy strategy = new Strategy("Insert Image", c);
        }
        if(choosemenu == Edit.removeimg){
           Strategy strategy = new Strategy("Remove Image", c); 
        }
        
        
        
        
        //Decorator Design pattern
             if(choosemenu == Edit.fontstyle){
             dp = new DecoratorPattern();
        }
             
        if(choosemenu == Edit.fontsize   || choosemenu == Edit.backgroundcolor || 
                choosemenu == Edit.fontcolor || choosemenu == Edit.fontface ){
         FactoryMaker fm = new FactoryMaker();
            FactoryMaker.getFactory(choosemenu);
        }
        
        
    
             
                      if(choosemenu == Edit.fontstyle){
             dp = new DecoratorPattern();
        }
        
        //Singleton design pattern
          if(choosemenu == Edit.cut){
              
               object.cut();
         }
           if(choosemenu == Edit.copy){
              object.copy();
          
        }
           if(choosemenu == Edit.copyall){
               object.copyAll();
          }
            if(choosemenu == Edit.paste){
          object.paste();
        }
                 if(choosemenu == Edit.newfile){
            try {
             Prototype p32 = (Prototype)LexiEditor.p.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(menuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
       
    }
}




	 class UndoActionListener implements ActionListener {
               static UndoManager undoMgr__;
                static enum UndoActionType {UNDO, REDO};
	
		private UndoActionType undoActionType;
	
		public UndoActionListener(UndoActionType type) {
		
			undoActionType = type;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			switch (undoActionType) {
			
				case UNDO:
					if (! undoMgr__.canUndo()) {
				
					Edit.pane.requestFocusInWindow();
						return; // no edits to undo
					}

					undoMgr__.undo();
					break;
					
				case REDO:
					if (! undoMgr__.canRedo()) {
				
						Edit.pane.requestFocusInWindow();
						return; // no edits to redo
					}

					undoMgr__.redo();
			}

			Edit.pane.requestFocusInWindow();
		}
	}
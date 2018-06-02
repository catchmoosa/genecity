package genecity.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.event.*;
import java.lang.Object;


/**
 * <p>Title: ReadHelpFrame</p>
 * <p>Description: Help Frame</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class ReadHelpFrame extends JInternalFrame {
  JScrollPane jScrollPane1 = new JScrollPane();
  JEditorPane jEditorPane1 = new JEditorPane();

  public ReadHelpFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }

  private void getThePage( String location )
{
   // load document and display location
   try {
      jEditorPane1.setPage( location );
   }
   catch ( IOException ioException ) {
      JOptionPane.showMessageDialog( this,
         "Help files not found", "Error",
         JOptionPane.ERROR_MESSAGE );
   }

}



  public static void main(String[] args) {
    ReadHelpFrame readHelpFrame = new ReadHelpFrame();
  }
  private void jbInit() throws Exception {
    this.setClosable(true);
    this.setClosed(true);
    this.setIcon(false);
    this.setIconifiable(true);
    this.setMaximizable(true);
    this.setResizable(true);
    this.setTitle("Online Help");
    jEditorPane1.setEditable(false);
    jEditorPane1.setText("");
    jEditorPane1.addHyperlinkListener(new HyperlinkListener() {

            // if user clicked hyperlink, go to specified page
            public void hyperlinkUpdate( HyperlinkEvent event )
            {
               if ( event.getEventType() ==
                    HyperlinkEvent.EventType.ACTIVATED )
                  getThePage( event.getURL().toString() );
            }

         });
    this.getContentPane().add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jEditorPane1, null);
    getThePage("file:genecity.html");

  }

}


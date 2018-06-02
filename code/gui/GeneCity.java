package genecity.gui;

import javax.swing.UIManager;
import java.awt.*;
import javax.swing.ImageIcon;
//import net.sourceforge.mlf.metouia.*;
//Import com.birosoft.liquid.*;
//import com.shfarr.ui.plaf.fh.*;
//import smooth.*;


/**
 * <p>Title: GeneCity</p>
 * <p>Description: Epidemiological Simulation of a Hereditary Disease in a Multi-Agent System</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class GeneCity {
  boolean packFrame = false;
  MenuFrame frame;
  //Construct the application
  public GeneCity() {
    SplashScreen ss = new SplashScreen(new ImageIcon("GeneCityLogo.jpg"));
    ss.show();
    frame = new MenuFrame();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2-20);
    ss.setVisible(false);
    frame.setVisible(true);
  }
  //Main method
  public static void main(String[] args) {
    try {
     //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
     //UIManager.setLookAndFeel(new MetouiaLookAndFeel());
     //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
     //UIManager.setLookAndFeel(("com.shfarr.ui.plaf.fh.FhLookAndFeel"));
     //UIManager.setLookAndFeel("smooth.SmoothLookAndFeel");
    /* com.incors.plaf.alloy.AlloyLookAndFeel.setProperty("alloy.licenseCode", "2004/07/08#eldemet@hotmail.com#odxlve#1986ew");
     javax.swing.LookAndFeel alloyLnF = new com.incors.plaf.alloy.AlloyLookAndFeel();
     javax.swing.UIManager.setLookAndFeel(alloyLnF);
   */ }
    catch(Exception e) {
      e.printStackTrace();
    }
    new GeneCity();
  }
}



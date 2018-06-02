package genecity.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;


/**
 * <p>Title: SplashScreen</p>
 * <p>Description: Display Slash Screen</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class SplashScreen
    extends JWindow {

  private ImageIcon icon;

  /**
   * Creates a new SplashScreen with the specified decoration.
   * @param icon the image to be displayed in the splash window.
   */
  public SplashScreen(ImageIcon icon) {
    this.icon = icon;
    getContentPane().add(new JLabel(icon));
  }

  /**
   * Shows the spalsh screen and positions it centrally on the screen.
   */
  public void show() {
    int iconWidth = icon.getIconWidth();
    int iconHeight = icon.getIconHeight();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width - iconWidth) / 2,
              (screenSize.height - iconHeight) / 2, iconWidth, iconHeight);
    super.show();
  }

}

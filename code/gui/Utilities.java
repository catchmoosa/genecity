package genecity.gui;


import java.io.File;
import javax.swing.ImageIcon;


/**
 * <p>Title: Utilities</p>
 * <p>Description: File Extentions</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class Utilities {
  public final static String grd = "gcs";
  public final static String set = "set";
  public final static String txt= "txt";

  /**
   * Gets the extension of a file
   * @param f the file
   * @return the file extension
   */
  public static String getExtension(File f) {
    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(i + 1).toLowerCase();
    }
    return ext;
  }

  /**
   * Returns an ImageIcon, or null if the path was invalid
   * @param path the path
   * @return the ImageIcon
   */
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = Utilities.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    }
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}

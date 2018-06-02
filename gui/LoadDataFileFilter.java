package genecity.gui;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;



/**
 * <p>Title: LoadDataFileFilter</p>
 * <p>Description: Data File Specifications</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class LoadDataFileFilter
    extends FileFilter {

  /**
   * Accepts all directories and all grd files
   * @param f the file
   * @return true if its a grid file flase otherway
   */
  public boolean accept(File f) {
    if (f.isDirectory()) {
      return true;
    }

    String extension = Utilities.getExtension(f);
    if (extension != null) {
      if (extension.equals(Utilities.txt)) {
        return true;
      }
      else {
        return false;
      }
    }

    return false;
  }

  /**
   * gets the description of this filter
   * @return the description of this filter
   */
  public String getDescription() {
    return "Genecity Files";
  }
}

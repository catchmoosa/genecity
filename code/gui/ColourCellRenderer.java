package genecity.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.Color;
import genecity.SuperAgent;

/**
 * <p>Title: ColorCellRenderer</p>
 * <p>Description: Color Table Cells</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


class ColorCellRenderer
    extends DefaultTableCellRenderer {

  public Component getTableCellRendererComponent(JTable table, Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus, int row,
                                                 int column) {

    // Obtains default cell settings
    Component cell = super.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column);

      if ( ( ( (Integer) table.getValueAt(row, 2)).intValue() +
            ( (Integer) table.getValueAt(row, 3)).intValue() - SuperAgent.epoch) <=
          0) {
        cell.setBackground(Color.lightGray);
      }else if(table.getValueAt(row,4).toString().startsWith("Diseased")){
        cell.setBackground(Color.pink);
      }else if(table.getValueAt(row,4).toString().startsWith("Carrier")){
        cell.setBackground(Color.cyan);
      }else if((( (Integer) table.getValueAt(row, 2)).intValue() > SuperAgent.epoch)){
        //not yet alive
        cell.setBackground(Color.green);
      }
      else {
        cell.setBackground(Color.white);
      }

      return cell;
  }
}

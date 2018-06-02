package genecity.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import jade.util.leap.*;
import javax.swing.table.DefaultTableModel;


/**
 * <p>Title: MyTableModel</p>
 * <p>Description: Table Model</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class MyTableModel extends AbstractTableModel {
      private String[] columnNames = {"Name","Sex","Epoch Birth","Life Epochs","Health","Fear","Information","Comments","Family ID"};
      private Object[][] data={{"","","","","","","","",""}};


      public MyTableModel(){
      }

      public void newData(Object[][] tableObj1) {
       this.data=tableObj1;  //temp;
      }


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }


    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

   public Object[] getValueAt(int x) {
     return data[x];
   }

}

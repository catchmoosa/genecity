package genecity.gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import genecity.SuperAgent;
import javax.swing.border.*;
import java.text.DecimalFormat;
import de.progra.charting.swing.*;
import de.progra.charting.event.*;
import de.progra.charting.model.*;
import de.progra.charting.render.*;
import de.progra.charting.*;


/**
 * <p>Title: GraphFrame</p>
 * <p>Description: Internal Frame of Graph</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class GraphFrame extends JInternalFrame implements ActionListener, ChartDataModelListener{


  ChartPanel panel;
  ChartPanel panel2;
  EditableChartDataModel data;

//  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel populationPanel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
//  JPanel jPanel1 = new JPanel();
//  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();

  public GraphFrame() {
    try {
      jbInit();
    }
    catch (Exception ex) {
    }
  }

  public void actionPerformed(ActionEvent evt) {
  }

  public void upDatePopulationGraph(){
    data.insertValue(0, new Double(genecity.SuperAgent.totalAgentPopulation),
                     new Double(genecity.SuperAgent.epoch));
    data.insertValue(2, new Double(genecity.SuperAgent.diseasedPopulation),
                     new Double(genecity.SuperAgent.epoch));
    data.insertValue(1, new Double(genecity.SuperAgent.carriersPopulation),
                     new Double(genecity.SuperAgent.epoch));

    double carriersPopPerc = (double) genecity.SuperAgent.carriersPopulation /
        (double) genecity.SuperAgent.totalAgentPopulation * 100;
    double diseasedPopPerc = (double) genecity.SuperAgent.diseasedPopulation /
        (double) genecity.SuperAgent.totalAgentPopulation * 100;
    double totalMutPopPerc = (double) (genecity.SuperAgent.carriersPopulation +
                                       genecity.SuperAgent.diseasedPopulation) /
        (double) genecity.SuperAgent.totalAgentPopulation * 100;

  }


  public void exportImages(String filename){
    if(MenuFrame.runPauseStatus>1){
      try {
        this.panel.repaint();
/*        SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        Date currentTime_1 = new Date();
        String dateString = formatter.format(currentTime_1);*/
        ChartEncoder.createPNG(new FileOutputStream(new File(filename+".png")),
                                this.panel);
      }
      catch (Exception e) {
      }
    }else{
      JOptionPane.showMessageDialog(null,"You must run a simulation","Error in save",JOptionPane.OK_OPTION);
    }
}


  private void jbInit() throws Exception {
    this.setClosable(true);
    this.setIconifiable(true);
    this.setMaximizable(true);
    this.setMaximum(false);
    this.setResizable(true);
    this.setTitle("Population Chart");
    this.setEnabled(true);
    populationPanel.setLayout(borderLayout1);
//    jPanel1.setLayout(borderLayout1);
//    jPanel3.setLayout(borderLayout1);
    this.getContentPane().add(populationPanel,  BorderLayout.CENTER);

//    jTabbedPane1.add(jPanel3,    "Simulation Statistical Data");
//    jTabbedPane1.add(jPanel1,  "Yet Another Graph");
//    jTabbedPane1.add(populationPanel,   "Population");

    //GRAPH-1
    double[][] model = {{genecity.SuperAgent.currentGridPopulation},{0},{0}};
    double[] columns = {0};
    String[] rows = {"Total Agents","Carriers", "Diseased Carriers"};
    String title = "Agent Population";
    // Create an editable chart data model
    data = new EditableChartDataModel(model, columns, rows);

    // Creating the Swing ChartPanel instead of DefaultChart
    panel = new ChartPanel(data, title, DefaultChart.LINEAR_X_LINEAR_Y);
    // Adding ChartRenderer as usual
    panel.addChartRenderer(new LineChartRenderer(panel.getCoordSystem(), data),1);
    // Register EventListener
    data.addChartDataModelListener(this);
    populationPanel.add(panel);
  }


public void chartDataChanged(ChartDataModelEvent evt){
    panel.revalidate();
    repaint();
  }
}

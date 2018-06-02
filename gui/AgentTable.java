package genecity.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.text.DecimalFormat;
import jade.wrapper.*;
import java.io.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.JDialog;
import genecity.SuperAgent;
import genecity.agentCommunication.Families;
import javax.swing.event.*;
import java.beans.*;


/**
 * <p>Title: AgentTable</p>
 * <p>Description: Internal Frame Table of Data</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class AgentTable extends JInternalFrame {
  TitledBorder titledBorder1;
  TitledBorder titledBorder4;
  JPanel jPanel1 = new JPanel(new GridLayout(1,0));
  JScrollPane jScrollPane1=new JScrollPane();
  private float previousPop=(float)(SuperAgent.totalAgentPopulation);
  boolean flag2=false;

  JTable jTable1 = new JTable(){
    public TableCellRenderer getCellRenderer(int row, int column) {
        return ccr;
    }
  };

  private MyTableModel myTableModel=new MyTableModel();

  public AgentTable() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }


  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"People Born in Simulation");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"% Carriers & Diseased /Population");
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Information Metrics /Epoch");
    titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Demographic Metrics /Epoch");
    jTable1.setModel(myTableModel);
    jTable1.setShowHorizontalLines(true);
    jTable1.setShowVerticalLines(false);
    jTable1.setPreferredScrollableViewportSize(new Dimension(500, 70));
    jTable1.addMouseListener(new AgentTable_jTable1_mouseAdapter(this));
    jTable1.setAutoscrolls(true);
    jTable1.setOpaque(true);
    jTable1.getTableHeader().setToolTipText("Click on a row to view the family tree");
    jTable1.setCellSelectionEnabled(true);
    jTable1.setColumnSelectionAllowed(false);
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jScrollPane1.setAutoscrolls(true);
    this.setClosable(true);
    this.setIconifiable(true);
    this.setMaximizable(true);
    this.setResizable(true);
    this.setTitle("Table of Agent");
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setPreferredSize(new Dimension(200, 200));
    jPanel2.setLayout(borderLayout1);
    jPanel3.setBorder(null);
    jPanel3.setDebugGraphicsOptions(0);
    jPanel3.setLayout(null);
    jLabel8.setBounds(new Rectangle(251, 15, 74, 15));
    jLabel8.setText("% Diseased");
    jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel4.setBounds(new Rectangle(122, 82, 48, 15));
    jLabel4.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel4.setText("0");
    jLabel26.setBounds(new Rectangle(331, 37, 55, 15));
    jLabel26.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel26.setText("0");
    jLabel12.setBounds(new Rectangle(19, 37, 80, 15));
    jLabel12.setText("Total");
    jPanel4.setLayout(null);
    jPanel4.setBackground(Color.white);
    jPanel4.setBorder(titledBorder1);
    jLabel1.setText("Male Agents:");
    jLabel1.setBounds(new Rectangle(19, 82, 90, 15));
    jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel3.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel3.setText("%");
    jLabel3.setBounds(new Rectangle(174, 15, 34, 15));
    jLabel13.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel13.setText("0");
    jLabel13.setBounds(new Rectangle(331, 60, 55, 15));
    jLabel2.setText("Female Agents:");
    jLabel2.setBounds(new Rectangle(19, 60, 94, 15));
    jLabel14.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel14.setText("0");
    jLabel14.setBounds(new Rectangle(251, 60, 58, 15));
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText("% Carriers");
    jLabel9.setBounds(new Rectangle(331, 15, 76, 15));
    jLabel37.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel37.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel37.setText("0");
    jLabel7.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel7.setRequestFocusEnabled(true);
    jLabel7.setText("0");
    jLabel7.setBounds(new Rectangle(176, 60, 58, 15));
    jLabel25.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel25.setToolTipText("");
    jLabel25.setText("0");
    jLabel25.setBounds(new Rectangle(251, 37, 58, 15));
    jLabel36.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel36.setForeground(Color.black);
    jLabel36.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel36.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel36.setText("Epoch");
    jLabel6.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel6.setText("0");
    jLabel6.setBounds(new Rectangle(122, 60, 47, 15));
    jLabel27.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel27.setText("0");
    jLabel27.setBounds(new Rectangle(122, 38, 50, 15));
    jLabel15.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel15.setText("0");
    jLabel15.setBounds(new Rectangle(251, 82, 58, 15));
    jLabel10.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel10.setText("0");
    jLabel10.setBounds(new Rectangle(331, 82, 55, 15));
    jLabel5.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel5.setText("0");
    jLabel5.setBounds(new Rectangle(176, 82, 58, 15));
    jPanel7.setLayout(gridBagLayout1);
    jButton1.setBackground(Color.green);
    jButton1.setEnabled(false);
    jButton1.setSelected(false);
    jButton1.setText("");
    jButton2.setBackground(Color.cyan);
    jButton2.setEnabled(false);
    jButton2.setDoubleBuffered(false);
    jButton2.setText("");
    jButton3.setBackground(Color.pink);
    jButton3.setEnabled(false);
    jButton3.setText("");
    jLabel22.setText("Unborn Children");
    jLabel23.setText("Carriers of mutation");
    jLabel24.setText("Diseased Agents");
    jButton4.setBackground(Color.lightGray);
    jButton4.setEnabled(false);
    jButton4.setText("");
    jLabel31.setText("Not alive");
    jPanel5.setBackground(Color.white);
    jPanel5.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel5.setLayout(borderLayout2);
    jLabel11.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel11.setText("100");
    jLabel11.setBounds(new Rectangle(176, 37, 40, 15));
    jLabel16.setText("Sum");
    jLabel16.setBounds(new Rectangle(122, 15, 40, 15));
    jPanel8.setBackground(Color.white);
    jPanel8.setBorder(titledBorder2);
    jPanel8.setLayout(gridLayout1);
    jLabel17.setText("% Carriers");
    jLabel21.setText("%");
    jLabel21.setBounds(new Rectangle(223, 149, 58, 15));
    jLabel21.setText("% Diseased");
    jLabel18.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel18.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel18.setText("0");
    jLabel19.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel19.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel19.setText("0");
    jPanel9.setBackground(Color.white);
    jPanel9.setBorder(titledBorder3);
    jPanel9.setLayout(null);
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel20.setText("Mean Information Exchange:");
    jLabel20.setBounds(new Rectangle(21, 22, 170, 15));
    jLabel28.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel28.setText("Mean no. People Informed:");
    jLabel28.setBounds(new Rectangle(21, 41, 159, 16));
    jLabel29.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel29.setText("Mean Media Information:");
    jLabel29.setBounds(new Rectangle(20, 60, 143, 16));
    jPanel10.setBackground(Color.white);
    jPanel10.setBorder(titledBorder4);
    jPanel10.setLayout(null);
    jLabel210.setText("Mean Births/epoch:");
    jLabel210.setBounds(new Rectangle(23, 21, 148, 15));
    jLabel210.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel211.setBounds(new Rectangle(23, 40, 159, 16));
    jLabel211.setText("Mean Deaths/epoch:");
    jLabel211.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel212.setBounds(new Rectangle(23, 60, 159, 16));
    jLabel212.setText("Mean new Families/epoch:");
    jLabel212.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel30.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel30.setText("0");
    jLabel30.setBounds(new Rectangle(197, 21, 70, 16));
    jLabel32.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel32.setText("0");
    jLabel32.setBounds(new Rectangle(197, 41, 66, 16));
    jLabel33.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel33.setText("0");
    jLabel33.setBounds(new Rectangle(197, 60, 68, 16));
    jLabel34.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel34.setText("0");
    jLabel34.setBounds(new Rectangle(198, 19, 59, 16));
    jLabel35.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel35.setText("0");
    jLabel35.setBounds(new Rectangle(198, 39, 66, 16));
    jLabel38.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel38.setText("0");
    jLabel38.setBounds(new Rectangle(198, 60, 63, 16));
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jScrollPane1);
    this.getContentPane().add(jPanel2,  BorderLayout.SOUTH);
    jPanel2.add(jPanel3, BorderLayout.NORTH);
    jPanel4.add(jLabel12, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(jLabel1, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(jLabel6, null);
    jPanel4.add(jLabel27, null);
    jPanel4.add(jLabel16, null);
    jPanel4.add(jLabel5, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(jLabel11, null);
    jPanel4.add(jLabel3, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jLabel25, null);
    jPanel4.add(jLabel14, null);
    jPanel4.add(jLabel15, null);
    jPanel4.add(jLabel10, null);
    jPanel4.add(jLabel13, null);
    jPanel4.add(jLabel26, null);
    jPanel7.add(jPanel10,  new GridBagConstraints(2, 1, 1, 2, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(8, 10, 3, 5), 264, 91));
    jPanel10.add(jLabel211, null);
    jPanel10.add(jLabel210, null);
    jPanel10.add(jLabel212, null);
    jPanel10.add(jLabel35, null);
    jPanel10.add(jLabel34, null);
    jPanel10.add(jLabel38, null);
    jPanel7.add(jPanel9,  new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3, 9, 0, 5), 268, 88));
    jPanel9.add(jLabel20, null);
    jPanel9.add(jLabel28, null);
    jPanel9.add(jLabel29, null);
    jPanel9.add(jLabel30, null);
    jPanel9.add(jLabel33, null);
    jPanel9.add(jLabel32, null);
    jPanel7.add(jPanel8,  new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(8, 6, 3, 0), 16, 25));
    jPanel8.add(jLabel17, null);
    jPanel8.add(jLabel19, null);
    jPanel8.add(jLabel21, null);
    jPanel8.add(jLabel18, null);
    jPanel7.add(jPanel5,  new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(8, 9, 3, 0), 97, 13));
    jPanel5.add(jLabel37, BorderLayout.CENTER);
    jPanel5.add(jLabel36, BorderLayout.NORTH);
    jPanel7.add(jPanel4,  new GridBagConstraints(0, 0, 2, 2, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3, 9, 0, 0), 447, 111));
    this.getContentPane().add(jPanel6, BorderLayout.NORTH);
    jPanel6.add(jButton1, null);
    jPanel6.add(jLabel22, null);
    jPanel6.add(jButton2, null);
    jPanel6.add(jLabel23, null);
    jPanel6.add(jButton3, null);
    jPanel6.add(jLabel24, null);
    jPanel6.add(jButton4, null);
    jPanel6.add(jLabel31, null);
    jPanel2.add(jPanel7, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jTable1, null);
  }

  public void newTable(Object[][] tableObj){
    myTableModel.newData(tableObj);
    jTable1.clearSelection();
    jTable1.setModel(myTableModel);
    jTable1.revalidate();
    jTable1.repaint();
    MenuFrame.jButton3.setEnabled(true);

  }


  void jTable1_mouseClicked(MouseEvent e) {
    int index=jTable1.getSelectedRow();

    if(index!=-1){
      Object[] family=myTableModel.getValueAt(index);
      if(Integer.parseInt(family[2].toString())>=0){
        int familyID = Integer.parseInt(family[8].toString());
        MenuFrame.la.pauseAgents();
        Families des2 = (Families) SuperAgent.allFamiliesList.get(familyID - 1);
        MenuFrame.drawPanelFrame2.family2View = des2;
        if (MenuFrame.drawFamilyPanelFrame.isVisible() == false) {
          try{
            MenuFrame.jDesktopPane1.add(MenuFrame.drawFamilyPanelFrame);
          }catch(Exception exept){
            System.out.println("agenttable 217");
          }
          MenuFrame.drawFamilyPanelFrame.setSize(530, 350);
          MenuFrame.drawFamilyPanelFrame.setLocation(500, 20);
          MenuFrame.drawFamilyPanelFrame.setTitle("Genealogical Trees");
          MenuFrame.drawFamilyPanelFrame.setVisible(true);
          MenuFrame.jButton2.setEnabled(true);
        }
      }else{
        try {
          MenuFrame.drawFamilyPanelFrame.setIcon(true);
        }
        catch (PropertyVetoException ex) {
        }
        JOptionPane.showMessageDialog(null,"There are no data for this agent","Insufficient Data",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  static ColorCellRenderer ccr = new ColorCellRenderer();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel26 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel37 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JPanel jPanel7 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder2;
  DecimalFormat t=new DecimalFormat("0.00");
  JPanel jPanel6 = new JPanel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JButton jButton4 = new JButton();
  JLabel jLabel31 = new JLabel();
  JPanel jPanel5 = new JPanel();


  private float cm=0;
  private float cf=0;
  private float cmd=0;
  private float cfd=0;
  private float cmc=0;
  private float cfc=0;
  private float tap=0;
  private float prp=0;
  private float cb=0;
  private float cd=0;
  private float cfam=0;
  private float cpi=0;
  private float cimed=0;
  private float cie=0;
  private int totalp=0;
  private int carriersp=0;
  private int diseasedp=0;
  JLabel jLabel11 = new JLabel();
  JLabel jLabel16 = new JLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  TitledBorder titledBorder3;
  JLabel jLabel17 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel9 = new JPanel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JPanel jPanel10 = new JPanel();
  JLabel jLabel210 = new JLabel();
  JLabel jLabel211 = new JLabel();
  JLabel jLabel212 = new JLabel();
  JLabel jLabel30 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JLabel jLabel33 = new JLabel();
  JLabel jLabel34 = new JLabel();
  JLabel jLabel35 = new JLabel();
  JLabel jLabel38 = new JLabel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();

  public void trigger(){
    cm+=SuperAgent.cm;
    cf+=SuperAgent.cf;
    cmd+=SuperAgent.cmd;
    cfd+=SuperAgent.cfd;
    cmc+=SuperAgent.cmc;
    cfc+=SuperAgent.cfc;
    tap=SuperAgent.totalAgentPopulation;
    float pop=(float)SuperAgent.cp;
    cb+=SuperAgent.cb;
    cd+=SuperAgent.cd;
    cfam+=SuperAgent.cfam;
    cpi+=SuperAgent.cpi;
    cimed+=SuperAgent.cimed;
    cie+=SuperAgent.cie;
    totalp=SuperAgent.totalAgentPopulation;
    carriersp=SuperAgent.carriersPopulation;
    diseasedp=SuperAgent.diseasedPopulation;

    jLabel37.setText(Integer.toString(SuperAgent.epoch));
    jLabel4.setText(Integer.toString((int)cm));
    jLabel6.setText(Integer.toString((int)cf));
    jLabel5.setText(t.format((100*cm/(cf+cm))).toString());
    jLabel7.setText(t.format((100*cf/(cf+cm))).toString());
    jLabel27.setText(Integer.toString((int)(cm+cf)));
    jLabel15.setText(t.format((float)(cmd)*100/(cf+cm)));
    jLabel14.setText(t.format((float)(cfd)*100/(cf+cm)));
    jLabel10.setText(t.format((float)(cmc)*100/(cf+cm)));
    jLabel13.setText(t.format((float)(cfc)*100/(cf+cm)));
    jLabel25.setText(t.format((float)(cmd+cfd)*100/(cf+cm)));
    jLabel26.setText(t.format((float)(cmc+cfc)*100/(cf+cm)));
    jLabel19.setText(t.format((float)carriersp*100/(float)totalp));
    jLabel18.setText(t.format((float)diseasedp*100/(float)totalp));

    jLabel30.setText(t.format(cie/((float)SuperAgent.epoch+1)));
    jLabel32.setText(t.format(cpi/((float)SuperAgent.epoch+1)));
    jLabel33.setText(t.format(cimed/((float)SuperAgent.epoch+1)));

    jLabel34.setText(t.format(cb/((float)SuperAgent.epoch+1)));
    jLabel35.setText(t.format(cd/((float)SuperAgent.epoch+1)));
    jLabel38.setText(t.format(cfam/((float)SuperAgent.epoch+1)));

  }
}

class AgentTable_jTable1_mouseAdapter extends java.awt.event.MouseAdapter {
  AgentTable adaptee;

  AgentTable_jTable1_mouseAdapter(AgentTable adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jTable1_mouseClicked(e);
  }
}
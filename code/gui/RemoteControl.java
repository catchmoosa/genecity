package genecity.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;
import genecity.agentCommunication.*;
import genecity.genetics.*;
import genecity.SuperAgent;

/**
 * <p>Title: RemoteControl</p>
 * <p>Description: Interface for online control</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class RemoteControl extends JInternalFrame {
  public JTextArea jTextArea1 = new JTextArea();
  public static Description newPerson=new Description();
  private ButtonGroup sexGroup;
  private jade.util.leap.ArrayList newAgentList=new jade.util.leap.ArrayList();
  public JProgressBar jProgressBar1 = new JProgressBar();
  public JScrollPane jScrollPane1 = new JScrollPane();
  private String healthComboBox[]={"Healthy", "Carrier", "Diseased"};
  private int diseaseType=1;
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  ImageIcon i11,i12,i21,i22,i31,i32;
  ImageIcon i111,i121,i211,i221,i311,i321;
  ImageIcon i40,i42,i45;
  ImageIcon mediaImage1;
  JSlider jSlider1 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JSlider jSlider2 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JSlider jSlider3 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JSlider jSlider4 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  public static int rcWeight1=50;
  public static int rcWeight2=50;
  public static int rcWeight3=50;
  public static int rcWeight4=50;
  public static int rcWeight5=50;
  public static int rcMedia=50;
  public static int rcMediaT=0;
  public static int rcMediaP=50;
  public static boolean rcMediaNeigh=false;
  int[] args=new int[8];
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JSplitPane jSplitPane1 = new JSplitPane();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea jTextArea2 = new JTextArea();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JSlider jSlider6 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JLabel jLabel20 = new JLabel();
  JSpinner jSpinner1 = new JSpinner();
  JLabel jLabel21 = new JLabel();
  SpinnerNumberModel mediaEpochSpinnerNumberModel = new SpinnerNumberModel(1,1,20,1);
  SpinnerNumberModel agentAgeSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getlifeSpan(),18,110,1);
  int epochPressed=-1;
  JSlider jSlider7 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JLabel jLabel22 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel24 = new JLabel();
  JSlider jSlider9 = new JSlider(SwingConstants.HORIZONTAL,0,15,6);
  JLabel jLabel25 = new JLabel();
  JLabel jLabel26 = new JLabel();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JLabel jLabel32 = new JLabel();
  JSpinner jSpinner3 = new JSpinner();
  public static JButton jButtonAddAgent = new JButton();
  JSlider jSlider10 = new JSlider(SwingConstants.HORIZONTAL,0,15,6);
  JSlider jSlider11 = new JSlider(SwingConstants.HORIZONTAL,0,31,15);
  JLabel jLabel33 = new JLabel();
  JSlider jSlider12 = new JSlider(SwingConstants.HORIZONTAL,0,31,15);
  JSlider jSlider13 = new JSlider(SwingConstants.HORIZONTAL,0,15,6);
  JLabel jLabel34 = new JLabel();
  JLabel jLabel35 = new JLabel();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel37 = new JLabel();
  JPanel jPanel12 = new JPanel();
  JRadioButton jRadioButton1 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  BorderLayout borderLayout5 = new BorderLayout();
  JComboBox jComboBox1 = new JComboBox(healthComboBox);
  JLabel jLabel30 = new JLabel();
  JLabel jLabel31 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JLabel jLabel38 = new JLabel();
  JTextField jTextField2 = new JTextField();
  JCheckBox jCheckBox1 = new JCheckBox();
  JCheckBox jCheckBox2 = new JCheckBox();
  JSlider jSlider15 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
  JLabel jLabel48 = new JLabel();
  JLabel jLabel49 = new JLabel();


  public RemoteControl() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();
  }
  private void jbInit() throws Exception {
    image1 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("grid.png"));
    image2 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("details.png"));
    image3 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("infoAgent.png"));
    i11 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("11.png"));
    i12 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("12.png"));
    i21 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("21.png"));
    i22 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("22.png"));
    i31 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("31.png"));
    i32 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("32.png"));
    i111 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("111.png"));
    i121 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("121.png"));
    i211 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("211.png"));
    i221 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("221.png"));
    i311 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("311.png"));
    i321 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("321.png"));
    i40 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("40.png"));
    i42 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("42.png"));
    i45 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("45.png"));
    mediaImage1 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("mediaEarth.png"));

    jTextArea1.setBackground(Color.white);
//    jTextArea1.setBorder(null);
    jTextArea1.setEditable(false);
    jTextArea1.setSelectionEnd(0);
    jTextArea1.setSelectionStart(0);
    jTextArea1.setText("GeneCity Launched\n");
    jTextArea1.setWrapStyleWord(true);
    this.getContentPane().setLayout(borderLayout3);
//    this.setFrameIcon(null);
    this.setIcon(false);
    this.setIconifiable(true);
    this.setMaximum(false);
    this.setResizable(false);
    this.setTitle("Agent Remote Control");
//    this.setBorder(BorderFactory.createLineBorder(Color.black));
    jSlider1.setPaintTicks(false);
    jSlider1.setBackground(UIManager.getColor("control"));
    jSlider1.setBounds(new Rectangle(92, 42, 132, 39));
    jSlider1.addChangeListener(new RemoteControl_jSlider1_changeAdapter(this));
    jProgressBar1.setBackground(Color.lightGray);
    jProgressBar1.setMinimumSize(new Dimension(10, 22));
    jProgressBar1.setString("0% waiting...");
    jProgressBar1.setStringPainted(true);
    jSlider2.setPaintTicks(false);
    jSlider2.setBackground(UIManager.getColor("control"));
    jSlider2.setBounds(new Rectangle(92, 75, 132, 40));
    jSlider2.addChangeListener(new RemoteControl_jSlider2_changeAdapter(this));
    jSlider3.setPaintTicks(false);
    jSlider3.setBackground(UIManager.getColor("control"));
    jSlider3.setBounds(new Rectangle(93, 8, 132, 36));
    jSlider3.addChangeListener(new RemoteControl_jSlider3_changeAdapter(this));
    jSlider4.addChangeListener(new RemoteControl_jSlider4_changeAdapter(this));
    jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel1.setText("50%");
    jLabel1.setBounds(new Rectangle(238, 19, 34, 15));
    jLabel2.setToolTipText("");
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setText("50%");
    jLabel2.setBounds(new Rectangle(237, 54, 34, 15));
    jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel3.setText("50%");
    jLabel3.setBounds(new Rectangle(237, 88, 34, 15));
    jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel4.setText("50%");
    jLabel4.setBounds(new Rectangle(237, 123, 34, 15));
    jLabel5.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel5.setText("Proximity");
    jLabel5.setBounds(new Rectangle(13, 19, 61, 15));
    jLabel6.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel6.setText("Age");
    jLabel6.setBounds(new Rectangle(13, 54, 86, 15));
    jLabel7.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel7.setText("Health");
    jLabel7.setBounds(new Rectangle(13, 88, 80, 15));
    jLabel8.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel8.setText("Wealth");
    jLabel8.setBounds(new Rectangle(13, 123, 58, 15));
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setEnabled(true);
    jSplitPane1.setContinuousLayout(true);
    jSplitPane1.setDividerSize(10);
    jSplitPane1.setOneTouchExpandable(true);
    jPanel1.setLayout(borderLayout1);
    jPanel2.setLayout(borderLayout2);
    jPanel3.setLayout(null);
    jPanel4.setLayout(null);
    jPanel5.setLayout(borderLayout4);
    jScrollPane1.setMinimumSize(new Dimension(50, 50));
    jSlider4.setPaintTicks(false);
    jSlider4.setBounds(new Rectangle(94, 111, 132, 39));
    jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel9.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel9.setIcon(i11);
    jPanel6.setLayout(null);
    jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel10.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel10.setIcon(i12);
    jLabel10.setText("");
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel11.setIcon(i21);
    jLabel11.setText("");
    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel12.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel12.setIcon(i32);
    jLabel12.setText("");
    jLabel13.setEnabled(true);
    jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel13.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel13.setIcon(i42);
    jLabel13.setText("");
    jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel14.setIcon(i31);
    jLabel14.setText("");
    jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel15.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel15.setIcon(i22);
    jLabel15.setText("");
    jLabel16.setEnabled(true);
    jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel16.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel16.setIcon(i40);
    jLabel16.setText("");
    jLabel17.setEnabled(true);
    jLabel17.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel17.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel17.setIcon(i45);
    jLabel17.setText("");
    jPanel7.setBorder(null);
    jPanel7.setBounds(new Rectangle(13, 10, 82, 44));
    jPanel7.addMouseListener(new RemoteControl_jPanel7_mouseAdapter(this));
    jPanel8.setBorder(null);
    jPanel8.setBounds(new Rectangle(13, 62, 82, 44));
    jPanel8.addMouseListener(new RemoteControl_jPanel8_mouseAdapter(this));
    jPanel9.setBorder(null);
    jPanel9.setBounds(new Rectangle(13, 114, 82, 44));
    jPanel9.addMouseListener(new RemoteControl_jPanel9_mouseAdapter(this));
    jPanel10.setBorder(null);
    jPanel10.setBounds(new Rectangle(138, 10, 113, 44));
    jPanel10.addMouseListener(new RemoteControl_jPanel10_mouseAdapter(this));
    jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane2.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane2.setBounds(new Rectangle(104, 54, 177, 119));
    jTextArea2.setEnabled(true);
    jTextArea2.setFont(new java.awt.Font("Dialog", 0, 11));
    jTextArea2.setEditable(false);
    jTextArea2.setText("Hover mouse over schematic for details");
    jTextArea2.setLineWrap(true);
    jTextArea2.setWrapStyleWord(true);
    jLabel18.setIcon(mediaImage1);
    jLabel18.setText("");
    jLabel18.setBounds(new Rectangle(6, 75, 54, 71));
    jPanel11.setLayout(null);
    jLabel19.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel19.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel19.setText("Population Receiving of Information (annual):");
    jLabel19.setBounds(new Rectangle(63, 108, 229, 44));
    jSlider6.setPaintTicks(true);
    jSlider6.setEnabled(false);
    jSlider6.setOrientation(JSlider.HORIZONTAL);
    jSlider6.setMajorTickSpacing(10);
    jSlider6.setBounds(new Rectangle(84, 137, 152, 40));
    jSlider6.addChangeListener(new RemoteControl_jSlider6_changeAdapter(this));
    jSlider6.addChangeListener(new RemoteControl_jSlider6_changeAdapter(this));
    jLabel20.setEnabled(false);
    jLabel20.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel20.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel20.setText("50 %");
    jLabel20.setBounds(new Rectangle(230, 143, 39, 15));
    jSpinner1.setBounds(new Rectangle(204, 34, 51, 24));
    jSpinner1.addChangeListener(new RemoteControl_jSpinner1_changeAdapter(this));
    jSpinner1.setEnabled(false);
    jSpinner1.setBorder(null);
    jSpinner1.setOpaque(false);
    jSpinner1.setModel(mediaEpochSpinnerNumberModel);
    jSpinner3.setModel(agentAgeSpinnerNumberModel);
    jLabel21.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel21.setText("Epochs until next media broadcast");
    jLabel21.setBounds(new Rectangle(-19, 40, 211, 15));
    jSlider7.setBounds(new Rectangle(84, 74, 152, 40));
    jSlider7.addChangeListener(new RemoteControl_jSlider7_changeAdapter(this));
    jSlider7.setMajorTickSpacing(10);
    jSlider7.setMinorTickSpacing(10);
    jSlider7.setPaintLabels(false);
    jSlider7.setOrientation(JSlider.HORIZONTAL);
    jSlider7.setPaintTicks(true);
    jSlider7.setEnabled(false);
    jSlider7.setOpaque(true);
    jLabel22.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel22.setText("Degree of Information:");
    jLabel22.setBounds(new Rectangle(63, 58, 156, 15));
    jLabel23.setBounds(new Rectangle(230, 81, 39, 15));
    jLabel23.setText("50 %");
    jLabel23.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel23.setEnabled(false);
    jLabel23.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel24.setText("Disease Type: Autosomatic Non Dominant");
    jLabel24.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel24.setBorder(null);
    jLabel24.setDebugGraphicsOptions(0);
    jLabel24.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel24.setBounds(new Rectangle(8, 8, 275, 15));
    jSlider9.setOrientation(JSlider.HORIZONTAL);
    jSlider9.setBounds(new Rectangle(55, 26, 66, 24));
    jSlider9.addChangeListener(new RemoteControl_jSlider9_changeAdapter(this));
    jLabel25.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel25.setText("Vision");
    jLabel25.setBounds(new Rectangle(8, 74, 50, 15));
    jLabel26.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel26.setText("Fear");
    jLabel26.setBounds(new Rectangle(8, 96, 50, 15));
    jLabel27.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel27.setText("Infuence");
    jLabel27.setBounds(new Rectangle(8, 30, 50, 15));
    jLabel28.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel28.setText("Accept");
    jLabel28.setBounds(new Rectangle(8, 52, 43, 15));
    jLabel29.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel29.setText("Wealth");
    jLabel29.setBounds(new Rectangle(8, 125, 50, 15));
    jLabel32.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel32.setText("Age of Death:");
    jLabel32.setBounds(new Rectangle(144, 31, 75, 15));
    jSpinner3.setOpaque(false);
    jSpinner3.setBorder(null);
    jSpinner3.setEnabled(true);
    jSpinner3.setBounds(new Rectangle(224, 28, 51, 24));
    jButtonAddAgent.setBounds(new Rectangle(173, 151, 101, 23));
    jButtonAddAgent.setEnabled(false);
    jButtonAddAgent.setText("Add Agent");
    jButtonAddAgent.addActionListener(new RemoteControl_jButtonAddAgent_actionAdapter(this));
    jSlider10.setBounds(new Rectangle(55, 49, 66, 24));
    jSlider10.addChangeListener(new RemoteControl_jSlider10_changeAdapter(this));
    jSlider10.setOrientation(JSlider.HORIZONTAL);
    jSlider11.setBounds(new Rectangle(55, 73, 66, 24));
    jSlider11.addChangeListener(new RemoteControl_jSlider11_changeAdapter(this));
    jSlider11.setOrientation(JSlider.HORIZONTAL);
    jLabel33.setText("");
    jLabel33.setBounds(new Rectangle(121, 30, 23, 15));
    jSlider12.setOrientation(JSlider.HORIZONTAL);
    jSlider12.setBounds(new Rectangle(55, 96, 66, 24));
    jSlider12.addChangeListener(new RemoteControl_jSlider12_changeAdapter(this));
    jSlider13.setOrientation(JSlider.HORIZONTAL);
    jSlider13.setBounds(new Rectangle(55, 120, 66, 24));
    jSlider13.addChangeListener(new RemoteControl_jSlider13_changeAdapter(this));
    jLabel34.setText("");
    jLabel34.setBounds(new Rectangle(121, 53, 23, 15));
    jLabel35.setBounds(new Rectangle(121, 76, 23, 15));
    jLabel35.setText("");
    jLabel36.setBounds(new Rectangle(121, 96, 23, 15));
    jLabel36.setText("");
    jLabel37.setBounds(new Rectangle(121, 118, 23, 15));
    jLabel37.setText("");
    jPanel12.setBorder(BorderFactory.createEtchedBorder());
    jPanel12.setBounds(new Rectangle(137, 67, 137, 30));
    jPanel12.setLayout(borderLayout5);
    jRadioButton1.setSelected(true);
    jRadioButton1.setText("Male");
    jRadioButton2.setText("Female");
    jComboBox1.setBounds(new Rectangle(137, 114, 138, 23));
    jLabel30.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel30.setText("Fear");
    jLabel30.setBounds(new Rectangle(4, 155, 32, 15));
    jLabel31.setVerifyInputWhenFocusTarget(true);
    jLabel31.setText("");
    jLabel31.setBounds(new Rectangle(28, 153, 29, 20));
    jTextField1.setText("10");
    jTextField1.setBounds(new Rectangle(36, 152, 37, 21));
    jLabel38.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel38.setVerifyInputWhenFocusTarget(true);
    jLabel38.setText("Information");
    jLabel38.setBounds(new Rectangle(70, 155, 66, 15));
    jTextField2.setText("15");
    jTextField2.setBounds(new Rectangle(132, 152, 37, 21));
    jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
    jTabbedPane1.setMinimumSize(new Dimension(70, 80));
    jTabbedPane1.setPreferredSize(new Dimension(70, 80));
    jCheckBox1.setFont(new java.awt.Font("Dialog", 0, 10));
    jCheckBox1.setSelected(false);
    jCheckBox1.setText("Media Agent Enabled");
    jCheckBox1.setBounds(new Rectangle(2, 10, 130, 23));
    jCheckBox1.addChangeListener(new RemoteControl_jCheckBox1_changeAdapter(this));
    jCheckBox2.setFont(new java.awt.Font("Dialog", 0, 10));
    jCheckBox2.setText("Neighborhood Learning");
    jCheckBox2.setBounds(new Rectangle(132, 11, 157, 23));
    jCheckBox2.addChangeListener(new RemoteControl_jCheckBox2_changeAdapter(this));
    jSlider15.setMajorTickSpacing(10);
    jSlider15.setPaintTicks(false);
    jSlider15.setBounds(new Rectangle(92, 145, 132, 39));
    jSlider15.addChangeListener(new RemoteControl_jSlider15_changeAdapter(this));
    jSlider15.addChangeListener(new RemoteControl_jSlider15_changeAdapter(this));
    jLabel48.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel48.setText("Reproduction");
    jLabel48.setBounds(new Rectangle(13, 157, 100, 15));
    jLabel49.setBounds(new Rectangle(237, 157, 34, 15));
    jLabel49.setText("50%");
    jLabel49.setHorizontalAlignment(SwingConstants.RIGHT);
    jPanel1.add(jScrollPane1, BorderLayout.CENTER);
    jPanel1.add(jProgressBar1, BorderLayout.SOUTH);
    jScrollPane1.getViewport().add(jTextArea1, null);
    jSplitPane1.add(jPanel2, JSplitPane.BOTTOM);
    jPanel2.add(jTabbedPane1, BorderLayout.CENTER);
    jPanel3.add(jLabel2, null);
    jPanel3.add(jSlider1, null);
    jPanel3.add(jLabel6, null);
    jPanel3.add(jLabel7, null);
    jPanel3.add(jSlider2, null);
    jPanel3.add(jLabel3, null);
    jPanel3.add(jLabel4, null);
    jPanel3.add(jLabel8, null);
    jPanel3.add(jSlider15, null);
    jPanel3.add(jLabel5, null);
    jPanel3.add(jSlider3, null);
    jPanel3.add(jLabel1, null);
    jPanel3.add(jSlider4, null);
    jPanel3.add(jLabel48, null);
    jPanel3.add(jLabel49, null);
    jSplitPane1.add(jPanel1, JSplitPane.TOP);
    jTabbedPane1.add(jPanel6,     "Mnemonics");
    jPanel6.add(jPanel7, null);
    jPanel7.add(jLabel9, null);
    jPanel7.add(jLabel10, null);
    jPanel6.add(jPanel8, null);
    jPanel8.add(jLabel11, null);
    jPanel8.add(jLabel15, null);
    jPanel6.add(jPanel9, null);
    jPanel9.add(jLabel14, null);
    jPanel9.add(jLabel12, null);
    jPanel10.add(jLabel16, null);
    jPanel10.add(jLabel13, null);
    jPanel10.add(jLabel17, null);
    jPanel6.add(jScrollPane2, null);
    jPanel6.add(jPanel10, null);
    jScrollPane2.getViewport().add(jTextArea2, null);
    jTabbedPane1.add(jPanel3, "Weights");
    jTabbedPane1.add(jPanel4,   "Insert Agent");
    jPanel4.add(jLabel24, null);
    jPanel4.add(jLabel27, null);
    jPanel4.add(jLabel28, null);
    jPanel4.add(jLabel25, null);
    jPanel4.add(jSlider10, null);
    jPanel4.add(jSlider11, null);
    jPanel4.add(jSlider9, null);
    jPanel4.add(jLabel33, null);
    jPanel4.add(jLabel26, null);
    jPanel4.add(jLabel29, null);
    jPanel4.add(jLabel34, null);
    jPanel4.add(jLabel35, null);
    jPanel4.add(jLabel36, null);
    jPanel4.add(jLabel37, null);
    jPanel4.add(jLabel32, null);
    jPanel4.add(jSpinner3, null);
    jPanel4.add(jPanel12, null);
    jPanel12.add(jRadioButton1,  BorderLayout.CENTER);
    jPanel12.add(jRadioButton2,  BorderLayout.EAST);
    jPanel4.add(jComboBox1, null);
    jPanel4.add(jButtonAddAgent, null);
    jPanel4.add(jTextField1, null);
    jTabbedPane1.add(jPanel11,   "Media Agent");
    jPanel11.add(jSlider6, null);
    jPanel11.add(jLabel20, null);
    jPanel11.add(jSlider7, null);
    jPanel11.add(jLabel23, null);
    jPanel11.add(jSpinner1, null);
    jPanel11.add(jCheckBox1, null);
    jPanel11.add(jCheckBox2, null);
    jPanel11.add(jLabel21, null);
    jPanel11.add(jLabel19, null);
    jPanel11.add(jLabel18, null);
    jPanel11.add(jLabel22, null);
    this.getContentPane().add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jSplitPane1, BorderLayout.CENTER);
    jSlider1.setMajorTickSpacing(10);
    jSlider2.setMajorTickSpacing(10);
    jSlider3.setMajorTickSpacing(10);
    jSlider4.setMajorTickSpacing(10);
    jSplitPane1.setDividerLocation(130);

    sexGroup=new ButtonGroup();
    sexGroup.add(jRadioButton1);
    sexGroup.add(jRadioButton2);
    jPanel4.add(jSlider12, null);
    jPanel4.add(jSlider13, null);
    jPanel4.add(jTextField2, null);
    jPanel4.add(jLabel30, null);
    jPanel4.add(jLabel31, null);
    jPanel4.add(jLabel38, null);

    args[5]=jSlider9.getValue();
    args[6]=jSlider10.getValue();
    args[3]=jSlider10.getValue();
    args[4]=jSlider10.getValue();
    args[7]=jSlider10.getValue();
    jTabbedPane1.setSelectedIndex(2);

  }

  void jSlider3_stateChanged(ChangeEvent e) {
    jLabel1.setText(Integer.toString(jSlider3.getValue())+"%");
    rcWeight1=jSlider3.getValue();
  }

  void jSlider1_stateChanged(ChangeEvent e) {
    jLabel2.setText(Integer.toString(jSlider1.getValue())+"%");
    rcWeight2=jSlider1.getValue();
  }

  void jSlider2_stateChanged(ChangeEvent e) {
    jLabel3.setText(Integer.toString(jSlider2.getValue())+"%");
    rcWeight3=jSlider2.getValue();
  }

  void jSlider4_stateChanged(ChangeEvent e) {
    jLabel4.setText(Integer.toString(jSlider4.getValue())+"%");
    rcWeight4=jSlider4.getValue();
  }

  void jButton2_actionPerformed(ActionEvent e) {
    MenuFrame.at.setVisible(true);
  }

 void jPanel7_mouseEntered(MouseEvent e) {
    jLabel9.setIcon(i111);
    jLabel10.setIcon(i121);
    jTextArea2.setText("Healthy, Man (square) and Woman (circle), with no mutated genes");
  }

  void jPanel7_mouseExited(MouseEvent e) {
    jLabel9.setIcon(i11);
    jLabel10.setIcon(i12);
//    jTextArea2.setText("Hover mouse over schematic for details");
  }

  void jPanel8_mouseEntered(MouseEvent e) {
    jLabel11.setIcon(i211);
    jLabel15.setIcon(i221);
    jTextArea2.setText(" Carriers, heterozygote, Man (square) as autosomatic non dominant, Woman (circle) as autosomatic non dominant or X-chromosome-related");

  }

  void jPanel8_mouseExited(MouseEvent e) {
    jLabel11.setIcon(i21);
    jLabel15.setIcon(i22);
//    jTextArea2.setText("Hover mouse over schematic for details");
  }

  void jPanel9_mouseEntered(MouseEvent e) {
    jLabel14.setIcon(i311);
    jLabel12.setIcon(i321);
    jTextArea2.setText(" Diseased, homozygote, Man (square) and Woman (circle)");
  }

  void jPanel9_mouseExited(MouseEvent e) {
    jLabel14.setIcon(i31);
    jLabel12.setIcon(i32);
//    jTextArea2.setText("Hover mouse over schematic for details");
  }

  void jPanel10_mouseEntered(MouseEvent e) {
    jTextArea2.setText("Different representations of a family. The GREEN area represents the existance of healthy agents, the RED area the diseased ones");
  }

  void jPanel10_mouseExited(MouseEvent e) {
//    jTextArea2.setText("Hover mouse over schematic for details");

  }

  void jSlider6_stateChanged(ChangeEvent e) {
    jLabel20.setText(Integer.toString(jSlider6.getValue())+"%");
    rcMedia=jSlider6.getValue();
  }

  void jSlider7_stateChanged(ChangeEvent e) {
    jLabel23.setText(Integer.toString(jSlider7.getValue())+"%");
    rcMediaP=jSlider7.getValue();  }




  public void renew(){
    if(MenuFrame.settings.getMethodTransmittion()==0&&MenuFrame.settings.getDominantAutosomatic()==false){
      diseaseType=1;
      jLabel24.setText("Disease Type: Autosomatic Non Dominant");
    }else if(MenuFrame.settings.getMethodTransmittion()==0&&MenuFrame.settings.getDominantAutosomatic()==true){
      jLabel24.setText("Disease Type: Autosomatic Dominant");
      diseaseType=2;
    }else if(MenuFrame.settings.getMethodTransmittion()==1){
      jLabel24.setText("Disease Type: X-related Disease");
      diseaseType=3;
    }

  }



  void jButtonAddAgent_actionPerformed(ActionEvent e) {
    jButtonAddAgent.setEnabled(false);
    setTextMessage("New agent will be born in next epoch");
    epochPressed=SuperAgent.epoch+1;
    Chromosoma chr=new Chromosoma();
    int sex=0;
    if(jRadioButton1.isSelected()==true){
      sex=1;
    }
    int diseaseGenes=0, diseaseState=0;
    int condition=jComboBox1.getSelectedIndex();
    //autosomatic not dominant
    if(diseaseType==1){//autosomatic non dominant
      if (condition==1) {//Carrier
        diseaseState=1;
        if(Math.random()<0.5){
          diseaseGenes=1; //01 position of genes
        }else{
          diseaseGenes=2;//10 position of genes
        }
      }else if(condition==2){
        diseaseGenes=3;
        diseaseState=2;
      }
    //dominant autosomatic
    }else if(diseaseType==2){
      if (condition==1) {
        diseaseState = 2; //diseased
        if(Math.random()<0.5){
          diseaseGenes=1; //01 position of genes
        }else{
          diseaseGenes=2;//10 position of genes
        }
      }else if(condition==2){
        diseaseState = 2; //diseased
        diseaseGenes=3;
      }
    //x-chromosome, x-related
    } else if (diseaseType==3){
      if(sex==0){ //woman
        if (condition==1){ //carrier
          diseaseState=1;//carrier
          if(Math.random()<0.5){
            diseaseGenes=1; //01 position of genes Xx
          }else{
            diseaseGenes=2;//10 position of genes xX
          }
        }else if(condition==2){
          diseaseState=2;
          diseaseGenes=3;        }
      }else{ //if men sex=1
        if (condition>0){
          diseaseState=2;//diseased
          diseaseGenes=2;//xY ONLY
        }
      }
    }
    args[0]=sex;
    args[2]=diseaseState;
    args[1]=diseaseGenes;
    //exw diseaseState kai diseaseGenes
    int gene=chr.initiateChromosomaRC(args);
    newPerson.setBitGene(gene);
    newPerson.setEpochOfBirth(epochPressed-MenuFrame.settings.getlegalMarriageAge());
    newPerson.setEpochsToLive(agentAgeSpinnerNumberModel.getNumber().intValue());
    newPerson.setFearDegree(Integer.parseInt(jTextField1.getText()));
    newPerson.setFromFamilyID(0);
    newPerson.setInformationDegree(Integer.parseInt(jTextField2.getText()));
    if(sex==0){
      newPerson.setSex("Female");
    }else if(sex==1){
      newPerson.setSex("Male");
    }
    newPerson.setName("RCAgent");
    if (diseaseState==1) {
      newPerson.setHealth("Carrier");
    }
    else if (diseaseState==2) {
      newPerson.setHealth("Diseased");
    }
    else {
      newPerson.setHealth("Healthy");
    }
  }






  void jSlider9_stateChanged(ChangeEvent e) {
    jLabel33.setText(Integer.toString(jSlider9.getValue()));
    args[5]=jSlider9.getValue();
  }

  void jSlider10_stateChanged(ChangeEvent e) {
    jLabel34.setText(Integer.toString(jSlider10.getValue()));
    args[6]=jSlider10.getValue();
  }

  void jSlider11_stateChanged(ChangeEvent e) {
    jLabel35.setText(Integer.toString(jSlider11.getValue()));
    args[3]=jSlider10.getValue();
  }

  void jSlider12_stateChanged(ChangeEvent e) {
    jLabel36.setText(Integer.toString(jSlider12.getValue()));
    args[4]=jSlider10.getValue();
  }

  void jSlider13_stateChanged(ChangeEvent e) {
    jLabel37.setText(Integer.toString(jSlider13.getValue()));
    args[7]=jSlider10.getValue();
  }

  private void setTextMessage(String s){
    jTextArea1.append(s+"\n");
    jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
  }


  void jCheckBox1_stateChanged(ChangeEvent e) {
    if(jCheckBox1.isSelected()==false){
      jSpinner1.setEnabled(false);
      jSlider7.setEnabled(false);
      jSlider6.setEnabled(false);
      jLabel23.setEnabled(false);
      jLabel20.setEnabled(false);
      rcMediaT=0;
    }else{
      rcMediaT=1;
      jSpinner1.setEnabled(true);
      jSlider7.setEnabled(true);
      jSlider6.setEnabled(true);
      jLabel23.setEnabled(true);
      jLabel20.setEnabled(true);
    }

  }

  void jSpinner1_stateChanged(ChangeEvent e) {
    rcMediaT=mediaEpochSpinnerNumberModel.getNumber().intValue();
  }

  void jCheckBox2_stateChanged(ChangeEvent e) {
    if(jCheckBox2.isSelected()==true){
      rcMediaNeigh=true;
    }else{
      rcMediaNeigh=false;
    }
  }

  void jSlider15_stateChanged(ChangeEvent e) {
    jLabel49.setText(Integer.toString(jSlider15.getValue())+"%");
    rcWeight5=jSlider15.getValue();
  }



}

class RemoteControl_jSlider3_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider3_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider3_stateChanged(e);
  }
}

class RemoteControl_jSlider1_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider1_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider1_stateChanged(e);
  }
}

class RemoteControl_jSlider2_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider2_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider2_stateChanged(e);
  }
}

class RemoteControl_jSlider4_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider4_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider4_stateChanged(e);
  }
}

class RemoteControl_jPanel7_mouseAdapter extends java.awt.event.MouseAdapter {
  RemoteControl adaptee;

  RemoteControl_jPanel7_mouseAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.jPanel7_mouseEntered(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.jPanel7_mouseExited(e);
  }
}

class RemoteControl_jPanel8_mouseAdapter extends java.awt.event.MouseAdapter {
  RemoteControl adaptee;

  RemoteControl_jPanel8_mouseAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.jPanel8_mouseEntered(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.jPanel8_mouseExited(e);
  }
}

class RemoteControl_jPanel9_mouseAdapter extends java.awt.event.MouseAdapter {
  RemoteControl adaptee;

  RemoteControl_jPanel9_mouseAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.jPanel9_mouseEntered(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.jPanel9_mouseExited(e);
  }
}

class RemoteControl_jPanel10_mouseAdapter extends java.awt.event.MouseAdapter {
  RemoteControl adaptee;

  RemoteControl_jPanel10_mouseAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.jPanel10_mouseEntered(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.jPanel10_mouseExited(e);
  }
}

class RemoteControl_jSlider6_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider6_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider6_stateChanged(e);
  }
}

class RemoteControl_jSlider7_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider7_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider7_stateChanged(e);
  }
}

class RemoteControl_jButtonAddAgent_actionAdapter implements java.awt.event.ActionListener {
  RemoteControl adaptee;

  RemoteControl_jButtonAddAgent_actionAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonAddAgent_actionPerformed(e);
  }
}

class RemoteControl_jSlider9_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider9_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider9_stateChanged(e);
  }
}

class RemoteControl_jSlider10_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider10_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider10_stateChanged(e);
  }
}

class RemoteControl_jSlider11_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider11_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider11_stateChanged(e);
  }
}

class RemoteControl_jSlider12_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider12_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider12_stateChanged(e);
  }
}

class RemoteControl_jSlider13_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider13_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider13_stateChanged(e);
  }
}

class RemoteControl_jCheckBox1_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jCheckBox1_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBox1_stateChanged(e);
  }
}

class RemoteControl_jSpinner1_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSpinner1_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner1_stateChanged(e);
  }
}

class RemoteControl_jCheckBox2_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jCheckBox2_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBox2_stateChanged(e);
  }
}

class RemoteControl_jSlider15_changeAdapter implements javax.swing.event.ChangeListener {
  RemoteControl adaptee;

  RemoteControl_jSlider15_changeAdapter(RemoteControl adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider15_stateChanged(e);
  }
}



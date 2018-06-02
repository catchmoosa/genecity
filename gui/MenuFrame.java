package genecity.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.beans.*;
//import com.borland.jbcl.layout.*;
import genecity.Settings;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import genecity.LaunchAgents;
import java.lang.Boolean;
import genecity.SuperAgent;
import java.util.Date;
import java.text.SimpleDateFormat;



/**
 * <p>Title: MenuFrame</p>
 * <p>Description: Main Interface</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class MenuFrame extends JFrame {
  public static Settings settings = new Settings();
  public static GraphFrame gFrame1 = new GraphFrame();
  public static SelectSettingsFrame selectSettingsFrame=new SelectSettingsFrame();
  public static DrawFamilyPanelFrame drawFamilyPanelFrame=new DrawFamilyPanelFrame();
  public static DrawPanelFrame drawPanelFrame2=new DrawPanelFrame();
  public static ReadHelpFrame helpFrame=new ReadHelpFrame();
  public static Grid grid;
  public static RemoteControl rc=new RemoteControl();
  public static AgentTable at=new AgentTable();
//  public static IndexGridFrame idx=new IndexGridFrame();

  public static LaunchAgents la = new LaunchAgents();

  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  JToolBar jToolBar = new JToolBar();
  JButton jButton1 = new JButton();
  public static JButton jButton2 = new JButton();
  /**
   * IMAGES
   */
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  ImageIcon image4;
  ImageIcon image5;
  ImageIcon image6;
  ImageIcon image7;
  ImageIcon image8;
  ImageIcon image9;
  ImageIcon image10;
  ImageIcon image11;
  ImageIcon image12;
  ImageIcon image13;
  ImageIcon image14,image15,image16;
  ImageIcon hydroImage;

  JLabel statusBar = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  public static JDesktopPane jDesktopPane1 = new JDesktopPane();
  JMenuItem jMenuItem2 = new JMenuItem();
  JMenuItem jMenuItem3 = new JMenuItem();
  JMenu jMenu1 = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenuItem jMenuItem8 = new JMenuItem();
  JMenu jMenu3 = new JMenu();
  JMenuItem jMenuItem10 = new JMenuItem();
  JMenuItem jMenuItem12 = new JMenuItem();
//  JInternalFrame jInternalFrame3 = new JInternalFrame();
  public static JScrollPane jScrollPane1 = new JScrollPane();
  public static JTextArea jTextArea1 = new JTextArea("GeneCity Launched\n");
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JFileChooser jFileChooser1 = new JFileChooser();
  BorderLayout borderLayout2 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  public static JButton jButton13 = new JButton();
  JButton jButton7 = new JButton();
  JMenuItem jMenuItem13 = new JMenuItem();
  JMenuItem jMenuItem4 = new JMenuItem();


  /**
   * Border Settings
   */
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  TitledBorder titledBorder5;
  TitledBorder titledBorder6;
  TitledBorder titledBorder7;
  JButton jButton6 = new JButton();
  JButton jButton9 = new JButton();
  public static JButton jButton12 = new JButton();
  JButton jButton14 = new JButton();
  public static JButton jButton15 = new JButton();
  JButton jButton17 = new JButton();

  LoadFileFilter loadFileFilter = new LoadFileFilter();
  LoadDataFileFilter loadDataFileFilter=new LoadDataFileFilter();

  TitledBorder titledBorder8;
  Boolean runStatus;
  public static int runPauseStatus=1;
  public static JProgressBar jProgressBar1 = new JProgressBar();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  public static JButton jButton3 = new JButton();
  JFileChooser jFileChooser2 = new JFileChooser();
  JFileChooser jFileChooser3 = new JFileChooser();
  JLabel jLabel1 = new JLabel();
  JMenu jMenu4 = new JMenu();
  JMenuItem jMenuItem1 = new JMenuItem();
  JMenuItem jMenuItem5 = new JMenuItem();
  JMenuItem jMenuItem6 = new JMenuItem();
  JMenuItem jMenuItem7 = new JMenuItem();
  JMenuItem jMenuItem9 = new JMenuItem();

  //Construct the frame
  public MenuFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    titledBorder5 = new TitledBorder("");
    titledBorder6 = new TitledBorder("");
    titledBorder7 = new TitledBorder("");
    titledBorder8 = new TitledBorder("");
    setIconImage(Toolkit.getDefaultToolkit().createImage("smallogo.gif"));
    this.setLocale(java.util.Locale.getDefault());
    this.setResizable(true);
    image1 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("openFile.png"));
    image2 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("closeFile.png"));
    image3 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("help.png"));
    image4 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("config.png"));
    image5 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("details.png"));
    image6 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("piechart.png"));
    image7 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("info.png"));
    image8 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("load.png"));
    image9 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("save.png"));
    image10 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("singleagent.png"));
    image11 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("play2.png"));
    image12 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("details.png"));
    image13 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("pause2.png"));
    image14 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("stop.png"));
    image15 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("jade.png"));
    image16 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("infoAgent.png"));
    hydroImage = new ImageIcon(genecity.gui.MenuFrame.class.getResource("hydro.png"));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);

    //Size of MenuFrame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height-30);

    jButton12.setActionCommand("");
    jButton14.setActionCommand("");
    jButton14.setIcon(image15);
    jButton14.setMnemonic('J');
    jButton15.setActionCommand("");
    jButton15.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton15.setIcon(image11);
    jButton15.setMnemonic('R');
    jButton15.setText("Run");
    jButton15.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton15.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton15.addActionListener(new MenuFrame_jButton15_actionAdapter(this));
    jButton7.setActionCommand("");
    jButton17.setActionCommand("");
    jButton17.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton17.setIcon(image14);
    jButton17.setMnemonic('S');
    jButton17.setText("Stop");
    jButton17.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton17.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton17.addChangeListener(new MenuFrame_jButton17_changeAdapter(this));
    jButton17.addActionListener(new MenuFrame_jButton17_actionAdapter(this));
    jFileChooser1.setAcceptAllFileFilterUsed(true);
    jFileChooser1.setFileFilter(loadFileFilter);
    jFileChooser2.setAcceptAllFileFilterUsed(true);
    jFileChooser2.setFileFilter(loadDataFileFilter);
    jFileChooser3.setAcceptAllFileFilterUsed(true);
    jFileChooser3.setFileFilter(loadDataFileFilter);
    jButton9.addActionListener(new MenuFrame_jButton9_actionAdapter(this));
    jMenuItem2.addActionListener(new MenuFrame_jMenuItem2_actionAdapter(this));
    jButton13.addActionListener(new MenuFrame_jButton13_actionAdapter(this));
    gFrame1.addAncestorListener(new MenuFrame_gFrame1_ancestorAdapter(this));

    this.setTitle("GeneCity Epidemiological Simulation");
    this.addWindowListener(new MenuFrame_this_windowAdapter(this));

    statusBar.setText(" ");
    jMenuFile.setText("File");
    jMenuFileExit.setText("Exit");
    jMenuFileExit.addActionListener(new MenuFrame_jMenuFileExit_ActionAdapter(this));
    jMenuHelp.setText("Help");
    jMenuHelpAbout.setText("About");
    jMenuHelpAbout.addActionListener(new MenuFrame_jMenuHelpAbout_ActionAdapter(this));
    jButton1.addActionListener(new MenuFrame_jButton1_actionAdapter(this));
    jButton1.addActionListener(new MenuFrame_jButton1_actionAdapter(this));
//    jButton1.setBorder(null);
    jButton1.setMaximumSize(new Dimension(70, 75));
    jButton1.setMinimumSize(new Dimension(70, 75));
    jButton1.setPreferredSize(new Dimension(70, 75));
    jButton1.setToolTipText("Configurations");
//    jButton1.setBorderPainted(true);
    jButton1.setHorizontalAlignment(SwingConstants.CENTER);
    jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton1.setIcon(image4);
    jButton1.setMnemonic('C');
    jButton1.setText("Options");
    jButton1.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton2.setIcon(image5);
    jButton2.setMnemonic('2');
    jButton2.setText("Tree");
    jButton2.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton2.addChangeListener(new MenuFrame_jButton2_changeAdapter(this));
    jButton2.addActionListener(new MenuFrame_jButton2_actionAdapter(this));
    jButton2.addActionListener(new MenuFrame_jButton2_actionAdapter(this));
    jButton2.setEnabled(false);
//    jButton2.setBorder(null);
//    jButton2.setBorder(BorderFactory.createEtchedBorder());
    jButton2.setMaximumSize(new Dimension(70, 75));
    jButton2.setMinimumSize(new Dimension(70, 75));
    jButton2.setPreferredSize(new Dimension(70, 75));
    jButton2.setToolTipText("Family Grid");
    jButton2.setHorizontalAlignment(SwingConstants.CENTER);
    jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
    jMenuItem2.setText("Save Settings");
    jMenuItem3.setText("Load Settings");
    jMenuItem3.addActionListener(new MenuFrame_jMenuItem3_actionAdapter(this));
    jMenu1.setText("Simulation");
    jMenu2.setText("Tools");
    jMenuItem8.setText("JADE Framework");
    jMenuItem8.addActionListener(new MenuFrame_jMenuItem8_actionAdapter(this));
    jMenu3.setText("Run");
    jMenuItem10.setText("Start");
    jMenuItem10.addActionListener(new MenuFrame_jMenuItem10_actionAdapter(this));
    jMenuItem12.setText("Manual");
    jMenuItem12.addActionListener(new MenuFrame_jMenuItem12_actionAdapter(this));
//    jDesktopPane1.setBorder(null);
    jDesktopPane1.setBackground(SystemColor.desktop);
    jDesktopPane1.setToolTipText("");
    jTextArea1.setEditable(false);
    jButton13.setEnabled(false);
//    jButton13.setBorder(null);
//    jButton13.setBorder(BorderFactory.createEtchedBorder());
    jButton13.setMaximumSize(new Dimension(70, 75));
    jButton13.setMinimumSize(new Dimension(70, 75));
    jButton13.setPreferredSize(new Dimension(70, 75));
    jButton13.setToolTipText("View Graphs");
    jButton13.setHorizontalAlignment(SwingConstants.CENTER);
    jButton13.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton13.setIcon(image6);
    jButton13.setMnemonic('M');
    jButton13.setText("Chart");
    jButton13.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton13.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton13.addChangeListener(new MenuFrame_jButton13_changeAdapter(this));
//    jButton7.setBorder(BorderFactory.createEtchedBorder());
//    jButton7.setBorder(null);
    jButton7.setMaximumSize(new Dimension(70, 75));
    jButton7.setMinimumSize(new Dimension(70, 75));
    jButton7.setPreferredSize(new Dimension(70, 75));
    jButton7.setToolTipText("Information");
    jButton7.setVerifyInputWhenFocusTarget(true);
    jButton7.setHorizontalAlignment(SwingConstants.CENTER);
    jButton7.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton7.setIcon(image7);
    jButton7.setMnemonic('I');
    jButton7.setText("Help");
    jButton7.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton7.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton7.addActionListener(new MenuFrame_jButton7_actionAdapter(this));
    jMenuItem13.setText("Configuration");
    jMenuItem13.addActionListener(new MenuFrame_jMenuItem13_actionAdapter(this));
    jMenuItem4.setText("Stop");
    jMenuItem4.setEnabled(false);
    jMenuItem4.addActionListener(new MenuFrame_jMenuItem4_actionAdapter(this));
//    jButton6.setBorder(null);
    jButton6.setMaximumSize(new Dimension(70, 75));
    jButton6.setMinimumSize(new Dimension(70, 75));
    jButton6.setPreferredSize(new Dimension(70, 75));
    jButton6.setToolTipText("Load File");
    jButton6.setActionCommand("Load");
    jButton6.setBorderPainted(true);
    jButton6.setContentAreaFilled(true);
    jButton6.setHorizontalAlignment(SwingConstants.CENTER);
    jButton6.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton6.setIcon(image8);
    jButton6.setMnemonic('L');
    jButton6.setText("Load");
    jButton6.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton6.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton6.addActionListener(new MenuFrame_jButton6_actionAdapter(this));
    jButton9.setForeground(Color.black);
 //   jButton9.setBorder(null);
    jButton9.setMaximumSize(new Dimension(70, 75));
    jButton9.setMinimumSize(new Dimension(70, 75));
    jButton9.setPreferredSize(new Dimension(70, 75));
    jButton9.setRequestFocusEnabled(true);
    jButton9.setToolTipText("Save to File");
    jButton9.setHorizontalAlignment(SwingConstants.CENTER);
    jButton9.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton9.setIcon(image9);
    jButton9.setMnemonic('S');
    jButton9.setText("Save");
    jButton9.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton9.setVerticalTextPosition(SwingConstants.BOTTOM);
    jToolBar.setMaximumSize(new Dimension(55, 68));
    jToolBar.setFloatable(false);
    jButton12.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton12.addChangeListener(new MenuFrame_jButton12_changeAdapter(this));
    jButton12.addActionListener(new MenuFrame_jButton12_actionAdapter(this));
    jButton12.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton12.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton12.setIcon(image10);
    jButton12.setMnemonic('1');
    jButton12.setText("Grid");
    jButton12.setHorizontalAlignment(SwingConstants.CENTER);
    jButton12.setVerifyInputWhenFocusTarget(true);
    jButton12.setToolTipText("Single Agent Grid");
    jButton12.setPreferredSize(new Dimension(70, 75));
    jButton12.setMinimumSize(new Dimension(70, 75));
    jButton12.setMaximumSize(new Dimension(70, 75));
    jButton12.setEnabled(false);
//    jButton12.setBorder(null);
//    jButton12.setBorder(BorderFactory.createEtchedBorder());
    jButton14.setBackground(Color.white);
//    jButton14.setFont(new java.awt.Font("Dialog", 1, 22));
//    jButton14.setBorder(null);
//    jButton14.setBorder(BorderFactory.createEtchedBorder());
    jButton14.setMaximumSize(new Dimension(70, 75));
    jButton14.setMinimumSize(new Dimension(70, 75));
    jButton14.setPreferredSize(new Dimension(110, 40));
    jButton14.setToolTipText("JADE Framework");
    jButton14.addMouseListener(new MenuFrame_jButton14_mouseAdapter(this));
    jButton14.addActionListener(new MenuFrame_jButton14_actionAdapter(this));
//    jButton15.setFont(new java.awt.Font("Dialog", 1, 12));
//    jButton15.setBorder(null);
    jButton15.setMaximumSize(new Dimension(70, 75));
    jButton15.setMinimumSize(new Dimension(70, 75));
    jButton15.setPreferredSize(new Dimension(70, 75));
    jButton15.setToolTipText("Run Simulation");
    jButton17.setEnabled(false);
//    jButton17.setFont(new java.awt.Font("Dialog", 1, 12));
//    jButton17.setBorder(null);
    jButton17.setMaximumSize(new Dimension(70, 75));
    jButton17.setMinimumSize(new Dimension(70, 75));
    jButton17.setPreferredSize(new Dimension(70, 75));
    jButton17.setToolTipText("Stop Simulation");
//    jProgressBar1.setForeground(SystemColor.desktop);
    jProgressBar1.setBackground(Color.lightGray);
    jProgressBar1.setString("0% waiting...");
    jProgressBar1.setStringPainted(true);
//    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//    jScrollPane1.setBorder(null);
    jPanel1.setLayout(borderLayout3);
//    jButton3.setBorder(null);
    jButton3.setEnabled(false);
    jButton3.setMaximumSize(new Dimension(70, 75));
    jButton3.setMinimumSize(new Dimension(70, 75));
    jButton3.setPreferredSize(new Dimension(70, 75));
    jButton3.setToolTipText("Metrics and Tables");
    jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton3.setIcon(image16);
    jButton3.setText("Tables");
    jButton3.setVerticalAlignment(SwingConstants.BOTTOM);
    jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
    jButton3.addChangeListener(new MenuFrame_jButton3_changeAdapter(this));
    jButton3.addActionListener(new MenuFrame_jButton3_actionAdapter(this));
//    at.setClosed(true);
//    at.setIcon(true);
    jLabel1.setIcon(hydroImage);
    jLabel1.setBounds(new Rectangle(-2, 0, 961, 651));
    jMenu4.setText("View");
    jMenuItem1.setEnabled(false);
    jMenuItem1.setText("Agent Table");
    jMenuItem1.addActionListener(new MenuFrame_jMenuItem1_actionAdapter(this));
    jMenuItem5.setEnabled(false);
    jMenuItem5.setText("Genealogical Tree");
    jMenuItem5.addActionListener(new MenuFrame_jMenuItem5_actionAdapter(this));
    jMenuItem6.setEnabled(false);
    jMenuItem6.setText("Agent Grid");
    jMenuItem6.addActionListener(new MenuFrame_jMenuItem6_actionAdapter(this));
    jMenuItem7.setEnabled(false);
    jMenuItem7.setText("Population Graph");
    jMenuItem7.addActionListener(new MenuFrame_jMenuItem7_actionAdapter(this));
    jMenuItem9.setEnabled(false);
    jMenuItem9.setText("Pause");
    jMenuItem9.addActionListener(new MenuFrame_jMenuItem9_actionAdapter(this));
    jToolBar.add(jButton6, null); //load
    jToolBar.add(jButton9, null);
    jToolBar.addSeparator();
    jToolBar.add(jButton1);
    jToolBar.addSeparator();
    jToolBar.add(jButton12, null); //save
    jToolBar.add(jButton2);//run
    jToolBar.add(jButton13, null);
    jToolBar.add(jButton3, null);
    jToolBar.addSeparator();
    jToolBar.add(jButton15, null);
    jToolBar.add(jButton17, null);
    jToolBar.addSeparator();
    jToolBar.add(jButton7, null);
    jToolBar.add(jPanel1, null);
    jPanel1.add(jButton14, BorderLayout.EAST);
    jMenuFile.add(jMenuItem2);
    jMenuFile.add(jMenuItem3);
    jMenuFile.addSeparator();
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuItem12);
    jMenuHelp.addSeparator();
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenu4);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu3);
    jMenuBar1.add(jMenu2);
    jMenuBar1.add(jMenuHelp);
    this.setJMenuBar(jMenuBar1);
    contentPane.add(jToolBar, BorderLayout.NORTH);
    contentPane.add(statusBar, BorderLayout.SOUTH);
    contentPane.add(jDesktopPane1, BorderLayout.CENTER);
    jDesktopPane1.add(rc);
    jDesktopPane1.add(jLabel1, null);
    jMenu1.add(jMenuItem13);
    jMenu2.add(jMenuItem8);
    jMenu3.add(jMenuItem10);
    jMenu3.add(jMenuItem9);
    jMenu3.addSeparator();
    jMenu3.add(jMenuItem4);
//    jDesktopPane1.add(selectSettingsFrame);
    jScrollPane1.getViewport().add(jTextArea1, null);
    jMenu4.add(jMenuItem6);
    jMenu4.add(jMenuItem1);
    jMenu4.add(jMenuItem5);
    jMenu4.addSeparator();
    jMenu4.add(jMenuItem7);
    rc.setSize(303,400);
    rc.setLocation(750,270);
    rc.setVisible(true);
//    jDesktopPane1.add(at);
    at.setSize(756,560);
//    jDesktopPane1.add(gFrame1);

  }
  //File | Exit action performed
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //Help | About action performed
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    MenuFrame_AboutBox dlg = new MenuFrame_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }

  /*/Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }*/

  void jButton1_actionPerformed(ActionEvent e) {
    //settings MENU
    if (selectSettingsFrame.isVisible()==false){
      jDesktopPane1.add(selectSettingsFrame);
      selectSettingsFrame.setSize(426,431);
      selectSettingsFrame.setVisible(true);
    }
    if (selectSettingsFrame.isIcon()==true){
      try {
        selectSettingsFrame.setIcon(false);
      }
      catch (PropertyVetoException ex) {
      }
    }


  }

 public void jButton2_actionPerformed(ActionEvent e) {
    if (drawFamilyPanelFrame.isVisible()==false){
      jDesktopPane1.add(drawFamilyPanelFrame);
      drawFamilyPanelFrame.setSize(530, 350);
      drawFamilyPanelFrame.setLocation(500, 20);
      drawFamilyPanelFrame.setTitle("Genealogical Trees");
      drawFamilyPanelFrame.setVisible(true);
    }
    if (drawFamilyPanelFrame.isIcon()==true){
      try {
        drawFamilyPanelFrame.setIcon(false);
      }
      catch (PropertyVetoException ex) {
      }
    }
  }



class MenuFrame_jMenuFileExit_ActionAdapter implements ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuFileExit_ActionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuFileExit_actionPerformed(e);
  }
}

class MenuFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuHelpAbout_ActionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuHelpAbout_actionPerformed(e);
  }
}

class MenuFrame_jButton1_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton1_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class MenuFrame_jButton2_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton2_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}



  void jMenuItem3_actionPerformed(ActionEvent e) {
    this.jButton6_actionPerformed(e);
  }


  void jMenuItem9_actionPerformed(ActionEvent e) {
    jButton15_actionPerformed(e);
  }





  void jButton6_actionPerformed(ActionEvent e) {
    /**
     * LOAD Button
     */
    jFileChooser1.setDialogTitle("Load Settings");
    int returnVal = jFileChooser1.showOpenDialog(this);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = jFileChooser1.getSelectedFile();
        try {
          FileReader fileIn = new FileReader(file);
          LineNumberReader in = new LineNumberReader(fileIn);
          String filetag = in.readLine();
          if (!filetag.equals("Settings file")) {
            JOptionPane.showMessageDialog(this,
                                          file.getName() +
                                          " is not a valid settings file");
            in.close();
            fileIn.close();
          }
          else{
            settings = new Settings(file);
            selectSettingsFrame.setFileOpenData();
            JOptionPane.showMessageDialog(this, "Settings loaded successfully");
          }
        }
        catch (IOException ex) {
        }
        catch (HeadlessException ex) {
        }

    }

  }

  void jMenuItem13_actionPerformed(ActionEvent e) {
    this.jButton1_actionPerformed(e);
  }

  void jButton12_actionPerformed(ActionEvent e) {
    //drawPanelFrame2=new DrawPanelFrame();
    if(drawPanelFrame2.isVisible()==false){
      jDesktopPane1.add(drawPanelFrame2);
      drawPanelFrame2.setSize(500,500);
      drawPanelFrame2.setTitle("Agent Village");
      drawPanelFrame2.setVisible(true);
    }
    if (drawPanelFrame2.isIcon()==true){
      try {
        drawPanelFrame2.setIcon(false);
      }
      catch (PropertyVetoException ex) {
      }
    }

  }

  void saveImage(){

    jFileChooser3.setDialogTitle("Export Image");
    int returnVal=jFileChooser3.showSaveDialog(this);
    if (returnVal==jFileChooser3.APPROVE_OPTION){
      File file = jFileChooser3.getSelectedFile();
      String filename=file.toString();
      gFrame1.exportImages(filename);
    }

  }

  void saveData(){
    jFileChooser2.setDialogTitle("Save Simulation Data");
    int returnVal = jFileChooser2.showSaveDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = jFileChooser2.getSelectedFile();
      String filename = file.toString()+"-1.txt";
      try {
        FileWriter fileOut = new FileWriter(filename);
        PrintWriter out = new PrintWriter(fileOut);
        SimpleDateFormat formatter= new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
        Date currentTime_1 = new Date();
        String dateString = formatter.format(currentTime_1);
        jade.util.leap.List data=SuperAgent.agentTableData;
        out.println("GeneCity data : "+dateString);
        //Epidemiological Simulation
        out.println("Does not affect death?:\t"+settings.getAffectDth());
        out.println("Is able to reproduce?:\t"+settings.getAffectReproduction());
        out.println("Age Difference:\t"+settings.getageDifferenceCouples());
        out.println("Mating Vision:\t"+settings.getagentMateVision());
        out.println("Initial Population:\t"+settings.getagentPopulation());
        out.println("Initial Info Degree:\t" +settings.getBeginInformationDegree());
        out.println("Condition:\t"+settings.getCondition());
        out.println("Disease Name:\t"+settings.getDiseaseName());
        out.println("Fertility Ratio:\t"+settings.getfertilityRatio());
        out.println("Legal Marriage Age:\t"+settings.getlegalMarriageAge());
        out.println("Life Span:\t"+settings.getlifeSpan());
        out.println("Expected years of life after disease:\t"+settings.getlifeYearsExpectancyDisease());
        out.println("Marriages over population:\t"+settings.getmarriageOverPopulation());
        out.println("Method of transmition:\t"+settings.getMethodTransmittion());
        out.println("Mean age disease effect:\t"+settings.getmeanAgeEffection());
        out.println("Patients over Population\t"+settings.getpatientsOverPopulation());
        out.println("Pre birth control:\t"+settings.getPrebirthControlAbortion());
        out.println("Mutation Rate:\t"+settings.getrealMutationRate());
        out.println("Reproduction ability:\t"+settings.getreproductionAbilityPerc());
        out.println("Diseased over carriers:\t"+settings.getDiseaseOverCarriers());
        out.println("Dominant?\t"+settings.getDominantAutosomatic());
        out.println("Name\tSex\tBirth\tDeathAt\tHealth\tFear\tInfo\tComment\tFamily\tEpoch\tGAccept\tGFear\tGHealth\tGInfluence\tGMut(Mother,Father)\tGPhenotype\tGReproduction\tGVision\tGWealth");
        for(int i=0;i<data.size();i++){
          for(int j=0;j<((jade.util.leap.List)data.get(0)).size();j++){
            out.print(((jade.util.leap.List)data.get(i)).get(j)+"\t");
          }
          out.println("");
        }
        out.close();
        fileOut.close();
      }
      catch (IOException ex) {
      }

      filename = file.toString()+"-2.txt";
      try {
        FileWriter fileOut = new FileWriter(filename);
        PrintWriter out = new PrintWriter(fileOut);
        SimpleDateFormat formatter= new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
        Date currentTime_1 = new Date();
        String dateString = formatter.format(currentTime_1);
        jade.util.leap.List data=SuperAgent.metricsList;
        out.println("GeneCity data : "+dateString);
        out.println("Epoch\tAgent Population\tCarriers\tDisreasedt\t100*Carriers/Population%\t100*Diseased/Population%\tNew children\tAborted Children\tNew agents in grid\tNumber Children Early Death\tNumber of Families\tDeaths\tBirths\tMales\tFemales\tPeople\tMale Carriers\tFemale Carriers\tMales Diseased\tFemale Diseased\tPeople Informed in this epoch\tDegree of Info spread from Media\tNeighborhood Informations");
        for(int i=0;i<data.size();i++){
          for(int j=0;j<((jade.util.leap.List)data.get(0)).size();j++){
            out.print(((jade.util.leap.List)data.get(i)).get(j)+"\t");
          }
          out.println("");
        }
        out.close();
        fileOut.close();
      }
      catch (IOException ex) {
      }
    }
  }



  void jButton9_actionPerformed(ActionEvent e) {
    if(runPauseStatus>1){
          la.pauseAgents();
      if (JOptionPane.showConfirmDialog(null, "Do you want to export images?",
                                        "Export Results",
                                        JOptionPane.YES_NO_OPTION) == 0) {
        jButton13_actionPerformed(e);
        saveImage();
      }
      if (JOptionPane.showConfirmDialog(null,
                                        "Do you want to export table of data?",
                                        "Export Results",
                                        JOptionPane.YES_NO_OPTION) == 0) {
        saveData();
      }
    }
    if(JOptionPane.showConfirmDialog(null,"Do you want to save settings?","Save Settings",JOptionPane.YES_NO_OPTION)==0){
      jFileChooser1.setDialogTitle("Save Simulation Settings");
      int returnVal = jFileChooser1.showSaveDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = jFileChooser1.getSelectedFile();
        String filename = file.toString();
        if (Utilities.getExtension(file)==null){
          filename = file.toString()+".gcs";
        }
        else if (!Utilities.getExtension(file).equals("gcs")){
          filename = file.toString()+".gcs";
        }
        try {
          FileWriter fileOut = new FileWriter(filename);
          PrintWriter out = new PrintWriter(fileOut);
          out.println("Settings file");
          //Epidemiological Simulation
          out.println(settings.getAffectDth());
          out.println(settings.getAffectReproduction());
          out.println(settings.getageDifferenceCouples());
          out.println(settings.getagentMateVision());
          out.println(settings.getagentPopulation());
          out.println(settings.getBeginInformationDegree());
          out.println(settings.getCondition());
          out.println(settings.getDiseaseName());
          out.println(settings.getfertilityRatio());
          out.println(settings.getlegalMarriageAge());
          out.println(settings.getlifeSpan());
          out.println(settings.getlifeYearsExpectancyDisease());
          out.println(settings.getmarriageOverPopulation());
          out.println(settings.getMethodTransmittion());
          out.println(settings.getmeanAgeEffection());
          out.println(settings.getpatientsOverPopulation());
          out.println(settings.getPrebirthControlAbortion());
          out.println(settings.getrealMutationRate());
          out.println(settings.getreproductionAbilityPerc());
          out.println(settings.getDiseaseOverCarriers());
          out.println(settings.getDominantAutosomatic());
          out.close();
          fileOut.close();
        }
        catch (IOException ex) {
        }
      } else {
      }
    }
     if(runPauseStatus>1){
       la.resumeAgents();
     }
  }

  void jMenuItem2_actionPerformed(ActionEvent e) {
    this.jButton9_actionPerformed(e);
  }

  void jButton13_actionPerformed(ActionEvent e) {

    if(gFrame1.isVisible()==false){
      jDesktopPane1.add(gFrame1);
      gFrame1.setSize(850,500);
      gFrame1.setVisible(true);

    }
  if (gFrame1.isIcon()==true){
  try {
    gFrame1.setIcon(false);
  }
  catch (PropertyVetoException ex) {
  }
}

  }

  void gFrame1_ancestorAdded(AncestorEvent e) {

  }

  void jButton14_actionPerformed(ActionEvent e) {
la.launchPlatform();

  }

  void jMenuItem10_actionPerformed(ActionEvent e) {
    jButton15_actionPerformed(e);
  }

  public void jButton15_actionPerformed(ActionEvent e) {
    if(runPauseStatus==1){  //TODO IF PLAY IS PRESSED FOR 1st TIME
      jMenuItem9.setEnabled(true);
      jMenuItem10.setEnabled(false);
      jMenuItem10.setText("Continue");
      if(selectSettingsFrame.isVisible()==true&&selectSettingsFrame.isIcon()!=true){
        selectSettingsFrame.jButton2_actionPerformed(e);
      }
      //drawPanelFrame1=new DrawPanelFrame();
      this.setTitle("GeneCity Epidemiological Simulation: "+MenuFrame.settings.getDiseaseName());
      grid = new Grid();
      jButton15.setIcon(image13); //pause button
      jButton15.setText("Pause");
      jButton15.setToolTipText("Pause Simulation");
      jButton17.setEnabled(true);
      runPauseStatus=2;
      setTextMessage("Initiating Agents...");
      la.launchSuperAgent(); //me auto ekkinoun oloi oi praktores
//      jButton1.setEnabled(false);

    }else if(runPauseStatus==2) { //todo if pause is pressed
      la.pauseAgents();
      jMenuItem10.setEnabled(true);
      jMenuItem9.setEnabled(false);
      jButton15.setIcon(image11);
      jButton15.setToolTipText("Run Simulation");
      jButton15.setText("Continue");
      runPauseStatus=3;
      setTextMessage("System Pause");


    }else if(runPauseStatus==3){ //todo if resume is pressed
      //resume
      la.resumeAgents();
      jMenuItem10.setEnabled(false);
      jMenuItem9.setEnabled(true);
      jButton15.setIcon(image13); //pause button
      jButton15.setText("Pause");
      jButton15.setToolTipText("Pause Simulation");
      jButton17.setEnabled(true);
      jButton12.setEnabled(true); //single agent button
//      jButton2.setEnabled(true); //family button
      runPauseStatus=2;
      setTextMessage("Resume Operation");
    }
  }

  void jButton17_actionPerformed(ActionEvent e) {
    if(drawFamilyPanelFrame.isVisible()==true){
      try {
        drawFamilyPanelFrame.setIcon(true);
      }
      catch (PropertyVetoException ex) {
      }
    }
    runPauseStatus=2;
    jButton15_actionPerformed(e);

    if(JOptionPane.showConfirmDialog(null,"This will erase all data\nProceed?\n","Warning",JOptionPane.YES_NO_OPTION)==0){

      //la.resumeAgents();
      la.pauseAgents();
      la.killAllAgents();

      //table dispose
      at.dispose();
      jButton3.setEnabled(false);

      //new graph
      gFrame1.dispose();
      gFrame1 = new GraphFrame();

      //hide
      if(drawFamilyPanelFrame.isIcon()==true){
        try {
          drawFamilyPanelFrame.setClosed(true);
        }
        catch (PropertyVetoException ex) {
        }
      }

      //enable settings
//      jButton1.setEnabled(true);

      MenuFrame.rc.jButtonAddAgent.setEnabled(false);
      jButton15.setIcon(image11);
      jButton15.setToolTipText("Run Simulation");
      jButton15.setText("Run");
      runPauseStatus=1;
      jButton17.setEnabled(false);
      jMenuItem10.setEnabled(true);
      jMenuItem9.setEnabled(false);
      jMenuItem10.setText("Start");

      if(drawPanelFrame2.isEnabled()==true){ drawPanelFrame2.setEnabled(false);}
      grid.clearArea();
      drawPanelFrame2.drawPanel.repaint();
      jButton12.setEnabled(false);
      jButton2.setEnabled(false);
      jButton13.setEnabled(false);
      runPauseStatus=1;

    }else la.resumeAgents();
  }

  void jButton7_actionPerformed(ActionEvent e) {
    if(helpFrame.isVisible()==false){
      jDesktopPane1.add(helpFrame);
      helpFrame.setSize(800, 600);
      helpFrame.show();
    }
  }

  private void setTextMessage(String s){
    MenuFrame.rc.jTextArea1.append(s+"\n");
    MenuFrame.rc.jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
}

  void jButton3_actionPerformed(ActionEvent e) {
    if(at.isVisible()==false){
      jDesktopPane1.add(at);
      at.setVisible(true);
    }
    if (at.isIcon()==true){
    try {
      at.setIcon(false);
    }
    catch (PropertyVetoException ex) {
    }
  }
  }

  void this_windowClosing(WindowEvent e) {
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    boolean result = false;
    int answer = JOptionPane.showConfirmDialog(this, "Do you want to terminate session?", "Exit", JOptionPane.YES_NO_OPTION);
    switch (answer) {
      case JOptionPane.YES_OPTION :
        result = true;
        break;
        default:
          result = false;
          break;
    }
    if (result) {   //do some destruction to release system resources first ....
    System.exit(0);
  }

  }

  void jMenuItem6_actionPerformed(ActionEvent e) {
    jButton12_actionPerformed(e);
  }

  void jMenuItem1_actionPerformed(ActionEvent e) {
    jButton3_actionPerformed(e);
  }

  void jMenuItem5_actionPerformed(ActionEvent e) {
    jButton2_actionPerformed(e);
  }

  void jMenuItem7_actionPerformed(ActionEvent e) {
    jButton13_actionPerformed(e);
  }

  void jMenuItem4_actionPerformed(ActionEvent e) {
    jButton17_actionPerformed(e);
  }

  void jButton3_stateChanged(ChangeEvent e) {
    if(jButton3.isEnabled()==true){
      jMenuItem1.setEnabled(true);
    }else{
      jMenuItem1.setEnabled(false);
    }
  }

  void jButton13_stateChanged(ChangeEvent e) {
    if(jButton13.isEnabled()==true){
      jMenuItem7.setEnabled(true);
    }else{
      jMenuItem7.setEnabled(false);
    }

  }

  void jButton2_stateChanged(ChangeEvent e) {
    if(jButton2.isEnabled()==true){
      jMenuItem5.setEnabled(true);
    }else{
      jMenuItem5.setEnabled(false);
    }

  }

  void jButton12_stateChanged(ChangeEvent e) {
    if(jButton12.isEnabled()==true){
      jMenuItem6.setEnabled(true);
    }else{
      jMenuItem6.setEnabled(false);
    }

  }

  void jMenuItem8_actionPerformed(ActionEvent e) {
    jButton14_actionPerformed(e);
  }

  void jMenuItem12_actionPerformed(ActionEvent e) {
    jButton7_actionPerformed(e);
  }

  void jButton17_stateChanged(ChangeEvent e) {
    if(jButton17.isEnabled()==true){
      jMenuItem4.setEnabled(true);
    }else{
      jMenuItem4.setEnabled(false);
    }

  }


}

class MenuFrame_jMenuItem3_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem3_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem3_actionPerformed(e);
  }
}

class MenuFrame_jButton1_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton1_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class MenuFrame_jButton2_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton2_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class MenuFrame_jButton6_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton6_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton6_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem13_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem13_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem13_actionPerformed(e);
  }
}

class MenuFrame_jButton12_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton12_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton12_actionPerformed(e);
  }
}

class MenuFrame_jButton9_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton9_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton9_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem2_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem2_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem2_actionPerformed(e);
  }
}

class MenuFrame_jButton13_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton13_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton13_actionPerformed(e);
  }
}

class MenuFrame_gFrame1_ancestorAdapter implements javax.swing.event.AncestorListener {
  MenuFrame adaptee;

  MenuFrame_gFrame1_ancestorAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void ancestorAdded(AncestorEvent e) {
    adaptee.gFrame1_ancestorAdded(e);
  }
  public void ancestorRemoved(AncestorEvent e) {
  }
  public void ancestorMoved(AncestorEvent e) {
  }
}

class MenuFrame_jButton14_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton14_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton14_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem10_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem10_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem10_actionPerformed(e);
  }
}

class MenuFrame_jButton15_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton15_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton15_actionPerformed(e);
  }
}

class MenuFrame_jButton17_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton17_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton17_actionPerformed(e);
  }
}

class MenuFrame_jButton14_mouseAdapter extends java.awt.event.MouseAdapter {
  MenuFrame adaptee;

  MenuFrame_jButton14_mouseAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
}

class MenuFrame_jButton7_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton7_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton7_actionPerformed(e);
  }
}

class MenuFrame_jButton3_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jButton3_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class MenuFrame_this_windowAdapter extends java.awt.event.WindowAdapter {
  MenuFrame adaptee;

  MenuFrame_this_windowAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void windowClosing(WindowEvent e) {
    adaptee.this_windowClosing(e);
  }
}

class MenuFrame_jMenuItem6_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem6_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem6_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem1_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem1_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem1_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem5_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem5_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem5_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem7_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem7_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem7_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem4_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem4_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem4_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem9_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem9_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem9_actionPerformed(e);
  }
}

class MenuFrame_jButton3_changeAdapter implements javax.swing.event.ChangeListener {
  MenuFrame adaptee;

  MenuFrame_jButton3_changeAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jButton3_stateChanged(e);
  }
}

class MenuFrame_jButton13_changeAdapter implements javax.swing.event.ChangeListener {
  MenuFrame adaptee;

  MenuFrame_jButton13_changeAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jButton13_stateChanged(e);
  }
}

class MenuFrame_jButton2_changeAdapter implements javax.swing.event.ChangeListener {
  MenuFrame adaptee;

  MenuFrame_jButton2_changeAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jButton2_stateChanged(e);
  }
}

class MenuFrame_jButton12_changeAdapter implements javax.swing.event.ChangeListener {
  MenuFrame adaptee;

  MenuFrame_jButton12_changeAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jButton12_stateChanged(e);
  }
}

class MenuFrame_jMenuItem8_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem8_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem8_actionPerformed(e);
  }
}

class MenuFrame_jMenuItem12_actionAdapter implements java.awt.event.ActionListener {
  MenuFrame adaptee;

  MenuFrame_jMenuItem12_actionAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItem12_actionPerformed(e);
  }
}

class MenuFrame_jButton17_changeAdapter implements javax.swing.event.ChangeListener {
  MenuFrame adaptee;

  MenuFrame_jButton17_changeAdapter(MenuFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jButton17_stateChanged(e);
  }
}

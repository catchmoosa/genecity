package genecity.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import genecity.agentCommunication.*;
import java.util.Vector;
import genecity.SuperAgent;

/**
 * <p>Title: DrawPanelFrame</p>
 * <p>Description: Internal Frame of Grid</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class DrawPanelFrame extends JInternalFrame {

  public static Families family2View=new Families();

  JSlider jSlider2 = new JSlider(5, 100, 30);
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel5 = new JPanel();

  public DrawPanel drawPanel = new DrawPanel();///////////////////////////////
//  public DrawPanel drawPanel2 = new DrawPanel();///////////////////////////////

  JScrollPane jScrollPane3 = new JScrollPane();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenu1 = new JMenu();
  public JCheckBoxMenuItem jCheckBoxMenuItemFamily = new JCheckBoxMenuItem();
  public JCheckBoxMenuItem jCheckBoxMenuItemSingle = new JCheckBoxMenuItem();
//  TitledBorder titledBorder1;
//  TitledBorder titledBorder2;

  public DrawPanelFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
//    titledBorder1 = new TitledBorder("");
//    titledBorder2 = new TitledBorder("");
    jPanel5.setLayout(borderLayout4);
    jPanel5.setMaximumSize(new Dimension(32767, 32767));
    jSlider2.setOrientation(JSlider.VERTICAL);
    jSlider2.addChangeListener(new DrawPanelFrame_jSlider2_changeAdapter(this));
    this.getContentPane().setLayout(borderLayout1);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setOpaque(true);
    jLabel1.setText(" ");
    drawPanel.setOpaque(false);
    drawPanel.addMouseMotionListener(new DrawPanelFrame_drawPanel_mouseMotionAdapter(this));
    drawPanel.addMouseListener(new DrawPanelFrame_drawPanel_mouseAdapter(this));
    this.setClosable(true);
//    this.setFrameIcon(null);
    this.setIconifiable(true);
    this.setMaximizable(true);
    this.setMaximum(false);
    this.setResizable(true);
    this.setEnabled(true);
//    this.setBorder(BorderFactory.createEtchedBorder());
    this.setPreferredSize(new Dimension(81, 241));
    jMenu1.setText("View in Grid");
    jCheckBoxMenuItemFamily.setText("Families");
    jCheckBoxMenuItemFamily.addChangeListener(new DrawPanelFrame_jCheckBoxMenuItemFamily_changeAdapter(this));
    jCheckBoxMenuItemSingle.setText("Single Agents");
    jCheckBoxMenuItemSingle.addChangeListener(new DrawPanelFrame_jCheckBoxMenuItemSingle_changeAdapter(this));
    jPanel5.add(jScrollPane3, BorderLayout.CENTER);
    jPanel5.add(jSlider2, BorderLayout.EAST);
    jPanel5.add(jLabel1,  BorderLayout.SOUTH);
    jScrollPane3.add(drawPanel, null);
    jScrollPane3.getViewport().add(drawPanel, null);
    this.getContentPane().add(jPanel5, BorderLayout.CENTER);
    jMenuBar1.add(jMenu1);
    jMenu1.add(jCheckBoxMenuItemFamily);
    jMenu1.add(jCheckBoxMenuItemSingle);
    jCheckBoxMenuItemFamily.setSelected(true);
    jCheckBoxMenuItemSingle.setSelected(true);
    this.setJMenuBar(jMenuBar1);
  }

  void jSlider2_stateChanged(ChangeEvent e) {
    int zoom = jSlider2.getValue();
    jLabel1.setText("zoom: " + String.valueOf(10 * zoom) + "%");
    drawPanel.CELL_SIZE = zoom;
    drawPanel.setPreferredSize(
        new Dimension(genecity.gui.MenuFrame.settings.getX() *
                      drawPanel.CELL_SIZE,
                      genecity.gui.MenuFrame.settings.getY() *
                      drawPanel.CELL_SIZE));
//    drawPanel.revalidate();
    drawPanel.revalidate();
    this.repaint();


  }


  void jCheckBoxMenuItemFamily_stateChanged(ChangeEvent e) {
    this.repaint();
  }

  void jCheckBoxMenuItemSingle_stateChanged(ChangeEvent e) {
    this.repaint();
  }

  void drawPanel_mouseClicked(MouseEvent e) {
    this.repaint();
    int x=(int)(100*(double)e.getX()/(double)(genecity.gui.MenuFrame.settings.getX() *
                      drawPanel.CELL_SIZE)/(100.0/(double)MenuFrame.grid.getD1()));
    int y=(int)(100*(double)e.getY()/(double)(genecity.gui.MenuFrame.settings.getX() *
                      drawPanel.CELL_SIZE)/(100.0/(double)MenuFrame.grid.getD1()));

    if(x>=MenuFrame.grid.getD1()||y>=MenuFrame.grid.getD1()){
      jLabel1.setText("Out of bounds");
    }else{
      Object takeData=MenuFrame.grid.getAgentName(x+1,y+1);

      if(takeData==null){
        jLabel1.setText("Empty cell");
      }else{
        if(takeData instanceof Description){
          Description des=(Description)takeData;
          jLabel1.setText("Agent: "+des.getName()+", "+des.getSex()+", "+des.getHealth());
          if(des.getFromFamilyID()>1){
            //MenuFrame.la.pauseAgents();
            Families des2 = (Families) SuperAgent.allFamiliesList.get( (des.
                getFromFamilyID()) - 1);
            family2View = des2;
            if (MenuFrame.drawFamilyPanelFrame.isVisible() == false) {
              MenuFrame.jDesktopPane1.add(MenuFrame.drawFamilyPanelFrame);
              MenuFrame.drawFamilyPanelFrame.setSize(530, 350);
              MenuFrame.drawFamilyPanelFrame.setLocation(500, 20);
              MenuFrame.drawFamilyPanelFrame.setTitle("Genealogical Trees");
              MenuFrame.drawFamilyPanelFrame.setVisible(true);
//              MenuFrame.jButton2.setEnabled(true);
            }
          }


        }else if(takeData instanceof Families){
          Families des=(Families)takeData;
          jLabel1.setText("Family: "+des.getFamilyID()+", "+des.getChildren().size()+" children, "+des.getFather().getName()+"+"+des.getMother().getName());
          //MenuFrame.la.pauseAgents();
          family2View=des;
          if (MenuFrame.drawFamilyPanelFrame.isVisible()==false){
            MenuFrame.jDesktopPane1.add(MenuFrame.drawFamilyPanelFrame);
            MenuFrame.drawFamilyPanelFrame.setSize(530, 350);
            MenuFrame.drawFamilyPanelFrame.setLocation(500, 20);
            MenuFrame.drawFamilyPanelFrame.setTitle("Genealogical Trees");
            MenuFrame.drawFamilyPanelFrame.setVisible(true);
//            MenuFrame.jButton2.setEnabled(true);
          }
        }
      }
    }



  }

  void drawPanel_mouseMoved(MouseEvent e) {
    this.repaint();
    int x=(int)(100*(double)e.getX()/(double)(genecity.gui.MenuFrame.settings.getX() *
                      drawPanel.CELL_SIZE)/(100.0/(double)MenuFrame.grid.getD1()));
    int y=(int)(100*(double)e.getY()/(double)(genecity.gui.MenuFrame.settings.getX() *
                      drawPanel.CELL_SIZE)/(100.0/(double)MenuFrame.grid.getD1()));

    if(x>=MenuFrame.grid.getD1()||y>=MenuFrame.grid.getD1()){
      jLabel1.setText("Out of bounds");
    }else{
      Object takeData=MenuFrame.grid.getAgentName(x+1,y+1);

      if(takeData==null){
        jLabel1.setText("Empty cell");
      }else{
        if(takeData instanceof Description){
          Description des=(Description)takeData;
          jLabel1.setText("Agent: "+des.getName()+", "+des.getSex()+", "+des.getHealth());
        }else if(takeData instanceof Families){
          Families des=(Families)takeData;
          jLabel1.setText("Family: "+des.getFamilyID()+", "+des.getChildren().size()+" children, "+des.getFather().getName()+"+"+des.getMother().getName());
        }
      }

    }
  }

  void jCheckBoxMenuItemAgentsFamilyNEt_stateChanged(ChangeEvent e) {
this.repaint();
  }







}

class DrawPanelFrame_jSlider2_changeAdapter implements javax.swing.event.ChangeListener {
  DrawPanelFrame adaptee;

  DrawPanelFrame_jSlider2_changeAdapter(DrawPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider2_stateChanged(e);
  }
}

class DrawPanelFrame_jCheckBoxMenuItemFamily_changeAdapter implements javax.swing.event.ChangeListener {
  DrawPanelFrame adaptee;

  DrawPanelFrame_jCheckBoxMenuItemFamily_changeAdapter(DrawPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBoxMenuItemFamily_stateChanged(e);
  }
}

class DrawPanelFrame_jCheckBoxMenuItemSingle_changeAdapter implements javax.swing.event.ChangeListener {
  DrawPanelFrame adaptee;

  DrawPanelFrame_jCheckBoxMenuItemSingle_changeAdapter(DrawPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBoxMenuItemSingle_stateChanged(e);
  }
}

class DrawPanelFrame_drawPanel_mouseAdapter extends java.awt.event.MouseAdapter {
  DrawPanelFrame adaptee;

  DrawPanelFrame_drawPanel_mouseAdapter(DrawPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.drawPanel_mouseClicked(e);
  }
}

class DrawPanelFrame_drawPanel_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  DrawPanelFrame adaptee;

  DrawPanelFrame_drawPanel_mouseMotionAdapter(DrawPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.drawPanel_mouseMoved(e);
  }
}







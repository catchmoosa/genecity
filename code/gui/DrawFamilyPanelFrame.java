package genecity.gui;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import genecity.agentCommunication.*;
import genecity.SuperAgent;
import genecity.genetics.Chromosoma;
import java.text.DecimalFormat;
import java.beans.*;

/**
 * <p>Title: DrawFamilyPanelFrame</p>
 * <p>Description:  Internal Frame of Geneological Tree</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class DrawFamilyPanelFrame extends JInternalFrame {
  private int familyGridSize=500;
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  ImageIcon icon1;
  DecimalFormat twoDigits=new DecimalFormat("0.000");


  JSlider jSlider1 = new JSlider(5, 100, 35);
  JPanel jPanel1 = new JPanel();
  JLabel jLabel5 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  DrawFamilyPanel drawFamilyPanel = new DrawFamilyPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  private boolean flag=false;
  JButton jButton1 = new JButton();
  JLabel jLabel18 = new JLabel();

  public DrawFamilyPanelFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Personal Data");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Characteristics");
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Family Data");
    icon1 = new ImageIcon(genecity.gui.MenuFrame.class.getResource("details2.png"));
    this.setClosable(true);
    this.setIcon(false);
    this.setMaximizable(false);
    this.setMaximum(false);
    this.setResizable(true);
    this.addInternalFrameListener(new DrawFamilyPanelFrame_this_internalFrameAdapter(this));
    jSlider1.setOrientation(JSlider.VERTICAL);
    jSlider1.addChangeListener(new DrawFamilyPanelFrame_jSlider1_changeAdapter(this));
    jPanel1.setMinimumSize(new Dimension(50, 50));
    jPanel1.setPreferredSize(new Dimension(0, 200));
    jPanel1.setLayout(null);
    jLabel5.setText("Health: ");
    jLabel5.setBounds(new Rectangle(12, 102, 107, 15));
    drawFamilyPanel.setOpaque(false);
    drawFamilyPanel.addMouseListener(new DrawFamilyPanelFrame_drawFamilyPanel_mouseAdapter(this));
    drawFamilyPanel.addMouseMotionListener(new DrawFamilyPanelFrame_drawFamilyPanel_mouseMotionAdapter(this));
    jPanel2.setBorder(titledBorder1);
    jPanel2.setBounds(new Rectangle(6, 12, 160, 181));
    jPanel2.setLayout(null);
    jPanel3.setBorder(titledBorder3);
    jPanel3.setBounds(new Rectangle(330, 12, 189, 132));
    jPanel3.setLayout(null);
    jLabel7.setText("Sex:");
    jLabel7.setBounds(new Rectangle(12, 42, 106, 15));
    jLabel4.setText("Epochs of life:");
    jLabel4.setBounds(new Rectangle(12, 81, 111, 17));
    jLabel2.setVerifyInputWhenFocusTarget(true);
    jLabel2.setText("Name:");
    jLabel2.setBounds(new Rectangle(12, 23, 127, 15));
    jLabel3.setText("Epoch of Birth:");
    jLabel3.setBounds(new Rectangle(12, 62, 127, 15));
    jLabel8.setText("Fear:");
    jLabel8.setBounds(new Rectangle(12, 141, 105, 15));
    jLabel9.setText("Information:");
    jLabel9.setBounds(new Rectangle(12, 121, 124, 15));
    jLabel10.setText("ID :");
    jLabel10.setBounds(new Rectangle(11, 20, 119, 17));
    jLabel11.setText("Fear Degree :");
    jLabel11.setBounds(new Rectangle(11, 54, 151, 17));
    jLabel12.setRequestFocusEnabled(true);
    jLabel12.setText("Info Degree :");
    jLabel12.setBounds(new Rectangle(10, 88, 156, 17));
    jPanel4.setBorder(titledBorder2);
    jPanel4.setBounds(new Rectangle(169, 12, 160, 181));
    jPanel4.setLayout(null);
    jLabel1.setText("Reproductive:");
    jLabel1.setBounds(new Rectangle(14, 22, 140, 15));
    jLabel6.setText("Phenotype:");
    jLabel6.setBounds(new Rectangle(14, 45, 138, 15));
    jLabel13.setText(" Wealth:");
    jLabel13.setBounds(new Rectangle(13, 68, 139, 15));
    jLabel14.setText("Acceptance: ");
    jLabel14.setBounds(new Rectangle(14, 90, 139, 15));
    jLabel15.setText("Infuency:");
    jLabel15.setBounds(new Rectangle(14, 112, 142, 15));
    jLabel16.setText("Fear:");
    jLabel16.setBounds(new Rectangle(14, 135, 135, 15));
    jLabel17.setText("Vision:");
    jLabel17.setBounds(new Rectangle(14, 157, 138, 15));
    jButton1.setBounds(new Rectangle(334, 151, 182, 37));
    jButton1.setText("Continue");
    jButton1.addActionListener(new DrawFamilyPanelFrame_jButton1_actionAdapter(this));
    jLabel18.setText("Mutation from:");
    jLabel18.setBounds(new Rectangle(12, 160, 125, 15));
    this.getContentPane().add(jSlider1, BorderLayout.EAST);
    this.getContentPane().add(jPanel1,  BorderLayout.SOUTH);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel18, null);
    jPanel1.add(jPanel4, null);
    jPanel3.add(jLabel11, null);
    jPanel3.add(jLabel10, null);
    jPanel3.add(jLabel12, null);
    jPanel1.add(jButton1, null);
    jPanel4.add(jLabel1, null);
    jPanel4.add(jLabel6, null);
    jPanel4.add(jLabel14, null);
    jPanel4.add(jLabel15, null);
    jPanel4.add(jLabel16, null);
    jPanel4.add(jLabel17, null);
    jPanel4.add(jLabel13, null);
    jPanel1.add(jPanel2, null);
    jPanel1.add(jPanel3, null);
    this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.add(drawFamilyPanel, null);
    jScrollPane1.getViewport().add(drawFamilyPanel, null);
  }

  void jSlider2_stateChanged(ChangeEvent e) {
    int zoom = jSlider1.getValue();
    drawFamilyPanel.CELL_SIZE = zoom;
    drawFamilyPanel.setPreferredSize(new Dimension(500,500));
    drawFamilyPanel.revalidate();

  }

  void jSlider1_stateChanged(ChangeEvent e) {
    int zoom = jSlider1.getValue();
    drawFamilyPanel.CELL_SIZE = zoom;
    drawFamilyPanel.setPreferredSize(new Dimension(500,500));
//    drawPanel.revalidate();
    drawFamilyPanel.revalidate();
    this.repaint();

  }

  /**
   * MOUSE MOVED
   * @param e
   */
  void drawFamilyPanel_mouseMoved(MouseEvent e) {
    int x=(int)(100*(double)e.getX()/(double)(familyGridSize *
                      drawFamilyPanel.CELL_SIZE)/(100.0/(double)familyGridSize));
    int y=(int)(100*(double)e.getY()/(double)(familyGridSize *
                      drawFamilyPanel.CELL_SIZE)/(100.0/(double)familyGridSize));
    Families thisFamily=(Families)this.drawFamilyPanel.getThisFamily();
    Description des=new Description();
    if(x==0&&y==0){//father
      des=thisFamily.getFather();
    }else if(x==2&&y==0){
      des=thisFamily.getMother();
    }else if(y==2){
      int lastKidPosition=2*thisFamily.getChildren().size();
      if((!(x%2==0))&&x>0&&x<lastKidPosition){
        des=(Description)thisFamily.getChildren().get((x-1)/2);
      }
    }
    jLabel2.setText("Name: "+des.getName());
    jLabel5.setText("Health: "+des.getHealth());
    jLabel7.setText("Sex: "+des.getSex());
    jLabel4.setText("Epochs to live: "+des.getEpochsToLive());
    jLabel3.setText("Epoch of Birth: "+des.getEpochOfBirth());
    jLabel8.setText("Fear: "+des.getFearDegree());
    jLabel9.setText("Information: "+des.getInformationDegree());
    jLabel10.setText("Family Id: "+thisFamily.getFamilyID());


//////////////////////////////////////////////////////////////////////////////////////////

    jLabel11.setText("Fear Degree : "+thisFamily.getFamilyFearDegree());
    jLabel12.setText("Information Degree : "+thisFamily.getFamilyInformationDegree());

    Chromosoma chr=new Chromosoma();
    int gene=des.getBitGene();
    if(chr.mutationGene(gene)==0){
      jLabel18.setText("Mutation from: None");
    }else if(chr.mutationGene(gene)==1){
      jLabel18.setText("Mutation from: Father");
    }else if(chr.mutationGene(gene)==2){
      jLabel18.setText("Mutation from: Mother");
    }else if(chr.mutationGene(gene)==3){
      jLabel18.setText("Mutation from: Both");
    }

    if(chr.reprAbilityGene(gene)==1){
      jLabel1.setText("Reproductive: No");
    }else if(des.getName()!=null){
      jLabel1.setText("Reproductive: Yes");
    }else{
      jLabel1.setText("Reproductive: N/A");
    }
    if(chr.phenoGene(gene)==1){
      jLabel6.setText("Phenotype: Slight");
    }else if (chr.phenoGene(gene)==2){
      jLabel6.setText("Phenotype: Obvious");
    }else if (chr.phenoGene(gene)==3){
      jLabel6.setText("Phenotype: Serious");
    }else if(chr.phenoGene(gene)==0&&des.getName()!=null){
      jLabel6.setText("Phenotype: Normal");
    }else{
      jLabel6.setText("Phenotype: N/A");
    }

    jLabel13.setText(" Wealth: "+twoDigits.format((float)chr.wealthGene(gene)/15));
    jLabel14.setText("Acceptance: "+twoDigits.format((float)chr.acceptanceGene(gene)/15));
    jLabel15.setText("Infuence ability: "+twoDigits.format((float)chr.influenceGene(gene)/15));
    jLabel16.setText("Fear: "+twoDigits.format((float)chr.wealthGene(gene)/31));
    jLabel17.setText("Vision: "+twoDigits.format((float)chr.wealthGene(gene)/31));


    this.repaint();
  }


  /**
   * MOUSE CLICKED
   * @param e
   */
  void drawFamilyPanel_mousePressed(MouseEvent e) {
    int x=(int)(100*(double)e.getX()/(double)(familyGridSize *
                      drawFamilyPanel.CELL_SIZE)/(100.0/(double)familyGridSize));
    int y=(int)(100*(double)e.getY()/(double)(familyGridSize *
                      drawFamilyPanel.CELL_SIZE)/(100.0/(double)familyGridSize));
    Families thisFamily=(Families)this.drawFamilyPanel.getThisFamily();
    Description des=new Description();

    if(x==0&&y==0){//father
      des=thisFamily.getFather();
      if(des.getFromFamilyID()>1){
        thisFamily = (Families) SuperAgent.allFamiliesList.get(des.
            getFromFamilyID() - 1);
        DrawPanelFrame.family2View = thisFamily;
        des = thisFamily.getFather();
      }

    }else if(x==2&&y==0){
      des=thisFamily.getMother();
      if(des.getFromFamilyID()>1){
        thisFamily = (Families) SuperAgent.allFamiliesList.get(des.
            getFromFamilyID() - 1);
        DrawPanelFrame.family2View = thisFamily;
        des = thisFamily.getMother();
      }

    }else if(y==2){
      int lastKidPosition=2*thisFamily.getChildren().size();
      if((!(x%2==0))&&x>0&&x<lastKidPosition){
        des=(Description)thisFamily.getChildren().get((x-1)/2);
        for(int i=thisFamily.getFamilyID();i<SuperAgent.allFamiliesList.size();i++){
//          System.out.println(des.getName()+".,"+((Families)SuperAgent.allFamiliesList.get(i)).getFather().getName().toString());
          if(des.getName().equals(((Families)SuperAgent.allFamiliesList.get(i)).getFather().getName().toString())){
            thisFamily=((Families)SuperAgent.allFamiliesList.get(i));
            DrawPanelFrame.family2View=thisFamily;
            des=thisFamily.getFather();
            break;
          }else if(des.getName().equals(((Families)SuperAgent.allFamiliesList.get(i)).getMother().getName().toString())){
            thisFamily=((Families)SuperAgent.allFamiliesList.get(i));
            DrawPanelFrame.family2View=thisFamily;
            des=thisFamily.getMother();
            break;
          }

        }

      }
    }
    jLabel2.setText("Name: "+des.getName());
    jLabel5.setText("Health: "+des.getHealth());
    jLabel7.setText("Sex: "+des.getSex());
    jLabel4.setText("Epochs to live: "+des.getEpochsToLive());
    jLabel3.setText("Epoch of Birth: "+des.getEpochOfBirth());
    jLabel8.setText("Fear: "+des.getFearDegree());
    jLabel9.setText("Information: "+des.getInformationDegree());
    jLabel10.setText("Family Id: "+des.getFromFamilyID());
    jLabel11.setText("Fear Degree : "+thisFamily.getFamilyFearDegree());
    jLabel12.setText("Information Degree : "+thisFamily.getFamilyInformationDegree());

    Chromosoma chr=new Chromosoma();
    int gene=des.getBitGene();
    if(chr.mutationGene(gene)==0){
      jLabel18.setText("Mutation from: None");
    }else if(chr.mutationGene(gene)==1){
      jLabel18.setText("Mutation from: Father");
    }else if(chr.mutationGene(gene)==2){
      jLabel18.setText("Mutation from: Mother");
    }else if(chr.mutationGene(gene)==3){
      jLabel18.setText("Mutation from: Both");
    }



    if(chr.reprAbilityGene(gene)==1){
      jLabel1.setText("Reproductive: No");
    }else{
      jLabel1.setText("Reproductive: Yes");
    }
    if(chr.phenoGene(gene)==1){
      jLabel6.setText("Phenotype: Slight");
    }else if (chr.phenoGene(gene)==2){
      jLabel6.setText("Phenotype: Obvious");
    }else if (chr.phenoGene(gene)==3){
      jLabel6.setText("Phenotype: Serious");
    }else{
      jLabel6.setText("Phenotype: Normal");
    }

    jLabel13.setText("Wealth: "+twoDigits.format((float)chr.wealthGene(gene)/15));
    jLabel14.setText("Acceptance: "+twoDigits.format((float)chr.acceptanceGene(gene)/15));
    jLabel15.setText("Infuence ability: "+twoDigits.format((float)chr.influenceGene(gene)/15));
    jLabel16.setText("Fear: "+twoDigits.format((float)chr.wealthGene(gene)/31));
    jLabel17.setText("Vision: "+twoDigits.format((float)chr.wealthGene(gene)/31));
    this.repaint();
  }

  void this_internalFrameClosing(InternalFrameEvent e) {
    setTextMessage("Resuming Simulation");
    MenuFrame.la.resumeAgents();
    MenuFrame.jButton15.setEnabled(true);
  }

  void this_internalFrameOpened(InternalFrameEvent e) {
    setTextMessage("Simulation Paused,\nClose Genealogical Tree to continue");
    if(flag==false){
      JOptionPane.showMessageDialog(null,"System will pause on\nGeneology Tree display","Information",JOptionPane.INFORMATION_MESSAGE);
      MenuFrame.drawPanelFrame2.family2View=(Families)SuperAgent.allFamiliesList.get(0);
    }
    flag=true;
    MenuFrame.la.pauseAgents();
    MenuFrame.jButton15.setEnabled(false);
  }

  private void setTextMessage(String s){
    MenuFrame.rc.jTextArea1.append(s+"\n");
    MenuFrame.rc.jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
  }

  void this_internalFrameActivated(InternalFrameEvent e) {
    setTextMessage("Simulation Paused,\nClose Genealogical Tree to continue");
    if(flag==false)JOptionPane.showMessageDialog(null,"System will pause on\nGeneology Tree display","Information",JOptionPane.INFORMATION_MESSAGE);
    flag=true;
    MenuFrame.la.pauseAgents();
    MenuFrame.jButton15.setEnabled(false);
  }



  void jButton1_actionPerformed(ActionEvent e) {
    MenuFrame.la.resumeAgents();
    MenuFrame.jButton15.setEnabled(true);
    setTextMessage("Resuming Simulation");
    this.dispose();
  }


  void this_internalFrameDeactivated(InternalFrameEvent e) {
    try {
      this.setIcon(true);
    }
    catch (PropertyVetoException ex) {
    }
  }

}

class DrawFamilyPanelFrame_jSlider1_changeAdapter implements javax.swing.event.ChangeListener {
  DrawFamilyPanelFrame adaptee;

  DrawFamilyPanelFrame_jSlider1_changeAdapter(DrawFamilyPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider1_stateChanged(e);
  }
}

class DrawFamilyPanelFrame_drawFamilyPanel_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  DrawFamilyPanelFrame adaptee;

  DrawFamilyPanelFrame_drawFamilyPanel_mouseMotionAdapter(DrawFamilyPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.drawFamilyPanel_mouseMoved(e);
  }
}

class DrawFamilyPanelFrame_drawFamilyPanel_mouseAdapter extends java.awt.event.MouseAdapter {
  DrawFamilyPanelFrame adaptee;

  DrawFamilyPanelFrame_drawFamilyPanel_mouseAdapter(DrawFamilyPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void mousePressed(MouseEvent e) {
    adaptee.drawFamilyPanel_mousePressed(e);
  }
}

class DrawFamilyPanelFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  DrawFamilyPanelFrame adaptee;

  DrawFamilyPanelFrame_this_internalFrameAdapter(DrawFamilyPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameClosing(InternalFrameEvent e) {
    adaptee.this_internalFrameClosing(e);
  }
  public void internalFrameOpened(InternalFrameEvent e) {
    adaptee.this_internalFrameOpened(e);
  }
  public void internalFrameActivated(InternalFrameEvent e) {
    adaptee.this_internalFrameActivated(e);
  }

  public void internalFrameDeactivated(InternalFrameEvent e) {
    adaptee.this_internalFrameDeactivated(e);
  }
}

class DrawFamilyPanelFrame_jButton1_actionAdapter implements java.awt.event.ActionListener {
  DrawFamilyPanelFrame adaptee;

  DrawFamilyPanelFrame_jButton1_actionAdapter(DrawFamilyPanelFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}







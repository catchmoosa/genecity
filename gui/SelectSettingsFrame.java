
package genecity.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import javax.swing.event.*;
import java.beans.*;
import genecity.Settings;


/**
 * <p>Title: SelectSettingsFrame</p>
 * <p>Description: Internal Frame for Settings</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class SelectSettingsFrame extends JInternalFrame {
    private String menuComboBox1[]={"Autosomatic", "X-Chromosome"};
    private String menuComboBox2[]={"Normal", "Slight", "Obvious", "Serious"};


  JSpinner jSpinner3 = new JSpinner();
  JLabel jLabel14 = new JLabel();
  JComboBox jComboBox2 = new JComboBox(menuComboBox2);
  JLabel jLabel6 = new JLabel();
  JSpinner jSpinner15 = new JSpinner();
  JComboBox jComboBox1 = new JComboBox(menuComboBox1);
  JTextField jTextField1 = new JTextField();
  JSpinner jSpinner4 = new JSpinner();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JSpinner jSpinner13 = new JSpinner();
  XYLayout xYLayout4 = new XYLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JCheckBox jCheckBox3 = new JCheckBox();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JSpinner jSpinner8 = new JSpinner();
  JPanel jPanel2 = new JPanel();
  JSpinner jSpinner1 = new JSpinner();
  JLabel jLabel19 = new JLabel();
  JCheckBox jCheckBox4 = new JCheckBox();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JSpinner jSpinner2 = new JSpinner();
  JSpinner jSpinner7 = new JSpinner();
  JSpinner jSpinner12 = new JSpinner();
  XYLayout xYLayout1 = new XYLayout();
  XYLayout xYLayout2 = new XYLayout();
  JLabel jLabel15 = new JLabel();
  JButton jButton2 = new JButton();
  SpinnerNumberModel agentPopulationSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getagentPopulation(),50,400,1);
  SpinnerNumberModel legalMarriageAgeSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getlegalMarriageAge(),15,21,1);
  SpinnerNumberModel lifeSpanSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getlifeSpan(),68,85,1);
  SpinnerNumberModel ageDifferenceCouplesSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getageDifferenceCouples(),0,7,0.5);
  SpinnerNumberModel fertilityRatioSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getfertilityRatio(),1,3,0.01);
  SpinnerNumberModel marriageOverPopulationSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getmarriageOverPopulation(),20,100,1);
  SpinnerNumberModel beginInformationDegreeSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getBeginInformationDegree(),0,500,1);
  SpinnerNumberModel prebirthControlAbortionSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getPrebirthControlAbortion(),0,1,0.1);
  SpinnerNumberModel agentMateVisionSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getagentMateVision(),0,100,1);
  SpinnerNumberModel realMutationRateSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getrealMutationRate(),0,1,0.001);
  SpinnerNumberModel meanAgeEffectionSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getmeanAgeEffection(),0,50,1);
  SpinnerNumberModel lifeYearsExpectancyDiseaseSpinnerNumberModel = new SpinnerNumberModel(MenuFrame.settings.getlifeYearsExpectancyDisease(),0,60,1);

  JButton jButton1 = new JButton();
  JLabel jLabel10 = new JLabel();
  JCheckBox jCheckBox1 = new JCheckBox();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JSpinner jSpinner9 = new JSpinner();
  JSpinner jSpinner10 = new JSpinner();
  JSlider jSlider1 = new JSlider(1,100,MenuFrame.settings.getreproductionAbilityPerc());
  JLabel jLabel9 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JSlider jSlider2 = new JSlider(0,100,MenuFrame.settings.getDiseaseOverCarriers());
  JSlider jSlider3 = new JSlider(0,100,MenuFrame.settings.getpatientsOverPopulation());
  JLabel jLabel20 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JSlider jSlider4 = new JSlider(50,400,MenuFrame.settings.getagentPopulation());
  JSlider jSlider5 = new JSlider(0,10,(int)(10*MenuFrame.settings.getPrebirthControlAbortion()));
  JSlider jSlider6 = new JSlider(0,500,MenuFrame.settings.getBeginInformationDegree());
  JSlider jSlider7 = new JSlider(100,300,(int)(MenuFrame.settings.getfertilityRatio()*100));
  JSlider jSlider8 = new JSlider(20,100,(int)MenuFrame.settings.getmarriageOverPopulation());


  public SelectSettingsFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }


}
  private void jbInit() throws Exception {
    jLabel14.setText("Years of life expected in disease");
    this.setClosable(true);
    this.setClosed(false);
//    this.setFrameIcon(null);
    this.setIconifiable(true);
    this.setTitle("Settings");
    this.addInternalFrameListener(new SelectSettingsFrame_this_internalFrameAdapter(this));
    this.getContentPane().setLayout(null);
    jLabel6.setText("Description");
    jSpinner15.setEnabled(false);
    jSpinner15.setModel(lifeYearsExpectancyDiseaseSpinnerNumberModel);
    jTextField1.setText("Familial Mediterrenian Fever -FMF");
    jTabbedPane1.setTabPlacement(JTabbedPane.TOP);
    jTabbedPane1.setBackground(SystemColor.inactiveCaptionBorder);
    jTabbedPane1.setEnabled(true);
    jTabbedPane1.setForeground(Color.black);
    jTabbedPane1.setBorder(null);
    jTabbedPane1.setDoubleBuffered(false);
    jTabbedPane1.setMaximumSize(new Dimension(32767, 32767));
    jTabbedPane1.setRequestFocusEnabled(true);
    jTabbedPane1.setBounds(new Rectangle(0, 5, 430, 330));
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setToolTipText("");
    jLabel5.setText("Ideal Age Difference in couples (m/f):");
    jLabel4.setText("Life Span (years):");
    jLabel8.setText("Phenotype");
    jLabel12.setText("% Carriers over Populations");
    jLabel1.setText("Agent Population:");
    jLabel3.setToolTipText("");
    jLabel3.setText("% Marriages over Population:");
    jLabel13.setText("Age of Effection");
    jCheckBox3.setBackground(SystemColor.inactiveCaptionBorder);
    jCheckBox3.setSelected(true);
    jCheckBox3.setText("No affect");
    jCheckBox3.addChangeListener(new SelectSettingsFrame_jCheckBox3_changeAdapter(this));
    jPanel3.setLayout(xYLayout4);
    jPanel3.setBackground(SystemColor.inactiveCaptionBorder);
    jPanel3.setEnabled(true);
    jLabel2.setText("Legal Marriage Age:");
    jPanel2.setBackground(SystemColor.inactiveCaptionBorder);
    jPanel2.setAlignmentX((float) 0.0);
    jPanel2.setAlignmentY((float) 0.0);
    jPanel2.setMaximumSize(new Dimension(32767, 32767));
    jPanel2.setToolTipText("");
    jPanel2.setLayout(xYLayout2);
    jSpinner1.setEnabled(true);
    jSpinner1.setToolTipText("");
    jSpinner1.setModel(agentPopulationSpinnerNumberModel);
    jSpinner1.addChangeListener(new SelectSettingsFrame_jSpinner1_changeAdapter(this));
    jLabel19.setText("Mean number of children in a family:");
    jCheckBox4.setBackground(SystemColor.inactiveCaptionBorder);
    jCheckBox4.setSelected(true);
    jCheckBox4.setText("Yes");
    jCheckBox4.addChangeListener(new SelectSettingsFrame_jCheckBox4_changeAdapter(this));
    jLabel11.setText("Real Mutation Rate");
    jLabel7.setText("Method of transmition");
    jLabel15.setText("Patient Reproduction Ability");
    jButton2.setBounds(new Rectangle(259, 345, 147, 45));
    jButton2.setSelected(false);
    jButton2.setText("Apply & Minimize");
    jButton2.addActionListener(new SelectSettingsFrame_jButton2_actionAdapter(this));
    jSpinner12.setModel(meanAgeEffectionSpinnerNumberModel);
//    jSpinner5.setModel(reproductionAbilityPercSpinnerNumberModel);
    jSpinner13.setModel(realMutationRateSpinnerNumberModel);
    jSpinner3.setModel(legalMarriageAgeSpinnerNumberModel);
    jSpinner2.setModel(lifeSpanSpinnerNumberModel);
    jSpinner4.setModel(ageDifferenceCouplesSpinnerNumberModel);
    jSpinner8.setModel(marriageOverPopulationSpinnerNumberModel);
    jSpinner8.addChangeListener(new SelectSettingsFrame_jSpinner8_changeAdapter(this));
    jSpinner7.setModel(fertilityRatioSpinnerNumberModel);
    jSpinner7.addChangeListener(new SelectSettingsFrame_jSpinner7_changeAdapter(this));
//    jSpinner14.setModel(patientsOverPopulationSpinnerNumberModel);
    jButton1.setBounds(new Rectangle(15, 352, 90, 31));
    jButton1.setText("Previous");
    jButton1.addActionListener(new SelectSettingsFrame_jButton1_actionAdapter(this));
    jLabel10.setText("% Homozygote over Carriers");
//    jSpinner6.setModel(diseasedOverPopulationSpinnerNumberModel);
    jCheckBox1.setBackground(SystemColor.inactiveCaptionBorder);
    jCheckBox1.setText("Dominant");
    jComboBox1.addActionListener(new SelectSettingsFrame_jComboBox1_actionAdapter(this));
    jLabel16.setText("Global Information Degree");
    jLabel17.setText("%Pre-birth control and abortion");
    jSpinner9.setModel(beginInformationDegreeSpinnerNumberModel);
    jSpinner9.addChangeListener(new SelectSettingsFrame_jSpinner9_changeAdapter(this));
    jSpinner10.setModel(prebirthControlAbortionSpinnerNumberModel);
    jSpinner10.addChangeListener(new SelectSettingsFrame_jSpinner10_changeAdapter(this));
    jLabel9.setText(MenuFrame.settings.getreproductionAbilityPerc()+"%");
    jSlider1.addChangeListener(new SelectSettingsFrame_jSlider1_changeAdapter(this));
    jLabel18.setText("years");
    jLabel110.setText("years");
    jLabel20.setText(MenuFrame.settings.getpatientsOverPopulation()+"%");
    jLabel21.setText(MenuFrame.settings.getDiseaseOverCarriers()+"%");
    jSlider3.addChangeListener(new SelectSettingsFrame_jSlider3_changeAdapter(this));
    jSlider2.addChangeListener(new SelectSettingsFrame_jSlider2_changeAdapter(this));
    jLabel22.setText("%");
    jSlider1.setBackground(SystemColor.inactiveCaptionText);
    jSlider2.setBackground(SystemColor.inactiveCaptionText);
    jSlider3.setBackground(SystemColor.inactiveCaptionText);
    jSlider4.addChangeListener(new SelectSettingsFrame_jSlider4_changeAdapter(this));
    jSlider4.setPaintLabels(false);
    jSlider4.setPaintTicks(false);
    jSlider4.setPaintTrack(true);
    jSlider4.setBackground(SystemColor.inactiveCaptionText);
    jSlider6.addChangeListener(new SelectSettingsFrame_jSlider6_changeAdapter(this));
    jSlider5.addChangeListener(new SelectSettingsFrame_jSlider5_changeAdapter(this));
    jSlider8.addChangeListener(new SelectSettingsFrame_jSlider8_changeAdapter(this));
    jSlider7.addChangeListener(new SelectSettingsFrame_jSlider7_changeAdapter(this));
    jSlider6.setBackground(SystemColor.inactiveCaptionText);
    jSlider5.setBackground(SystemColor.inactiveCaptionText);
    jSlider8.setBackground(SystemColor.inactiveCaptionText);
    jSlider7.setBackground(SystemColor.inactiveCaptionText);
    jPanel2.add(jLabel5,  new XYConstraints(22, 185, 234, -1));
    jPanel2.add(jLabel1, new XYConstraints(22, 19, 115, -1));
    jPanel2.add(jLabel2,  new XYConstraints(22, 86, 127, -1));
    jPanel2.add(jLabel4,  new XYConstraints(22, 152, 133, -1));
    jPanel2.add(jLabel3,  new XYConstraints(22, 219, 204, -1));
    jPanel2.add(jLabel19, new XYConstraints(22, 252, 219, -1));
    jPanel2.add(jLabel17,  new XYConstraints(21, 119, 224, -1));
    jPanel2.add(jLabel16, new XYConstraints(19, 51, 219, -1));
    jPanel2.add(jSlider7, new XYConstraints(234, 252, 90, -1));
    jPanel2.add(jSlider8, new XYConstraints(234, 213, 90, 28));
    jPanel2.add(jSlider5, new XYConstraints(234, 115, 90, 25));
    jPanel2.add(jSlider6, new XYConstraints(234, 49, 90, -1));
    jPanel2.add(jSlider4, new XYConstraints(234, 9, 90, 34));
    jPanel2.add(jSpinner1, new XYConstraints(331, 14, 54, 25));
    jPanel2.add(jSpinner9, new XYConstraints(332, 49, 54, -1));
    jPanel2.add(jSpinner3, new XYConstraints(332, 82, 54, 25));
    jPanel2.add(jSpinner10, new XYConstraints(332, 115, 54, -1));
    jPanel2.add(jSpinner2, new XYConstraints(332, 148, 54, 25));
    jPanel2.add(jSpinner4, new XYConstraints(332, 181, 54, 25));
    jPanel2.add(jSpinner8, new XYConstraints(332, 215, 54, -1));
    jPanel2.add(jSpinner7, new XYConstraints(332, 247, 54, -1));
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton1, null);
    jTabbedPane1.add(jPanel3, "Medical - Biological");
    jPanel3.add(jLabel6, new XYConstraints(19, 10, 71, -1));
    jPanel3.add(jTextField1,   new XYConstraints(110, 7, 248, -1));
    jPanel3.add(jLabel7,    new XYConstraints(19, 105, 134, -1));
    jPanel3.add(jLabel11,     new XYConstraints(19, 42, 152, -1));
    jPanel3.add(jLabel8,    new XYConstraints(19, 73, 66, -1));
    jPanel3.add(jLabel12,       new XYConstraints(19, 136, 237, -1));
    jPanel3.add(jComboBox2,       new XYConstraints(248, 68, 110, 24));
    jPanel3.add(jSpinner13,     new XYConstraints(266, 37, 92, -1));
    jPanel3.add(jLabel13,   new XYConstraints(19, 199, 89, -1));
    jPanel3.add(jSpinner12,     new XYConstraints(304, 194, 54, -1));
    jPanel3.add(jSpinner15,    new XYConstraints(304, 226, 54, -1));
    jPanel3.add(jCheckBox3,  new XYConstraints(219, 227, -1, -1));
    jPanel3.add(jLabel14,   new XYConstraints(19, 231, 199, -1));
    jPanel3.add(jLabel15,   new XYConstraints(19, 262, 191, -1));
    jPanel3.add(jCheckBox4,   new XYConstraints(219, 258, 52, -1));
    jPanel3.add(jLabel10,      new XYConstraints(19, 168, 227, -1));
    jPanel3.add(jComboBox1, new XYConstraints(164, 100, 110, 24));
    jPanel3.add(jCheckBox1,   new XYConstraints(289, 100, -1, -1));
    jPanel3.add(jSlider1,            new XYConstraints(268, 256, 90, 27));
    jPanel3.add(jSlider2,         new XYConstraints(268, 164, 90, 27));
    jPanel3.add(jSlider3,          new XYConstraints(268, 128, 90, 31));
    jPanel3.add(jLabel20,   new XYConstraints(366, 136, 34, -1));
    jPanel3.add(jLabel9,  new XYConstraints(366, 262, 33, -1));
    jPanel3.add(jLabel18,  new XYConstraints(366, 231, -1, -1));
    jPanel3.add(jLabel110,  new XYConstraints(366, 199, -1, -1));
    jPanel3.add(jLabel21,   new XYConstraints(366, 170, 39, -1));
    jPanel3.add(jLabel22,  new XYConstraints(366, 42, 31, -1));
    jTabbedPane1.add(jPanel2,  "Demographical - Sociological");
    this.getContentPane().add(jTabbedPane1, null);
//    jTabbedPane1.setSelectedComponent(jPanel2);
  }

  public void  setFileOpenData(){
    beginInformationDegreeSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getBeginInformationDegree()));
        prebirthControlAbortionSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getPrebirthControlAbortion()));
        agentMateVisionSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getagentMateVision()));
        fertilityRatioSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getfertilityRatio()));
        marriageOverPopulationSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getmarriageOverPopulation()));
        ageDifferenceCouplesSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getageDifferenceCouples()));
        lifeSpanSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlifeSpan()));
        legalMarriageAgeSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlegalMarriageAge()));
        agentPopulationSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getagentPopulation()));
        jTextField1.setText(MenuFrame.settings.getDiseaseName());
        realMutationRateSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getrealMutationRate()));
        jComboBox2.setSelectedIndex(MenuFrame.settings.getCondition());
        jComboBox1.setSelectedIndex(MenuFrame.settings.getMethodTransmittion());
        jSlider3.setValue( MenuFrame.settings.getpatientsOverPopulation());
        meanAgeEffectionSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getmeanAgeEffection()));
        lifeYearsExpectancyDiseaseSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlifeYearsExpectancyDisease()));
//        reproductionAbilityPercSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getreproductionAbilityPerc()));
        jSlider1.setValue(MenuFrame.settings.getreproductionAbilityPerc());
        jCheckBox3.setSelected(MenuFrame.settings.getAffectDth());
        jCheckBox4.setSelected(MenuFrame.settings.getAffectReproduction());
        jSlider2.setValue((MenuFrame.settings.getDiseaseOverCarriers()));
        jCheckBox1.setSelected(MenuFrame.settings.getDominantAutosomatic());
  }


  void jCheckBox3_stateChanged(ChangeEvent e) {
if (jCheckBox3.isSelected()){
      jSpinner15.setEnabled(false);
    }
    else{
      jSpinner15.setEnabled(true);
    }
  }

  void jCheckBox4_stateChanged(ChangeEvent e) {
    if (jCheckBox4.isSelected()){
          jSlider1.setEnabled(true);
          jLabel9.setEnabled(true);
        }
        else{
          jSlider1.setEnabled(false);
          jLabel9.setEnabled(false);
        }

  }

  public void jButton2_actionPerformed(ActionEvent e) {
//set values in settings
    MenuFrame.settings.setDiseaseName(jTextField1.getText());
    MenuFrame.settings.setAffectReproduction(jCheckBox4.isSelected());
    MenuFrame.settings.setageDifferenceCouples((ageDifferenceCouplesSpinnerNumberModel.getNumber().floatValue()));
    MenuFrame.settings.setagentMateVision(agentMateVisionSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setagentPopulation(agentPopulationSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setAffectDth(jCheckBox3.isSelected());
    MenuFrame.settings.setBeginInformationDegree(beginInformationDegreeSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setCondition(jComboBox2.getSelectedIndex());
    MenuFrame.settings.setfertilityRatio(fertilityRatioSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setlegalMarriageAge(legalMarriageAgeSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setlifeSpan( lifeSpanSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setlifeYearsExpectancyDisease(lifeYearsExpectancyDiseaseSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setmarriageOverPopulation(marriageOverPopulationSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setmeanAgeEffection(meanAgeEffectionSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setMethodTransmittion(jComboBox1.getSelectedIndex());
    MenuFrame.settings.setpatientsOverPopulation(jSlider3.getValue());
    MenuFrame.settings.setPrebirthControlAbortion(prebirthControlAbortionSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setrealMutationRate(realMutationRateSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setreproductionAbilityPerc(jSlider1.getValue());
    MenuFrame.settings.setDiseaseOverCarriers(jSlider2.getValue());
    MenuFrame.settings.setDominantAutosomatic(jCheckBox1.isSelected());
    MenuFrame.rc.renew();
//    JOptionPane.showMessageDialog(null,"Settings saved\nFrame will minimize", "Save", JOptionPane.INFORMATION_MESSAGE);
    try {
      this.setIcon(true);
    }
    catch (PropertyVetoException ex) {
    }
//    this.setVisible(false);
  }


  void jButton1_actionPerformed(ActionEvent e) {
    beginInformationDegreeSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getBeginInformationDegree()));
    prebirthControlAbortionSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getPrebirthControlAbortion()));
    agentMateVisionSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getagentMateVision()));
    fertilityRatioSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getfertilityRatio()));
    marriageOverPopulationSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getmarriageOverPopulation()));
    ageDifferenceCouplesSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getageDifferenceCouples()));
    lifeSpanSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlifeSpan()));
    legalMarriageAgeSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlegalMarriageAge()));
    agentPopulationSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getagentPopulation()));
    jTextField1.setText(MenuFrame.settings.getDiseaseName());
    realMutationRateSpinnerNumberModel.setValue(new Float(MenuFrame.settings.getrealMutationRate()));
    jComboBox2.setSelectedIndex(MenuFrame.settings.getCondition());
    jComboBox1.setSelectedIndex(MenuFrame.settings.getMethodTransmittion());
    jSlider3.setValue(MenuFrame.settings.getpatientsOverPopulation());
    meanAgeEffectionSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getmeanAgeEffection()));
    lifeYearsExpectancyDiseaseSpinnerNumberModel.setValue(new Integer(MenuFrame.settings.getlifeYearsExpectancyDisease()));
    jSlider1.setValue((MenuFrame.settings.getreproductionAbilityPerc()));
    jCheckBox1.setSelected(MenuFrame.settings.getDominantAutosomatic());
    jCheckBox3.setSelected(MenuFrame.settings.getAffectDth());
    jCheckBox4.setSelected(MenuFrame.settings.getAffectReproduction());
    jSlider2.setValue((MenuFrame.settings.getDiseaseOverCarriers()));
  }

  void jComboBox1_actionPerformed(ActionEvent e) {
    if (jComboBox1.getSelectedIndex()==1){
      jCheckBox1.setEnabled(false);
      jLabel12.setText("% Female Carriers over Population");
      jLabel10.setText("% Males Diseased over Population");
    }else{
      jCheckBox1.setEnabled(true);
      jLabel12.setText("% Carriers over Populations");
      jLabel10.setText("% Homozygote over Carriers");
    }
  }

  void this_internalFrameClosing(InternalFrameEvent e) {
    MenuFrame.settings.setDiseaseName(jTextField1.getText());
    MenuFrame.settings.setAffectReproduction(jCheckBox4.isSelected());
    MenuFrame.settings.setageDifferenceCouples((ageDifferenceCouplesSpinnerNumberModel.getNumber().floatValue()));
    MenuFrame.settings.setagentMateVision(agentMateVisionSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setagentPopulation(agentPopulationSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setAffectDth(jCheckBox3.isSelected());
    MenuFrame.settings.setBeginInformationDegree(beginInformationDegreeSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setCondition(jComboBox2.getSelectedIndex());
    MenuFrame.settings.setfertilityRatio(fertilityRatioSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setlegalMarriageAge(legalMarriageAgeSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setlifeSpan( lifeSpanSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setlifeYearsExpectancyDisease(lifeYearsExpectancyDiseaseSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setmarriageOverPopulation(marriageOverPopulationSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setmeanAgeEffection(meanAgeEffectionSpinnerNumberModel.getNumber().intValue());
    MenuFrame.settings.setMethodTransmittion(jComboBox1.getSelectedIndex());
    MenuFrame.settings.setpatientsOverPopulation(jSlider3.getValue());
    MenuFrame.settings.setPrebirthControlAbortion(prebirthControlAbortionSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setrealMutationRate(realMutationRateSpinnerNumberModel.getNumber().floatValue());
    MenuFrame.settings.setreproductionAbilityPerc(jSlider1.getValue());
    MenuFrame.settings.setDiseaseOverCarriers(jSlider2.getValue());
    MenuFrame.settings.setDominantAutosomatic(jCheckBox1.isSelected());
    MenuFrame.rc.renew();
    JOptionPane.showMessageDialog(null,"Settings saved", "Save", JOptionPane.INFORMATION_MESSAGE);
  }

  void jSlider1_stateChanged(ChangeEvent e) {
    jLabel9.setText(jSlider1.getValue()+"%");
  }

  void jSlider3_stateChanged(ChangeEvent e) {
    jLabel20.setText(jSlider3.getValue()+"%");
  }

  void jSlider2_stateChanged(ChangeEvent e) {
    jLabel21.setText(jSlider2.getValue()+"%");
  }

  void jSpinner1_stateChanged(ChangeEvent e) {
    jSlider4.setValue(agentPopulationSpinnerNumberModel.getNumber().intValue());
  }

  void jSlider4_stateChanged(ChangeEvent e) {
    agentPopulationSpinnerNumberModel.setValue(new Integer(jSlider4.getValue()));
  }

  void jSpinner9_stateChanged(ChangeEvent e) {
    jSlider6.setValue(beginInformationDegreeSpinnerNumberModel.getNumber().intValue());
  }

  void jSlider6_stateChanged(ChangeEvent e) {
    beginInformationDegreeSpinnerNumberModel.setValue(new Integer(jSlider6.getValue()));
  }

  void jSpinner10_stateChanged(ChangeEvent e) {
    jSlider5.setValue((int)(prebirthControlAbortionSpinnerNumberModel.getNumber().floatValue()*10));
  }

  void jSlider5_stateChanged(ChangeEvent e) {
    prebirthControlAbortionSpinnerNumberModel.setValue(new Float((float)jSlider5.getValue()/10));
  }

  void jSpinner8_stateChanged(ChangeEvent e) {
    jSlider8.setValue(marriageOverPopulationSpinnerNumberModel.getNumber().intValue());
  }

  void jSlider8_stateChanged(ChangeEvent e) {
    marriageOverPopulationSpinnerNumberModel.setValue(new Integer(jSlider8.getValue()));
  }

  void jSpinner7_stateChanged(ChangeEvent e) {
    jSlider7.setValue((int)(100*fertilityRatioSpinnerNumberModel.getNumber().floatValue()));
  }

  void jSlider7_stateChanged(ChangeEvent e) {
    fertilityRatioSpinnerNumberModel.setValue(new Float(((float)(jSlider7.getValue()))/100));
  }
}

class SelectSettingsFrame_jCheckBox3_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jCheckBox3_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBox3_stateChanged(e);
  }
}

class SelectSettingsFrame_jCheckBox4_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jCheckBox4_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jCheckBox4_stateChanged(e);
  }
}

class SelectSettingsFrame_jButton2_actionAdapter implements java.awt.event.ActionListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jButton2_actionAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class SelectSettingsFrame_jButton1_actionAdapter implements java.awt.event.ActionListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jButton1_actionAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class SelectSettingsFrame_jComboBox1_actionAdapter implements java.awt.event.ActionListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jComboBox1_actionAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jComboBox1_actionPerformed(e);
  }
}

class SelectSettingsFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_this_internalFrameAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameClosing(InternalFrameEvent e) {
    adaptee.this_internalFrameClosing(e);
  }
}

class SelectSettingsFrame_jSlider1_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider1_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider1_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider3_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider3_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider3_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider2_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider2_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider2_stateChanged(e);
  }
}

class SelectSettingsFrame_jSpinner1_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSpinner1_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner1_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider4_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider4_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider4_stateChanged(e);
  }
}

class SelectSettingsFrame_jSpinner9_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSpinner9_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner9_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider6_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider6_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider6_stateChanged(e);
  }
}

class SelectSettingsFrame_jSpinner10_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSpinner10_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner10_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider5_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider5_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider5_stateChanged(e);
  }
}

class SelectSettingsFrame_jSpinner8_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSpinner8_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner8_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider8_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider8_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider8_stateChanged(e);
  }
}

class SelectSettingsFrame_jSpinner7_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSpinner7_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSpinner7_stateChanged(e);
  }
}

class SelectSettingsFrame_jSlider7_changeAdapter implements javax.swing.event.ChangeListener {
  SelectSettingsFrame adaptee;

  SelectSettingsFrame_jSlider7_changeAdapter(SelectSettingsFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jSlider7_stateChanged(e);
  }
}
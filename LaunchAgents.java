package genecity;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;
import jade.core.behaviours.OneShotBehaviour;

//import ecosystem.geneticalgorithm.Rules;
import java.awt.Point;
import java.util.ArrayList;
import java.beans.*;
import genecity.gui.MenuFrame;
import javax.swing.JOptionPane;

/**
 * <p>Title: LaunchAgents</p>
 * <p>Description: Initiate - Pause - Resume - Kille SuperAgent </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class LaunchAgents {

  public static int agentsPopulation = 0;
  public static int N = 1;
// Get a hold on JADE runtime
  static Runtime rt = Runtime.instance();
// create a default Profile
  static Profile pMain = new ProfileImpl();
//  MainFrame.jTextAreaMessages.append("Launching a whole in-process platform..."+pMain+"\n");
// Create a new main container
  static MainContainer mc = rt.createMainContainer(pMain);
// set now the default Profile to start a container
  static ProfileImpl pContainer;
//  static ProfileImpl pContainer2;// MainFrame.jTextAreaMessages.append("Launching the agent container ..."+pContainer+"\n");
// Create a new non-main container, connecting to the default
// main container (i.e. on this host, port 1099)
  static AgentContainer acSingle;
//  static AgentContainer acFamily; // 2o CONTAINER

  private AgentController rma;
  private static AgentController superAgent=null;


  public void launchPlatform() {
    try{
      // Launch a complete platform
      Object args[] = new Object[1];
      args[0]="-gui";
      //MainFrame.jTextAreaMessages.append("Launching the rma agent on the main container ...\n");
      rma = mc.createNewAgent("rma", "jade.tools.rma.rma", args);
      // Fire up the agent
      rma.start();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  public void launchSuperAgent(){
    pContainer = new ProfileImpl();
//    pContainer2 = new ProfileImpl();

    acSingle = rt.createAgentContainer(pContainer);
//    acFamily = rt.createAgentContainer(pContainer2);
    Object args[] = new Object[1];
    args[0] =null;
    try {
      superAgent = mc.createNewAgent("SuperAgent",
                                     genecity.SuperAgent.class.getName(),
                                     args);
      try {
        superAgent.start();
      }
      catch (ControllerException ex1) {
      }
    }
    catch (StaleProxyException ex) {
    }
  }




  public void killAllAgents(){
    int errors=0;
    SuperAgent.agentTableData.clear();
    SuperAgent.metricsList.clear();
    Object[][] blank={{"","","","","","","",""}};
    MenuFrame.at.newTable(blank);
    MenuFrame.grid.clearArea();
    SuperAgent.totalAgentPopulation=MenuFrame.settings.getPopulation();
    SuperAgent.enabledAgentsList.clear();
    SuperAgent.allFamiliesList.clear();

      try {
        superAgent.kill();
      }
      catch (ControllerException ex1) {
        errors++;
      }
      try {
        acSingle.kill();
      }
      catch (StaleProxyException ex2) {
        errors++;
        JOptionPane.showMessageDialog(null,"An unexpected JADE(tm) error occured\nRestart platform to continue","Error message",javax.swing.JOptionPane.ERROR_MESSAGE);
      }


      SuperAgent.agentTableData.clear();
    MenuFrame.rc.jProgressBar1.setValue(100);
    MenuFrame.rc.jProgressBar1.setString("100% agents deleted");
    setTextMessage("Agents deleted with "+errors+" errors");
    setTextMessage("------------------------------------");
  }



  public void pauseAgents(){
    try {
      superAgent.suspend();
    }
    catch (ControllerException ex) {
    }

  }

  public void resumeAgents(){
    try {
      superAgent.activate();
    }
    catch (ControllerException ex) {
    }
  }

  private void setTextMessage(String s){
    MenuFrame.rc.jTextArea1.append(s+"\n");
    MenuFrame.rc.jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
  }

}






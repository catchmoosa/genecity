package genecity;
import jade.gui.*;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import java.io.File;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import jade.core.behaviours.OneShotBehaviour;
import jade.content.ContentManager;
import genecity.agentCommunication.*;
import genecity.gui.MenuFrame;
import jade.util.leap.List;
/**
 * <p>Title: MediaAgent</p>
 * <p>Description: Simulate Media Information </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class MediaAgent  {

  public MediaAgent() {//ta xronia tha ta pairnei apo ta dedomena eisagwgis
  }

  public Description mediaInform(Description p){
    String pName=p.getName();
    for(int i=0;i<SuperAgent.gridAgents.size();i++){
      if(((Description)SuperAgent.gridAgents.get(i)).getName().equals(p.getName())){
        p.setFearDegree(((Description)SuperAgent.gridAgents.get(i)).getFearDegree());
        p.setInformationDegree(((Description)SuperAgent.gridAgents.get(i)).getInformationDegree());
      }
    }
    return p;
  }

  //starting of agents
  public Description mediaInform(Description p, int i){
    if(i==0){
      p.setInformationDegree(MenuFrame.settings.getBeginInformationDegree());
    }
    return p;
  }






}
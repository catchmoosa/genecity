package genecity;

import java.awt.Point;
import javax.swing.JScrollPane;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Random;
import java.text.DecimalFormat;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.content.*;
import jade.content.lang.sl.SLCodec;
import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.util.leap.ArrayList;
import jade.proto.*;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPANames;
import genecity.gui.MenuFrame;
import genecity.gui.DrawPanelFrame;
import genecity.agentCommunication.*;
import genecity.geneticAlgorithm.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.wrapper.*;
import jade.core.IMTPException;
import jade.util.leap.*;
import jade.content.lang.Codec.*;
import jade.content.onto.OntologyException;
import genecity.methods.*;


/**
 * <p>Title: MatchAgent</p>
 * <p>Description: Calculate Matching Couples </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class MatchAgent extends Agent {

  private double MARRIAGE_PROB=1; // auto einai gia tin grammi 365
  public static int counterFinalMarriages=0;

  private ContentManager m1 = (ContentManager) getContentManager();
  private Codec codec = new SLCodec();
//  private Ontology ontology = PersonOntology.getInstance();
  private Ontology ontology = SimulationOntology.getInstance();
  private List matesList=new ArrayList();
  private List sexList=new ArrayList();
  private List maleList=new ArrayList();
  private List femaleList=new ArrayList();
  private List malexList=new ArrayList();
  private List maleyList=new ArrayList();
  private List femalexList=new ArrayList();
  private List femaleyList=new ArrayList();
  private List maleBitGeneList=new ArrayList();
  private List femaleBitGeneList=new ArrayList();
  private List maleAgeList=new ArrayList();
  private List femaleAgeList=new ArrayList();
  private int matchCounter1=0;
  private int matchCounter2=0;
 // private Person p2=new Person();
//  private Persons p2=new Persons();
  private int progressBarValue;


  private  Vector maleVector=new Vector();
  private  Vector femaleVector=new Vector();
  private Vector temp=new Vector();
  public static Vector vectorOfPersons=new Vector();

  private Preferences malePreferences=new Preferences();
  private Preferences femalePreferences=new Preferences();
  public static int marriagesNumber;




  protected void setup() {

    m1.registerLanguage(codec);
    m1.registerOntology(ontology);

    Behaviour simpleBehaviour=new LoadingBehaviour(this);
    addBehaviour(simpleBehaviour);
  }


  class LoadingBehaviour
      extends CyclicBehaviour {
    public LoadingBehaviour(Agent agent) {
      super(agent);
    }
    public void action(){
      MessageTemplate mt=MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),MessageTemplate.MatchOntology(ontology.getName()));
      ACLMessage msg = blockingReceive(mt);
      try{
        ContentElement ce=null;
        if(msg.getPerformative()==ACLMessage.INFORM){
            ce=getContentManager().extractContent(msg);
          if (ce  instanceof Human){
            Description p1=((Human) ce).getCharacteristics();
            matesList.add(p1.getName());
            sexList.add(p1.getSex());
            if (p1.getSex().equals("Male")){
              femalePreferences.addPreferences(p1);
              maleList.add(p1.getName()); //lista me onomata andres!!!
            }else{
              malePreferences.addPreferences(p1);
              femaleList.add(p1.getName()); //lista me onomata gynaikes!!!
            }
            matchCounter1++;
            progressBarValue = (int) (100.0 * ( (float) matchCounter1) / ( (float) SuperAgent.enabledAgentsList.size()));
            setProgressBar(progressBarValue, "% receiving details");

            if (matchCounter1==SuperAgent.enabledAgentsList.size()){
              //to zeromize so jade do not produce errors
              femalePreferences.setWillForMarriage(0);
              malePreferences.setWillForMarriage(0);
              for(int i=0;i<matchCounter1;i++){
                ACLMessage respondmsg=new ACLMessage(ACLMessage.INFORM_IF);
                respondmsg.setLanguage(codec.getName());
                respondmsg.setOntology(ontology.getName());
                respondmsg.addReceiver(new AID(matesList.get(i).toString(), AID.ISLOCALNAME));
                if((sexList.get(i).toString()).startsWith("Male")){
                  try{
                    m1.fillContent(respondmsg, malePreferences);
                  }catch(Exception ex){
                    ex.printStackTrace();
                  }
                }else{
                  try{
                    m1.fillContent(respondmsg, femalePreferences);
                  }catch(Exception ex){
                    ex.printStackTrace();
                  }
                }
                //sends the lists for the men and the women
                send(respondmsg);
              }//end FOR
              //to zeromize the vector! unless an exception occurs!
              femaleVector.removeAllElements();
              maleVector.removeAllElements();
              for(int i=0;i<femaleList.size();i++){
                femaleVector.add(new Integer(-1));
              }
              for(int i=0;i<maleList.size();i++){
                maleVector.add(new Integer(-1));
              }
              matchCounter1=0;
            }
          }




        }else if(msg.getPerformative()==ACLMessage.INFORM_IF){
          ce=getContentManager().extractContent(msg);

          if (ce  instanceof Preferences){

            Preferences pref1 = (Preferences) ce;
            matchCounter2++;
            if(SuperAgent.enabledAgentsList.size()==0){
              progressBarValue=0;
            }else{
              progressBarValue = (int) (100.0 * ( (float) matchCounter2) /
                                        ( (float) SuperAgent.enabledAgentsList.
                                         size()));
            }
            setProgressBar(progressBarValue, "% preferencing");

            vectorOfPersons.add(pref1);

            if (matchCounter2 == SuperAgent.enabledAgentsList.size()) {

              for (int i=0;i<vectorOfPersons.size();i++){
                temp.removeAllElements();

                if(((Preferences)vectorOfPersons.get(i)).getWhois().getSex().startsWith("Female")){
                  for(int j=0;j<femaleList.size();j++){
                    if(femaleList.get(j).equals(((Preferences)vectorOfPersons.get(i)).getWhois().getName())){
                      femaleVector.set(j,((Preferences)vectorOfPersons.get(i)).getPreferencesNames());
                      break;
                    }
                  }
                }else{ //an einai male
                  for(int j=0;j<maleList.size();j++){
                    if(maleList.get(j).equals(((Preferences)vectorOfPersons.get(i)).getWhois().getName())){
                      maleVector.set(j,((Preferences)vectorOfPersons.get(i)).getPreferencesNames());
                      break;
                    }
                  }
                }
              }//for

              for(int i=0;i<maleVector.size();i++){
                List a=(List)(maleVector.get(i));
                Vector b=new Vector();
                for(int j=0;j<a.size();j++){
                  b.add(a.get(j).toString());
                }
                maleVector.set(i,b);
              }
              for(int i=0;i<femaleVector.size();i++){
                List a=(List)(femaleVector.get(i));
                Vector b=new Vector();
                for(int j=0;j<a.size();j++){
                  b.add(a.get(j).toString());
                }
                femaleVector.set(i,b);
              }

              for(int i=0;i<maleVector.size();i++){
                Vector a=(Vector)(maleVector.get(i));
                for(int j=0;j<a.size();j++){
                  for(int k=0;k<femaleList.size();k++){
                    if(femaleList.get(k).toString().equals(a.get(j).toString())){
                      a.set(j,new Integer(k));
                      maleVector.set(i,a);
                      break;
                    }
                  }
                }
              }

              for(int i=0;i<femaleVector.size();i++){
                Vector a=(Vector)(femaleVector.get(i));
                for(int j=0;j<a.size();j++){
                  for(int k=0;k<maleList.size();k++){
                    if(maleList.get(k).toString().equals(a.get(j).toString())){
                      a.set(j,new Integer(k));
                      femaleVector.set(i,a);
                      break;
                    }
                  }
                }
              }


              //ektelesh tou SMP
              ExperimentMarriage em=new ExperimentMarriage(maleVector,femaleVector);
              maleVector.removeAllElements();
              femaleVector.removeAllElements();


              //to vector einai oi gynaikes synartisi twn andrwn [w1[m1] w2[m2]...]
              Vector finalSelection=new Vector();

              double marriageOverPop=(float) (MenuFrame.settings.getmarriageOverPopulation() / 100);
              marriagesNumber=(int)(SuperAgent.currentGridPopulation*marriageOverPop);


              if(em.PAIRS>=1&&marriagesNumber==0){
                if(Math.random()<=MARRIAGE_PROB){
                  marriagesNumber = 1;
                }
              }
              if(marriagesNumber>em.returnMatingVector().size()){
                marriagesNumber=em.returnMatingVector().size();
              }

              //if not any more agents
              if (marriagesNumber==0){
                setTextMessage("No marriages in this sezon");
                ACLMessage mateInfo = new ACLMessage(ACLMessage.INFORM);
                mateInfo.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME)); //10-06-2004
                mateInfo.setOntology(ontology.getName());
                mateInfo.setContent(SuperAgent.REMOVEOLDADDNEW);
                mateInfo.setLanguage(codec.getName());
                send(mateInfo);

                //CLEAR AREA!!!
                matchCounter2=0;
                maleList.clear();
                femaleList.clear();
                sexList.clear();
                matesList.clear();
                malexList.clear();
                maleyList.clear();
                femalexList.clear();
                femaleyList.clear();
                maleBitGeneList.clear();
                femaleBitGeneList.clear();
                maleAgeList.clear();
                femaleAgeList.clear();
                femalePreferences.clearAllPreferences();
                malePreferences.clearAllPreferences();


              }else{

                for (int i = 0; i < marriagesNumber; i++) {
                  // na epistrefei [[w m], [w m]...]
                  Vector a = new Vector();
                  int x;
                  boolean exit = false;
                  do {
                    x = (int) (Math.random() * em.returnMatingVector().size());
                    if (i == 0)
                      exit = true;
                    for (int j = 0; j < finalSelection.size(); j++) {
                      if (x ==Integer.parseInt( ( (Vector) finalSelection.get(j)).
                                           firstElement().toString())) {
                        break;
                      }
                      else if (j == (finalSelection.size() - 1)) {
                        exit = true;
                      }
                    }
                  }
                  while (exit == false);

                  a.add(new Integer(x));
                  a.add(em.returnMatingVector().get(x));
                  finalSelection.add(a);
                }



                //[[1 2] [4 5] [2 3]... [w m]...
                //metatropi se onomata!
                for (int i = 0; i < finalSelection.size(); i++) {
                  Vector a = new Vector();
                  int tempWoman = Integer.parseInt( ( (Vector) finalSelection.
                      get(i)).firstElement().toString());
                  ( (Vector) finalSelection.get(i)).set(0,(((Description)malePreferences.getPreferences().get(tempWoman)).getName()));
                }
                for (int i = 0; i < finalSelection.size(); i++) {
                  Vector a = new Vector();
                  int tempMan = Integer.parseInt( ( (Vector) finalSelection.get(
                      i)).get(1).toString());
                  ( (Vector) finalSelection.get(i)).set(1,(((Description)femalePreferences.getPreferences().get(tempMan)).getName()));
                }

                maleList.clear();
                femaleList.clear();
                sexList.clear();
                matesList.clear();
                femalePreferences.clearAllPreferences();
                malePreferences.clearAllPreferences();

                Vector mateOKv = new Vector();

                for (int i = 0; i < finalSelection.size(); i++) {
                  float mateOK = 0;
                  Vector a = new Vector();
                  a = (Vector) finalSelection.get(i);
                  for (int j = 0; j < vectorOfPersons.size(); j++) {
                    String name = ( (Preferences) vectorOfPersons.get(j)).
                        getWhois().getName();
                    if ( (name.equals(a.firstElement()) ||
                          name.equals(a.get(1).toString()))) {
                      mateOK = mateOK +
                          ( (Preferences) vectorOfPersons.get(i)).getWillForMarriage();
                    }
                  }
                  mateOKv.add(new Float(mateOK));
                }
                counterFinalMarriages=0;
                for (int i = 0; i < finalSelection.size(); i++) {
                  float mateOK=Float.parseFloat(mateOKv.get(i).toString());
                  if (mateOK >= 1) {
                    counterFinalMarriages++;
                  }
                }
                //an den yparxei kaneis pou na thelei na pantreftei
                if(counterFinalMarriages==0){
                  setTextMessage("No agents to activate-3");
                  ACLMessage selfLoop = new ACLMessage(ACLMessage.INFORM);
                  selfLoop.setLanguage(codec.getName());
                  selfLoop.setOntology(ontology.getName());
                  selfLoop.setContent(SuperAgent.REMOVEOLDADDNEW);
                  selfLoop.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                  send(selfLoop);
                }else{
                  for (int i = 0; i < finalSelection.size(); i++) {
                    float mateOK = Float.parseFloat(mateOKv.get(i).toString());
                    if (mateOK >= 1) {
                      Vector a = new Vector();
                      a = (Vector) finalSelection.get(i);
                      Families family = new Families();
                      ACLMessage mateInfo = new ACLMessage(ACLMessage.PROPOSE);
                      mateInfo.setContent(a.firstElement().toString());
                      mateInfo.addReceiver(new AID(a.get(1).toString(),
                          AID.ISLOCALNAME));
                      mateInfo.setLanguage(codec.getName());
                      mateInfo.setOntology(ontology.getName());
                      send(mateInfo);
                    }
                  }
                }

                matchCounter2 = 0;
                vectorOfPersons.removeAllElements();
                mateOKv.removeAllElements();
              }
            }//if exoun ginei ola ==
          }//if ce




        }
        else{
          this.block();
        }
      }catch(CodecException ce){
        ce.printStackTrace();
      }catch(OntologyException oe){
        oe.printStackTrace();
      }
    }//end void action
  }//end cyclic beh



      /**
       * PROGRESS BAR
       */
      private void setProgressBar(int barValue, String s ){
        MenuFrame.rc.jProgressBar1.setValue(barValue);
        MenuFrame.rc.jProgressBar1.setString(barValue+s);
      }

      private void setTextMessage(String s){
        MenuFrame.rc.jTextArea1.append(s+"\n");
        MenuFrame.rc.jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
      }

    }

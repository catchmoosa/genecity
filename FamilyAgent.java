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
import genecity.agentCommunication.*;
import javax.swing.JOptionPane;
import genecity.genetics.*;
import genecity.gui.AgentTable;


/**
 * <p>Title: FamilyAgent</p>
 * <p>Description: Create and Allocate Families </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class FamilyAgent
    extends Agent {

  private ContentManager manager = (ContentManager) getContentManager();
  private Codec codec = new SLCodec();
  private Ontology ontology = SimulationOntology.getInstance();
//  private Persons person1=new Persons();
  private Human person1=new Human();
  private static int marriageIdNumber;
  private int counter=0;
  private List familiesList=new ArrayList();

  protected void setup() {

    manager.registerLanguage(codec);
    manager.registerOntology(ontology);
    marriageIdNumber=0;
    Behaviour simpleBehaviour=new LoadingBehaviour(this);
    addBehaviour(simpleBehaviour);
  }

  /**
   * Set starting position for agents
   */
  protected Point familyPosition(Families f,int affectedPer5){
    /**
     * tha ypologizei to meso simeio tou patera kai tis manas,
     * kai tha ypologizei mia tyxaia timi anamesa se ekeino to
     * diasthma, apo tin anw aristera gwnia mexri this
     */
    int x, y;
    float xmean=(((float)(f.getFather().getX()+f.getMother().getX()))/2);
    float ymean=(((float)(f.getFather().getY()+f.getMother().getY()))/2);
    int status;

    x = 1 + (int) (xmean * Math.random());
    y = 1 + (int) (ymean * Math.random());
    int counter2=0;

    while (MenuFrame.grid.getP(x, y) != 0) {
      x = 1 + (int) (xmean * Math.random());
      y = 1 + (int) (xmean * Math.random());
      //se periptosi pou oles oi theseis einai katellimenes
      counter2++;
      if(counter2==20){
        xmean=MenuFrame.grid.getD1();
        ymean=MenuFrame.grid.getD1();
      }
    }


    MenuFrame.grid.fillAgents(x, y, 9, affectedPer5);

    Point a = new Point(x, y);
    return a;
  }




  class LoadingBehaviour
      extends CyclicBehaviour {
    public LoadingBehaviour(Agent agent) {
      super(agent);
    }
    public void action() {
      MessageTemplate mt=MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),MessageTemplate.MatchOntology(ontology.getName()));
      ACLMessage msg = blockingReceive(mt);

            try{
              ContentElement ce=null;

              if(msg.getPerformative()==ACLMessage.INFORM){
                ce = getContentManager().extractContent(msg);
                if (ce instanceof Families) {
                  Chromosoma chr=new Chromosoma();
                  Families family1=(Families) ce;
                  marriageIdNumber++;
                  family1.setFamilyID(marriageIdNumber);
                  float fatherInfoDegree=family1.getFather().getInformationDegree();
                  float motherInfoDegree=family1.getMother().getInformationDegree();
                  float fatherAcceptance=(float)(chr.acceptanceGene(family1.getFather().getBitGene()))/15;
                  float motherAcceptance=(float)(chr.acceptanceGene(family1.getMother().getBitGene()))/15;
                  float fatherFearDegree=family1.getFather().getFearDegree();
                  float motherFearDegree=family1.getMother().getFearDegree();
                  float fatherInfulence=(float)(chr.influenceGene(family1.getFather().getBitGene()))/15;
                  float motherInfulence=(float)(chr.influenceGene(family1.getMother().getBitGene()))/15;

                  family1.setFamilyInformationDegree((int)((fatherInfoDegree*motherAcceptance+motherInfoDegree*fatherAcceptance)/2));
                  family1.setFamilyFearDegree((int)((fatherFearDegree*fatherInfulence+motherFearDegree*motherInfulence)/(fatherInfulence+motherInfulence)));

                  //dimiourgia listas oikogeneiwn
                  familiesList.add(family1);
                  counter++;

                  //an exoun erthei oloi oi goneis
                  if(counter==MatchAgent.counterFinalMarriages){

                    //anathesi twn newn oikogeneiwn se kapoio POINT-X,Y
                    for(int i=0;i<counter;i++){
                      //ANA OIKOGENEIA
                      Families thisFamily=(Families) familiesList.get(familiesList.size()-counter+i);
                      int familyMembersAffected=0;
                      int childerAffected=0;
                      //einai oi goneis astheneis?
                      if(chr.healthGene(thisFamily.getFather().getBitGene())==1)
                        familyMembersAffected++;
                      if(chr.healthGene(thisFamily.getMother().getBitGene())==1)
                        familyMembersAffected++;

                      List thisFamilyChildren=thisFamily.getChildren();


                      //calculate affected family members
                      for(int j=0;j<thisFamilyChildren.size();j++){
                        Description child=(Description)thisFamilyChildren.get(j);
                        if(chr.healthGene(child.getBitGene())==1){
                          familyMembersAffected++;
                          childerAffected++;
                          if (child.getEpochsToLive() < 20 &&
                              MenuFrame.settings.getAffectDth() == false) {
                            childerAffected++; //to double the fear
                          }
                        }
                      }

                      if(childerAffected>0){
//                        int fear=(thisFamily.getFather().getFearDegree()+thisFamily.getMother().getFearDegree())/2;
                        int newFear=(int)((float)childerAffected*((float)thisFamily.getFamilyFearDegree()/2));
                        if (newFear>500){
                          newFear = 500;
                        }
                        thisFamily.setFamilyFearDegree(newFear);
                      }

                      //calualte new child value
                      for(int j=0;j<thisFamilyChildren.size();j++){
                        Description child=(Description)thisFamilyChildren.get(j);
                        int totalFear=(int)((float)thisFamily.getFamilyFearDegree()*((float)chr.acceptanceGene(child.getBitGene()))/15+
                                            (float)familyMembersAffected*(float)chr.fearGene(child.getBitGene()));
                        int totalInfo=(int)((float)thisFamily.getFamilyInformationDegree()*((float)chr.acceptanceGene(child.getBitGene()))/15);
                        if (totalFear>500){
                          totalFear = 500;
                        }
                        if (totalInfo>500){
                          totalInfo=500;
                        }
                        child.setFearDegree(totalFear);
                        child.setInformationDegree(totalInfo);
//                        newPeople.addBabysDescription(child);
                      }


                      //pososto me vasi to 5-[0,1,..5]
                      int affectedPer5=(int)(5*(float)familyMembersAffected/(float)(thisFamily.getChildren().size()+2)); //2 if for parents

                      //grid setup
                      Point b=familyPosition(thisFamily,affectedPer5);
                      thisFamily.setFX((int)b.getX());
                      thisFamily.setFY((int)b.getY());

                      ACLMessage informSuperAgent = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                      informSuperAgent.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                      informSuperAgent.setOntology(ontology.getName());
                      informSuperAgent.setLanguage(codec.getName());
                      manager.fillContent(informSuperAgent,thisFamily);
                      send(informSuperAgent);

                    }
                    //midenismos tou counter
                    counter=0;

                  }
                }
              }else if(msg.getPerformative()==ACLMessage.INFORM_IF){
                if(msg.getContent().startsWith(SuperAgent.NOMARRIAGES)){
                  ACLMessage mateInfo = new ACLMessage(ACLMessage.INFORM);
                  mateInfo.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                  mateInfo.setOntology(ontology.getName());
                  mateInfo.setContent(SuperAgent.REMOVEOLDADDNEW);
                  mateInfo.setLanguage(codec.getName());
                }

              }else{
                this.block();
              }


            }catch(CodecException ce){
              ce.printStackTrace();

            }catch(OntologyException oe){
              oe.printStackTrace();
            }

          }//end void action
        }//end cyclic behavior
}


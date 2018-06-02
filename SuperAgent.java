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
import org.mancer.tools.NormalRandom;
import genecity.gui.AgentList;
import genecity.methods.*;

/**
 * <p>Title: SuperAgent</p>
 * <p>Description: Agent that Supervises All Functions </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class SuperAgent extends Agent {

  public static AgentList al=new AgentList();

  private int counter=0;
  private int counter3=0;
  private int counter4=0;

  private int countChildrenInNewFamilies=0;

  private static int newAgentPopulation;
  //CHART-1
  public static int diseasedPopulation=0;
  public static int carriersPopulation=0;
  public static int totalAgentPopulation=0;
  public static int currentGridPopulation=0;


  private int counterEarlyDiseasedChildren=0;
  private int abortedChildren=0;


///////// C O U N T E R S

  private int counterMales=0;
 private int counterFemales=0;
  private int counterPeople=0;
  private int counterMaleCarriers=0;
 private int counterFemaleCarriers=0;
 private int counterMaleDiseased=0;
  private int counterFemaleDiseased=0;
  private int counterBirths=0;
 private int counterDeaths=0;
  private int counterFamilies=0;
 private int countPeopleInformed=0;
 private int countInfoFromMedia=0;
 private int countNumberInformationsExchanged=0;

  public static int cm=0;
  public static int cf=0;
  public static int cp=0;
  public static int cmc=0;
  public static int cfc=0;
  public static int cmd=0;
  public static int cfd=0;
  public static int cb=0;
  public static int cd=0;
  public static int cfam=0;
  public static int cpi=0;
  public static int cimed=0;
  public static int cie=0;


    ///////////////////////////////////////////////

  private static AgentController matchAgent=null;
  private static AgentController familyAgent=null;


  public static int epoch;
  private long globalAgentID=0;
  private AgentController simAgent=null;

  public static List gridAgents=new ArrayList();//oi Single Agents sto grid
  public static List enabledAgentsList=new ArrayList();//lista me INTEGER noumera twn Agents pou tha 3ekinhsoun
  private List waitingList=new ArrayList();//lista me born Agents DESCRIPTION ata age 0
  private List upToGridList=new ArrayList(); //oi neoi pou tha mpoun sto grid meta to Born kai 18 xronia
  private List familiesList=new ArrayList(); //all tha families until the day the last person(father or mother) dies
  public static List allFamiliesList=new ArrayList(); // the list for all the families
  public static List agentTableData=new ArrayList();//gia apeikonisi sta tables tpt idiaitero


  public static List metricsList=new ArrayList();



  private int progressBarValue;
  private int numberAgentsToWakeUp;

  public final static String STARTUP="Startup";
  public final static String READYTOMATE="Ready to mate";
  public final static String FEEDBACKFORYOU="Feedback for yourself";
  public final static String NOMARRIAGES="No new marriages";
  public final static String REMOVEOLDADDNEW="Remove old Add new";
  public final static String EXCHANGEKNOWLEDGE="Exchange Knowledge";


  private ContentManager manager1 = (ContentManager) getContentManager();
  private Codec codec = new SLCodec();
//  private Ontology ontology = PersonOntology.getInstance();
  private Ontology ontology = SimulationOntology.getInstance();



//  private Person person=new Person();
//  private Persons person1=new Persons();
  private Description person1=new Description();



  protected void setup() {
    manager1.registerLanguage(codec);
    manager1.registerOntology(ontology);
    epoch=0;
    diseasedPopulation=0;
    carriersPopulation=0;
    totalAgentPopulation=0;
////////////////////////////////////////////////////
    counterMales=0;
    counterFemales=0;
    counterPeople=0;
    counterMaleCarriers=0;
    counterFemaleCarriers=0;
    counterMaleDiseased=0;
    counterFemaleDiseased=0;
    counterBirths=0;
    gridAgents.clear();
    counterFamilies=0;

   ///////////////////////////////////////////////////
    createFuncAgents();
    createVillage();
    Behaviour simpleBehaviour=new LoadingBehaviour(this);
    addBehaviour(simpleBehaviour);
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

              if(msg.getPerformative()==ACLMessage.CONFIRM){
                ce= getContentManager().extractContent(msg);


                if (ce  instanceof Human){
                  if (newAgentPopulation > 0) {
                    counter3++;
                    Description p1 = ( (Human) ce).getCharacteristics();

                    if(p1.getFromFamilyID()==0)
                      al.addAgent(p1);
                    if(p1.getEpochOfBirth()<0){
                      setTableData(p1,"Initial");
                    }
                    gridAgents.add(p1);
                    MenuFrame.grid.setAgentName(p1.getX(), p1.getY(),p1);
                    //arxikopoihsh twn agents
                    progressBarValue = (int) (100.0 * ( (float) counter3) /
                                              ( (float) newAgentPopulation));
                    setProgressBar(progressBarValue, "% new agents created");
                    //when the counter reaches the initial population
                    if (counter3 == newAgentPopulation) {
                      setTextMessage(gridAgents.size() +
                                     " agents succesfully initiated...");
                      setTextMessage("Epoch: " + epoch);
                      setTextMessage("Total Agent Population: "+totalAgentPopulation);

                      //setProgressBar(0,"% waiting...");
                      MenuFrame.jButton12.setEnabled(true);
                      MenuFrame.jButton13.setEnabled(true);
//                      MenuFrame.jButton2.setEnabled(true);

                      getMaleFemalePopulation();
                      enabledAgentsList.clear();
                      counter3 = 0;

                      if (numberAgentsToWakeUp > 0) {
                        chooseRandomAgents();
                      }else{
                        setTextMessage("No agents to activate-1");
                        ACLMessage selfLoop = new ACLMessage(ACLMessage.INFORM);
                        selfLoop.setLanguage(codec.getName());
                        selfLoop.setOntology(ontology.getName());
                        selfLoop.setContent(SuperAgent.REMOVEOLDADDNEW);
                        selfLoop.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                        send(selfLoop);
                      }
                      if ( (currentGridPopulation + waitingList.size()) == 0) {
                        JOptionPane.showMessageDialog(null,
                                                      "Not enough agents in grid\nto continue the simulation",
                                                      "Simulation Ended",
                                                      JOptionPane.INFORMATION_MESSAGE);
                      }
                    }
                  }
                  else {
                    setTextMessage("Epoch: " + epoch);
                    setTextMessage("Total Agent Population: "+totalAgentPopulation);

                     //an den exw neous praktores gia enar3i
                     setTextMessage("No new agent in the field");
                     getMaleFemalePopulation();
                     enabledAgentsList.clear();
                      counter3 = 0;

                     if (numberAgentsToWakeUp > 0) {
                       chooseRandomAgents();
                     }else if ( (currentGridPopulation + waitingList.size()) == 0) {
                       JOptionPane.showMessageDialog(null,
                                                     "Not enough agents in grid\nto continue the simulation",
                                                     "Simulation Ended",
                                                     JOptionPane.INFORMATION_MESSAGE);
                     } else{
                       setTextMessage("No agents to activate-2");
                       ACLMessage selfLoop = new ACLMessage(ACLMessage.INFORM);
                       selfLoop.setLanguage(codec.getName());
                       selfLoop.setOntology(ontology.getName());
                       selfLoop.setContent(SuperAgent.REMOVEOLDADDNEW);
                       selfLoop.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                       send(selfLoop);
                     }
                  }
                }

              }else if(msg.getPerformative()==ACLMessage.INFORM){
                if (SuperAgent.READYTOMATE.equals(msg.getContent())) {
                  //An einai oloi etoimoi, na aposteiloun ta stoixeia tous gia mating
                  counter++;
                  if (counter == numberAgentsToWakeUp) {
                    //repaint frame with "colored" agents
//                    MenuFrame.drawPanelFrame2.drawPanel.repaint();
                    //new epoch\
                    //                    epoch++;
                    //create recepients list
                    ACLMessage replyccmsg = new ACLMessage(ACLMessage.INFORM);
                    //respond to all of the agents as carbon copy!
                    for (int i = 0; i < counter; i++) {
                      replyccmsg.addReceiver(new AID(gridAgentInfo(Integer.parseInt(enabledAgentsList.get(i).toString())).getName(),
                                                     AID.ISLOCALNAME));
                    }
                    replyccmsg.setContent(SuperAgent.FEEDBACKFORYOU);
                    replyccmsg.setLanguage(codec.getName());
                    replyccmsg.setOntology(ontology.getName());
                    send(replyccmsg);
                    counter = 0; //zeromize counter
                    //paint selected agents!
                    MenuFrame.drawPanelFrame2.drawPanel.repaint();
                    //GIA GRAFIKI< ISOS THA TO BGALW ARGOTERA
               //     if(epoch==1)
//                    System.out.println(currentGridPopulation+"+"+waitingList.size());
                  }





////////////////////  R E M O V E    O L D    N E W

                }else if(SuperAgent.REMOVEOLDADDNEW.equals(msg.getContent())){
                  //new epoch!!!
                  epoch++;

                  //enable agent adding in Remote Control
                  if(epoch>3)
                    MenuFrame.rc.jButtonAddAgent.setEnabled(true);

                  //reset enabledP
                  for(int i=0;i<MenuFrame.grid.getD1();i++){
                    for (int j = 0; j < MenuFrame.grid.getD1(); j++) {
                      MenuFrame.grid.setEnabledP(i+1,j+1,0);
                    }
                  }
                  //this one to add new agents and delete old ones
                  //before looping!
                  Chromosoma chr=new Chromosoma();
                  //waiting to be born(over 18!) list
                  counter=0;
                  counterEarlyDiseasedChildren=0;
                  for(int i=0;i<waitingList.size();i++){
                    Description des=(Description) waitingList.get(i);
                    //Increase DISEASE POPULATION if has healthy bit-1, else
                    //if just carrier, increase CARRIERS POPULATION
                    if(des.getEpochOfBirth()==epoch){
                      counterBirths++;
                      //COUNTERS
                      if(des.getSex().startsWith("Male")){
                        counterMales++;
                        if(chr.healthGene(des.getBitGene())==1){
                          counterMaleDiseased++;
                        }else if (chr.mutationGene(des.getBitGene())>0){
                          counterMaleCarriers++;
                        }
                      }else{ //if woman
                        counterFemales++;
                        if(chr.healthGene(des.getBitGene())==1){
                          counterFemaleDiseased++;
                        }else if (chr.mutationGene(des.getBitGene())>0){
                          counterFemaleCarriers++;
                        }

                      }
                      totalAgentPopulation++;
                      counterPeople++;

                      if(chr.healthGene(des.getBitGene())==1){ //new epoch about newcomers
                        diseasedPopulation++;
                      }else if(chr.mutationGene(des.getBitGene())>0){
                        carriersPopulation++;
                      }
                    }
                    if((des.getEpochOfBirth()+des.getEpochsToLive())==epoch){  //in the case o diseased early death
                      waitingList.remove(i);
                      i--;
                      totalAgentPopulation--;
                      counterEarlyDiseasedChildren++;
                      if(chr.healthGene(des.getBitGene())==1){
                        diseasedPopulation--;
                      }else if(chr.mutationGene(des.getBitGene())>0){
                        carriersPopulation--;
                      }
                    }else if((des.getEpochOfBirth()+MenuFrame.settings.getlegalMarriageAge())==epoch){
                     counter++;
                     upToGridList.add(des);
                     waitingList.remove(i);
                     i--;
                   }

                  }
                  newAgentPopulation=+counter;
                  currentGridPopulation=currentGridPopulation+newAgentPopulation;
                  //to delete all old ones
                  removeDeadAgents();

                  //calculate agents to participate in next round
                  numberAgentsToWakeUp = (int) ((float)gridAgents.size() * (float) MenuFrame.settings.getmarriageOverPopulation() / 100);
                  if (! (numberAgentsToWakeUp % 2 == 0)) {
                    numberAgentsToWakeUp++;
                  }
                  if(newAgentPopulation==0){
                    ACLMessage selfLoop = new ACLMessage(ACLMessage.CONFIRM);
                    selfLoop.setLanguage(codec.getName());
                    selfLoop.setOntology(ontology.getName());
                    Human human=new Human();
                    manager1.fillContent(selfLoop,human);
                    selfLoop.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                    send(selfLoop);
                  }else{
                    //add to the matrix!
                    addNewAgentsToGrid(upToGridList);
                    upToGridList.clear();
                  }

                  //calculate the MEDIA INFORMATION
                  mediaExchange();

                  //refresh Grid!
                   MenuFrame.gFrame1.upDatePopulationGraph();

                   //save export data
                   List temp=new ArrayList();
                   temp.add(new Integer(epoch));
                   temp.add(new Integer(totalAgentPopulation));
                   temp.add(new Integer(carriersPopulation));
                   temp.add(new Integer(diseasedPopulation));
                   temp.add(new Float((float)carriersPopulation/(float)totalAgentPopulation));
                   temp.add(new Float((float)diseasedPopulation/(float)totalAgentPopulation));
                   temp.add(new Integer(countChildrenInNewFamilies));
                   temp.add(new Integer(abortedChildren));
                   temp.add(new Integer(counter)); //new agents in the grid
                   counter=0;
                   //
                   temp.add(new Integer(counterEarlyDiseasedChildren));
                   /////////
                   temp.add(new Integer(counterFamilies)); //size of families list in this epoch
                   //
                   temp.add(new Integer(counterDeaths));
                   temp.add(new Integer(counterBirths));
                   temp.add(new Integer(counterMales));
                   temp.add(new Integer(counterFemales));
                   temp.add(new Integer(counterPeople));
                   temp.add(new Integer(counterMaleCarriers));
                   temp.add(new Integer(counterFemaleCarriers));
                   temp.add(new Integer(counterMaleDiseased));
                   temp.add(new Integer(counterFemaleDiseased));
                   //
                   temp.add(new Integer(countPeopleInformed));
                   temp.add(new Integer(countInfoFromMedia));
                   temp.add(new Integer(countNumberInformationsExchanged));
                   metricsList.add(temp);

                   //triger metrics
                   MenuFrame.at.trigger();
                   zeromizeCounters();
                }



              }else if(msg.getPerformative()==ACLMessage.ACCEPT_PROPOSAL){
                ce= getContentManager().extractContent(msg);
                if(ce instanceof Families){
                  counter4++;
                  Families f1=(Families)ce;
                  familiesList.add(f1);

                  if (counter4==MatchAgent.counterFinalMarriages){
                    counterFamilies=counter4;
                    countChildrenInNewFamilies=0;
                    abortedChildren=0;
                    for(int i=(familiesList.size()-MatchAgent.counterFinalMarriages);i<familiesList.size();i++){
                      Families thisFamily = (Families) familiesList.get(i);
                      //put kids in a waiting list

                      for (int j = 0; j < thisFamily.getChildren().size(); j++) {
                        Description des = (Description) thisFamily.getChildren().get(j);

                        countChildrenInNewFamilies++;
                        //setup initial data
                        globalAgentID++;
                        ((Description)(thisFamily.getChildren().get(j))).setName("human-"+globalAgentID);
                        ((Description)(thisFamily.getChildren().get(j))).setFromFamilyID(thisFamily.getFamilyID());

                        Chromosoma chr=new Chromosoma();

                        boolean flag=false;
                        if(chr.healthGene(des.getBitGene())==1){
                          if(Math.random()<MenuFrame.settings.getPrebirthControlAbortion()){
                            abortedChildren++;
                            des.setEpochsToLive(0);
                            setTextMessage("Abortion: "+des.getName());
                            setTableData(des,"Abortion");
                            flag=true;
                          }
                        }
                        if(!flag){
                          waitingList.add(des);
                          setTableData(des, "Normal");
                        }
                        al.addAgent(des);
                      }

                      MenuFrame.grid.setAgentName(thisFamily.getFX(), thisFamily.getFY(), thisFamily);
                      allFamiliesList.add(thisFamily); //add new family, all families ever!
                      MenuFrame.jButton2.setEnabled(true);

                      if((epoch==(MenuFrame.rc.newPerson.getEpochOfBirth()+MenuFrame.settings.getlegalMarriageAge()-1))&&MenuFrame.rc.newPerson.getName()=="RCAgent"){
                         Description desRC = MenuFrame.rc.newPerson;
                         globalAgentID++;
                         Chromosoma chr=new Chromosoma();
                         System.out.println(chr.mutationGene(desRC.getBitGene()));
                         desRC.setName("human-" +globalAgentID );
                         setTextMessage("->Human-"+globalAgentID+" entered from user");
                         waitingList.add(desRC);
                         setTableData(desRC,"User");
                         MenuFrame.rc.jButtonAddAgent.setEnabled(true);
                         if(desRC.getHealth().startsWith("Diseased")){
                             //diseasedPopulation++; //RC AGENT ?DEEDED?
                           }else if(desRC.getHealth().startsWith("Carrier")){
                             //carriersPopulation++;
                           }
                           //COUNTERS
                           if(desRC.getSex().startsWith("Male")){
                             counterMales++;
                             if(desRC.getHealth().startsWith("Diseased")){
                               counterMaleDiseased++;
                             }else if (desRC.getHealth().startsWith("Carrier")){
                               counterMaleCarriers++;
                             }
                           }else{ //if woman
                             counterFemales++;
                             if(desRC.getHealth().startsWith("Diseased")){
                               counterFemaleDiseased++;
                             }else if (desRC.getHealth().startsWith("Carrier")){
                               counterFemaleCarriers++;
                             }
                           }
                           totalAgentPopulation++;
                           counterPeople++;
                           al.addAgent(desRC);
                        }


                      //remove parents from grid
                        //father
                      Description p1=(Description) thisFamily.getFather();
                      //remove from grid
                      MenuFrame.grid.setAgentName(p1.getX(), p1.getY(),null);
                      MenuFrame.grid.setP(p1.getX(), p1.getY(), 0);
                      //gia na tous afairei apo to agentsList
                      for (int j = 0; j < gridAgents.size(); j++) {
                        if (p1.getName().equals(gridAgentInfo(j).getName().toString())) {
                          gridAgents.remove(j);
                          break;
                        }
                      }
                      //remove father from container
                      ACLMessage deleteFather = new ACLMessage(ACLMessage.DISCONFIRM);
                      deleteFather.setLanguage(codec.getName());
                      deleteFather.setOntology(ontology.getName());
                      deleteFather.addReceiver(new AID(p1.getName(), AID.ISLOCALNAME));
                      send(deleteFather);

                      //mother
                      Description p2=(Description) thisFamily.getMother();
                      //remove from grid
                      MenuFrame.grid.setAgentName(p2.getX(), p2.getY(),null);
                      MenuFrame.grid.setP(p2.getX(), p2.getY(), 0);
                      //gia na tous afairei apo to agentsList
                      for (int j = 0; j < gridAgents.size(); j++) {
                        if (p2.getName().equals(gridAgentInfo(j).getName().toString())) {
                          gridAgents.remove(j);
                          break;
                        }
                      }
                      //remove mother from container
                      ACLMessage deleteMother = new ACLMessage(ACLMessage.DISCONFIRM);
                      deleteMother.setLanguage(codec.getName());
                      deleteMother.setOntology(ontology.getName());
                      deleteMother.addReceiver(new AID(p2.getName(), AID.ISLOCALNAME));
                      send(deleteMother);


                    }
                    currentGridPopulation=currentGridPopulation-MatchAgent.counterFinalMarriages*2; //minus 2 parents*families here
                    ACLMessage selfLoop = new ACLMessage(ACLMessage.INFORM);
                    selfLoop.setLanguage(codec.getName());
                    selfLoop.setOntology(ontology.getName());
                    selfLoop.setContent(SuperAgent.REMOVEOLDADDNEW);
                    selfLoop.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
                    send(selfLoop);
                    counter4=0;
                  }
                }

              }else{  //if acl.inform, if not inform, proceed to else!
                this.block();
              }



            }catch(CodecException ce){
              ce.printStackTrace();

            }catch(OntologyException oe){
              oe.printStackTrace();
            }

          }//end void action
        }//end cyclic beh






  protected void chooseRandomAgents(){
    int randomAgentIndex=-1;
    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
    Point a=new Point();
    int status;
    for (int k = 0; k < numberAgentsToWakeUp; k++) {
      status=1;
      int tempCount=0;
      while(status==1){
        if(k<numberAgentsToWakeUp/2){
          do{
            randomAgentIndex = (int) (Math.abs( ( (double) gridAgents.size()) *
                                          Math.random()));
//            tempCount++;
//            if(tempCount%50==0){
//              numberAgentsToWakeUp=numberAgentsToWakeUp-2;
//            }
          }while(gridAgentInfo(randomAgentIndex).getSex().startsWith("Male"));
        }else{
          do{
            randomAgentIndex = (int) (Math.abs( ( (double) gridAgents.size()) *
                                          Math.random()));
//            tempCount++;
//            if(tempCount%50==0){
//               numberAgentsToWakeUp=numberAgentsToWakeUp-2;
//            }
          }while(gridAgentInfo(randomAgentIndex).getSex().startsWith("Female"));
        }

        if (MenuFrame.grid.getEnabledP( gridAgentInfo(randomAgentIndex).getX(), gridAgentInfo(randomAgentIndex).getY()) ==0) {
          MenuFrame.grid.setEnabledP(gridAgentInfo(randomAgentIndex).getX(), gridAgentInfo(randomAgentIndex).getY(), 1);
          status=0;
        }
      }

      progressBarValue=(int)(100.0*((float)(k+1))/((float)numberAgentsToWakeUp));
      setProgressBar(progressBarValue,"% random selection");
      if(progressBarValue>100){
//        System.out.println("Random selection in SuperA over "+progressBarValue);
      }

      enabledAgentsList.add(new Integer(randomAgentIndex));
      msg.addReceiver(new AID(gridAgentInfo(randomAgentIndex).getName().toString(), AID.ISLOCALNAME));
    }
    msg.setOntology(ontology.getName());
    msg.setLanguage(codec.getName());
    msg.setContent(SuperAgent.STARTUP);
    send(msg);
  }

  /**
   *
   * @return
   */
  protected void getMaleFemalePopulation(){
    int x=0;
    int y=0;
    for(int i=0;i<gridAgents.size();i++){
      if(((Description)gridAgents.get(i)).getSex().startsWith("Male")){
        x++;
      }else if (((Description)gridAgents.get(i)).getSex().startsWith("Female")){
        y++;
      }
    }
    if(x<(numberAgentsToWakeUp/2)||y<(numberAgentsToWakeUp/2)){
      if(x<=y){
        numberAgentsToWakeUp=x*2;
      }else{
        numberAgentsToWakeUp=y*2;
      }
    }


  }



  /**
   * CREATION OF AGENT VILLAGE
   */
  protected void createVillage() {
    newAgentPopulation=MenuFrame.settings.getagentPopulation();
    int methodTransmition=MenuFrame.settings.getMethodTransmittion();
    boolean dominant=MenuFrame.settings.getDominantAutosomatic();
    int popHealthy=MenuFrame.settings.getPopulationHealthyPeople();
    int popCarriers=MenuFrame.settings.getPopulationCarriersNotDiseased();
    int popWomanCarriers=MenuFrame.settings.getPopulationWomanCarriers();
    int popManDiseased=MenuFrame.settings.getPopulationMalesDiseased();

    try {
      currentGridPopulation=(int)(MenuFrame.settings.getagentPopulation());
        for (int i = 0;  i < currentGridPopulation;  i++) {
            globalAgentID++;

            String localName = "human-"+globalAgentID;
            int sex, diseaseState=0; // 1-male, 0-female // 0-healthy, 1-trair, 2-omozygotic
            int diseaseGenes=0;
            // create a new agent
            //set half the agents in men and women
            if(i%2==0){
              sex=0;
              //women
            }else{
              sex=1; //men
            }

            //initiate agents with a genetic (or not) disease (and how they appear)
            //diseaseState=0 clear, =1 carrier, =2 diseased

            //autosomatic not dominant
            if(methodTransmition==0&dominant==false){
              if (i >= popHealthy) {
                diseaseState = 1; //carrier
                if(Math.random()<0.5){
                  diseaseGenes=1; //01 position of genes
                }else{
                  diseaseGenes=2;//10 position of genes
                }
              }
              if (i >= (popHealthy +popCarriers)) {
                diseaseState = 2; //diseased
                diseaseGenes=3; //11
              }

            //dominant autosomatic
            }else if(methodTransmition==0&dominant==true){
              if (i >= popHealthy) {
                diseaseState = 2; //diseased
                if(Math.random()<0.5){
                  diseaseGenes=1; //01 position of genes
                }else{
                  diseaseGenes=2;//10 position of genes
                }
              }
              if (i >= (popHealthy +popCarriers)) {
                diseaseState = 2; //diseased
                diseaseGenes=3;
              }

            //x-chromosome, x-related
            } else if (methodTransmition==1){
              if(sex==0){ //woman
                if (i>=2*(currentGridPopulation/2-popWomanCarriers)){
                  diseaseState=1;//carrier
                  if(Math.random()<0.5){
                    diseaseGenes=1; //01 position of genes Xx
                  }else{
                    diseaseGenes=2;//10 position of genes xX
                  }
                }
              }else{ //if men sex=1
                if (i>(2*(currentGridPopulation/2-popManDiseased))){
                  diseaseState=2;//diseased
                  diseaseGenes=2;//xY ONLY
                }
              }
            }




            //ypologismos hlikias!
          int epochOfBirth=(int)(-12*Math.random()-18);
          //place the agent on the Grid

          Object args[] = new Object[9];
          args[0]=new Integer((int)(epochOfBirth)); //epoch of birth
          args[2]=new Integer(sex);
          args[3]=new Integer(diseaseState);
          args[6]=new Integer(0);
          args[7]=new Integer(0);
          args[8]=new Integer(diseaseGenes);

          Chromosoma chr=new Chromosoma();
          int gene=chr.initiateChromosoma(args);
          args[6]=new Integer(gene);
          //if mutated
          if(chr.mutationGene(gene)>0&&diseaseState==0){
            //mutation occured
            args[8]=new Integer(chr.diseaseGene(gene));
            if(chr.healthGene(gene)==1){
              diseaseState=2;
              args[3]=new Integer(2);
            }else{
              diseaseState=1;
              args[3]=new Integer(1);
            }
          }
          Point a=startingPosition(sex,Integer.parseInt(args[3].toString()));
          args[4]=new Integer((int)a.getX());
          args[5]=new Integer((int)a.getY());

          int agentAge=calculateRandomAge(chr.healthGene(gene));

          int epochToLive=agentAge; //gia tous 1ous praktores, pou exoun gennithei edw kai 20 xronia!

          args[1]=new Integer(epochToLive); //+epoch to die

          if(diseaseState==2){
            diseasedPopulation++; //IN VILLAGE
          }else if(diseaseState==1){
            carriersPopulation++;
          }

          //////////////////////////////////////////////////
          if(sex==1){
            counterMales++;
            if(diseaseState==2){
              counterMaleDiseased++;
            }else if (diseaseState==1){
              counterMaleCarriers++;
            }
          }else{ //if woman
            counterFemales++;
            if(diseaseState==2){
              counterFemaleDiseased++;
            }else if (diseaseState==1){
              counterFemaleCarriers++;
            }
          }
          totalAgentPopulation++;
          counterPeople++;
          ////////////////////////////////////////////////////

            simAgent = LaunchAgents.acSingle.createNewAgent(localName,genecity.SimpleAgent.class.getName(),args);
            simAgent.start();
          }
          //refresh GUI
          MenuFrame.drawPanelFrame2.drawPanel.repaint();
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }







      /**
       *
       * @param bachelors
       */
      protected void addNewAgentsToGrid(List bachelors){
        Chromosoma chr=new Chromosoma();
        try{
          for (int k = 0; k < bachelors.size(); k++) {
            Description ds = (Description) bachelors.get(k);
//            globalAgentID++;
            int sex = 0;
            if (ds.getSex().startsWith("Male")) {
              sex = 1;
            }
            int diseaseState = 0;
            int bitgene=ds.getBitGene();
            if(chr.healthGene(bitgene)==1){
              diseaseState=2;
            }else if(chr.mutationGene(bitgene)>0){
              diseaseState=1;
            }
            Object args[] = new Object[8];
            args[0] = new Integer(ds.getEpochOfBirth()); //epoch of birth
            args[1] = new Integer(ds.getEpochsToLive()); //+epoch to die
            args[2] = new Integer(sex);
            args[6] = new Integer(bitgene);
            args[7] = new Integer(ds.getFromFamilyID());
            args[3] = new Integer(diseaseState);
            Point a = startingPosition(sex, diseaseState);
            args[4] = new Integer( (int) a.getX());
            args[5] = new Integer( (int) a.getY());
            String localName = ds.getName();
            //launch new agents
            simAgent = LaunchAgents.acSingle.createNewAgent(localName,genecity.SimpleAgent.class.getName(), args);
            simAgent.start();
          }
        }catch(Exception ex){
          ex.printStackTrace();
        }
      }





      protected void mediaExchange(){
        Chromosoma chr=new Chromosoma();
        MediaAgent mA=new MediaAgent();
        if(MenuFrame.rc.rcMediaT!=0){
          if (epoch % MenuFrame.rc.rcMediaT == 0) {
            for (int i = 0; i < gridAgents.size(); i++) {
              if (MenuFrame.rc.rcMediaT == 0) {
                break;
              }
              if (Math.random() <= ( (float) MenuFrame.rc.rcMedia / 100)) {
                countPeopleInformed++;
                countInfoFromMedia=countInfoFromMedia+MenuFrame.rc.rcMediaP;
                int thisInform = gridAgentInfo(i).getInformationDegree();
                int thisAccept = chr.acceptanceGene(gridAgentInfo(i).getBitGene());
                int newInform=thisInform +thisAccept *MenuFrame.rc.rcMediaP;
                if (newInform>500){
                  newInform=500;
                }
                gridAgentInfo(i).setInformationDegree(newInform);
              }
            }
          }
        }

        //based on moore neighborhood
        if(MenuFrame.rc.rcMediaNeigh==true){
          for (int i = 0; i < MenuFrame.grid.getD1(); i++) {
            for (int j = 0; j < MenuFrame.grid.getD1(); j++) {
              Object hostObj = MenuFrame.grid.getAgentName(i, j);
              if (hostObj != null) {
                for (int i2 = -1; i2 < 2; i2++) {
                  for (int j2 = -1; j2 < 2; j2++) {
                    if (i2 > 0 && j2 > 0 && i2 <= MenuFrame.grid.getD1() &&
                        j2 <= MenuFrame.grid.getD1()) {
                      Object clientObj = MenuFrame.grid.getAgentName(i+i2,j+j2);
                      if (clientObj != null) {
                        int hostInformationDegree = 0;
                        int clientInformationDegree = 0;
                        if (hostObj instanceof Description) {
                          hostInformationDegree = ( (Description) (hostObj)).
                              getInformationDegree();
                        }
                        else if (hostObj instanceof Families) {
                          hostInformationDegree = ( (Families) (hostObj)).
                              getFamilyInformationDegree();
                        }
                        if (clientObj instanceof Description) {
                          clientInformationDegree = ( (Description) (clientObj)).
                              getInformationDegree();
                        }
                        else if (clientObj instanceof Families) {
                          clientInformationDegree = ( (Families) (clientObj)).
                              getFamilyInformationDegree();
                        }
                        //mathenoume apo aftous pou 3eroun alla-perissotera apo emas(theoria pliroforiwn)
                        //O HOST enhmerwnetai mono, oi alloi otan tha einai h seira tous.
                        if (hostInformationDegree < clientInformationDegree) {
                          countNumberInformationsExchanged++;
                          if (hostObj instanceof Description) {
                            ( (Description) (hostObj)).setInformationDegree( ( (
                                Description) (hostObj)).getInformationDegree() +
                                clientInformationDegree *
                                chr.acceptanceGene( ( (Description) (hostObj)).
                                                   getBitGene()));
                          }
                          else if (hostObj instanceof Families) {
                            ( (Families) (hostObj)).setFamilyInformationDegree( ( (
                                Families) (hostObj)).getFamilyInformationDegree() +
                                clientInformationDegree *
                                ( ( (Families) (hostObj)).getFather().
                                 getInformationDegree() +
                                 ( (Families) (hostObj)).getMother().
                                 getInformationDegree()) / 2);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            progressBarValue = (int) (100.0 * ( (float) i) /
                                      ( (float) MenuFrame.grid.getD1() - 1));
            setProgressBar(progressBarValue, "% Information exchanged");
          }
        }
      }



      protected void removeDeadAgents(){
        //remove dead families:
        Chromosoma chr=new Chromosoma();
        int countDeadFamilies=0;
        for (int i=0;i<familiesList.size();i++){
          Families f=(Families) familiesList.get(i);
          int fatherage=f.getFather().getEpochsToLive()+f.getFather().getEpochOfBirth();
          int motherage=f.getMother().getEpochOfBirth()+f.getMother().getEpochsToLive();
          if(fatherage==epoch){
            totalAgentPopulation--;
            if(chr.healthGene(f.getFather().getBitGene())==1){
              diseasedPopulation--;
            }else if(chr.mutationGene(f.getFather().getBitGene())>0){
              carriersPopulation--;
            }
          }
          if(motherage==epoch){
            totalAgentPopulation--;
            if(chr.healthGene(f.getMother().getBitGene())==1){
              diseasedPopulation--;
            }else if(chr.mutationGene(f.getMother().getBitGene())>0){
              carriersPopulation--;
            }
          }

          //next to remove grid representation
          boolean deleteThis=false;
          if((fatherage>=motherage)&&fatherage<=epoch){
            deleteThis=true;
          }else if((fatherage<motherage)&&motherage<=epoch){
            deleteThis=true;
          }
          if(deleteThis==true){
           countDeadFamilies++;
           counterDeaths++;
           int x=f.getFX();
           int y=f.getFY();
           //remove family
           familiesList.remove(i);
//           MenuFrame.grid.setP(x, y, 0);
           MenuFrame.grid.setP(x,y, 0);
           MenuFrame.grid.setAgentName(x,y,null);
//           MenuFrame.grid.setAllAgentsMatrix(x,y,0);
           countDeadFamilies++;
           MenuFrame.grid.fillAgents(x,y,1001,0);
           i--;
         }
        }
        setTextMessage(countDeadFamilies+" family/ies died this epoch");

        //remove dead single agents
        ACLMessage killYou= new ACLMessage(ACLMessage.DISCONFIRM);
        int counter9=0;
        killYou.setOntology(ontology.getName());
        killYou.setLanguage(codec.getName());
        for (int i=0;i<gridAgents.size();i++){
          int dieEpoch=gridAgentInfo(i).getEpochOfBirth()+gridAgentInfo(i).getEpochsToLive();
          if (dieEpoch==(epoch)){
            counterDeaths++;
            if(chr.healthGene(gridAgentInfo(i).getBitGene())==1){
              diseasedPopulation--;
            }else if(chr.mutationGene(gridAgentInfo(i).getBitGene())>0){
              carriersPopulation--;
            }
            /**
             * CHECK IF THEY DIED BECAUSE OF THE DISEASE, IF YES,
             * THEN INFORM FAMILY BROTHERS
             */
            killYou.addReceiver(new AID(gridAgentInfo(i).getName(),AID.ISLOCALNAME));
 //           MenuFrame.grid.setAllAgentsMatrix(gridAgentInfo(i).getX(),gridAgentInfo(i).getY(), 0);
            MenuFrame.grid.setP(gridAgentInfo(i).getX(),gridAgentInfo(i).getY(), 0);
            MenuFrame.grid.setAgentName(gridAgentInfo(i).getX(),gridAgentInfo(i).getY(),null);
            MenuFrame.grid.fillAgents(gridAgentInfo(i).getX(),gridAgentInfo(i).getY(),1000,0);
            gridAgents.remove(i);
            i--;
            counter9++;
            totalAgentPopulation--;
          }
        }
        send(killYou);

        currentGridPopulation=currentGridPopulation-counter9;
        setTextMessage(counter9+" agents died this epoch");
//        MatchAgent.counterDead=counter9;
        counter9=0;
        MenuFrame.drawPanelFrame2.drawPanel.repaint();
        for(int i=0;i<MenuFrame.grid.getD1();i++){
          for(int j=0;j<MenuFrame.grid.getD1();j++){
            if(MenuFrame.grid.getP(i+1,j+1)==1000||MenuFrame.grid.getP(i+1,j+1)==1001){
              MenuFrame.grid.setP(i+1,j+1,0);
            }
          }
        }
      }





      /**
       * Set starting position for agents
       */
      private Point startingPosition(int sex, int diseaseState){
        int x,y;
        x=1+(int)(MenuFrame.grid.getD1()*Math.random());
        y=1+(int)(MenuFrame.grid.getD1()*Math.random());

        while (MenuFrame.grid.getP(x,y)!=0){
          x=1+(int)(MenuFrame.grid.getD1()*Math.random());
          y=1+(int)(MenuFrame.grid.getD1()*Math.random());
        }
        MenuFrame.grid.fillAgents(x,y,sex,diseaseState);
        Point a=new Point(x,y);
        return a;
      }



      private int calculateRandomAge(int health){
        int randomAge = 0;
        double rand = NormalRandom.nextGaussian();
        if (rand>0){
          randomAge=(int)(rand*7); //gia na dinei max=100
        }else{
          randomAge=(int)(rand*15) ;//gia na dinei peripou mexri ta 20 thanato
        }

        randomAge = (int) MenuFrame.settings.getlifeSpan() + (int) randomAge;
        //if disease affects death
        if (!MenuFrame.settings.getAffectDth()&&health==1) {
          randomAge = (int) (10 * Math.random() *
                             Math.pow( -1, Math.round(Math.random()))) +
              MenuFrame.settings.getmeanAgeEffection() +
              MenuFrame.settings.getlifeYearsExpectancyDisease();
        }

        return randomAge;
      }






      public Description gridAgentInfo(int i){
        return (Description)gridAgents.get(i);
      }


      public void setTableData(Description person,String comment){
        Chromosoma chr=new Chromosoma();
        List temp=new ArrayList();
        temp.add(person.getName());
        temp.add(person.getSex());
        temp.add(new Integer(person.getEpochOfBirth()));
        temp.add(new Integer(person.getEpochsToLive()));
        temp.add(person.getHealth());
        temp.add(new Integer(person.getFearDegree()));
        temp.add(new Integer(person.getInformationDegree()));
        temp.add(comment);
        temp.add(new Integer(person.getFromFamilyID()));
        //-----------------------------------------
        temp.add(new Integer(epoch));
        temp.add(new Integer(chr.acceptanceGene(person.getBitGene())));
        temp.add(new Integer(chr.fearGene(person.getBitGene())));
        temp.add(new Integer(chr.healthGene(person.getBitGene())));
        temp.add(new Integer(chr.influenceGene(person.getBitGene())));
        temp.add(new Integer(chr.mutationGene(person.getBitGene())));
        temp.add(new Integer(chr.phenoGene(person.getBitGene())));
        temp.add(new Integer(chr.reprAbilityGene(person.getBitGene())));
        temp.add(new Integer(chr.visionGene(person.getBitGene())));
        temp.add(new Integer(chr.wealthGene(person.getBitGene())));
       agentTableData.add(temp);
        Object[][] tableObj=new Object[agentTableData.size()][19];
        Object[][] tableObj1=new Object[agentTableData.size()][9];
        int tempcounter=0;
        for(int i=agentTableData.size()-1;i>=0;i--){
          List p1=(List) agentTableData.get(i);
          for(int j=0;j<19;j++){
            tableObj[tempcounter][j]=p1.get(j);
            if(j<9){
              tableObj1[tempcounter][j]=p1.get(j);
            }
          }
          tempcounter++;
        }
        MenuFrame.at.newTable(tableObj1);
      }





      private void zeromizeCounters(){
        cm=counterMales;
        cf=counterFemales;
        cp=counterPeople;
        cmc=counterMaleCarriers;
        cfc=counterFemaleCarriers;
        cmd=counterMaleDiseased;
        cfd=counterFemaleDiseased;
        cb=counterBirths;
        cd=counterDeaths;
        cfam=counterFamilies;
        cpi=countPeopleInformed;
        cimed=countInfoFromMedia;
        cie=countNumberInformationsExchanged;

        counterMales=0;
        counterFemales=0;
        counterPeople=0;
        counterMaleCarriers=0;
        counterFemaleCarriers=0;
       counterMaleDiseased=0;
        counterFemaleDiseased=0;
        counterBirths=0;
        counterDeaths=0;
       counterFamilies=0;
       countPeopleInformed=0;
       countInfoFromMedia=0;
       countNumberInformationsExchanged=0;
      }


      /**
       * PROGRESS BAR
       * @param barValue
       * @param s
       */
      private void setProgressBar(int barValue, String s ){
        MenuFrame.rc.jProgressBar1.setValue(barValue);
        MenuFrame.rc.jProgressBar1.setString(barValue+s);
      }

      private void setTextMessage(String s){
        MenuFrame.rc.jTextArea1.append(s+"\n");
        MenuFrame.rc.jScrollPane1.getVerticalScrollBar().setValue(MenuFrame.rc.jTextArea1.getHeight()-MenuFrame.rc.jTextArea1.getVisibleRect().height-1);
      }



      public List getGridAgentsInfo(){
        return gridAgents;
      }

      public static void exportAgentData(){

      }

      public void createFuncAgents(){
        Object[] args=new Object[1];
        args[0]=null;
        try {
          matchAgent = LaunchAgents.acSingle.createNewAgent("MatchAgent",
              genecity.MatchAgent.class.getName(), args);
        }
        catch (StaleProxyException ex) {
        }
        try {
          familyAgent = LaunchAgents.acSingle.createNewAgent("FamilyAgent",
              genecity.FamilyAgent.class.getName(), args);
        }
        catch (StaleProxyException ex) {
        }

        try {
          matchAgent.start();
        }
        catch (ControllerException ex1) {
        }
        try {
         familyAgent.start();
       }
       catch (ControllerException ex1) {
       }


      }

      public void deleteFuncAgents(){
        try {
          familyAgent.kill();
        }
        catch (ControllerException ex4) {
        }
        try {
          matchAgent.kill();
        }
        catch (ControllerException ex5) {
        }
      }

      public void pauseFuncAgents(){
        try {
          familyAgent.suspend();
        }
        catch (ControllerException ex) {
        }
        try {
          matchAgent.suspend();
        }
        catch (ControllerException ex) {
        }
      }

      public void activateFuncAgents(){
      try {
        familyAgent.activate();
      }
      catch (ControllerException ex) {
      }
      try {
        matchAgent.activate();
      }
      catch (ControllerException ex1) {
      }
      }



    }

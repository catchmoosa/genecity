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
//import jade.util.leap.ArrayList;
import jade.proto.*;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPANames;
import genecity.gui.MenuFrame;
import genecity.gui.DrawPanelFrame;
import genecity.agentCommunication.*;
import genecity.geneticAlgorithm.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import java.io.*;
import jade.util.leap.*;
import jade.content.lang.Codec.*;
import jade.content.onto.OntologyException;
import java.math.*;
//import java.util.*;
import genecity.agentCommunication.*;

import genecity.genetics.Chromosoma;
import org.mancer.tools.NormalRandom;


/**
 * <p>Title: SimpleAgent</p>
 * <p>Description: Create and assing Behaviours to Human Agents </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class SimpleAgent
    extends Agent {

  private ContentManager manager1 = (ContentManager) getContentManager();
  private Codec codec = new SLCodec();

  private Ontology ontology = SimulationOntology.getInstance();
  private String service;

  private Object[] args;
  private String isOfSex;
  private String diseaseStatus;


  private Families family=new Families();
  private Description person1=new Description();

  private Vector oppositeSexAgentList=new Vector();
  private int counter=0;
  private List l=new ArrayList();
//  private Random generator = new Random();
  private MediaAgent mA=new MediaAgent();


  protected void setup() {
    manager1.registerLanguage(codec);
    manager1.registerOntology(ontology);

    args = getArguments();
      //gia initial conditions
      if (args[2].equals(new Integer(1))) {
        isOfSex = "Male";
      }
      else {
        isOfSex = "Female";
      }

      if (args[3].equals(new Integer(1))) {
        diseaseStatus = "Carrier";
      }
      else if (args[3].equals(new Integer(2))) {
        diseaseStatus = "Diseased";
      }
      else {
        diseaseStatus = "Healthy";
      }

      person1.setName(getLocalName());
      person1.setHealth(diseaseStatus);
      person1.setSex(isOfSex);
      person1.setX(Integer.parseInt(args[4].toString()));
      person1.setY(Integer.parseInt(args[5].toString()));
      person1.setEpochOfBirth(Integer.parseInt(args[0].toString()));
      person1.setEpochsToLive(Integer.parseInt(args[1].toString()));
      person1.setBitGene(Integer.parseInt(args[6].toString()));
      person1.setFromFamilyID(Integer.parseInt(args[7].toString()));
      person1=mA.mediaInform(person1,0);
//      person1.setInformationDegree(mt.mediaInform());



    //  add one shot behaviour to handle initialization tasks
    Behaviour myInitialBehaviour = new InitializeBehaviour(this);
    addBehaviour(myInitialBehaviour);


    //  add a SIMPLEBehaviour for the SuperAgent
    Behaviour simpleBehaviour=new LoadingBehaviour(this);
    addBehaviour(simpleBehaviour);
  }




  /**
   * Calulates the distance between 2 agents
   * @param x1
   * @param y1
   * @param x2
   * @param y2
   * @return
   */
  private int distance(int x1,int y1,int x2,int y2){
    return (int)(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));

  }





  /**
   * Tanh Hyperbolic tan function, to be used as a filter in "likeness- Vision"
   * @param x1 the integer
   * @param w1 the weight, the bigger, the closer to a -u(t-1), thus bigger value
   * @return float
   */

  private float tanh(float x, float w1){
    double y;
    x=x*w1;
    y=((Math.exp(x)-Math.exp(-x))/(Math.exp(x)+Math.exp(-x)));
    return (float)y;
  }



  /**
   * PREFERENCE FUNCTION
   * @param p1
   */
  private float[] preferenceMethod(Preferences p1){
    int thisGeneBit=p1.getWhois().getBitGene();
    int thisAge=p1.getWhois().getEpochOfBirth()+SuperAgent.epoch;
    String thisSex=p1.getWhois().getSex();
    float thisFear=(float)p1.getWhois().getFearDegree()/500;//normalize
    float thisInfo=(float)p1.getWhois().getInformationDegree()/500;//normalize
    float thisAgeDifference=MenuFrame.settings.getageDifferenceCouples();
    int diseaseType=MenuFrame.settings.getMethodTransmittion();
    boolean dominant=MenuFrame.settings.getDominantAutosomatic();

    Chromosoma chromosomeMethods=new Chromosoma();

    float v=chromosomeMethods.visionGene(thisGeneBit);   //5; //tanh(w1,d) tha vgainei apo ton genetiko

    //weights by remote control
    float w1=(float)MenuFrame.rc.rcWeight1/100;//proximity
    float w2=(float)MenuFrame.rc.rcWeight2/100;//age
    float w3=(float)MenuFrame.rc.rcWeight3/100;//health
    float w4=(float)MenuFrame.rc.rcWeight4/100;//wealth
    float w5=(float)MenuFrame.rc.rcWeight5/100;//reproduction

    int health=0;


    float preferenceValue;
    float tempPreferences[]=new float[p1.getPreferences().size()];

    for (int i=0;i<p1.getPreferences().size();i++){
      Description ds=(Description) p1.getPreferences().get(i);

      //others' agent data
      int otherX=ds.getX();
      int otherY=ds.getY();
      int otherAge=ds.getEpochOfBirth()+SuperAgent.epoch;
      int otherGeneBit=ds.getBitGene();

      //chromosomatic sequences
      int h1 =chromosomeMethods.healthGene(otherGeneBit);
      int h2 =chromosomeMethods.healthGene(thisGeneBit);
      int repr =chromosomeMethods.reprAbilityGene(otherGeneBit);
      int ph =chromosomeMethods.phenoGene(otherGeneBit);
      int w =chromosomeMethods.wealthGene(otherGeneBit);
      int m1=chromosomeMethods.mutationGene(otherGeneBit);
      int m2=chromosomeMethods.mutationGene(thisGeneBit);

      float d=distance(person1.getX(),person1.getY(),otherX,otherY);



      //FUNCTIONS

      //like-distance according to vision
      float proximity=tanh(1/d,v); //d=distance, w1 oso megalytero, toso kalyterh proseggis//h synartisi ^ mas epistrefei kapoio noumero [0...1]
      //age difference
      double ad=0;
      int ageMale,ageFemale;
      if (thisSex.startsWith("Male")){
        ageMale=thisAge;
        ageFemale=otherAge;
      }else{
        ageMale=otherAge;
        ageFemale=thisAge;
      }
      int maleFemaleAgeDifference=ageMale-ageFemale;
      //Normal Function e(-(x-4)^2/20);
      ad=Math.exp((-1*Math.pow(maleFemaleAgeDifference-thisAgeDifference,2))/20);

      //reproduction
      double rp;
      if(repr==0){//no problems
        rp=1; //yes
      }else{
        rp=0; //no
      }
      if(ageFemale>50&&ageMale>50){
        rp=0;
      }

      //wealth
      float wlth=(float)w/15;

      //health FUZZY LOGIC
      double hlth=1;
      if(h1==0&&m1==0){//if totaly healthy
        hlth=1;
      }else if(h1==0&&m1>0){//carrier
        hlth=0.8;
      }else{
        if(MenuFrame.settings.getAffectDth()==true){
          if (ph == 0) {
            hlth = 0.75;
          }
          else if (ph == 1) {
            hlth = 0.5;
          }
          else if (ph == 2) {
            hlth = 0.25;
          }
          else {
            hlth = 0.2;
          }
        }else{ //if it affects life
          int years2death=ds.getEpochsToLive()-otherAge;
          if (years2death>10){
            if (ph == 0) {
              hlth = 0.5;
            }
            else if (ph == 1) {
              hlth = 0.4;
            }
            else if (ph == 2) {
              hlth = 0.2;
            }
            else {
              hlth = 0.2;
            }
          }else{
            if (ph == 0) {
              hlth = 0.4;
            }
            else if (ph == 1) {
              hlth = 0.3;
            }
            else if (ph == 2) {
              hlth = 0.15;
            }
            else {
              hlth = 0.05;
            }
          }
        }
      }

      //the combination of both,(1-p)robablilites for diseased child_
      double pDisease=1;
      if(m1==0){
        if(m2==0){
          pDisease=1;
        }else{//there is mutation 01 10 11
          //if autosomatic or x-related and 2 is a woman
          if(diseaseType==0){// autosomatic
            if(dominant==true){
              pDisease=0.5;
            }else{//not dominant
              if(h2==0){
                pDisease = 1;
              }else{
                pDisease=0.9;
              }
            }
          }else{ //xchromosome
            if(ds.getSex().startsWith("Female")){
              pDisease=0.75;
            }else{
              pDisease=1;
            }
          }
        }
      }else if (m1<3){ // 01 10
        if(m2==0){
          if(diseaseType==0){// autosomatic
            if(dominant==true){
              pDisease=0.5;
            }else{//not dominant
              if(h2==0){
                pDisease = 1;
              }else{
                pDisease=0.9;
              }
            }
          }else{ //xchromosome
            if(thisSex.startsWith("Female")){
              pDisease=0.75;
            }else{
              pDisease=1;
            }
          }
        }else if(m2<3) { //01 10
          if(diseaseType==0){// autosomatic
            if(dominant==true){
              pDisease=0.5;
            }else{ //not dominant
              pDisease=0.75;
            }
          }else{
            if(thisSex.startsWith("Female")){
              pDisease=0.5;
            }else if(ds.getSex().startsWith("Female")){
              pDisease=1;
            }
          }
        }else if(m2==3){
          if(diseaseType==0){// autosomatic
            if(dominant=true){
              pDisease=0.25;
            }else{
              pDisease=0.5;
            }
          }else pDisease=0;
        }

      }else if(m1==3){ //
        if(m2==0){
          if(diseaseType==0){// autosomatic
            if(dominant==true){
              pDisease=0;
            }else{//not dominant
              if(h2==0){
                pDisease = 1;
              }else{
                pDisease=0.9;
              }
            }
          }else{ //xchromosome
            if(thisSex.startsWith("Female")){
              pDisease=0;
            }
          }
        }else if(m2<3) { //01 10
          if(diseaseType==0){// autosomatic
            if(dominant==true){
              pDisease=0;
            }else{ //not dominant
              pDisease=0.5;
            }
          }else{
            if(thisSex.startsWith("Female")){
              pDisease=0;
            }
          }
        }else if(m2==3){
          pDisease=0;
        }
      }


      //bigger/ better
      preferenceValue=(proximity*w1)+((float)ad*w2)+(w4*wlth)+(w5*(float)rp) + w3*((float)hlth+(float)pDisease)/((thisInfo*thisFear)+1); //*
//      System.out.println(preferenceValue);
//preferenceValue= w3*(float)hlth; //*
      //(float)ad*(w1/likenessDistance + h*(w2*ph+w3*thisFear*thisInfo)+w4/(w+1));
//      System.out.println(h1+" preference gives "+preferenceValue);
      tempPreferences[i]=preferenceValue;
    }//end for
    return tempPreferences;
  }




  /**
   * simple bubble sort
   * @param a Matrix of float
   */
    private int[] sorting(float[] a){
      int[] position=new int[a.length];
      for(int i=0;i<a.length;i++){
        position[i]=i;
      }

      for(int pass=1;pass<a.length;pass++){
        for(int element=0; element<a.length-1;element++){
          if(a[element]>a[element+1]){
            //gia na alla3ei o pinakas me to vathmo protimisis
            float hold;
            hold = a[element];
            a[element]=a[element+1];
            a[element+1]=hold;
            //gia na alla3ei to position
            int hold2;
            hold2=position[element];
            position[element]=position[element+1];
            position[element+1]=hold2;
          }
        }
      }

      return position;
    }






    /**
     * Cyclick Behaviour
     * <p>Title: GeneCity</p>
     * <p>Description: Epidemiological Simulation of a Hereditary Disease in a Multi-Agent System</p>
     * <p>Copyright: Copyright (c) 2004</p>
     * <p>Company: </p>
     * @author Eliades G. Demetrios
     * @version 1.0
     */
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

         if (SuperAgent.STARTUP.equals(msg.getContent())) {
          ACLMessage replymsg = msg.createReply();
          replymsg.setContent(SuperAgent.READYTOMATE);
          send(replymsg);
          }

          else if(SuperAgent.FEEDBACKFORYOU.equals(msg.getContent())){
            ACLMessage replymsg1=new ACLMessage(ACLMessage.INFORM);
            replymsg1.setLanguage(codec.getName());
            replymsg1.setOntology(ontology.getName());
            replymsg1.addReceiver(new AID("MatchAgent", AID.ISLOCALNAME));
            Human human=new Human();
            human.setCharacteristics(person1);
            manager1.fillContent(replymsg1, human);
            send(replymsg1);
          }




        }else if(msg.getPerformative()==ACLMessage.INFORM_IF){
          ce= getContentManager().extractContent(msg);
          if (ce  instanceof Preferences){
            person1=mA.mediaInform(person1);

            Preferences pref1=(Preferences) ce;
            pref1.setWillForMarriage(getWillForMarriage());
            //gia "oikoiopoihsh" tis listas pou molis stalike!
            pref1.setWhois(person1);
            //kalei tin synartisi protimisis  SYNARTISI PROTIMISIS
            float[] a=preferenceMethod(pref1);

            //kanei sort ta apotelesmata kai epistrefei array
            int[] sortedList=sorting(a);

            List tempList=new ArrayList();
//            System.out.println(p1.getPreferenceList());

            for(int i=0;i<pref1.getPreferences().size();i++){
              tempList.add(pref1.getPreferences().get(sortedList[i]));
            }
//            System.out.println(tempC);
            //allagi sto preference list tou praktora
            pref1.setPreferences(tempList);

            ACLMessage forsmpmsg=new ACLMessage(ACLMessage.INFORM_IF);
            forsmpmsg.setLanguage(codec.getName());
            forsmpmsg.setOntology(ontology.getName());
            forsmpmsg.addReceiver(new AID("MatchAgent",AID.ISLOCALNAME ));
            try{
              manager1.fillContent(forsmpmsg, pref1);
            }catch(CodecException cex){
              cex.printStackTrace();
            }
//            System.out.println("SA: "+forsmpmsg);
            send(forsmpmsg);
          }





        }else if (msg.getPerformative()==ACLMessage.PROPOSE){
            Families familyInfo=new Families();
            person1=mA.mediaInform(person1);
            familyInfo.setFather(person1);
            ACLMessage familyTalk = new ACLMessage(ACLMessage.REQUEST);
            familyTalk.setOntology(ontology.getName());
            familyTalk.setLanguage(codec.getName());
            familyTalk.addReceiver(new AID(msg.getContent().toString(),
                                           AID.ISLOCALNAME));
            manager1.fillContent(familyTalk, familyInfo);
            send(familyTalk);


        }else if (msg.getPerformative()==ACLMessage.REQUEST){
          ce= getContentManager().extractContent(msg);
          if (ce  instanceof Families){
            Families newFamily = (Families) ce;
            person1=mA.mediaInform(person1);
            newFamily.setMother(person1);
            Families familyPack=setFamilyPlanning(newFamily);
            //asostoli minimatos ston FamilyAgent
            ACLMessage infoFamilyAgent = new ACLMessage(ACLMessage.INFORM);
            infoFamilyAgent.addReceiver(new AID("FamilyAgent",AID.ISLOCALNAME));
            infoFamilyAgent.setOntology(ontology.getName());
            infoFamilyAgent.setLanguage(codec.getName());
            manager1.fillContent(infoFamilyAgent,familyPack);
            send(infoFamilyAgent);

          }else{
            this.block();
          }

        }else if (msg.getPerformative()==ACLMessage.AGREE){

        }else if (msg.getPerformative()==ACLMessage.DISCONFIRM){

          doDelete();
        }

        else{  //if acl.inform, if not inform, proceed to else!
          this.block();
        }


      }catch(CodecException ce){
        ce.printStackTrace();

      }catch(OntologyException oe){
        oe.printStackTrace();
      }


    }//end ACTION
  }


  class InitializeBehaviour
      extends OneShotBehaviour {
    public InitializeBehaviour(Agent agent) {
      super(agent);
    }
    public void action() {
      ACLMessage msg= new ACLMessage(ACLMessage.CONFIRM);
      msg.addReceiver(new AID("SuperAgent", AID.ISLOCALNAME));
      msg.setLanguage(codec.getName());
      msg.setOntology(ontology.getName());
      Human human=new Human();
      human.setCharacteristics(person1);
      try{
        manager1.fillContent(msg, human);
      }catch(Exception ex){
        ex.printStackTrace();
      }
      send(msg);
    } //end action()
  }

  /**
   * METHODOS GIA PROGRESS BAR KAI SETTEXMESSAGE
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


  private Families setFamilyPlanning(Families family2){//(Description m, Description f){
//    List l=new ArrayList();
    Description m=family2.getFather();
    Description f=family2.getMother();

    int fGene=f.getBitGene();
    int mGene=m.getBitGene();
    int noOfChildren=0;
    float meanChildBirth=MenuFrame.settings.getfertilityRatio();

    Chromosoma chr=new Chromosoma();
    int motherAge=SuperAgent.epoch-f.getEpochOfBirth();
    boolean reproductives=chr.reprAbilityGene(fGene)==0&&chr.reprAbilityGene(mGene)==0;
    boolean mAge=motherAge<50;
    boolean previousRelation=m.getFromFamilyID()!=f.getFromFamilyID()||f.getFromFamilyID()==0;


    //check if pDisease are able to reproduce
    if(reproductives&&mAge&&previousRelation){

      //calculation of children based on demographic data
      //using NORMAL DISTRIBUTION
      noOfChildren = (int)Math.round(NormalRandom.nextGaussian()+meanChildBirth);
      if(noOfChildren<0)noOfChildren=0;

      //to caluclate genes and birthepoch
      for(int i=0;i<noOfChildren;i++){
        Description thisChild=new Description();

        //children between a 5 year gap, where t=marriage epoch+randomEpochsToBirth
        int randomEpochsToBirth=(int)(6*Math.random());

        thisChild.setEpochOfBirth(randomEpochsToBirth+SuperAgent.epoch+1);

        //total age to live
        int expectedAgeToLive;
        //chromosoma method DO EM ALL METHOD
        int newGeneBit=chr.doCrossover(mGene,fGene);

        thisChild.setBitGene(newGeneBit);

        //giaepilogi xronwn zohs
        if(chr.healthGene(newGeneBit)==1&&!MenuFrame.settings.getAffectDth()){
          expectedAgeToLive=(int)(10*Math.random()*Math.pow(-1,Math.round(Math.random())))+
              MenuFrame.settings.getmeanAgeEffection()+MenuFrame.settings.getlifeYearsExpectancyDisease();
        }else{
          expectedAgeToLive=calculateRandomAge(chr.healthGene(newGeneBit));
        }

        thisChild.setEpochsToLive(expectedAgeToLive);

        //sex
        if(chr.sexGene(thisChild.getBitGene())==1){
          thisChild.setSex("Male");
        }else{
          thisChild.setSex("Female");
        }

        //status of health
        if(chr.healthGene(thisChild.getBitGene())==0){
          if(chr.mutationGene(thisChild.getBitGene())>0){
            thisChild.setHealth("Carrier");
          }else{
            thisChild.setHealth("Healthy");
          }
        }else{
         thisChild.setHealth("Diseased");
        }


        family2.addChildren(thisChild);
//        System.out.println(randomEpochsToBirth+" epochs to be birthed\n"+expectedAgeToLive+" life expectancy\n"+Integer.toBinaryString(newGeneBit));

      }
//      System.out.println("Male:"+Integer.toBinaryString(mGene)+"\nFemale:"+Integer.toBinaryString(fGene)+"\n--------------------------------------------------------");
    }
    return family2;
  }

  private float getWillForMarriage(){
    float will;
    int age=SuperAgent.epoch-person1.getEpochOfBirth();
    int mMariageAge;
    if(person1.getSex().startsWith("Male")){
       mMariageAge=28+(int)NormalRandom.nextGaussian();
    }else{
      mMariageAge=24+(int)NormalRandom.nextGaussian();
    }

    if(age>mMariageAge){
      will=1;
    }else{
      will=(float)(age-MenuFrame.settings.getlegalMarriageAge())/(float)(mMariageAge-MenuFrame.settings.getlegalMarriageAge());
    }

    return will;
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



}


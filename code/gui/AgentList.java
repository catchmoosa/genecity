package genecity.gui;


/**
 * <p>Title: AgentList</p>
 * <p>Description: Object to help carry Data </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

import jade.util.leap.*;
import genecity.agentCommunication.*;
import genecity.SuperAgent;

public class AgentList {

  private Description d;
  private boolean underAge;
  private int diesAt;
  private int LAST_KNOWN_DEATH_INDEX=0;

  private List list=new ArrayList();
  private List deathList=new ArrayList();
  private List birthList=new ArrayList();
  private List unbornList=new ArrayList();
  private int countBirths=0;
  private float all=0;
  public AgentList() {
  }

  public void addAgent(Description d1){
    list.add(d1);
    diesAt=d1.getEpochOfBirth()+d1.getEpochsToLive();
    deathList.add(new Integer(diesAt));
    birthList.add(new Integer(d1.getEpochOfBirth()));
  }

  public Description description(int x){
    return (Description)list.get(x);
  }

  public int getDeath(int i){
    return Integer.parseInt(deathList.get(i).toString());
  }

  public int getBirth(int i){
    return Integer.parseInt(birthList.get(i).toString());
  }

  public List createAgesList(){
    List a=aliveList();
    List distributionAges=new ArrayList();
    float[] ages=new float[9];
    for(int i=0;i<aliveList().size();i++){
      int age=SuperAgent.epoch-((Description)a.get(i)).getEpochOfBirth();
      if(age==0){countBirths++;}
      if(age>=0){
        if (age < 15) {

          ages[0]++;
        }
        else if (age < 65) {
          ages[1]++;
        }
        else{
          ages[2]++;
        }
      }
    }
    all=ages[0]+ages[1]+ages[2];
    distributionAges.add(new Float(100*ages[0]/all));
    distributionAges.add(new Float(100*ages[1]/all));
    distributionAges.add(new Float(100*ages[2]/all));
    return distributionAges;
  }

  public float getBirths(){
    createAgesList();
    return 1000*(float)countBirths/all;
  }




  public List aliveList(){
    List aList=new ArrayList();
    boolean flag=true;
    for(int i=LAST_KNOWN_DEATH_INDEX;i<list.size();i++){

      if(flag=true&&i>0&&getDeath(i)<SuperAgent.epoch&&getDeath(i-1)<SuperAgent.epoch){
        flag=false;
        LAST_KNOWN_DEATH_INDEX=i;
      }

      if(getDeath(i)>SuperAgent.epoch&&getBirth(i)<=SuperAgent.epoch){
       aList.add(description(i));
     }
    }

    return aList;
  }

  public void getDeathsThisEpoch(){

  }

  public void getBirthsThisEpoch(){

  }

  public int getCurrentAge(){
    return SuperAgent.epoch-d.getEpochOfBirth();
  }

  public Description getDescription(){
    return d;
  }





}
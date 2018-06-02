package genecity;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import genecity.gui.MenuFrame;

/**
 * <p>Title: Settings</p>
 * <p>Description: Provide Methods for Manipulating Settings </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class Settings {


  private int beginInformationDegree;
  private float prebirthControlAbortion;
  private int agentMateVision;
  private float fertilityRatio;
  private float marriageOverPopulation;
 private float ageDifferenceCouples;
 private int lifeSpan;
 private int legalMarriageAge;
 private int agentPopulation;
 private String diseaseName;
 private float realMutationRate;
 private int conditionPhenotype;
 private int methodTransmittion;
 private int patientsOverPopulation;
 private int meanAgeEffection;
 private int lifeYearsExpectancyDisease;
 private int reproductionAbilityPerc;
 private boolean affectDth;
 private boolean affectReproduction;
 private boolean dominantAutosomatic;
 private int diseaseOverCarriers;
 private int CELL_EXPAND=50;
 private long startTime = 0L;






   /**
    * grid's vertical dimension
    */
   private int X;
  /**
   * grid's horizontal dimension
   */
  private int Y;
  /**
   * initial population
   */
  private int population;
  /**
   * number of epochs after which food reapears on the same position on grid
   */
  private int foodRefreshRate;
  /**
   * probability of a food to be seen as a trap by an agent and the opposite
   */
  private int visionError;
  /**
   * default value of food cells on grid
   */
  private int FOOD_DEFAULT;
  /**
   * default value of obstacle cells on grid
   */
  private int OBSTACLES_DEFAULT;
  /**
   * default value of trap cells on grid
   */
  private int TRAPS_DEFAULT;
  /**
   * maximum value of food cells on grid
   */
  private int FOOD_MAX;
  /**
   * maximum value of obstacle cells on grid
   */
  private int OBSTACLES_MAX;
  /**
   * maximum value of trap cells on grid
   */
  private int TRAPS_MAX;
  /**
   * number of food cells in grid
   */
  private int food;
  /**
   * number of obstacle cells in grid
   */
  private int obstacles;
  /**
   * number of trap cells in grid
   */
  private int traps;

  //Agent Settings
  //**************

   /**
    * initial agent energy
    */
   private int energy;
  /**
   * number of steps after which agents loose +1 energy units for motion
   */
  private int ageingRate;
  /**
   * the number of rules an agent can store
   */
  private int numberOfRules;
  /**
   * the number of steps every which genetic algorithm is fired
   */
  private int gaRate;
  /**
   * the number of steps every which two agents can communicate
   */
  private int communicationRate;
  /**
   * the percentage of rules which will be exchanged betwenn two agents
   */
  private int exchangedRulesPercentage;
  /**
   * constructor applies default settings
   */
  public Settings() {
    defaultAgentSettings();
    defaultEnvironmentSettings();
    //startTime = System.currentTimeMillis();
  }

  /**
   * constructor specifying settings
   * @param s the settings
   */
  public Settings(Settings s) {
    setEnvironmentSettings(s.getX(), s.getY(), s.getPopulation(),
                           s.getFoodRefreshRate(), s.getVisionError(),
                           s.getFood(), s.getObstacles(), s.getTraps());
    setAgentSettings(s.getEnergy(), s.getAgeingRate(), s.getNumberOfRules(),
                     s.getGARate(), s.getCommunicationRate(),
                     s.getExchangedRulesPercentage());
  }

  /**
   * constructor specifying settings file
   * @param file the seetings file
   */
  public Settings(File file) {
    try {
      FileReader fileIn = new FileReader(file);
      LineNumberReader in = new LineNumberReader(fileIn);
      String filetag = in.readLine();
      this.affectDth = in.readLine().startsWith("true");
      this.affectReproduction= in.readLine().startsWith("true");
      this.ageDifferenceCouples=Float.parseFloat(in.readLine());
      this.agentMateVision=Integer.parseInt(in.readLine());
      this.agentPopulation=Integer.parseInt(in.readLine());
      this.beginInformationDegree=Integer.parseInt(in.readLine());
      this.conditionPhenotype=Integer.parseInt(in.readLine());
      this.diseaseName=in.readLine();
      this.fertilityRatio=Float.parseFloat(in.readLine());
      this.legalMarriageAge=Integer.parseInt(in.readLine());
      this.lifeSpan=Integer.parseInt(in.readLine());
      this.lifeYearsExpectancyDisease=Integer.parseInt(in.readLine());
      this.marriageOverPopulation=Float.parseFloat(in.readLine());
      this.methodTransmittion=Integer.parseInt(in.readLine());
      this.meanAgeEffection=Integer.parseInt(in.readLine());
      this.patientsOverPopulation=Integer.parseInt(in.readLine());
      this.prebirthControlAbortion=Float.parseFloat(in.readLine());
      this.realMutationRate=Float.parseFloat(in.readLine());
      this.reproductionAbilityPerc=Integer.parseInt(in.readLine());
      this.diseaseOverCarriers=Integer.parseInt(in.readLine());
      this.dominantAutosomatic=in.readLine().startsWith("true");
      in.close();
      fileIn.close();
      this.X = (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND; ///////////////////////////////////////////////// 40 x 40 /////////////////
      this.Y = (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND;

    }
    catch (IOException ex) {
    }
  }

  /**
   * gets grid's vertical dimension
   * @return grid's vertical dimension
   */
  public int getX() {
    return (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND;
  }

  public int getBeginInformationDegree(){
    return beginInformationDegree;
  }

  public float getPrebirthControlAbortion(){
    return prebirthControlAbortion;
  }

  public int getagentMateVision(){
    return agentMateVision;
  }

  public float getfertilityRatio(){
    return fertilityRatio;
  }

  public float getmarriageOverPopulation(){
    return marriageOverPopulation;
  }

  public float getageDifferenceCouples(){
    return ageDifferenceCouples;
  }

  public int getlifeSpan(){
    return lifeSpan;
  }

  public int getlegalMarriageAge(){
    return legalMarriageAge;
  }


  public int getagentPopulation(){
    return agentPopulation;
  }

  public String getDiseaseName(){
    return diseaseName;
  }

  public float getrealMutationRate(){
    return realMutationRate;
  }

  public int getCondition(){
    return conditionPhenotype;
  }

  public int getMethodTransmittion(){
    return methodTransmittion;
  }

  public int getpatientsOverPopulation(){
    return patientsOverPopulation;
  }

  public int getmeanAgeEffection(){
    return meanAgeEffection;
  }

  public int getlifeYearsExpectancyDisease(){
    return lifeYearsExpectancyDisease;
  }

  public int getreproductionAbilityPerc(){
    return reproductionAbilityPerc;
  }

  public boolean getAffectDth(){
    return affectDth;
  }

  public boolean getAffectReproduction(){
    return affectReproduction;
  }

  public boolean getDominantAutosomatic(){
    return dominantAutosomatic;
  }



  public int getPopulationHealthyPeople(){
    return (this.agentPopulation-this.agentPopulation*this.patientsOverPopulation/100);
  }

  public int getPopulationCarriersNotDiseased(){
    return (int)((float)this.agentPopulation*(float)this.patientsOverPopulation/100.0*(1.0-(float)this.diseaseOverCarriers/100));
  }


  //in the case of x-chromosome transmition
  public int getPopulationWomanCarriers(){
    int a;
    if((this.agentPopulation/2%2)==0){
      a=this.agentPopulation/2; //woman population
    }else{
      a=(this.agentPopulation+1)/2; //woman population
    }
    a=(a*this.patientsOverPopulation)/100; //arithmos gynaikwn forewn
    return a;
  }

  public int getPopulationMalesDiseased(){
    int a;
    if((this.agentPopulation/2%2)==0){
      a=this.agentPopulation/2; //man population
    }else{
      a=(this.agentPopulation-1)/2; //man population
    }
    a=(a*this.diseaseOverCarriers)/100; //arithmos andrwn arrostwn
    return a;
  }


  public int getDiseaseOverCarriers(){
    return diseaseOverCarriers;
  }

  public long getSystemTimeStart(){
    return startTime = 0L;
  }





////////////////////////

  public void setBeginInformationDegree(int x){
  beginInformationDegree=x;
}

public void setPrebirthControlAbortion(float x){
  prebirthControlAbortion=x;
}

public void setagentMateVision(int x){
  agentMateVision=x;
}

public void setfertilityRatio(float x){
  fertilityRatio=x;
}

public void  setmarriageOverPopulation(float x){
  marriageOverPopulation=x;
}

public void setageDifferenceCouples(float x){
  ageDifferenceCouples=x;
}

public void setlifeSpan(int x){
  lifeSpan=x;
}

public void setlegalMarriageAge(int x){
  legalMarriageAge=x;
}

public void setagentPopulation(int x){
  agentPopulation=x;
}

public void setDiseaseName(String x){
  diseaseName=x;
}

public void setrealMutationRate(float x){
  realMutationRate=x;
}

public void setCondition(int x){
  conditionPhenotype=x;
}

public void setMethodTransmittion(int x){
  methodTransmittion=x;
}

public void  setpatientsOverPopulation(int x){
  patientsOverPopulation=x;
}

public void setDiseaseOverCarriers(int x){
  diseaseOverCarriers=x;
}

public void setmeanAgeEffection(int x){
  meanAgeEffection=x;
}

public void setlifeYearsExpectancyDisease(int x){
  lifeYearsExpectancyDisease=x;
}

public void setreproductionAbilityPerc(int x){
  reproductionAbilityPerc=x;
}

public void setAffectDth(boolean x){
  affectDth=x;
}

public void setAffectReproduction(boolean x){
  affectReproduction=x;
}

public void setDominantAutosomatic(boolean x){
  dominantAutosomatic=x;
}

























  /**
   * sets grid's vertical dimension
   * @param x grid's new vertical dimension
   */
  public void setX(int x) {
    X = x;
  }

  /**
   * gets grid's horizontal dimension
   * @return grid's horizontal dimension
   */
  public int getY() {
    //(int)Math.sqrt(this.agentPopulation)+5
    return (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND;
  }

  /**
   * sets grid's horizontal dimension
   * @param y grid's new horizontal dimension
   */
  public void setY(int y) {
    Y = y;
  }

  /**
   * gets intitial population
   * @return intitial population
   */
  public int getPopulation() {
    return population;
  }

  /**
   * sets initial population
   * @param p new intitial population
   */
  public void setPopulation(int p) {
    population = p;
  }

  /**
   * gets refresh rate of food cells
   * @return the refresh rate of food cells
   */
  public int getFoodRefreshRate() {
    return foodRefreshRate;
  }

  /**
   * sets refresh rate of food cells
   * @param r the new refresh rate of food cells
   */
  public void setFoodRefreshRate(int r) {
    foodRefreshRate = r;
  }

  /**
   * gets vision error of environment
   * @return the vision error of environment
   */
  public int getVisionError() {
    return visionError;
  }

  /**
   * set vision error of environment
   * @param v the new vision error of environment
   */
  public void setVisionError(int v) {
    visionError = v;
  }

  /**
   * gets default value of food
   * @return the default value of food
   */
  public int getFOOD_DEFAULT() {
    return FOOD_DEFAULT;
  }

  /**
   * sets default value of food
   */
  public void setFOOD_DEFAULT() {
    FOOD_DEFAULT = (int) (X * Y * 7 / 100);
  }

  /**
   * gets default value of obstacels
   * @return the default value of obstacles
   */
  public int getOBSTACLES_DEFAULT() {
    return OBSTACLES_DEFAULT;
  }

  /**
   * sets default value of food
   */
  public void setOBSTACLES_DEFAULT() {
    OBSTACLES_DEFAULT = (int) (X * Y * 15 / 100);
  }

  /**
   * gets default value of traps
   * @return the default value of food
   */
  public int getTRAPS_DEFAULT() {
    return TRAPS_DEFAULT;
  }

  /**
   * sets default value of food
   */
  public void setTRAPS_DEFAULT() {
    TRAPS_DEFAULT = (int) (X * Y * 0.625 / 100);
  }

  /**
   * gets maximum value of food
   * @return the maximum value of food
   */
  public int getFOOD_MAX() {
    return FOOD_MAX;
  }

  /**
   * sets maximum value of food
   */
  public void setFOOD_MAX() {
    FOOD_MAX = (int) (X * Y * 30 / 100);
  }

  /**
   * gets maximum value of obstacles
   * @return the maximum value of obstacles
   */
  public int getOBSTACLES_MAX() {
    return OBSTACLES_MAX;
  }

  /**
   * sets maximum value of obstacles
   */
  public void setOBSTACLES_MAX() {
    OBSTACLES_MAX = (int) (X * Y * 50 / 100);
  }

  /**
   * gets maximum value of traps
   * @return the maximum value of traps
   */
  public int getTRAPS_MAX() {
    return TRAPS_MAX;
  }

  /**
   * sets maximum value of traps
   */
  public void setTRAPS_MAX() {
    TRAPS_MAX = (int) (X * Y * 20 / 100);
  }

  /**
   * get value of food
   * @return the value of food
   */
  public int getFood() {
    return food;
  }

  /**
   * sets vlaue of food
   * @param f the new value of food
   */
  public void setFood(int f) {
    food = f;
  }

  /**
   * gets value of obstacles
   * @return the value of obstacles
   */
  public int getObstacles() {
    return obstacles;
  }

  /**
   * sets value of obstacles
   * @param o the new value of obstacles
   */
  public void setObstacles(int o) {
    obstacles = o;
  }

  /**
   * gets value of traps
   * @return the value of traps
   */
  public int getTraps() {
    return traps;
  }

  /**
   * ger value of traps
   * @param t the value of traps
   */
  public void setTraps(int t) {
    traps = t;
  }

  /**
   * gets the value of energy
   * @return the value of energy
   */
  public int getEnergy() {
    return energy;
  }

  /**
   * sets the value of energy
   * @param e the new value of energy
   */
  public void setEnergy(int e) {
    energy = e;
  }

  /**
   * gets the value of ageing rate
   * @return the value of ageing rate
   */
  public int getAgeingRate() {
    return ageingRate;
  }

  /**
   * sets the value of ageing rate
   * @param a the new value of ageing rate
   */
  public void setAgeingRate(int a) {
    ageingRate = a;
  }

  /**
   * gets the value of number of rules
   * @return the value of number of rules
   */
  public int getNumberOfRules() {
    return numberOfRules;
  }

  /**
   * sets the value of number of rules
   * @param nr the new value of number of rules
   */
  public void setNumberOfRules(int nr) {
    numberOfRules = nr;
  }

  /**
   * gets the value of genetic algorithms rate
   * @return the value of genetic algorithms rate
   */
  public int getGARate() {
    return gaRate;
  }

  /**
   * sets the value of genetic algorithms rate
   * @param ga the new value of genetic algorithms rate
   */
  public void setGArate(int ga) {
    gaRate = ga;
  }

  /**
   * gets the value of communication rate
   * @return the value of genetic algorithms rate
   */
  public int getCommunicationRate() {
    return communicationRate;
  }

  /**
   * sets the value of genetic algorithms rate
   * @param c the new value of genetic algorithms rate
   */
  public void setCommunicationRate(int c) {
    communicationRate = c;
  }

  /**
   * gets the value of exchanged rules percentage
   * @return the value of genetic algorithms rate
   */
  public int getExchangedRulesPercentage() {
    return exchangedRulesPercentage;
  }

  /**
   * sets the value of genetic algorithms rate
   * @param erp the new value of genetic algorithms rate
   */
  public void setExchangedRulesPercentage(int erp) {
    exchangedRulesPercentage = erp;
  }

  /**
   * sets the values for environment settings
   * @param x grid's vertical coordinate
   * @param y grid's horizontal coordinate
   * @param population initial population
   * @param foodRefreshRate number of epochs after which food reapears on the same position on grid
   * @param visionError probability of a food to be seen as a trap by an agent and the opposite
   * @param food number of food cells in grid
   * @param obstacles number of obstacle cells in grid
   * @param traps number of trap cells in grid
   */
  public void setEnvironmentSettings(int x, int y, int population,
                                     int foodRefreshRate, int visionError,
                                     int food, int obstacles, int traps) {
//Grid Dimensions
    X = x;
    Y = y;
//Environmental Attributes
    this.population = population;
    this.foodRefreshRate = foodRefreshRate;
    this.visionError = visionError;
//Contents
    FOOD_DEFAULT = (int) (X * Y * 7 / 100);
    OBSTACLES_DEFAULT = (int) (X * Y * 15 / 100);
    TRAPS_DEFAULT = (int) (X * Y * 0.625 / 100);
    FOOD_MAX = (int) (X * Y * 30 / 100);
    OBSTACLES_MAX = (int) (X * Y * 50 / 100);
    TRAPS_MAX = (int) (X * Y * 20 / 100);

    this.food = food;
    this.obstacles = obstacles;
    this.traps = traps;
  }

  /**
   * sets the values for agent settings
   * @param energy initial agent energy
   * @param ageingRate number of steps after which agents loose +1 energy units for motion
   * @param numberOfRules the number of rules an agent can store
   * @param gaRate the number of steps every which genetic algorithm is fired
   * @param communicationRate the number of steps every which two agents can communicate
   * @param exchangedRulesPercentagethe percentage of rules which will be exchanged betwenn two agents
   */
  public void setAgentSettings(int energy, int ageingRate, int numberOfRules,
                               int gaRate, int communicationRate,
                               int exchangedRulesPercentage) {
//Agent Attributes
    this.energy = energy;
    this.ageingRate = ageingRate;
//Knowledge Attributes
    this.numberOfRules = numberOfRules;
    this.gaRate = gaRate;
//Communication Attributes
    this.communicationRate = communicationRate;
    this.exchangedRulesPercentage = exchangedRulesPercentage;
  }

  /**
   * sets the default values for environment settings
   */
  public void defaultEnvironmentSettings() {
// General Settings
    this.CELL_EXPAND=50;
    this.beginInformationDegree=0;
    this.prebirthControlAbortion=0;
    this.agentMateVision=30;
    this.fertilityRatio=(float)(2.5);
    this.marriageOverPopulation=30;
    this.ageDifferenceCouples=4;
    this.lifeSpan=75;
    this.legalMarriageAge=18;
    this.agentPopulation=50;
    this.diseaseName="Familial Mediterranian Fever -FMF";
    this.realMutationRate=(float)(0.003);
    this.conditionPhenotype=0; //NORMAL
    this.methodTransmittion=0;
    this.dominantAutosomatic=false;
    this.patientsOverPopulation=15;
    this.diseaseOverCarriers=50;
    this.meanAgeEffection=20;
    this.lifeYearsExpectancyDisease=40;
    this.reproductionAbilityPerc=100;
    this.affectDth=true;
    this.affectReproduction=true;

//Grid Dimensions
    X = (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND; ///////////////////////////////////////////////// 40 x 40 /////////////////
    Y = (int)Math.sqrt(this.agentPopulation)+CELL_EXPAND;






//Environmental Attributes
    population = 5;
    foodRefreshRate = 30;
    visionError = 1;
//Contents
    FOOD_DEFAULT = (int) (X * Y * 7 / 100);
    OBSTACLES_DEFAULT = (int) (X * Y * 15 / 100);
    TRAPS_DEFAULT = (int) (X * Y * 0.625 / 100);
    FOOD_MAX = (int) (X * Y * 30 / 100);
    OBSTACLES_MAX = (int) (X * Y * 50 / 100);
    TRAPS_MAX = (int) (X * Y * 20 / 100);

    food = FOOD_DEFAULT;
    obstacles = OBSTACLES_DEFAULT;
    traps = TRAPS_DEFAULT;
  }

  /**
   * sets the default values for agent settings
   */
  public void defaultAgentSettings() {
//Agent Attributes
    energy = 500;
    ageingRate = 3000;
//Knowledge Attributes
    numberOfRules = 3000;
    gaRate = 200;
//Communication Attributes
    communicationRate = 200;
    exchangedRulesPercentage = 10;
  }

}

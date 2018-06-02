package genecity.gui;

import java.util.Arrays;
import java.util.Vector;
import java.awt.Point;
import java.io.*;
import genecity.agentCommunication.*;
//import ecosystem.maze.Maze;
import genecity.Settings;


/**
 * <p>Title: Grid</p>
 * <p>Description: Basic operations in Grid enviroment</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class Grid {

//  public int popDis=MenuFrame.settings.getPopulationDiseasePeople();
//  public int popHea=MenuFrame.settings.getPopulationHealthyPeople();


  // 2D matrix containing the grid
  private int[][] p;
  private int[][] enabledAgentsMatrix;
  private long[][] allAgentsMatrix;
  // vertical dimension of grid
  private int d1;
  // horizontal dimension of grid
  private int d2;
  public final int BLANK = 0;
  public final int FOOD = 1;
  public final int TRAP = 2;
  public final int OBSTACLE = 3;
  public final int AGENT = 4;
  public final int HMAN=1;
  public final int HWMAN=2;
  public final int TMAN=3;
  public final int TWMAN=4;
  public final int DMAN=5;
  public final int DWMAN=6;


//  public double VISION_ERROR = MainFrame.settings.getVisionError();
  final int MAX_GRID_SIZE = 40;
  int maxGridSizeX;
  int maxGridSizeY;
  // 2D matrix with the names of the potential agents in each position
  private Object[][] nameMap;
  // 2D matrix with the energy of the potential agents in each position
  private int[][] energyMap;
  // 2D matrix with 0s in each position containing food
  //               -2s in each position containing trap
  //               -1s in each position not containing food
  //                #s any other positive value representing the number of epochs when the food should be refreshed
  private int[][] foodMap;
  // each row of the folowing matrix contains the difference of x and y coordinate
  // of a position in the vision vector and the current position
  int[][] nav = {
      {
       -3, -3}
      , {
       -1, -2}
      , {
      0, -2}
      , {
      1, -2}
      , {
      2, -2}
      , {
       -2, -1}
      , {
       -1, -1}
      , {
      0, -1}
      , {
      1, -1}
      , {
      2, -1}
      , {
       -2, 0}
      , {
       -1, 0}
      , {
      1, 0}
      , {
      2, 0}
      , {
       -2, 1}
      , {
       -1, 1}
      , {
      0, 1}
      , {
      1, 1}
      , {
      2, 1}
      , {
       -2, 2}
      , {
       -1, 2}
      , {
      0, 2}
      , {
      1, 2}
      , {
      2, 2}
  };

  /**
   * Constructor
   * Sets the area dimensions and clear all positions
   */
  public Grid() {
    d1 = MenuFrame.settings.getX();
    d2 = MenuFrame.settings.getY();

    p = new int[d1][d2];
    enabledAgentsMatrix=new int[d1][d2];
    allAgentsMatrix=new long[d1][d2];
    nameMap = new Object[d1 + 1][d2 + 1];
    energyMap = new int[d1 + 1][d2 + 1];
    foodMap = new int[d1 + 1][d2 + 1];

    if (d1 < MAX_GRID_SIZE) {
      maxGridSizeX = d1;
    }
    else {
      maxGridSizeX = MAX_GRID_SIZE;
    }
    if (d2 < MAX_GRID_SIZE) {
      maxGridSizeY = d2;
    }
    else {
      maxGridSizeY = MAX_GRID_SIZE;
    }
// DELETE???
    // initialize p matrix
    for (int i = 0; i < d1; i++) {
      for (int j = 0; j < d2; j++) {
        p[i][j] = BLANK;
      }
    }
    // initialize foodMap
    for (int i = 0; i < d1; i++) {
      for (int j = 0; j < d2; j++) {
        foodMap[i][j] = -1;
      }
    }
    clearArea();
    //fillArea(); //GIA NA EVAZE PRIN TIN ARXIKOPOIHSH EIKONIDIA PRAKTORWN TYXAIA!



  } //end of constructor

  /**
   * Constructor
   * load grid from file
   * @param file the file that contains the grid
   */
  public Grid(File file) {
    try {
      FileReader fileIn = new FileReader(file);
      LineNumberReader in = new LineNumberReader(fileIn);
      String filetag = in.readLine();
      d1 = Integer.parseInt(in.readLine());
      d2 = Integer.parseInt(in.readLine());
      p = new int[d1][d2];
      for (int i = 0; i < d1; i++) {
        for (int j = 0; j < d1; j++) {
          p[i][j] = Integer.parseInt(in.readLine());
        }
      }
      in.close();
      fileIn.close();
    }
    catch (IOException ex) {
    }
    nameMap = new Description[d1 + 1][d2 + 1];
    energyMap = new int[d1 + 1][d2 + 1];
    foodMap = new int[d1 + 1][d2 + 1];

    if (d1 < MAX_GRID_SIZE) {
      maxGridSizeX = d1;
    }
    else {
      maxGridSizeX = MAX_GRID_SIZE;
    }
    if (d2 < MAX_GRID_SIZE) {
      maxGridSizeY = d2;
    }
    else {
      maxGridSizeY = MAX_GRID_SIZE;
    }

    // initialize foodMap
    for (int i = 0; i < d1; i++) {
      for (int j = 0; j < d2; j++) {
        foodMap[i][j] = -1;
      }
    }
  } //end of file constructor

  /**
   * Fills p(x,y) with food
   * p(x,y)=1
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void fillFood(int x, int y) {
    if (p[x - 1][y - 1] == BLANK) {
      p[x - 1][y - 1] = FOOD;
    }
  }

  /**
   * Fills p(x,y) with trap
   * p(x,y)=2
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void fillTrap(int x, int y) {
    if (p[x - 1][y - 1] == BLANK) {
      p[x - 1][y - 1] = TRAP;
    }
  }

  /**
   * Fills p(x,y) with obstacle
   * p(x,y)=3
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void fillObstacle(int x, int y) {
    if (p[x - 1][y - 1] == BLANK) {
      p[x - 1][y - 1] =5; //OBSTACLE;///////////////////////////////////////////////////////
    }
  }



  /**
   * Fills p(x,y) with agent
   * p(x,y)=4
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void fillAgent(int x, int y, int state) {
    if (p[x - 1][y - 1] == BLANK) {
      p[x - 1][y - 1] = state;
    }
  }



  /**
   * fillAgents //////////////////////////////////////////////////////DIKI MOU ///////////////
   * @param x
   * @param y
   */
  public void fillAgents(int x, int y, int sex, int diseaseState) {

    if (sex==0){ //female
      if(diseaseState>0){
        if(diseaseState==1){
          p[x - 1][y - 1] = 3;
        } else{
          p[x - 1][y - 1] = 5;
        }
      } else{
        p[x - 1][y - 1] = 1;
      }
    }
    else if(sex==1){ //male
      if(diseaseState>0){
        if(diseaseState==1){
          p[x - 1][y - 1] = 4;
        }else{
          p[x - 1][y - 1] = 6;
        }
      } else{
        p[x - 1][y - 1] = 2;
      }
    }else if(sex==9){ //family
      p[x - 1][y - 1] =diseaseState*10+10; //apo 10-60
    }else if(sex==1000||sex==1001){ //dead
      p[x-1][y-1]=sex;
    }

  }


  public void fillHealthyAgents(int x, int y){
    float rad= (float)Math.random();

    if (p[x - 1][y - 1] == BLANK&rad>=0.5) {
      p[x - 1][y - 1] = 1;
    }
    else if(p[x - 1][y - 1] == BLANK){
      p[x - 1][y - 1] = 2;
    }
  }

  public void fillDiseaseAgents(int x, int y){
    float rad= (float)Math.random();

    if (p[x - 1][y - 1] == BLANK&rad>=0.5) {
      p[x - 1][y - 1] = 3;
    }
    else if(p[x - 1][y - 1] == BLANK){
      p[x - 1][y - 1] = 4;
    }

  }



  /**
   * set agent name on nameMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @param name agent name
   */
  public void setAgentName(int x, int y, Object obj) {
    if(obj instanceof Description){
      Description des=(Description) obj;
      nameMap[x][y] = des;
    }else if(obj instanceof Families){
      Families fam=(Families) obj;
      nameMap[x][y]=fam;
    }else{
      nameMap[x][y]=null;
    }
  }

  /**
   * get agent name from nameMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @return agent name
   */
  public Object getAgentName(int x, int y) {
    return nameMap[x][y];
  }

  /**
   * set agent energy on energyMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @param energy agent energy
   */
  public void setAgentEnergy(int x, int y, int energy) {
    energyMap[x][y] = energy;
  }

  /**
   * get agent name from energyMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @return agent energy
   */
  public int getAgentEnergy(int x, int y) {
    return energyMap[x][y];
  }

  /**
   * set value on foodMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @param value int value
   */
  public void setFoodMap(int x, int y, int value) {
    foodMap[x - 1][y - 1] = value;
  }

  /**
   * decrement position on foodMap by one
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void decFoodMap(int x, int y) {
    foodMap[x - 1][y - 1] -= 1;
  }

  /**
   * get value from foodMap
   * @param x vertical coordinate
   * @param y horizontal coordinate
   * @return int value
   */
  public int getFoodMap(int x, int y) {
    return foodMap[x - 1][y - 1];
  }

  /**
   * Fills area randomly with 'number' positions of food
   * @param number number of food cells
   */
  public void fillRandomFood(int number) {
    int i;
    int x1, y1;
    for (i = 0; i < number; i++) {

      x1 = 1 + (int) (d1 * Math.random());
      y1 = 1 + (int) (d2 * Math.random());

      // Sun8hkh gia thn epibebaiosh oti to shmeio auto einai keno
      if (getP(x1, y1) == BLANK) {
//        fillFood(x1, y1);
//        setFoodMap(x1, y1, 0);
      }
      // An to shmeio den einai keno tote na mhn auksei8ei to i
      // Edw Thelei prosoxh mh ginei aenaos brogxos(NA ginoun epipleon sun8hkes??)
      else {
        i--;
      }
    }
  }

  /**
   * Fills area randomly with 'number' positions of traps
   * @param number number of trap cells
   */
  public void fillRandomTraps(int number) {
    int i;
    int x1, y1;

    for (i = 0; i < number; i++) {

      x1 = 1 + (int) (d1 * Math.random());
      y1 = 1 + (int) (d2 * Math.random());

      if (getP(x1, y1) == BLANK) {
//        fillTrap(x1, y1);
//        setFoodMap(x1, y1, -2);
      }
      else {
        i--;
      }
    }
  }

  /**
   * Fills area randomly with 'number' positions of obstacles
   * @param number of obstacle cells
   */
  public void fillRandomObstacles(int number) {
    int i;
    int x1, y1;
    for (i = 0; i < 100; i++) {

      x1 = 1 + (int) (d1 * Math.random());
      y1 = 1 + (int) (d2 * Math.random());

      if (getP(x1, y1) == BLANK) {
        fillObstacle(x1, y1);
      }
      else {
        i--;
      }
    }
  }

  public void fillRandomAgents(int number) {
  int i;
  int x1, y1;
  for (i = 0; i <number; i++) {

    x1 = 1 + (int) (d1 * Math.random());
    y1 = 1 + (int) (d2 * Math.random());

    if (getP(x1, y1) == BLANK) {
      fillObstacle(x1, y1);
    }
    else {
      i--;
    }
  }
}

  public void fillRandomHealthyAgents(int number){
    int i;
    int x1, y1;
    for (i = 0; i <number; i++) {

      x1 = 1 + (int) (d1 * Math.random());
      y1 = 1 + (int) (d2 * Math.random());

      if (getP(x1, y1) == BLANK) {
        fillHealthyAgents(x1, y1);
      }
      else {
        i--;
      }
    }
  }

  public void fillRandomDiseaseAgents(int number){
    int i;
    int x1, y1;
    for (i = 0; i <number; i++) {

      x1 = 1 + (int) (d1 * Math.random());
      y1 = 1 + (int) (d2 * Math.random());

      if (getP(x1, y1) == BLANK) {
        fillDiseaseAgents(x1, y1);
      }
      else {
        i--;
      }
    }

  }



  /*
    /**
    * Positions the agent in a random position
    *
       void fillRandomAgent(){
         int x1, y1;
         x1 = 1 + (int)(d1*Math.random());
         y1 = 1 + (int)(d2*Math.random());
         while(getP(x1,y1)!=0){
           x1 = 1 + (int)(d1*Math.random());
           y1 = 1 + (int)(d2*Math.random());
         }
         fillAgent(x1, y1);
       }
    */

   /**
    * Returns the value of p(x,y);
    * @param x horizontal coordinate
    * @param y vertical coordinate
    * @return returns an integer representing the cells content
    */
   public int getP(int x, int y) {
     return p[x - 1][y - 1];
   }

  /**
   * DIKO MOY gia na mou leei kata poso se afti tin diefthinsi einia energopoihmenos o praktoras!
   * @param x
   * @param y
   * @return
   */
  public int getEnabledP(int x, int y){
    return enabledAgentsMatrix[x-1][y-1];
  }
  public void setEnabledP(int x,int y,int z){
    enabledAgentsMatrix[x-1][y-1]=z;
  }


  /*public long getAllAgentsMatrix(int x, int y){
    return allAgentsMatrix[x][y];
  }
*/
 /* public void setAllAgentsMatrix(int x, int y, long z){
    allAgentsMatrix[x-1][y-1]=z;
  }*/

  /////////////////////////////////////////////////////////////////////////

  /////////////////////////////////////////////////


  /**
   * set the value on matrix p
   * @param x horizontal coordinate
   * @param y vertical coordinate
   * @param value int value
   */
  public void setP(int x, int y, int value) {
    p[x - 1][y - 1] = value;
  }

  /**
   * Returns the vertical dimension d1
   * @return returns the vertical dimension
   */
  public int getD1() {
    return d1;
  }

  /**
   * set vertical dimension of grid
   * @param D1 vertical dimension of grid
   */
  public void setD1(int D1) {
    d1 = D1;
  }

  /**
   * Returns the horizontal dimension d2
   * @return returns the horizontal dimension
   */
  public int getD2() {
    return d2;
  }

  /**
   * set horizontal dimension of grid
   * @param D2 horizontal dimension of grid
   */
  public void setD2(int D2) {
    d2 = D2;
  }

  /**
   * Fills the area
   * @param f number of food cells
   * @param t number of trap cells
   * @param o number of obstacle cells
   */
  public void fillArea() {
//    fillRandomDiseaseAgents(MenuFrame.settings.getPopulationDiseasePeople());
//    fillRandomHealthyAgents(MenuFrame.settings.getPopulationHealthyPeople());
  }

  /**
   * Clears the area
   */
  public void clearArea() {
    int i, j;
    for (i = 1; i <= d1; i++) {
      for (j = 1; j <= d2; j++) {
        clearPosition(i, j);
        //setFoodMap(i, j, -1);
      }
    }
  }

  public void clearEnabledMatrix() {
    int i, j;
    for (i = 1; i <= d1; i++) {
      for (j = 1; j <= d2; j++) {
        clearEnabledMatrixPosition(i, j);
      }
    }
  }

  public void clearEnabledMatrixPosition(int x, int y) {
  enabledAgentsMatrix[x - 1][y - 1] = BLANK;
}


  /**
   * Clears x,y position
   * @param x vertical coordinate
   * @param y horizontal coordinate
   */
  public void clearPosition(int x, int y) {
    p[x - 1][y - 1] = BLANK;
  }

  /**
   * construct the vision vector
   * @param x current position vertical coordinate
   * @param y current position horizontal coordinate
   * @return the vison vector
   */
  int[] readVisionVector(int x, int y) {

    int[] visionVector = new int[nav.length];

    for (int i = 0; i < nav.length; i++) {
      //check whether any of vision vector positions is out of bounds
      if (x + nav[i][0] == 0 || x + nav[i][0] == getD1() + 1
          || x + nav[i][0] == -1 || x + nav[i][0] == getD1() + 2
          || y + nav[i][1] == 0 || y + nav[i][1] == getD2() + 1
          || y + nav[i][1] == -1 || y + nav[i][1] == getD2() + 2) {
        visionVector[i] = 3;
      }
      else {
        visionVector[i] = getP(x + nav[i][0], y + nav[i][1]);
      }
    }
    return visionVector;
  }

  /**
   * calculate resource availability
   * @return resource availability
   */
  public double resourceAvailability() {

    double e = 0;
    double totalAmountOfResources = 0;
    double totalHarvestDistance = 0;
    Vector foodPosition = new Vector();
    int[][] grid = new int[getD2()][getD1()];
    int nearestDistance = 0;

    for (int i = 0; i < getD1(); i++) {
      for (int j = 0; j < getD2(); j++) {
        grid[j][i] = p[i][j];
      }
    }

    for (int i = 0; i < maxGridSizeY; i++) {
      for (int j = 0; j < maxGridSizeX; j++) {
        if (grid[i][j] == FOOD) {
          foodPosition.add(new Point(j, i));
          grid[i][j] = BLANK;
        }
      }
    }
    totalAmountOfResources = foodPosition.size();
    if (totalAmountOfResources == 1) {
      return 1;
    }

    do {
      // find nearest neighbour
      nearestDistance = (int) ( (Point) foodPosition.get(0)).
          distance( (Point) foodPosition.get(1));
      // mark nearest neighbour
      int nearestNeighbour = 1;

      for (int i = 2; i < foodPosition.size(); i++) {
        if (nearestDistance < 3) {
          break;
        }
        int distance = (int) ( (Point) foodPosition.get(0)).
            distance( (Point) foodPosition.get(i));
        if (nearestDistance > distance) {
          nearestDistance = distance;
          // mark nearest neighbour
          nearestNeighbour = i;

        }
      }
      if (foodPosition.size() > 2) {
        foodPosition.removeElementAt(0);
        foodPosition.insertElementAt(foodPosition.get(nearestNeighbour - 1), 0);
        foodPosition.removeElementAt(nearestNeighbour);
      }
      else {
        foodPosition.removeElementAt(0);
      }
      totalHarvestDistance += nearestDistance;
    }
    while (foodPosition.size() >= 2);

    e = totalAmountOfResources / totalHarvestDistance;
//    System.out.print("*** resource availability ***"+"\n");
//    System.out.print("total amount of resources: "+totalAmountOfResources+"\n");
//    System.out.print("total harvest distance: "+totalHarvestDistance+"\n");
//    System.out.print("e: "+e+"\n");
    return e;
  }

  /**
   * calculate environmental variety
   * @return environmental variety
   */
  public double environmentalVariety() {
    double f = 0;
    int numberOfDistinctSenseVectors = 0;
    int numberOfNonBlankPositions = 0;
    int numberOfBlankPositions = 0;
    Vector DistinctSenseVectors = new Vector();
    int[] visionVector;
    boolean found = false;

    for (int i = 0; i < maxGridSizeX; i++) {
      for (int j = 0; j < maxGridSizeY; j++) {
        if (p[i][j] == BLANK) {
          visionVector = readVisionVector(i + 1, j + 1);
          found = false;
          for (int k = 0; k < DistinctSenseVectors.size(); k++) {

            int counter = 0;
            for (int l = 0; l < visionVector.length; l++) {
              if ( ( (int[]) DistinctSenseVectors.get(k))[l] == visionVector[l]) {
                ++counter;
              }
              else {
                break;
              }
            }
            if (counter == visionVector.length) {
              found = true;
              break;
            }
            /*
                 if (Arrays.equals( (int[]) DistinctSenseVectors.get(k),visionVector)) {
                          found = true;
                          break;
                        }
             */
          }
          if (!found) {
            DistinctSenseVectors.add(visionVector);
          }
          ++numberOfBlankPositions;
        }
      }
    }

    numberOfDistinctSenseVectors = DistinctSenseVectors.size();
    numberOfNonBlankPositions = maxGridSizeX * maxGridSizeY -
        numberOfBlankPositions;
    f = (double) numberOfDistinctSenseVectors /
        (double) numberOfNonBlankPositions;
//    System.out.print("*** environmental variety ***"+"\n");
//    System.out.print("number of distinct sense vectors: "+numberOfDistinctSenseVectors+"\n");
//    System.out.print("number of nonblank positions: "+numberOfNonBlankPositions+"\n");
//    System.out.print("f: "+f+"\n");
    return f;
  }

  /**
   * calculate environmental reliability
   * @return environmental reliability
   */
  double environmentalReliability() {
    return (1 - (double) MenuFrame.settings.getVisionError() / 100.);
  }

}

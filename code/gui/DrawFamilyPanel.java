package genecity.gui;


import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import genecity.agentCommunication.*;
import genecity.SuperAgent;

/**
 * <p>Title: DrawFamilyPanel</p>
 * <p>Description: Geneological Tree Visulization</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class DrawFamilyPanel
    extends JPanel {

  public int CELL_SIZE = 35;
  private int familyGridSize=500;
  private Families mainFamily=new Families();


  /**
   * default constructor
   */

  public DrawFamilyPanel() {
  }

  /**
   * Draws a grid visualizing the area with its content
   * @param screen the graphics componet to draw on
   */
  public void paint(Graphics screen) {
    int drawCase=0;
    mainFamily=MenuFrame.drawPanelFrame2.family2View;

    //Draw the grid
    for (int i = 0; i <= familyGridSize; i += CELL_SIZE) {
      for (int j = 0; j <= familyGridSize; j += CELL_SIZE) {
        screen.setColor(Color.lightGray); //TO XROMA TOU GRID
        screen.drawLine(i, j, i, familyGridSize);
        screen.drawLine(i, j, familyGridSize, j);
      }
    }
    screen.drawLine(familyGridSize, 0, familyGridSize,
                    familyGridSize);
    screen.drawLine(0, familyGridSize, familyGridSize,
                   familyGridSize);

   //apothikefsi olwn twn oikogeneiwn se ena array
   jade.util.leap.List allFamiliesList= SuperAgent.allFamiliesList;


  Description father=mainFamily.getFather();
  int i=0,j=0;
  if(father.getHealth().startsWith("Diseased")){

    screen.setColor(Color.lightGray);
    screen.fillRect((i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.black);
    screen.drawRect((i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
  }else if(father.getHealth().startsWith("Carrier")){
    screen.setColor(Color.white);
    screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

    screen.setColor(Color.lightGray);
    screen.fillRect((i * CELL_SIZE + 1+CELL_SIZE/2), (j * CELL_SIZE + 1),(CELL_SIZE - 1)/2, CELL_SIZE - 1);

    screen.setColor(Color.BLACK);
    screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.BLACK);
    screen.drawRect((i * CELL_SIZE + 1+CELL_SIZE/2), (j * CELL_SIZE + 1),(CELL_SIZE - 1)/2, CELL_SIZE - 1);
  }else if(father.getHealth().startsWith("Healthy")){
    screen.setColor(Color.white);
    screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.black);
    screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

  }else{ //if father unknown
    screen.setColor(Color.black);
    screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.black);
    screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    father.setName("Unknown");
  }

  i=2;
  j=0;
  Description mother=mainFamily.getMother();
  if(mother.getHealth().startsWith("Diseased")){
    screen.setColor(Color.lightGray);
    screen.fillOval((i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.black);
    screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
  }else if(mother.getHealth().startsWith("Carrier")){
    screen.setColor(Color.white);
    screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

    screen.setColor(Color.lightGray);
    screen.fillOval((i * CELL_SIZE + 1 + (CELL_SIZE/2)/2), (j * CELL_SIZE + 1+ (CELL_SIZE/2)/2), CELL_SIZE/2, CELL_SIZE/2);
    screen.setColor(Color.black);
    screen.drawOval((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1, CELL_SIZE - 1);
    screen.setColor(Color.black);
    screen.drawOval((i * CELL_SIZE + 1 + (CELL_SIZE/2)/2), (j * CELL_SIZE + 1+ (CELL_SIZE/2)/2), CELL_SIZE/2, CELL_SIZE/2);

  }else if(mother.getHealth().startsWith("Healthy")){
    screen.setColor(Color.white);
    screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

    screen.setColor(Color.black);
    screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
  }else{
    screen.setColor(Color.black);
    screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

    screen.setColor(Color.black);
    screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
    mother.setName("Unknown");
  }

  screen.setColor(Color.black);
  screen.drawLine(CELL_SIZE,CELL_SIZE/2,2*CELL_SIZE,CELL_SIZE/2);
  screen.drawLine(CELL_SIZE*3/2,CELL_SIZE/2,CELL_SIZE*3/2,CELL_SIZE*3/2);

  if(mainFamily.getChildren().size()>0){
    i = 1;
    j = 2;
    for (int k = 0; k < mainFamily.getChildren().size(); k++) {
      Description child = (Description) mainFamily.getChildren().get(k);
      if (child.getSex().startsWith("Male")) {
        if (child.getHealth().startsWith("Diseased")) {

          screen.setColor(Color.lightGray);
          screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
          screen.setColor(Color.black);
          screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
        }
        else if (child.getHealth().startsWith("Carrier")) {
          screen.setColor(Color.white);
          screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);

          screen.setColor(Color.lightGray);
          screen.fillRect( (i * CELL_SIZE + 1 + CELL_SIZE / 2),
                          (j * CELL_SIZE + 1), (CELL_SIZE - 1) / 2,
                          CELL_SIZE - 1);

          screen.setColor(Color.BLACK);
          screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
          screen.setColor(Color.BLACK);
          screen.drawRect( (i * CELL_SIZE + 1 + CELL_SIZE / 2),
                          (j * CELL_SIZE + 1), (CELL_SIZE - 1) / 2,
                          CELL_SIZE - 1);
        }
        else if (child.getHealth().startsWith("Healthy")) {
          screen.setColor(Color.white);
          screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
          screen.setColor(Color.black);
          screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
        }
      }
      else { //female
        if (child.getHealth().startsWith("Diseased")) {
          screen.setColor(Color.lightGray);
          screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
          screen.setColor(Color.black);
          screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
        }
        else if (child.getHealth().startsWith("Carrier")) {
          screen.setColor(Color.white);
          screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);

          screen.setColor(Color.lightGray);
          screen.fillOval( (i * CELL_SIZE + 1 + (CELL_SIZE / 2) / 2),
                          (j * CELL_SIZE + 1 + (CELL_SIZE / 2) / 2),
                          CELL_SIZE / 2, CELL_SIZE / 2);
          screen.setColor(Color.black);
          screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
          screen.setColor(Color.black);
          screen.drawOval( (i * CELL_SIZE + 1 + (CELL_SIZE / 2) / 2),
                          (j * CELL_SIZE + 1 + (CELL_SIZE / 2) / 2),
                          CELL_SIZE / 2, CELL_SIZE / 2);

        }
        else if (child.getHealth().startsWith("Healthy")) {
          screen.setColor(Color.white);
          screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);

          screen.setColor(Color.black);
          screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),
                          CELL_SIZE - 1, CELL_SIZE - 1);
        }
      }
      screen.setColor(Color.black);
      screen.drawLine( (i * CELL_SIZE) + CELL_SIZE / 2, CELL_SIZE * 3 / 2,
                      (i * CELL_SIZE) + CELL_SIZE / 2, CELL_SIZE * 2);
      i = i + 2;
    }
    screen.setColor(Color.black);
    screen.drawLine(CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2,
                    CELL_SIZE * 3 / 2 +
                    (mainFamily.getChildren().size() - 1) * CELL_SIZE * 2,
                    CELL_SIZE * 3 / 2);
  }

  repaint();
}




  public int paintSingleAgentGrid(int i, int j){
    int k = MenuFrame.grid.getP(i + 1, j + 1);
    return k;
  }

  public Families getThisFamily(){
    return mainFamily;
  }

}

/**
 *         switch (drawCase) {

          case 0:
            break;

            //draw woman-healthy-blue
          case 1:
            screen.setColor(colourCase1);
            screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            screen.setColor(Color.black);
            screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            break;

            //draw man-healthy-blue
          case 2:
            screen.setColor(colourCase1);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            screen.setColor(Color.black);
            screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            break;

            //draw woman-trait-red
          case 3:
            screen.setColor(colourCase1);
            screen.fillOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            screen.setColor(colourCase2);
            screen.fillOval((i * CELL_SIZE + 1 + (CELL_SIZE/2)/2), (j * CELL_SIZE + 1+ (CELL_SIZE/2)/2), CELL_SIZE/2, CELL_SIZE/2);

            screen.setColor(Color.black);
            screen.drawOval((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1, CELL_SIZE - 1);
            screen.setColor(Color.black);
            screen.drawOval((i * CELL_SIZE + 1 + (CELL_SIZE/2)/2), (j * CELL_SIZE + 1+ (CELL_SIZE/2)/2), CELL_SIZE/2, CELL_SIZE/2);
          break;

            //draw man-trait-red
          case 4:
            screen.setColor(colourCase1);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            screen.setColor(colourCase2);
            screen.fillRect((i * CELL_SIZE + 1+CELL_SIZE/2), (j * CELL_SIZE + 1),(CELL_SIZE - 1)/2, CELL_SIZE - 1);

            screen.setColor(Color.BLACK);
            screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            screen.setColor(Color.BLACK);
            screen.drawRect((i * CELL_SIZE + 1+CELL_SIZE/2), (j * CELL_SIZE + 1),(CELL_SIZE - 1)/2, CELL_SIZE - 1);


            break;
            //draw woman-disease-red
          case 5:
            screen.setColor(colourCase2);
            screen.fillOval((i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            screen.setColor(Color.black);
            screen.drawOval( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            break;

            //draw man-disease-red
          case 6:
            screen.setColor(colourCase2);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            screen.setColor(Color.black);
            screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);

            break;


          //family agents
          case 9:
            screen.setColor(Color.green);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            int rW=(int)(((float)(CELL_SIZE - 1))*((float)familyPer5)/50.0);
            screen.setColor(Color.red);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1,rW);
            screen.setColor(Color.lightGray);
            screen.drawRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
            break;

          case 1000:
            screen.setColor(Color.black);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
//            repaint();
//            MenuFrame.grid.setP(i+1,j+1,0);
            break;

          case 1001:
            screen.setColor(Color.pink);
            screen.fillRect( (i * CELL_SIZE + 1), (j * CELL_SIZE + 1),CELL_SIZE - 1, CELL_SIZE - 1);
//            repaint();
//            MenuFrame.grid.setP(i+1,j+1,0);
            break;
        }

 */


package genecity.gui;

import java.awt.*;
import javax.swing.*;



/**
 * <p>Title: DrawPanel</p>
 * <p>Description: Grid Visualization</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */

public class DrawPanel
    extends JPanel {

  public int CELL_SIZE = 30;
  public static boolean nets=false;


  /**
   * deafault constructor
   */

  public DrawPanel() {
  }

  /**
   * Draws a grid visualizing the area with its content
   * @param screen the graphics componet to draw on
   */
  public void paint(Graphics screen) {
    int drawCase=0;

    //Draw the grid
    for (int i = 0; i <= MenuFrame.grid.getD1() * CELL_SIZE; i += CELL_SIZE) {
      for (int j = 0; j <= MenuFrame.grid.getD2() * CELL_SIZE; j += CELL_SIZE) {
        screen.setColor(Color.lightGray); //TO XROMA TOU GRID
        screen.drawLine(i, j, i, MenuFrame.grid.getD2());
        screen.drawLine(i, j, MenuFrame.grid.getD1(), j);
      }
    }

    screen.drawLine(MenuFrame.grid.getD1(), 0, MenuFrame.grid.getD1(),
                    MenuFrame.grid.getD2());
    screen.drawLine(0, MenuFrame.grid.getD2(), MenuFrame.grid.getD1(),
                    MenuFrame.grid.getD2());

    for (int i = 0; i < MenuFrame.grid.getD1(); i++) {
      for (int j = 0; j <MenuFrame.grid.getD2(); j++) {

        //set White colour in all boxes
//        screen.setColor(Color.white);
//        screen.fillRect((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1, CELL_SIZE - 1);


        drawCase=paintAgentGrid(i,j); //afto tha alla3ei me ena allo if, wste na perilamvanei kai to family network
        //family drawing
        int familyPer5=drawCase-10;
        if (drawCase>9&&drawCase<100){
          drawCase = 9;
        }

        Color colourCase1=Color.white;
        Color colourCase2=Color.lightGray;
        Color colourCase3=Color.white;

        if(MenuFrame.grid.getEnabledP(i+1,j+1)==1) {
          colourCase1 = Color.yellow;
          colourCase2= Color.orange;
          colourCase3= Color.cyan;
        }

        if(!MenuFrame.drawPanelFrame2.jCheckBoxMenuItemFamily.isSelected()){
          if(drawCase==9)
            drawCase=0;
        }
        if(!MenuFrame.drawPanelFrame2.jCheckBoxMenuItemSingle.isSelected()){
          if(drawCase<9)
            drawCase=0;
        }



        switch (drawCase) {

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
            screen.setColor(Color.black);
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
      }
    }


  }
  public int paintAgentGrid(int i, int j){
    int k = MenuFrame.grid.getP(i + 1, j + 1);
    return k;
  }

}




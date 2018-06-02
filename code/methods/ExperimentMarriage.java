package genecity.methods;


import java.util.Vector;
/*
 * DriveMarriage.java
 *
 * Created on October 28, 2003, 10:47 PM
 * Author: Armando Ramirez-alr2106 edited by Demetrios Eliades
 */


public class ExperimentMarriage {

    public static int PAIRS;
    //number of pairs of people to be married

    public static Mates[] Women;//=new Mates[PAIRS];
    //initialize the array of Persons for Women
    public static Mates[] Men;//=new Mates[PAIRS];
    //initialize the array of Persons for Men


    public ExperimentMarriage(Vector v1,Vector v2)
    {
      PAIRS=v1.size();
      Women=new Mates[PAIRS];
      Men=new Mates[PAIRS];
      createArray(v1,v2);  //method invoked
      Marriage.Match(Men,Women);
      Marriage.round=0;
      //Match matches the men and women to be married
     // displayResults();
    }


    public static void createArray(Vector v1,Vector v2)
    {
        for(int x=0; x<PAIRS; x++)
        {
            Men[x]=new Mates(PAIRS,'M',(Vector)v1.get(x));
            Women[x]=new Mates(PAIRS, 'F',(Vector)v2.get(x));
        }
    }
    /*fill array fills the men and women array with references to objects of
     *type person
     */
    public static void displayResults()
    {
        for (int w=0;w<PAIRS;w++)
        {
            System.out.println("\nwoman="+w);
            for(int z=0;z<PAIRS;z++)
                System.out.print(" "+Women[w].getRank(z));
        }
        for (int a=0;a<PAIRS;a++)
        {
            System.out.println("\nMan="+a);
            for(int b=0;b<PAIRS;b++)
                System.out.print(" "+Men[a].getRank(b));
        }
        for (int x=0;x<PAIRS;x++)
        {
            System.out.println("Woman "+x+" Marries Man "
                                 +Women[x].getMaritalStat());
        }
    }
    /*display results displays the person that the woman was
     *married to.
     */

    public Vector returnMatingVector(){
      Vector a=new Vector();
      for(int i=0;i<PAIRS;i++){
        a.add(new Integer(Women[i].getMaritalStat()));
      }
      return a;
    }
}

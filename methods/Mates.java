package genecity.methods;

import java.util.Vector;

/*
 *Person.java         Author: Armando  Ramirez edited by Demetrios Eliades
 *Person Class: blueprint for object of type person that will
 *contain a ranking of how many people the
 *constructor receives as a parameter
 *
 */

public class Mates {

    private int maritalStat=-1;
    //MaritalStat is set to -1 indicating that the person is
    //not married yet, a non-negative number indicates that the person
    //is married to the person corresponding to that non-negative number

    private int[] rank;  //rank array holds the rankings
    private char gender;  //(M/F)

    /** Creates a new instance of Person */
    public Mates(int people,char genderType, Vector v)
    {
        gender=genderType;
        rank= new int[people];
        generateRank(v);

    }
    /*Constructor initializes the gender and the size of the rank arrary
     *as well as calling the generateRank() method to fill the array
     */
    private void generateRank()
    {
        boolean flag;
        for(int x=0;x<rank.length;x++)
        {
            do{
                flag=false;
                rank[x]=(int)(Math.random()*rank.length);
                for(int y=0;y<x;y++)
                    if (rank[y]==rank[x])
                        flag=true;
            }while(flag==true);
        }
    }
    /*GenerateRank array fills the rank array with random numbers-
     *the do-while and for statements ensure that the array will not
     *have any numbers that repeat
     */

    private void generateRank(Vector v)
    {
        for(int x=0;x<rank.length;x++)
        {
          try{
            rank[x] = Integer.parseInt(v.get(x).toString());
          }catch(Exception ex){
            ex.printStackTrace();
          }
        }
    }

    public int getRank(int x)
    {
        return rank[x];
    }
    /*get rank returns the value of rank at a specified index*/

    public void changeMaritalStat(int status)
    {
        maritalStat=status;
    }
    /*changes maritalStat of person-New value shall correspond to either
     *still being single or the person that this person is married to
     */

    public int getMaritalStat()
    {
        return maritalStat;
    }
    /*returns the marita/
     */
    public char getGender()
    {
        return gender;
    }
    /*returns the gender of person if neeeded*/
}

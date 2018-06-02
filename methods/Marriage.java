package genecity.methods;


/* Armando Ramirez edited by Demetrios Eliades
 * Marriage.Java
 * This class contains the match static method that matches two arrays
 */
public class Marriage
{
    public static int round=0;
    //round keeps track of the round that the alrorithm is in

    public static void Match(Mates[] Men, Mates[] Women)
    {

        int highestRank=-1;
        /*highest rank initialized to -1 indicating that if the
         *person is not matched, they will remain single
         */
        boolean flag=true; //controlls do-while
        do{



            for (int female=0; female<Women.length;female++)
            {
                if (Women[female].getMaritalStat()==-1)
                {
                    highestRank=compare(Women[female],female, Men);
                    if (highestRank>=0)
                        Women[female].changeMaritalStat(highestRank);

                }
                /*if the women are single(-1), then compare
                 *shall be called to return the their match
                 */

            }
            /*for statement goes around once per round
             *for every Woman
             */
            if(matchComplete(Women))
                flag=false;
                round+=1;
            /*match complete checks to see if everyone has been matched*/
        }while(flag==true);
        //do while iterates for every round

    }



    private static boolean matchComplete(Mates[] female)
    {
        boolean flag=true;
        for(int x=0;x<female.length;x++)
        {
            if (female[x].getMaritalStat()==-1)
                flag=false;
        }
        return flag;
    }
    /*match complete goes through every woman and checks if they are
     *married, if they are, match complete will return false and
     *terminate the do-while statement
     */
    private static int compare(Mates Woman,int female, Mates[] Man)
    {

        int highestRank2=-1;
        int proposals = numPropose(female,Man);
        //num propose returns the number of men that proposed to one woman
        //of index "female"
        if(proposals>1)
        {
            for(int z=0;z<Man.length;z++)//index of woman's ranking list
            {
                for(int w=0;w<Man.length;w++)
                    /*w corresponds to the index on the Man[]
                     *array, (i.e. Man1, man2, man3....)
                     */
                    if(Woman.getRank(z)==w && Man[w].getRank(round)==female
                       && Man[w].getMaritalStat()==-1)
                    {
                        Man[w].changeMaritalStat(female);
                        highestRank2=w;
                        w=Man.length;
                        z=Man.length;
                    }
            }
        /*If there are multiple proposals, the above doce will search
         *for the highest ranking man on the womans list
         *and changes her marital status to that as long
         *as the guy is not married
         */
        }
        if(proposals==0)
               highestRank2=-1;
        //if proposals=0, woman is still single
        if(proposals==1)
           {
               for(int x=0;x<Man.length;x++)
                   if (Man[x].getRank(round)==female
                       && Man[x].getMaritalStat()==-1)
                   {
                       Man[x].changeMaritalStat(female);
                       highestRank2=x;
                   }
           }
        /*if proposals=1, then the above code looks for the
         *man who proposed and changes marital stat to that man
         */
        return highestRank2;

    }

    private static int numPropose(int female, Mates[] Man)
    {
        int counter=0;
        for(int x=0; x<Man.length;x++)
        {
            if(Man[x].getRank(round)==female &&Man[x].getMaritalStat()==-1)
                counter++;
        }
        return counter;
    }
    /*checks how many men that are single proposed to one woman of
     *index "female" in the Women[] array
     */
}


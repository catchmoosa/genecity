package genecity.genetics;

import genecity.gui.MenuFrame;
import java.util.Random;
import java.util.Random;

/**
 * <p>Title: Chromosoma</p>
 * <p>Description: Genetic Algotirthms Methods </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Aristotle University of Thessaloniki</p>
 * @author Eliades Demetrios
 * @version 1.0
 */


public class Chromosoma {
  //initial gene
  private int gene=0;
  //reproduction ability
  private boolean rA=MenuFrame.settings.getAffectReproduction();
  private float rApc=MenuFrame.settings.getreproductionAbilityPerc()/100;
  //Method transmittion
  private int dT=MenuFrame.settings.getMethodTransmittion();
  private boolean dT2=MenuFrame.settings.getDominantAutosomatic();
  //real mutation rate
  private float mRate=MenuFrame.settings.getrealMutationRate();
  //phenotype
  private int phT=MenuFrame.settings.getCondition();



  public Chromosoma() {
  }

  /**
   * Initiate 31 Bit Chomosomes for each agent during starup
   * @param a A set of Objects in the form of arguments
   * @return An Integer equal to the binary representation of the chromosome
   */
  public int initiateChromosoma(Object[] a) {
    //SET SEX
    int sex=0;
    if(a[2].equals(new Integer(1))){ //male-1 female-0
      sex=1;
    }

    //method for biological mutation of gene
    if(a[3].equals(new Integer(0))){ //if he/she is healthy
       if(Math.random()<=mRate){
         //an einai autosomatiki!
         if(dT==1&&sex==1){
           a[3] = new Integer(2);
         }else{
           a[3] = new Integer(1); //to set as carrier
         }
         a[8]=new Integer(2); //to set mutated genes as 10 (to cover x-releted and autosomatic
       }
    }


    //SET DISEASE TYPE (
    int diseaseType=0;
    if (dT==1&&!(a[3].equals(new Integer(0)))){    //sex related x-chromosome
      diseaseType=3; //00011
    }else if(dT==0&&!(a[3].equals(new Integer(0)))) { //autosomatic
      if(dT2){ //if is dominant
        diseaseType=2; //00010
      }else{
        diseaseType=1; //00001  //not dominant
      }
    }

    //SET MUTATION TYPE
    int mutationType=0;
    mutationType=Integer.parseInt(a[8].toString());

    //SET HEALTH STATE
    int healthStatus=0; //getHealthStatus(sex,Integer.parseInt(a[3].toString()),mutationType);
    if(Integer.parseInt(a[3].toString())==2)
      healthStatus=1; //else he has a normal health status, either as a carrier or as a healty person

    //SET REPRODUCTIVE PABILITY
    int reproductiveAbility=getReproductiveAbility(healthStatus);

    //SET PHENOTYPE VALUE
    int phenotype=getPhenotype(healthStatus);


    //vision(5)
    int vision=0;
    vision=(int)(Math.random()*31); //31 2^0+...2^4
    gene<<=5;
    gene=gene|vision;

    //fear(5) in every step added
    int fear=0;
    fear=(int)(Math.random()*31); //31 2^0+...2^4
    gene<<=5;
    gene=gene|fear;

    //influence(4) random initation
    int infulence=0;
    infulence=(int)(Math.random()*15); //31 2^0+...2^4
    gene<<=4;
    gene=gene|infulence;

    //acceptance(4) random initation
    int acceptance=0;
    acceptance=(int)(Math.random()*15); //31 2^0+...2^4
    gene<<=4;
    gene=gene|acceptance;

    //wealth(4)
    int wealth=0;
    wealth=(int)(Math.random()*15); //31 2^0+...2^4
    gene<<=4;
    gene=gene|wealth;

    //phenotype(2)
    gene<<=2;
    gene=gene|phenotype;

    //reproductive ability(1)
    gene<<=1;
    gene=gene|reproductiveAbility;

    //health(1)
    gene<<=1;
    gene=gene|healthStatus;


    //Body mutation(2)
    gene<<=2;
    gene=gene|mutationType;

    //mutation type(2)
    gene<<=2;
    gene=gene|diseaseType; //the type of disease, to be used in childbirth

    //insert sex(1)
    gene<<=1;
    gene=gene|sex;


//    System.out.println(Integer.toBinaryString(gene));
//    System.out.println(gene);

    return gene;
  }









  public int initiateChromosomaRC(int[] a) {
     //SET SEX
     int sex=0;
     if(a[0]==1){ //male-1 female-0
       sex=1;
     }

     //SET DISEASE TYPE (
     int diseaseType=0;
     if (dT==1&&!(a[1]==0)){    //sex related x-chromosome
       diseaseType=3; //00011
     }else if(dT==0&&!(a[1]==0)) { //autosomatic
       if(dT2){ //if is dominant
         diseaseType=2; //00010
       }else{
         diseaseType=1; //00001  //not dominant
       }
     }

     //SET MUTATION TYPE
     int mutationType=0;
     mutationType=a[1];

     //SET HEALTH STATE
     int healthStatus=0; //getHealthStatus(sex,Integer.parseInt(a[3].toString()),mutationType);
     if(a[2]==2)
       healthStatus=1; //else he has a normal health status, either as a carrier or as a healty person

     //SET REPRODUCTIVE PABILITY
     int reproductiveAbility=getReproductiveAbility(healthStatus);

     //SET PHENOTYPE VALUE
     int phenotype=getPhenotype(healthStatus);


     //vision(5)
     int vision=0;
     vision=a[3]; //31 2^0+...2^4
     gene<<=5;
     gene=gene|vision;

     //fear(5) in every step added
     int fear=0;
     fear=a[4]; //31 2^0+...2^4
     gene<<=5;
     gene=gene|fear;

     //influence(4) random initation
     int infulence=0;
     infulence=a[5]; //31 2^0+...2^4
     gene<<=4;
     gene=gene|infulence;

     //acceptance(4) random initation
     int acceptance=0;
     acceptance=a[6]; //31 2^0+...2^4
     gene<<=4;
     gene=gene|acceptance;

     //wealth(4)
     int wealth=0;
     wealth=a[7]; //31 2^0+...2^4
     gene<<=4;
     gene=gene|wealth;

     //phenotype(2)
     gene<<=2;
     gene=gene|phenotype;

     //reproductive ability(1)
     gene<<=1;
     gene=gene|reproductiveAbility;

     //health(1)
     gene<<=1;
     gene=gene|healthStatus;


     //Body mutation(2)
     gene<<=2;
     gene=gene|mutationType;

     //mutation type(2)
     gene<<=2;
     gene=gene|diseaseType; //the type of disease, to be used in childbirth

     //insert sex(1)
     gene<<=1;
     gene=gene|sex;

//     System.out.println(Integer.toBinaryString(gene));

     return gene;
   }





  public int sexGene(int gene){
    int sex=1&gene;
    return sex;
  }

  public int diseaseGene(int gene){
    int diseasegene=gene>>1;
    diseasegene=diseasegene&3;
    return diseasegene;
  }

  public int mutationGene(int gene){
    int mutgene=gene>>3;
    mutgene=mutgene&3;
    return mutgene;
  }

  public int healthGene(int gene){
    int healthgene=gene>>5;
    healthgene=healthgene&1;
    return healthgene;
  }

  public int reprAbilityGene(int gene){
    int reprabitilygene=gene>>6;
    reprabitilygene=reprabitilygene&1;
    return reprabitilygene;
  }

  public int phenoGene(int gene){
    int phenogene=gene>>7;
    phenogene=phenogene&3;
    return phenogene;
  }

  public int wealthGene(int gene){
    int wealthgene=gene>>9;
    wealthgene=wealthgene&15;
    return wealthgene;
  }

  public int acceptanceGene(int gene){
    int acceptancegene=gene>>13;
    acceptancegene=acceptancegene&15;
    return acceptancegene;
  }

  public int influenceGene(int gene){
    int influencegene=gene>>17;
    influencegene=influencegene&15;
    return influencegene;
  }


  public int fearGene(int gene){
    int feargene=gene>>21;
    feargene=feargene&31;
    return feargene;
  }

  public int visionGene(int gene){
    int visionGene=gene>>26;
    visionGene=visionGene&31;
    return visionGene;
  }




  public int doCrossover(int f,int m){ //father - mother

    int crossedGene=0;
    double random=0;


    int sex=0;
    //random sex
    random =Math.random();
    if(random<=0.5){
      sex=1;
    }

    // M E D I C A L   C R O S S O V E R!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //diseaseGene
    int mDG=diseaseGene(m);
    int fDG=diseaseGene(f);
    int diseaseGene=0;
    if (mDG!=0){
      diseaseGene=mDG;
    }else if (fDG!=0){
      diseaseGene=fDG;
    }

    //vazei stis metavlites tis MUTATION an yparxoun.
    //o kathe apogonos painei me 50% kathe mia apo aftes
    int mMut = mutationGene(m); //00-ok (10 01)-eterozygorikos 11-omozygotikos
    int fMut = mutationGene(f);
    int maleMutationBit=0 ;
    int femaleMutationBit=0;
    if(diseaseGene!=3){//aftosomatikh
      maleMutationBit = fMut >> (int) (Math.round(Math.random()));
      maleMutationBit = maleMutationBit & 1;
      femaleMutationBit = mMut >> (int) (Math.round(Math.random()));
      femaleMutationBit = femaleMutationBit & 1;
    }else{// gia x-chromosome
      if(sex==1){//if man
        maleMutationBit = fMut & 1;//de3i bit apo patera
        femaleMutationBit = mMut >> (int) (Math.round(Math.random())); //aristero bit apo mitera
        femaleMutationBit = femaleMutationBit & 1;
      }else{
        maleMutationBit = fMut >> 1;
        maleMutationBit = maleMutationBit & 1;
        femaleMutationBit = mMut >> (int) (Math.round(Math.random()));
        femaleMutationBit = femaleMutationBit & 1;
      }
    }
    int mutation=0;
    mutation=mutation|femaleMutationBit;
    mutation<<=1;
    mutation=mutation|maleMutationBit;
    if(mutation==0)diseaseGene=0;

    //health(1)
    int hStatus=getHealthStatus(sex,diseaseGene,mutation);

    //reproductive
    int repr=getReproductiveAbility(hStatus);
    //phenotype
    int phen=getPhenotype(hStatus);

    //  S O C I O  C R O S S O V E R!
    int mInf=influenceGene(m);
    int fInf=influenceGene(f);
    int mW=wealthGene(m);
    int fW=wealthGene(f);
    int mAcc=acceptanceGene(m);
    int fAcc=acceptanceGene(f);
    int fFear=fearGene(f);
    int mFear=fearGene(m);
    int mVis=visionGene(m);
    int fVis=visionGene(m);

    //wealth
    int wealth=doSocialCrossover(mW,fW,4);
    //acceptance
    int accept=doSocialCrossover(mAcc,fAcc,4);
    //influence
    int influence=doSocialCrossover(mInf,fInf,4);
    //fear
    int fear=doSocialCrossover(mFear,fFear,5);
    //vison
    int vision=doSocialCrossover(mVis,fVis,5);


    //VISION
    crossedGene<<=5;
    crossedGene=crossedGene|vision;

    //FEAR
    crossedGene<<=5;
    crossedGene=crossedGene|fear;

    //INFLUENCE
    crossedGene<<=4;
    crossedGene=crossedGene|influence;
    //ACCEPTANCE
    crossedGene<<=4;
    crossedGene=crossedGene|accept;

    //WEALTH
    crossedGene<<=4;
    crossedGene=crossedGene|wealth;
    //PHENOTYPE
    crossedGene<<=2;
    crossedGene=crossedGene|phen;
    //REPRODUCE
    crossedGene<<=1;
    crossedGene=crossedGene|repr;
    //HEALTH
    crossedGene<<=1;
    crossedGene=crossedGene|hStatus;
    //MUTATION GENE
    crossedGene=crossedGene<<2;
    crossedGene=crossedGene|mutation;
    //DISEASE
    crossedGene<<=2;
    crossedGene=crossedGene|diseaseGene;
    //SEX
    crossedGene=crossedGene<<1;
    crossedGene=crossedGene|sex;


    /**
     * CROSSOVER SOCIOLOGICAL
     */
    return crossedGene;
  }













  private int getHealthStatus(int s, int d, int m){
    int status=0;
    if (d==1){ //autosomotiki ypoleipomeni
      if(m==3){ //gia 0011
        status=1;
      }
    }else if (d==2){//gia aftosomatiki kyriarxh
      if(m>0){
        status=1;
      }
    }else if(d==3){
      if(s==1){//man
        if(m==2){//10
          status=1;
        }
      }else{//woman
        if(m==3){
          status=1;
        }
      }
    }
    return status;
  }

  private int getReproductiveAbility(int healthStatus){
    int reproductiveAbility=0;
    if (rA==false&&healthStatus==1){
      reproductiveAbility=1; //cannot_reproduce-1 can-0
    }else if(rA==true&&healthStatus==1){
      if(Math.random()>rApc){
        reproductiveAbility=1;
      }
    }
    return reproductiveAbility;
  }

  private int getPhenotype(int healthStatus){
    int phenotype=0;
    if(healthStatus==1){
      if(phT==1){
        phenotype=1;
      }else if(phT==2){
        phenotype=2;
      }else if(phT==3){
        phenotype=3;
      }
    }
    return phenotype;

  }

  private int doSocialCrossover(int m,int f,int size){
    int byt=0;
    if (m>=f){ //na parei ta MSB apo ton patera
      byt=cross(m,f,size);
    }else if(m<f){
      byt=cross(f,m,size);
    }
    //Mutation in very rare cases
    if(Math.random()<mRate){
      int bitPlace=(int)(Math.random()*size);
      int temp=1;
      temp<<=size;
      byt=byt|temp;
    }
    return byt;
  }

  private int cross(int a1, int a2,int size){
    int byt=0;
    Random rad=new Random();
    int pointErr=(int)rad.nextGaussian();
    if (Math.abs(pointErr)>=2){
      pointErr=0;
    }
    int point=2+pointErr;
    a1>>=point;
    byt=byt|a1;
    byt<<=point;
    int mask2=0;
    for(int i=0;i<size-point;i++){
      mask2=mask2+(int)Math.pow(2,i);
    }
    a2=a2&mask2;
    byt=byt|a2;
    return byt;
  }



  public int changeCharacteristics(int gene){
    Random rad=new Random();
    int mask=511; //000000000000111111111
    int temp=rad.nextInt(2147483647);
    gene=gene&mask;
    temp=temp&(~mask);
    gene=temp|gene;
    return gene;
  }






}


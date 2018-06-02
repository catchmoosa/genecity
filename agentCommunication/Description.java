package genecity.agentCommunication;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/** file: Description.java
 * @author ontology bean generator
 * @version 2004/06/9
 */


public class Description implements Concept{

  // int epochOfBirth
  private int epochOfBirth;
  public void setEpochOfBirth(int s) { this.epochOfBirth=s; }
  public int getEpochOfBirth() { return this.epochOfBirth; }

  // int bitGene
  private int bitGene;
  public void setBitGene(int s) { this.bitGene=s; }
  public int getBitGene() { return this.bitGene; }

  // int y
  private int y;
  public void setY(int s) { this.y=s; }
  public int getY() { return this.y; }

  // String name
  private String name;
  public void setName(String s) { this.name=s; }
  public String getName() { return this.name; }

  // String health
  private String health;
  public void setHealth(String s) { this.health=s; }
  public String getHealth() { return this.health; }

  // int FearDegree
  private int FearDegree;
  public void setFearDegree(int s) { this.FearDegree=s; }
  public int getFearDegree() { return this.FearDegree; }

  // String sex
  private String sex;
  public void setSex(String s) { this.sex=s; }
  public String getSex() { return this.sex; }

  // int InformationDegree
  private int InformationDegree;
  public void setInformationDegree(int s) { this.InformationDegree=s; }
  public int getInformationDegree() { return this.InformationDegree; }

  // int epochsToLive
  private int epochsToLive;
  public void setEpochsToLive(int s) { this.epochsToLive=s; }
  public int getEpochsToLive() { return this.epochsToLive; }

  // int x
  private int x;
  public void setX(int s) { this.x=s; }
  public int getX() { return this.x; }

  // int fromFamilyID
  private int fromFamilyID;
  public void setFromFamilyID(int s) { this.fromFamilyID=s; }
  public int getFromFamilyID() { return this.fromFamilyID; }

}

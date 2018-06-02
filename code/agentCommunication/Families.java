package genecity.agentCommunication;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/** file: Families.java
 * @author ontology bean generator
 * @version 2004/06/10
 */


public class Families implements Predicate{

  //  Collection  Children
  private List Children = new ArrayList();
  public void addChildren(Description o) { Children.add(o); }
  public boolean removeChildren(Description o) {return Children.remove(o); }
  public void clearAllChildren() {Children.clear(); }
  public Iterator getAllChildren() {return Children.iterator(); }
  public List getChildren() {return Children; }
  public void setChildren(List l) {Children = l; }

  // Description Mother
  private Description Mother;
  public void setMother(Description s) { this.Mother=s; }
  public Description getMother() { return this.Mother; }

  // Object fY
  private int fY;
  public void setFY(int s) { this.fY=s; }
  public int getFY() { return this.fY; }

  // int familyID
  private int familyID;
  public void setFamilyID(int s) { this.familyID=s; }
  public int getFamilyID() { return this.familyID; }

  // int fX
  private int fX;
  public void setFX(int s) { this.fX=s; }
  public int getFX() { return this.fX; }

  // Description Father
  private Description Father;
  public void setFather(Description s) { this.Father=s; }
  public Description getFather() { return this.Father; }

  // int FamilyFearDegree
  private int FamilyFearDegree;
  public void setFamilyFearDegree(int s) { this.FamilyFearDegree=s; }
  public int getFamilyFearDegree() { return this.FamilyFearDegree; }

  // int FamilyInformationDegree
  private int FamilyInformationDegree;
  public void setFamilyInformationDegree(int s) { this.FamilyInformationDegree=s; }
  public int getFamilyInformationDegree() { return this.FamilyInformationDegree; }

}

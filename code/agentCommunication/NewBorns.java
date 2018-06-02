package genecity.agentCommunication;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/** file: NewBorns.java
 * @author ontology bean generator
 * @version 2004/06/10
 */


public class NewBorns implements Predicate{

  //  Collection  removeParentsDescriptions
  private List removeParentsDescriptions = new ArrayList();
  public void addRemoveParentsDescriptions(Description o) { removeParentsDescriptions.add(o); }
  public boolean removeRemoveParentsDescriptions(Description o) {return removeParentsDescriptions.remove(o); }
  public void clearAllRemoveParentsDescriptions() {removeParentsDescriptions.clear(); }
  public Iterator getAllRemoveParentsDescriptions() {return removeParentsDescriptions.iterator(); }
  public List getRemoveParentsDescriptions() {return removeParentsDescriptions; }
  public void setRemoveParentsDescriptions(List l) {removeParentsDescriptions = l; }

  //  Collection  babysDescription
  private List babysDescription = new ArrayList();
  public void addBabysDescription(Description o) { babysDescription.add(o); }
  public boolean removeBabysDescription(Description o) {return babysDescription.remove(o); }
  public void clearAllBabysDescription() {babysDescription.clear(); }
  public Iterator getAllBabysDescription() {return babysDescription.iterator(); }
  public List getBabysDescription() {return babysDescription; }
  public void setBabysDescription(List l) {babysDescription = l; }

}

package genecity.agentCommunication;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/** file: Preferences.java
 * @author ontology bean generator
 * @version 2004/06/9
 */


public class Preferences implements Predicate{

  // Description whois
  private Description whois;
  public void setWhois(Description s) { this.whois=s; }
  public Description getWhois() { return this.whois; }

  //  Collection  preferences
  private List preferences = new ArrayList();
  public void addPreferences(Description o) { preferences.add(o); }
  public boolean removePreferences(Description o) {return preferences.remove(o); }
  public void clearAllPreferences() {preferences.clear(); }
  public Iterator getAllPreferences() {return preferences.iterator(); }
  public List getPreferences() {return preferences; }
  public void setPreferences(List l) {preferences = l; }
  public List getPreferencesNames() {
    List l=new ArrayList();
    for (int i=0;i<preferences.size();i++){
      l.add(((Description)preferences.get(i)).getName());
    }
    return l;
  }

  // Integer willForMarriage
  private float willForMarriage;
  public void setWillForMarriage(float s) { this.willForMarriage=s; }
  public float getWillForMarriage() { return this.willForMarriage; }



}

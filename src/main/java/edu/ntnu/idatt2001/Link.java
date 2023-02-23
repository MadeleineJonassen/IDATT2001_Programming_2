package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.Action;

import java.util.ArrayList;
import java.util.List;

public class Link {
  private final String text;
  private final String reference;
  List<Action> actions = new ArrayList<>();
  
  public Link(String text, String reference){
    this.text = text;
    this.reference = reference;
  }
  
  public String getText() {
    return text;
  }
  
  public String getReference() {
    return reference;
  }
  
  public void addAction(Action action){
    actions.add(action);
  }
  
  public List<Action> getActions() {
    return actions;
  }
  
  @Override
  public String toString() {
    return text + ", next: " + reference;
  }
  
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Link compareTo = (Link) obj;
    if(this.text.equals(compareTo.getText()) && this.reference.equals(compareTo.getReference())){
      return true;
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

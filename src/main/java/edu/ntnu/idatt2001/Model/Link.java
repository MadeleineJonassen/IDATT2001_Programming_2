package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.Action.Action;

import java.util.ArrayList;
import java.util.List;

public class Link {
  private final String text;
  private final String reference;
  List<Action> actions = new ArrayList<>();
  
  public Link(String text, String reference){
    if(text.isEmpty()){
      throw new IllegalArgumentException("Text cannot be empty");
    }
    if(reference.isEmpty()){
      throw new IllegalArgumentException("Reference cannot be empty");
    }
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
    if(actions.contains(action)){
      throw new IllegalArgumentException("Action has already been added to the link");
    }
    actions.add(action);
  }
  
  public List<Action> getActions() {
    //return deep copied list?
    return actions;
  }
  
  @Override
  public String toString() {
    return text + ", next: " + reference + ". Actions: " + actions.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Link compareTo = (Link) obj;
    //return this.text.equals(compareTo.getText()) && this.reference.equals(compareTo.getReference());
    return this.reference.equals(compareTo.getReference());
  }
  
  @Override
  public int hashCode() {
    return this.reference.hashCode();
  }
}

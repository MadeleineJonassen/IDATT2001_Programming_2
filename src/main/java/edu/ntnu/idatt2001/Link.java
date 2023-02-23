package edu.ntnu.idatt2001;

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
    return super.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
  
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

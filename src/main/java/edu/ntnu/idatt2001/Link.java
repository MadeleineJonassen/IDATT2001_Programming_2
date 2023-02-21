package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.List;

public class Link {
  private String text;
  private String reference;
  List<Action> actions = new ArrayList<Action>;
  
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
  
  //method: addAction
  public void addAction(Action action){
    actions.add(action);
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

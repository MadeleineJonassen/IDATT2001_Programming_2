package edu.ntnu.idatt2001;

public class Link {
  private String text;
  private String reference;
  //class variable: List<Action> actions
  
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

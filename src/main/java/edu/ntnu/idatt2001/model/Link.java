package edu.ntnu.idatt2001.model;

import edu.ntnu.idatt2001.model.Action.Action;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Link.
 */
public class Link {
  private final String text;
  private final String reference;
  /**
   * The Actions.
   */
  List<Action> actions = new ArrayList<>();
  
  /**
   * Instantiates a new Link.
   *
   * @param text      the text
   * @param reference the reference
   */
  public Link(String text, String reference) {
    if (text.isEmpty()) {
      throw new IllegalArgumentException("Text cannot be empty");
    }
    if (reference.isEmpty()) {
      throw new IllegalArgumentException("Reference cannot be empty");
    }
    this.text = text;
    this.reference = reference;
  }
  
  /**
   * Gets text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }
  
  /**
   * Gets reference.
   *
   * @return the reference
   */
  public String getReference() {
    return reference;
  }
  
  /**
   * Add action.
   *
   * @param action the action
   */
  public void addAction(Action action) {
    if (actions.contains(action)) {
      throw new IllegalArgumentException("Action has already been added to the link");
    }
    actions.add(action);
  }
  
  /**
   * Gets actions.
   *
   * @return the actions
   */
  public List<Action> getActions() {
    return actions;
  }
  
  @Override
  public String toString() {
    return text + ", next: " + reference + ". Actions: " + actions.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Link compareTo = (Link) obj;
    return this.reference.equals(compareTo.getReference());
  }
  
  @Override
  public int hashCode() {
    return this.reference.hashCode();
  }
}

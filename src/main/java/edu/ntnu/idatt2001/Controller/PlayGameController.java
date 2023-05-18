package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Link;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Passage;

public class PlayGameController {
  private GameManager gameManager;
  private Passage currentPassage; //or use passage name, and deal with this in gameManager
  
  public Passage nextPassage(String linkName){
    //TODO: refactor method
    
    Passage nextPassage = null;
    
    for (Link l : currentPassage.getLinks()){
      if (l.getText().equals(linkName)){
        nextPassage = gameManager.nextPassage(l);
      }
    }
    
    currentPassage = nextPassage;
    
    return currentPassage;
    //display passage (update from controller), or send passage to view?
  }
  
  private void showPassage(Passage passage){
  
  }
}

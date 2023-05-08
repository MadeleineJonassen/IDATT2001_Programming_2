package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Passage;

public class PlayGameController {
  private GameManager gameManager;
  private Passage currentPassage; //or use passage name, and deal with this in gameManager
  
  public void nextPassage(String linkName){
    //currentPassage.getLinks
    //find matching link
    //use go-method, or create nextPassage-method in GameManager?
    //update current passage?
  }
  
  private void showPassage(Passage passage){
  
  }
}

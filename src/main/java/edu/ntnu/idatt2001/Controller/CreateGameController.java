package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;

public class CreateGameController {
  private GameManager gameManager;
  
  public void getStoryFiles(){
    
    //returns string list
  }
  
  public void scanStory(String fileName){
    //parameter: string, file name?
    //construct path from this
    //File scanFile = new File("src/main/resources" + fileName);
    //return story name?
  }
  
  public void getPassages(){
    //Return list of strings (names)?
  }
  
  public void deletePassage(String passageName){
    //remove passage from story
    //return passages that link to this passage, so that user may delete these?
    //Alternatively, add possibility to edit passages (separate window)
  }
  
  public void getBrokenLinks(){
    //story.getBrokenLinks();
    //return missing passage-names
  }
  
  public void editPassage(String passageName){
    //Open popup window
  }
  
  
  
  public void addPlayer(){
    //TODO: use builder-constructor
  }
  
  public void addGoal(){
    
    //Check goals in end passage, "you win" if all (?) goals are completed
  }
  
  
  
  
  
  
  
  
  
  
  
  

}

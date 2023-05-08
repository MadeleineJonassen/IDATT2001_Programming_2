package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Story;

import java.io.File;

public class MenuSceneController {
  private GameManager gameManager;
  
  public void getStoryFiles(){
  
  }
  
  public void scanStory(File file){
    //return story name?
  }
  
  public void getPassages(){
  
  }
  
  public void deletePassage(){
    //remove passage from story
    //return passages that link to this passage, so that user may delete these?
    //Alternatively, add possibility to edit passages (separate window)
  }
  
  public void getBrokenLinks(){
    //story.getBrokenLinks();
    //return missing passage-names
  }
  
  public void addPlayer(){
    //Use builder-player
  }
  
  public void addGoal(){
  
  }
  
  
  
  
  
}

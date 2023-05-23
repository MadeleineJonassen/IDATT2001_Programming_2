package edu.ntnu.idatt2001.fileHandler;

import edu.ntnu.idatt2001.Action.*;
import edu.ntnu.idatt2001.model.Action.*;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanStory {
  
  //Scans a story from a text-file, returns the story
  public Story scanStory(File file) throws FileNotFoundException {
    //TODO: check file type, throw exceptions
    
    Scanner scan = new Scanner(file);
    String storyTitle = scan.nextLine();
    scan.nextLine();
    Passage openingPassage = scanPassage(scan);
    
    Story story = new Story(storyTitle, openingPassage);
    
    while(scan.hasNext()){
      story.addPassage(scanPassage(scan));
    }
    scan.close();
    return story;
  }
  
  //help method, scans an undividual passage in the story
  private Passage scanPassage(Scanner scan){
    if(!scan.hasNext()){
      throw new IllegalArgumentException("There are no more passages");
    }
    
    String title = scan.nextLine().substring(2);
    Passage passage = new Passage(title, scan.nextLine());
    
    if(scan.hasNext()){
      String line;
      while(!(line = scan.nextLine()).isBlank()){
        passage.addLink(scanLink(line));
      }
    }
    
    return passage;
  }
  
  public Link scanLink(String line){

    String text = line.substring(1,line.indexOf(']'));
    String reference = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
    
    Link link = new Link(text, reference);
    
    String[] actionStrings = line.split("[{]");
    
    List<Action> actions = scanActions(actionStrings);
    for(Action a : actions) {
      link.addAction(a);
    }
    
    return link;
  }
  
  private List<Action> scanActions(String[] actionLines){
    List<Action> actions = new ArrayList<>();
    for(int i = 1; i < actionLines.length; i++){
      String actionString = actionLines[i];
      String s = actionString.replace("[{}]", "");
      String actionType = s.substring(0, s.indexOf('('));
      String actionContent = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
      
      if(actionType.equalsIgnoreCase("gold")){
        Action goldAction = new GoldAction(Integer.parseInt(actionContent));
        actions.add(goldAction);
      }else if(actionType.equalsIgnoreCase("health")){
        Action healthAction = new HealthAction(Integer.parseInt(actionContent));
        actions.add(healthAction);
      }else if(actionType.equalsIgnoreCase("score")){
        Action scoreAction = new ScoreAction(Integer.parseInt(actionContent));
        actions.add(scoreAction);
      }else if(actionType.equalsIgnoreCase("inventory")){
        Action inventoryAction = new InventoryAction(actionContent);
        actions.add(inventoryAction);
      }else {
        throw new IllegalArgumentException("Action type not recognised");
      }
    }
    return actions;
  }
  
}

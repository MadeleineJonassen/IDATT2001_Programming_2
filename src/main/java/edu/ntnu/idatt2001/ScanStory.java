package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanStory {
  
  //make method static?
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
  
  private Passage scanPassage(Scanner scan){
    if(!scan.hasNext()){
      throw new IllegalArgumentException();
    }
    
    String title = scan.nextLine().substring(2);
    Passage passage = new Passage(title, scan.nextLine());
    
    String line;
    while(!(line = scan.nextLine()).isBlank()){
      passage.addLink(scanLink(line));
    }
    
    return passage;
  }
  
  public Link scanLink(String line){
    //TODO: add support for actions
    //TODO: check for multiple occurences of [](){}
    String text = line.substring(1,line.indexOf(']'));
    String reference = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
    
    Link link = new Link(text, reference);
    
    int actionCount = line.length() - line.replace("{", "").length();
    int actionIndex = 0;
    
    //TODO: seperate out scanAction method
    while(actionIndex <= (line.length() - 1)){
      String actionString = line.substring(line.indexOf('{') + 1, line.indexOf('}'));
      
      actionIndex = line.indexOf('}');
      
      String actiontype = actionString.substring(0, actionString.indexOf('('));
      String actionContent = actionString.substring(actionString.indexOf('(') + 1, actionString.indexOf(')'));
      if(actiontype.equalsIgnoreCase("gold")){
        Action goldAction = new GoldAction(Integer.parseInt(actionContent));
        link.addAction(goldAction);
      }else if(actiontype.equalsIgnoreCase("health")){
        Action healthAction = new HealthAction(Integer.parseInt(actionContent));
        link.addAction(healthAction);
      }else if(actiontype.equalsIgnoreCase("score")){
        Action scoreAction = new ScoreAction(Integer.parseInt(actionContent));
        link.addAction(scoreAction);
      }else{
        Action inventoryAction = new InventoryAction(actionContent);
        link.addAction(inventoryAction);
      }
    }
    
    return link;
  }
  
}

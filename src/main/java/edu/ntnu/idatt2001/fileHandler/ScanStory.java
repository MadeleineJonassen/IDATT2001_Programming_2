package edu.ntnu.idatt2001.fileHandler;

import edu.ntnu.idatt2001.action.*;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Scan story.
 */
public class ScanStory {
  
  /**
   * Scan story story.
   *
   * @param file the file
   * @return the story
   * @throws FileNotFoundException the file not found exception
   */
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
      throw new IllegalArgumentException();
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
  
  /**
   * Scan link link.
   *
   * @param line the line
   * @return the link
   */
  public Link scanLink(String line){
    //TODO: add support for actions
    //TODO: check for multiple occurences of [](){}
    String text = line.substring(1,line.indexOf(']'));
    String reference = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
    
    Link link = new Link(text, reference);
    int actionCount = 0;
    //StringUtils.countMatches(line, "{");
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '{') {
        actionCount++;
      }
    }
    String[] actionStrings = line.split("[{]");
    //TODO: seperate out scanAction method
    for(int i = 1; i < actionStrings.length; i++){
      String actionString = actionStrings[i];
      String s = actionString.replace("[{}]", "");
      String actionType = s.substring(0, s.indexOf('('));
      String actionContent = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
      
      if(actionType.equalsIgnoreCase("gold")){
        Action goldAction = new GoldAction(Integer.parseInt(actionContent));
        link.addAction(goldAction);
      }else if(actionType.equalsIgnoreCase("health")){
        Action healthAction = new HealthAction(Integer.parseInt(actionContent));
        link.addAction(healthAction);
      }else if(actionType.equalsIgnoreCase("score")){
        Action scoreAction = new ScoreAction(Integer.parseInt(actionContent));
        link.addAction(scoreAction);
      }else{
        Action inventoryAction = new InventoryAction(actionContent);
        link.addAction(inventoryAction);
      }
    }
    
    return link;
  }
  
  private void scanAction(String substring){
  
  }
  
}

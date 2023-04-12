package edu.ntnu.idatt2001;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanStory {
  
  //make method static?
  public Story scanStory(File file) throws FileNotFoundException {
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
    
    //make scanLinks as separate method?
    String line = null;
    while(!(line = scan.nextLine()).isBlank()){
      String text = line.substring(1,line.indexOf("]"));
      String reference = line.substring(line.indexOf("(") + 1, line.length() - 1);
      passage.addLink(new Link(text, reference));
    }
    
    return passage;
  }
  
}

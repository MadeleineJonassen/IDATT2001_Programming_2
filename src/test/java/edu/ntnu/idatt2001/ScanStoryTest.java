package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.GoldAction;
import edu.ntnu.idatt2001.Action.InventoryAction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ScanStoryTest {
  
  @Test
  void scanStory() throws FileNotFoundException {
    ScanStory scan = new ScanStory();
    Story scanStory = scan.scanStory(new File("src/main/resources/Stories.paths"));
    
    Passage openingPassage = new Passage("Beginnings", "You are in a small, dimly lit room. There is a door in front of you.");
    openingPassage.addLink(new Link("Try to open the door","Another room"));
    Story story = new Story("Haunted House", openingPassage);
    Passage passage = new Passage("Another room", "The door opens to another room. You see a desk with a large, dusty book.");
    passage.addLink(new Link("Open the book","The book of spells"));
    passage.addLink(new Link("Go back","Beginnings"));
    story.addPassage(passage);
    
    //assertEquals(story, scanStory);
    assertEquals(story.getOpeningPassage(), scanStory.getOpeningPassage());
    //assertEquals(story.getPassages(), scanStory.getPassages());
    //^^ same elements, different order
    
  }
  
  @Test
  void scanLinkTest(){
    Link link = new Link("text", "reference");
    link.addAction(new GoldAction(10));
    link.addAction(new InventoryAction("watch"));
    
    ScanStory scan = new ScanStory();
    Link stringLink = scan.scanLink("[text](reference){gold(10)}{inventory(watch)}");
    
    
    
  }
}
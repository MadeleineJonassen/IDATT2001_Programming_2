package edu.ntnu.idatt2001;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.fileHandler.ScanStory;
import edu.ntnu.idatt2001.model.Action.GoldAction;
import edu.ntnu.idatt2001.model.Action.InventoryAction;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;


class ScanStoryTest {
  
  @Test
  void scanStory() throws FileNotFoundException {
    ScanStory scan = new ScanStory();
    Story scanStory = scan.scanStory(new File("src/main/resources/Stories/Stories.paths"));
    
    Passage openingPassage = new Passage("Beginnings",
            "You are in a small, dimly lit room. There is a door in front of you.");
    openingPassage.addLink(new Link("Try to open the door", "Another room"));
    Story story = new Story("Haunted House", openingPassage);
    Passage passage = new Passage("Another room",
            "The door opens to another room. You see a desk with a large, dusty book.");
    passage.addLink(new Link("Open the book", "The book of spells"));
    passage.addLink(new Link("Go back", "Beginnings"));
    story.addPassage(passage);
    
    assertEquals(story, scanStory);
    assertEquals(story.getOpeningPassage(), scanStory.getOpeningPassage());
    assertTrue(story.getPassages().containsAll(scanStory.getPassages()));
  }
  
  @Test
  void scanLinkTest() {
    Link link1 = new Link("text", "reference");
    link1.addAction(new GoldAction(10));
    link1.addAction(new InventoryAction("watch"));
    
    ScanStory scan = new ScanStory();
    Link link2 = scan.scanLink("[text](reference){gold(10)}{inventory(watch)}");
    
    assertEquals(link1.toString(), link2.toString());
    
  }
  
}
package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.fileHandler.WriteStory;
import edu.ntnu.idatt2001.model.Action.*;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;
import org.junit.jupiter.api.Test;

class WriteStoryTest {
  Passage openingPassage = new Passage("Opening passage", "Opening passage");
  Story story = new Story("Test Story title", openingPassage);
  Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
  Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
  Link link1 = new Link("PassageTitle1", "PassageTitle1");
  Link link2 = new Link("PassageTitle2", "PassageTitle2");
  Action goldAction = new GoldAction(10);
  Action inventoryAction = new InventoryAction("Inventory");
  Action scoreAction = new ScoreAction(30);
  Action healthAction = new HealthAction(10);
  
  
  @Test
  void writeShortStory() {
    WriteStory write = new WriteStory();
    write.write(story);
  }
  
  @Test
  void writeStoryWithPassages() {
    link1.addAction(goldAction);
    link1.addAction(inventoryAction);
    link1.addAction(scoreAction);
    link1.addAction(healthAction);
    openingPassage.addLink(link1);
    openingPassage.addLink(link2);
    WriteStory write = new WriteStory();
    write.write(story);
  }
  
}

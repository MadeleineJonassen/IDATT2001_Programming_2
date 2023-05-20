package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.Model.Passage;
import edu.ntnu.idatt2001.Model.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoryTest {
  
  @Nested
  class ConstructStory {
    
    @Test
    public void constructCorrectly(){
      Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
      
      Story story = new Story("Title",openingPassage);
      
      assertEquals(story.getOpeningPassage(), openingPassage);
      assertEquals(story.getTitle(), "Title");
    }
    
    @Test
    public void emptyTitle(){
      Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
      
      
      assertThrows(IllegalArgumentException.class, () -> {
        Story story = new Story("",openingPassage);
      }, "Title cannot be empty");
    }
  }
  
  @Nested
  class GetMethods {
    Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
    Story story = new Story("Title",openingPassage);
    
    Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
    Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
    Passage passage3 = new Passage("PassageTitle3", "PassageContent3");
    
    @Test
    public void getSinglePassage(){
      story.addPassage(passage1);
      
      assertEquals(passage1, story.getPassage(new Link("PassageTitle1","PassageTitle1")));
    }
    
    @Test
    public void getNonExistingPassage(){
      story.addPassage(passage1);
      
      assertFalse(story.getPassages().contains(passage2));
      
      assertThrows(IllegalArgumentException.class, () -> {
        story.getPassage(new Link("PassageTitle2","PassageTitle2"));
      }, "No such link in the story.");
    }
    
    @Test
    public void getMultiplePassages(){
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      Story story2 = new Story("Title" ,openingPassage);
      story2.addPassage(passage1);
      story2.addPassage(passage2);
      
      
      assertEquals(story.getPassages(), story2.getPassages());
      
      Story story3 = new Story("Title" ,openingPassage);
      story3.addPassage(passage1);
      story3.addPassage(passage3);
      
      assertNotEquals(story, story3);
    }
    
  }
  
  @Nested
  class ChangePassages {
    Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
    Story story = new Story("Title",openingPassage);
    
    @Test
    public void addPassages(){
      Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
      Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
      Passage passage3 = new Passage("PassageTitle3", "PassageContent3");
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      story.addPassage(passage3);
      
      assertEquals(story.getPassages().size(), 4);
    }
    
    @Test
    public void addDuplicatePassages(){
      Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
      Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      assertThrows(IllegalArgumentException.class, () -> {
        story.addPassage(passage1);
      }, "This passage has already been added to the story");
    }
    
    @Test
    public void removePassages(){
      Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
      Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
      Passage passage3 = new Passage("PassageTitle3", "PassageContent3");
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      story.addPassage(passage3);
      
      assertTrue(story.getPassages().contains(passage1));
      
      story.removePassage(new Link("PassageTitle1", "PassageTitle1"));
      
      assertFalse(story.getPassages().contains(passage1));
      assertTrue(story.getPassages().contains(passage2));
      assertTrue(story.getPassages().contains(passage3));
    }
    
    @Test
    public void removeNonExistingPassage(){
      Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
      Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
      story.addPassage(passage1);
      
      assertTrue(story.getPassages().contains(passage1));
      assertFalse(story.getPassages().contains(passage2));
      
      assertThrows(IllegalArgumentException.class, () -> {
        story.removePassage(new Link("PassageTitle1", "PassageTitle2"));
      }, "No such link in the story.");
      
    }
    
    @Test
    public void replacePassages(){
      Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
      Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
      Passage passage3 = new Passage("PassageTitle3", "PassageContent3");
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      story.addPassage(passage3);
      
      assertTrue(story.getPassages().contains(passage1));
      
      story.removePassage(new Link("PassageTitle1", "PassageTitle1"));
      
      story.addPassage(passage1);
      
      assertTrue(story.getPassages().contains(passage1));
      assertTrue(story.getPassages().contains(passage2));
      assertTrue(story.getPassages().contains(passage3));
      
      
    }
  }
  
  @Nested
  class Equals {
    Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
    Story story = new Story("Title",openingPassage);
    Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
    Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
    
    Passage openingPassage2 = new Passage("Opening Passage","Opening Passage Content");
    Story story2 = new Story("Title" ,openingPassage2);
    
    
    @Test
    public void testEquals(){
      story.addPassage(passage1);
      
      story2.addPassage(passage1);
      
      assertEquals(story, story2);
      
      story2.addPassage(passage2);
      
      assertNotEquals(story, story2);
    }
    
    @Test
    public void equalsDifferentPassages(){
      Passage passage3 = new Passage("PassageTitle3", "PassageContent3");
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      story2.addPassage(passage1);
      story2.addPassage(passage3);
      
      assertNotEquals(story, story2);
      
      story.addPassage(passage3);
      story2.addPassage(passage2);
      
      assertEquals(story,story2);
      
    }
    
  }
  
  @Nested
  class BrokenLinks {
    Passage openingPassage = new Passage("Opening Passage","Opening Passage Content");
    Story story = new Story("Title",openingPassage);
    
    Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
    Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
    
    @Test
    public void getStoryBrokenLinks(){
      Link brokenLink1 = new Link("Link3","PassageTitle3");
      openingPassage.addLink(new Link("Link1","PassageTitle1"));
      openingPassage.addLink(new Link("Link2","PassageTitle2"));
      passage1.addLink(new Link("Link3","PassageTitle2"));
      passage1.addLink(brokenLink1);
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      List<Link> brokenLinks = story.getBrokenLinks();

      assertTrue(brokenLinks.contains(brokenLink1));
    }
    
    @Test
    public void noBrokenLinks(){
      Link brokenLink1 = new Link("Link3","PassageTitle3");
      openingPassage.addLink(new Link("Link1","PassageTitle1"));
      openingPassage.addLink(new Link("Link2","PassageTitle2"));
      passage1.addLink(new Link("Link3","PassageTitle2"));
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      assertEquals(0, story.getBrokenLinks().size());
    }
    
    @Test
    public void testDeleteBrokenLinks(){
      Link brokenLink1 = new Link("Link3","PassageTitle3");
      openingPassage.addLink(new Link("Link1","PassageTitle1"));
      openingPassage.addLink(new Link("Link2","PassageTitle2"));
      passage1.addLink(new Link("Link3","PassageTitle2"));
      passage1.addLink(brokenLink1);
      
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      List<Link> brokenLinks = story.getBrokenLinks();
      
      assertTrue(brokenLinks.contains(brokenLink1));
      
      story.deleteBrokenLinks();
      
      assertEquals(0, story.getBrokenLinks().size());
    }
  }
}

package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassageTest {
  
  @Nested
  class ConstructPassages {
    
    @Test
    void constructSimplePassage(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      assertEquals(passage.getTitle(), "PassageTitle");
      assertEquals(passage.getContent(), "PassageContent");
    }
    
    @Test
    void constructPassageWithLinks(){
      Link link1 = new Link("LinkText1","LinkReference1");
      Link link2 = new Link("LinkText2","LinkReference2");
      Passage passage = new Passage("PassageTitle", "PassageContent", link1, link2);
      assertEquals(passage.getTitle(), "PassageTitle");
      assertEquals(passage.getContent(), "PassageContent");
      assertEquals(passage.getLinks().get(0), link1);
      assertEquals(passage.getLinks().get(1), link2);
    }
  }
  
  @Nested
  class AddLinksToPassage {
    
    @Test
    void addLinks(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Link link1 = new Link("LinkText1","LinkReference1");
      Link link2 = new Link("LinkText2","LinkReference2");
      passage.addLink(link1);
      passage.addLink(link2);
      assertTrue(passage.hasLinks());
      assertEquals(passage.getLinks().get(0), link1);
      assertEquals(passage.getLinks().get(1), link2);
    }
    
    @Test
    void removeLinks(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Link link1 = new Link("LinkText1","LinkReference1");
      Link link2 = new Link("LinkText2","LinkReference2");
      Link link3 = new Link("LinkText3","LinkReference3");
      passage.addLink(link1);
      passage.addLink(link2);
      passage.addLink(link3);
      passage.removeLink(link1);
      assertEquals(passage.getLinks().get(0), link2);
      assertEquals(passage.getLinks().get(1), link3);
    }
    
    @Test
    void addDuplicateLinks(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Link link1 = new Link("LinkText1","LinkReference1");
      passage.addLink(link1);
      
      assertThrows(IllegalArgumentException.class, () -> {
        passage.addLink(link1);
      }, "Link has already been added to the passage");
      
    }
  }
  
  @Nested
  class PassageToString {
    
    @Test
    public void passageToString(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      assertEquals(passage.toString(), "Passage: PassageTitle, content: PassageContent.");
    }
  }
  
  @Nested
  class Equals {
    @Test
    public void equalReferenceAndText(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Passage passage2 = new Passage("PassageTitle", "PassageContent");
      assertEquals(passage, passage2);
    }
    
    @Test
    public void equalTitle(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Passage passage2 = new Passage("PassageTitle", "Unequal PassageContent");
      assertEquals(passage, passage2);
    }
    
    @Test
    public void equalContent(){
      Passage passage = new Passage("PassageTitle", "PassageContent");
      Passage passage2 = new Passage("Unequal PassageTitle", "PassageContent");
      assertNotEquals(passage, passage2);
    }
  }
  
}

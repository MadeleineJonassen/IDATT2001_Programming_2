package edu.ntnu.idatt2001;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.model.Action.Action;
import edu.ntnu.idatt2001.model.Action.GoldAction;
import edu.ntnu.idatt2001.model.Action.HealthAction;
import edu.ntnu.idatt2001.model.Link;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test for the unit Link.
 */
public class LinkTest {
  
  @Nested
  class ConstructLinks {
    @Test
    public void constructCorrectly() {
      Link link = new Link("LinkText", "LinkReference");
      assertEquals(link.getText(), "LinkText");
      assertEquals(link.getReference(), "LinkReference");
    }
    
    @Test
    public void constructEmptyText() {
      IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
        Link link = new Link("", "LinkReference");
      }, "Text cannot be empty");
    }
    
    @Test
    public void constructEmptyReference() {
      assertThrows(IllegalArgumentException.class, () -> {
        Link link = new Link("LinkText", "");
      }, "Reference cannot be empty");
    }
  }
  
  @Nested
  class AddActions {
    Link link = new Link("LinkText", "LinkReference");

    @Test
    public void addCorrectly() {
      Action goldAction = new GoldAction(10);
      link.addAction(goldAction);
      Action healthAction = new HealthAction(20);
      link.addAction(healthAction);
      assertEquals(link.getActions().get(0), goldAction);
      assertEquals(link.getActions().get(1), healthAction);
    }
    
    @Test
    public void addNoActions() {
      assertTrue(link.getActions().isEmpty());
    }
    
    @Test
    public void addDuplicates() {
      Action goldAction = new GoldAction(10);
      link.addAction(goldAction);
      assertThrows(IllegalArgumentException.class, () -> {
        link.addAction(goldAction);
      }, "Action has already been added to the link");
    }
    
  }
  
  @Nested
  class ToString {
    Link link = new Link("LinkText", "LinkReference");
    
    @Test
    public void testToString() {
      assertEquals(link.toString(),
              "LinkText" + ", next: " + "LinkReference" + ". Actions: [" + "]");
    }
  }
  
  @Nested
  class Equals {
    Link link = new Link("LinkText", "LinkReference");
    
    
    @Test
    public void equalTextAndReference() {
      Link newLink = new Link("LinkText", "LinkReference");
      
      assertEquals(link, newLink);
    }
    
    @Test
    public void equalText() {
      Link newLink = new Link("LinkText", "UnEqual LinkReference");
      
      assertNotEquals(newLink, link);
    }
    
    @Test
    public void equalReference() {
      Link newLink = new Link("UnEqual LinkText",  "LinkReference");
      
      assertEquals(newLink, link);
    }
  }
}
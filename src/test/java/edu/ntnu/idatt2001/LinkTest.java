package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
  
  String testText = "testText";
  String testReference = "testReference";
  Link testLink = new Link(testText, testReference);
  
  @Test
  void getTextTest() {
    assertEquals(testText, testLink.getText());
  }
  
  @Test
  void getReferenceTest() {
    assertEquals(testReference, testLink.getReference());
  }
  
  @Test
  void addGetActionTest() {
    Action testAction = new GoldAction(10);
    testLink.addAction(testAction);
    assertEquals(testAction, testLink.getActions().get(0));
  }
  
   @Test
   void addGetActionsTest(){
     Action testAction1 = new GoldAction(10);
     Action testAction2 = new HealthAction(10);
     Action testAction3 = new ScoreAction(50);
     Action testAction4 = new InventoryAction("TestItem");
     testLink.addAction(testAction1);
     testLink.addAction(testAction2);
     testLink.addAction(testAction3);
     testLink.addAction(testAction4);
     assertEquals(testAction4, testLink.getActions().get(3));
   }
  
  @Test
  void toStringTest() {
    assertEquals(testText + ", next: " + testReference, testLink.toString());
  }
  
  @Test
  void testEquals() {
    String testText2 = "testText";
    String testReference2 = "testReference";
    Link testLink2 = new Link(testText2, testReference2);
    assertTrue(testLink2.equals(testLink));
  }
  
  @Test
  void testHashCode() {
  }
}
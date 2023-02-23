package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.GoldAction;
import org.junit.jupiter.api.Test;

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
  void addActionTest() {
    testLink.addAction(new GoldAction(10));
  }
  
  @Test
  void testToStringTest() {
  }
  
  @Test
  void testEquals() {
  }
  
  @Test
  void testHashCode() {
  }
}
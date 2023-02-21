package edu.ntnu.idatt2001;

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
  void addAction() {
  
  }
  
  @Test
  void testToString() {
  }
  
  @Test
  void testEquals() {
  }
  
  @Test
  void testHashCode() {
  }
}
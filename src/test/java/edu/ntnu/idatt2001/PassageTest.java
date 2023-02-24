package edu.ntnu.idatt2001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassageTest {
  
  String testTitle = "testTitle";
  String testContent = "testContent";
  Passage testPassage = new Passage(testTitle, testContent);
  
  @Test
  void getTitle() {
    assertEquals(testTitle, testPassage.getTitle());
  }
  
  @Test
  void getContent() {
    assertEquals(testContent, testPassage.getContent());
  }
  
  @Test
  void addGetLink() {
    Link testLink = new Link("testLinkText", "testLinkReference");
    testPassage.addLink(testLink);
    assertEquals(testLink, testPassage.getLinks().get(0));
  }
  
  @Test
  void addGetLinks() {
    Link testLink1 = new Link("testLinkText1", "testLinkReference1");
    testPassage.addLink(testLink1);
    Link testLink2 = new Link("testLinkText2", "testLinkReference2");
    testPassage.addLink(testLink2);
    Link testLink3 = new Link("testLinkText3", "testLinkReference3");
    testPassage.addLink(testLink3);
    assertEquals(testLink3, testPassage.getLinks().get(2));
  }
  
  @Test
  void hasLinks() {
    Link testLink1 = new Link("testLinkText1", "testLinkReference1");
    testPassage.addLink(testLink1);
    Link testLink2 = new Link("testLinkText2", "testLinkReference2");
    testPassage.addLink(testLink2);
    Link testLink3 = new Link("testLinkText3", "testLinkReference3");
    testPassage.addLink(testLink3);
    assertTrue(testPassage.hasLinks());
  }
  
  @Test
  void testToString() {
    assertEquals("Passage: " + testTitle + ", content: " + testContent + ".", testPassage.toString());
  }
  
  @Test
  void testEquals() {
    String testTitle1 = "testTitle";
    String testContent1 = "testContent";
    Passage testPassage1 = new Passage(testTitle1, testContent1);
    assertTrue(testPassage1.equals(testPassage));
  }
  
  @Test
  void testHashCode() {
  }
}
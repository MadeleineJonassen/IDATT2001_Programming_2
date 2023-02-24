package edu.ntnu.idatt2001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

  
  
  @Test
  void getTitleTest() {
    String testTitle = "testTitle";
    Passage testPassage = new Passage("testPassageTitle", "testPassageContent");
    Story testStory = new Story(testTitle, testPassage);
    assertEquals(testTitle, testStory.getTitle());
  }
  
  @Test
  void getOpeningPassageTest() {
    String testTitle = "testTitle";
    Passage testOpeningPassage = new Passage("testOpeningPassageTitle", "testPassageContent");
    Story testStory = new Story(testTitle, testOpeningPassage);
    assertEquals(testOpeningPassage, testStory.getOpeningPassage());
  }
  
  @Test
  void addGetPassageTest() {
    String testTitle = "testTitle";
    Passage testOpeningPassage = new Passage("testOpeningPassageTitle", "testPassageContent");
    Link testLink1 = new Link("testLink1","testPassage1");
    testOpeningPassage.addLink(testLink1);
    Passage testPassage1 = new Passage("testPassage1", "testPassage1Content");
    Story testStory = new Story(testTitle, testOpeningPassage);
    testStory.addPassage(testPassage1);
    assertEquals(testPassage1, testStory.getPassage(testLink1));
  }
  
  @Test
  void addGetPassagesTest() {
    String testTitle = "testTitle";
    Passage testOpeningPassage = new Passage("testOpeningPassageTitle", "testPassageContent");
    Link testLink1 = new Link("testLink1","testPassage1");
    Link testLink2 = new Link("testLink2","testPassage2");
    Link testLink3 = new Link("testLink3","testPassage3");
    testOpeningPassage.addLink(testLink1);
    testOpeningPassage.addLink(testLink2);
    testOpeningPassage.addLink(testLink3);
    Passage testPassage1 = new Passage("testPassage1", "testPassage1Content");
    Passage testPassage2 = new Passage("testPassage2", "testPassage2Content");
    Passage testPassage3 = new Passage("testPassage3", "testPassage3Content");
    Story testStory = new Story(testTitle, testOpeningPassage);
    testStory.addPassage(testPassage1);
    testStory.addPassage(testPassage2);
    testStory.addPassage(testPassage3);
    assertEquals(testPassage3, testStory.getPassage(testLink3));
  }
}
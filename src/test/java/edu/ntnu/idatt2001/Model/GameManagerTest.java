package edu.ntnu.idatt2001.Model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
  
  @Test
  void listFiles() {
    Set<String> files = new HashSet<String>();
    files.add("Stories.paths");
    files.add("Stories.txt");
    files.add("Write.txt");
    
    GameManager gameManager = new GameManager();
    
    assertEquals(files, gameManager.listFiles());
  }
  
  @Test
  void setPlayer() {
  }
  
  @Test
  void setGoals() {
  }
  
  @Test
  void addGoal() {
  }
  
  @Test
  void newGame() {
  }
  
  @Test
  void getBrokenLinks() {
  }
  
  @Test
  void getGame() {
  }
  
  @Test
  void getStoryTitle() {
  }
}
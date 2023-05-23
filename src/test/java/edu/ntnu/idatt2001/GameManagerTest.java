package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.model.Action.Action;
import edu.ntnu.idatt2001.model.Action.GoldAction;
import edu.ntnu.idatt2001.model.Action.InventoryAction;
import edu.ntnu.idatt2001.model.Goal.Goal;
import edu.ntnu.idatt2001.model.Goal.GoldGoal;
import edu.ntnu.idatt2001.model.Goal.HealthGoal;
import edu.ntnu.idatt2001.model.Player;
import edu.ntnu.idatt2001.model.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
  GameManager gameManager = new GameManager();
  Player player1 = new Player(new Player.Builder("Name", 0, 0, 0, new ArrayList<>()));
  Goal goal1 = new HealthGoal(20);
  Goal goal2 = new GoldGoal(10);
  Passage openingPassage = new Passage("Opening passage","Opening passage");
  Story story = new Story("Story title", openingPassage);
  Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
  Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
  Link link1 = new Link("PassageTitle1", "PassageTitle1");
  Link link2 = new Link("PassageTitle2", "PassageTitle2");
  Action goldAction = new GoldAction(10);
  Action inventoryAction = new InventoryAction("Inventory");
  
  @Nested
  class AddPrerequisites {
    @Test
    void setStory () {
      assertFalse(gameManager.storyHasBeenAdded());
      gameManager.setStory(story);
      assertTrue(gameManager.storyHasBeenAdded());
    }
    
    @Test
    void setPlayer() {
      assertFalse(gameManager.playerHasBeenAdded());
      gameManager.setPlayer(player1);
      assertTrue(gameManager.playerHasBeenAdded());
    }
    
    @Test
    void addGoals() {
      assertTrue(gameManager.getGoals().isEmpty());
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      assertFalse(gameManager.getGoals().isEmpty());
    }
  }
  @Nested
  class ConstructGame {
    @Test
    void constructGameWithoutStory() {
      gameManager.setPlayer(player1);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      
      assertThrows(NullPointerException.class, () -> {
        gameManager.createGame();
      }, "Story has not been added");
    }
    
    @Test
    void constructGameWithoutPlayer() {
      gameManager.setStory(story);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      assertThrows(NullPointerException.class, () -> {
        gameManager.createGame();
      }, "Player has not been added");
    }
    
    @Test
    void constructGameWithoutGoals() {
      gameManager.setStory(story);
      gameManager.setPlayer(player1);
      assertThrows(NullPointerException.class, () -> {
        gameManager.createGame();
      }, "Goals have not been added");
    }
    
    @Test
    void constructGame() {
      gameManager.setStory(story);
      gameManager.setPlayer(player1);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      assertNull(gameManager.getGame());
      gameManager.createGame();
      assertNotNull(gameManager.getGame());
    }
  }
  
  @Nested
  class ClassMethods {
    
    @Test
    void getMethods() {
      assertThrows(IllegalArgumentException.class, () -> gameManager.getPlayer(), "Player has not been added.");
      assertThrows(IllegalArgumentException.class, () -> gameManager.getPlayerName(), "Player has not been added.");
      assertThrows(IllegalArgumentException.class, () -> gameManager.getBrokenLinks(), "The story is not defined");
      assertThrows(NullPointerException.class, () -> gameManager.getStoryTitle(), "Story must be added first");
      assertThrows(NullPointerException.class, () -> gameManager.getStoryPassageNames(), "Story must be added first");
      
      gameManager.setPlayer(player1);
      gameManager.setStory(story);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      gameManager.createGame();
      
      assertEquals(gameManager.getPlayer(), player1);
      assertEquals(gameManager.getPlayerName(), player1.getName());
      assertEquals(gameManager.getGame().getStory(), story);
      assertEquals(gameManager.getStoryTitle(), story.getTitle());
      
      
      assertTrue(gameManager.getStoryPassageNames().contains(openingPassage.getTitle()));
      
      List<String> playerInfo = new ArrayList<>();
      playerInfo.add((player1.getName()));
      playerInfo.add(Integer.toString(player1.getHealth()));
      playerInfo.add(Integer.toString(player1.getGold()));
      playerInfo.add(Integer.toString(player1.getScore()));
      playerInfo.add(player1.getInventory().toString().replace("[", "").replace("]", ""));
      
      assertEquals(gameManager.getPlayerInfo().stream().toList(), playerInfo);
    }
    
    @Test
    void gameInProgress() {
      gameManager.setPlayer(player1);
      gameManager.setStory(story);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      gameManager.createGame();
      
      PlayGameModel playGameModel = new PlayGameModel(gameManager.getGame());
      gameManager.setGameInProgress(playGameModel);
      
      assertEquals(gameManager.getGameInProgress(), playGameModel);
    }
    
    @Test
    void brokenLinks() {
      openingPassage.addLink(link1);
      openingPassage.addLink(link2);
      gameManager.setStory(story);
      
      assertNotNull(gameManager.getBrokenLinks());
      gameManager.deleteBrokenLinks();
      assertTrue(gameManager.getBrokenLinks().isEmpty());
    }
    
    @Test
    void clearGoals() {
      gameManager.setPlayer(player1);
      gameManager.setStory(story);
      gameManager.addGoal(goal1);
      gameManager.addGoal(goal2);
      
      assertEquals(gameManager.getGoals().size(), 2);
      
      gameManager.clearGoals();
      
      assertEquals(gameManager.getGoals().size(), 0);
    }
  }
  
  
  
  
}

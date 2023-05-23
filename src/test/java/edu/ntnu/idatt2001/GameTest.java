package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.model.Game;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;
import edu.ntnu.idatt2001.model.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
  
  Player player1 = new Player(new Player.Builder("Name", 0, 0, 0, new ArrayList<>()));
  
  Passage openingPassage = new Passage("Opening passage","Opening passage");
  Story story = new Story("Story title", openingPassage);
  
  Passage passage1 = new Passage("PassageTitle1", "PassageContent1");
  Passage passage2 = new Passage("PassageTitle2", "PassageContent2");
  
  Link link1 = new Link("PassageTitle1", "PassageTitle1");
  Link link2 = new Link("PassageTitle2", "PassageTitle2");
  
  List<Goal> goals = new ArrayList<>();
  
  List<String> goalList = new ArrayList<>();
  Goal goal1 = new InventoryGoal(goalList);
  Goal goal2 = new GoldGoal(10);
  Goal goal3 = new HealthGoal(20);
  Goal goal4 = new ScoreGoal(30);
  
  @Nested
  class Construct {
    
    @Test
    public void constructWithEmptyGoals(){
      Game game = new Game(player1, story, goals);
      
      assertEquals(game.getStory(), story);
    }
    
    @Test
    public void constructWithGoals(){
      goals.add(goal1);
      goals.add(goal2);
      goals.add(goal3);
      goals.add(goal4);
      
      Game game = new Game(player1, story, goals);
      
      assertEquals(game.getGoals(), goals);
    }
    
    @Test
    public void addGoalsAfterConstruction(){

      Game game = new Game(player1, story, goals);
      
      goals.add(goal4);
      
      assertEquals(game.getGoals(), goals);
    }
  }
  
  @Nested
  class CheckGoals {
    @Test
    public void checkGoalCompletion(){
      goalList.add("Inventory1");
      goals.add(goal1);
      goals.add(goal2);
      goals.add(goal3);
      goals.add(goal4);
      
      Game game = new Game(player1, story, goals);
      
      int numOfCompletedGoals = 0;
      
      for(Goal g : game.getGoals()){
        if (g.isFulfilled(player1)){
          numOfCompletedGoals++;
        }
      }
      
      assertEquals(0, numOfCompletedGoals);
    }
    
    @Test
    public void checkCompletedGoals(){
      goalList.add("Inventory1");
      goals.add(new InventoryGoal(goalList));
      goals.add(goal2);
      goals.add(goal3);
      goals.add(goal4);
      
      Game game = new Game(player1, story, goals);
      
      player1.addToInventory("Inventory1");
      player1.addGold(20);
      player1.addHealth(20);
      player1.addScore(30);
      
      int numOfCompletedGoals = 0;
      
      for(Goal g : game.getGoals()){
        if (g.isFulfilled(player1)){
          numOfCompletedGoals++;
        }
      }
      
      assertEquals(game.getGoals().size(), numOfCompletedGoals);
    }
  }
  
  @Nested
  class StoryPassages {
    @Test
    public void beginTest(){
      Game game = new Game(player1, story, goals);
      
      assertEquals(openingPassage, game.begin());
    }
    
    @Test
    public void goToExistingPassages(){
      Link link1 = new Link("PassageTitle1", "PassageTitle1");
      Link link2 = new Link("PassageTitle2", "PassageTitle2");
      openingPassage.addLink(link1);
      openingPassage.addLink(link2);
      story.addPassage(passage1);
      story.addPassage(passage2);
      
      Game game = new Game(player1, story, goals);
      
      game.go(link1);
      
      assertEquals(game.go(link1), passage1);
      assertEquals(game.go(link2), passage2);
    }
    
    @Test
    public void goToNonExistingPassage(){
      Link link1 = new Link("PassageTitle1", "PassageTitle1");
      Link link2 = new Link("PassageTitle2", "PassageTitle2");
      openingPassage.addLink(link1);
      openingPassage.addLink(link2);
      story.addPassage(passage1);
      
      Game game = new Game(player1, story, goals);
      
      game.go(link1);
      
      assertEquals(game.go(link1), passage1);
      assertThrows(IllegalArgumentException.class, () -> {
        game.go(link2);
      }, "No such link in the story");
    }
  }
}

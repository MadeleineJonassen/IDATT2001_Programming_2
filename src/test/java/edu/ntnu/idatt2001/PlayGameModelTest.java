package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.model.Action.Action;
import edu.ntnu.idatt2001.model.Action.GoldAction;
import edu.ntnu.idatt2001.model.Action.InventoryAction;
import edu.ntnu.idatt2001.model.Goal.Goal;
import edu.ntnu.idatt2001.model.Goal.GoldGoal;
import edu.ntnu.idatt2001.model.Goal.HealthGoal;
import edu.ntnu.idatt2001.model.Player;
import edu.ntnu.idatt2001.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PlayGameModelTest {
  
  Player player1 = new Player(new Player.Builder("Name", 10, 5, 0, new ArrayList<>()));
  List<Goal> goals = new ArrayList<>();
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
  Game game = new Game(player1, story, goals);
  PlayGameModel playGameModel;
  
  @BeforeEach
  void setup() {
    goals.add(goal1);
    goals.add(goal2);
    openingPassage.addLink(link1);
    openingPassage.addLink(link2);
    playGameModel = new PlayGameModel(game);
  }
  
  @Nested
  class GetMethods {
    
    @Test
    void getStoryMethods() {
      
      assertEquals(playGameModel.getStoryTitle(), story.getTitle());
      assertEquals(playGameModel.getPassageText().get(0), openingPassage.getTitle());
      assertEquals(playGameModel.getPassageText().get(1), openingPassage.getContent());
      assertTrue(playGameModel.getLinksText().contains(link1.getText()));
      assertTrue(playGameModel.getLinksText().contains(link2.getText()));
    }
    
    @Test
    void getGoalMethods(){
      assertTrue(playGameModel.getNonCompletedGoals().contains(goal1));
      assertTrue(playGameModel.getNonCompletedGoals().contains(goal2));
      assertTrue(playGameModel.getCompletedGoals().isEmpty());
    }
    
    @Test
    void getPlayerMethods(){
      String playerinfo = "["
              + player1.getName() + ", "
              + player1.getGold() + ", "
              + player1.getHealth() + ", "
              + player1.getScore() + ", "
              + player1.getInventory()
              + "]";
      assertEquals(playGameModel.getPlayerInfo().toString(), playerinfo);
    }
  }
  
  @Nested
  class PlayGame {
    
    @Test
    void nextPassage() {
      story.addPassage(passage1);
      story.addPassage(passage2);
      playGameModel = new PlayGameModel(game);
      
      playGameModel.nextPassage(link1.getText());
      assertEquals(playGameModel.getPassageText().get(0), passage1.getTitle());
      assertEquals(playGameModel.getPassageText().get(1), passage1.getContent());
    }
  }
}

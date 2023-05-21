package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.Action;
import edu.ntnu.idatt2001.Action.GoldAction;
import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.Model.Passage;
import edu.ntnu.idatt2001.Players.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
  
  @Nested
  class BuilderTesting {
    Player player = new Player.Builder("Name").health(10).score(20).gold(30).inventory(new ArrayList<>()).build();
    
    @Test
    public void addGoldTest(){
      int goldAmount = 15;
      player.addGold(goldAmount);
      
      assertEquals(45, player.getGold());
    }
    
    @Test
    public void goldActionTest(){
      int goldAmount = 15;
      Action goldaction = new GoldAction(15);
      goldaction.execute(player);
      
      assertEquals(45, player.getGold());
    }
  }
  
}

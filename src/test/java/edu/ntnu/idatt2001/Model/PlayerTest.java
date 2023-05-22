package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.action.Action;
import edu.ntnu.idatt2001.action.GoldAction;
import edu.ntnu.idatt2001.Players.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
  
  @Nested
  class BuilderTesting {
    Player player = new Player.Builder("Name", 10, 30).score(20).inventory(new ArrayList<>()).build();
    
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


package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Action.Action;
import edu.ntnu.idatt2001.Action.GoldAction;
import edu.ntnu.idatt2001.model.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
  Player player = new Player.Builder("Name", 10, 30).score(20).inventory(new ArrayList<>()).build();
  @Nested
  class BuilderConstruction {
    @Test
    void buildBarebones() {
      player = new Player.Builder("Name").health(10).gold(20).score(30).inventory(new ArrayList<>()).build();
      assertEquals(10, player.getHealth());
    }
    
    @Test
    void buildMandatoryValues() {
      player = new Player.Builder("Name", 17, 20).build();
      assertEquals(17, player.getHealth());
    }
  }
  
  @Nested
  class PlayerMethods {
    @Test
    void goldActionTest(){
      Action goldaction = new GoldAction(15);
      goldaction.execute(player);
      
      assertEquals(45, player.getGold());
    }
    
    @Test
    void addGoldTest(){
      int goldAmount = 15;
      player.addGold(goldAmount);
      
      assertEquals(45, player.getGold());
    }
    
    @Test
    void getString() {
      assertEquals("Name: Name | 10 HP | 20 score | 30 gold || Inventory: []", player.toString());
    }
    
  }
  
}


package edu.ntnu.idatt2001.Players;

import java.util.Collections;

public class PlayerData {

  //TODO fix playerData

  public void playerData(){
    Player Swordsman = new Player.Builder("Swordsman", 250, 10, 100).inventory(Collections.singletonList("Sword")).build();
    Player Witch = new Player.Builder("Witch", 200, 35, 150).inventory(Collections.singletonList("Book of Spells")).build();
  }
}

package edu.ntnu.idatt2001.Players;

import java.util.Collections;
import java.util.List;

public class PlayerData {

  //TODO make a list of "listed" players.

  //private List listedPlayers = new List <>;
  public static Player playerData(){
    Player Swordsman = new Player.Builder("Swordsman", 250, 10, 100).inventory(Collections.singletonList("Sword")).build();
    Player Witch = new Player.Builder("Witch", 200, 35, 150).inventory(Collections.singletonList("Book of Spells")).build();
    return Swordsman;
  }
}

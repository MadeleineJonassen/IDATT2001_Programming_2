package edu.ntnu.idatt2001.Players;

import javafx.collections.ObservableList;

import java.util.Collections;

import static edu.ntnu.idatt2001.GUI.MainMenu.listView;

public class PlayerData {

  public static String getPlayers() {
    ObservableList players = listView.getItems();
    players.add(new Player.Builder("Swordsman", 250, 10, 100, Collections.singletonList("Sword")).build());
    players.add(new Player.Builder("Witch", 200, 35, 150, Collections.singletonList("Book of Spells")).build());
    return players.toString();
  }
}

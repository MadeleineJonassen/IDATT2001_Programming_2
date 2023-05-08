package edu.ntnu.idatt2001.GUI;

import javafx.scene.control.Label;

public class createGameController {

  Label selectedPlayer;

  public void displayPlayer(String player) {
    selectedPlayer.setText("Hello: " + player);
  }
}

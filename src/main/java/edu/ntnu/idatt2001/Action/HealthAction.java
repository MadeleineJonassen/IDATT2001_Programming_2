package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.Player;

public class HealthAction implements Action {
  private int health;
  
  public void HealthAction(int health) {
    this.health = health;
  }
  
  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
}

package edu.ntnu.idatt2001.Goal;

import edu.ntnu.idatt2001.Players.Player;

public class HealthGoal implements Goal {
  private final int minimumHealth;
  
  public HealthGoal(int minimumHealth) {
    this.minimumHealth = minimumHealth;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getHealth() >= minimumHealth;
  }
}

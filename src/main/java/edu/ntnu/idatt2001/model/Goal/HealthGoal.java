package edu.ntnu.idatt2001.model.Goal;

import edu.ntnu.idatt2001.model.Player;

/**
 * A goal for health.
 */
public class HealthGoal implements Goal {
  private final int minimumHealth;
  
  public HealthGoal(int minimumHealth) {
    this.minimumHealth = minimumHealth;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getHealth() >= minimumHealth;
  }
  
  @Override
  public String toString() {
    return "Health Goal :" + minimumHealth
            + " hp";
  }
}

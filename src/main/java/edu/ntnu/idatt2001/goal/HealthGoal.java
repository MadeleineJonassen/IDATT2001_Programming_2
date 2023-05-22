package edu.ntnu.idatt2001.goal;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Health goal.
 */
public class HealthGoal implements Goal {
  private final int minimumHealth;
  
  /**
   * Instantiates a new Health goal.
   *
   * @param minimumHealth the minimum health
   */
  public HealthGoal(int minimumHealth) {
    this.minimumHealth = minimumHealth;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getHealth() >= minimumHealth;
  }
  
  @Override
  public String toString() {
    return "Health Goal :" + minimumHealth +
            " hp";
  }
}

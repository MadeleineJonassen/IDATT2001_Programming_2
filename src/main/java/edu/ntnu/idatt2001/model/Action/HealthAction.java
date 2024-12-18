package edu.ntnu.idatt2001.model.Action;

import edu.ntnu.idatt2001.model.Player;

/**
 * An action for health.
 */
public class HealthAction implements Action {
  private final int health;
  
  public HealthAction(int health) {
    this.health = health;
  }
  
  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
  
  @Override
  public String toString() {
    return "Health(" + health + ")";
  }
}

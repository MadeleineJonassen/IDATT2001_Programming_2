package edu.ntnu.idatt2001.action;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Health action.
 */
public class HealthAction implements Action {
  private final int health;
  
  /**
   * Instantiates a new Health action.
   *
   * @param health the health
   */
  public HealthAction(int health) {
    this.health = health;
  }
  
  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
  
  @Override
  public String toString(){
    return "Health: " + health;
  }
}

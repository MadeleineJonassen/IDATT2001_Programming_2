package edu.ntnu.idatt2001.goal;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Gold goal.
 */
public class GoldGoal implements Goal {
  private final int minimumGold;
  
  /**
   * Instantiates a new Gold goal.
   *
   * @param minimumGold the minimum gold
   */
  public GoldGoal(int minimumGold) {
    this.minimumGold = minimumGold;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getGold() >= minimumGold;
  }
  
  @Override
  public String toString() {
    return "Gold Goal: " + minimumGold +
            " gold";
  }
}

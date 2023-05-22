package edu.ntnu.idatt2001.goal;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Score goal.
 */
public class ScoreGoal implements Goal {
  private final int minimumPoints;
  
  /**
   * Instantiates a new Score goal.
   *
   * @param minimumPoints the minimum points
   */
  public ScoreGoal(int minimumPoints) {
    this.minimumPoints = minimumPoints;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getScore() >= minimumPoints;
  }
  
  @Override
  public String toString() {
    return "Score Goal: " + minimumPoints +
            " points";
  }
}

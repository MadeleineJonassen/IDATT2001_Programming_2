package edu.ntnu.idatt2001.model.Goal;

import edu.ntnu.idatt2001.model.Player;

/**
 * A goal for score.
 */
public class ScoreGoal implements Goal {
  private final int minimumPoints;
  
  public ScoreGoal(int minimumPoints) {
    this.minimumPoints = minimumPoints;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getScore() >= minimumPoints;
  }
  
  @Override
  public String toString() {
    return "Score Goal: " + minimumPoints
            + " points";
  }
}

package edu.ntnu.idatt2001.model.Action;

import edu.ntnu.idatt2001.model.Player;

/**
 * An action for score.
 */
public class ScoreAction implements Action {
  private final int points;
  
  public ScoreAction(int points) {
    this.points = points;
  }
  
  @Override
  public void execute(Player player) {
    player.addScore(points);
  }
  
  @Override
  public String toString() {
    return "Points(" + points + ")";
  }
}

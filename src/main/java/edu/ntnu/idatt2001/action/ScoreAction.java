package edu.ntnu.idatt2001.action;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Score action.
 */
public class ScoreAction implements Action {
  private final int points;
  
  /**
   * Instantiates a new Score action.
   *
   * @param points the points
   */
  public ScoreAction(int points) {
    this.points = points;
  }
  
  @Override
  public void execute(Player player) {
    player.addScore(points);
  }
  
  @Override
  public String toString(){
    return "Points: " + points;
  }
}

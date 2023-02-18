package edu.ntnu.idatt2001;

public class ScoreAction implements Action {
  private int points;
  
  public void ScoreAction(int points) {
    this.points = points;
  }
  
  @Override
  public void execute(Player player) {
    player.addScore(points);
  }
}

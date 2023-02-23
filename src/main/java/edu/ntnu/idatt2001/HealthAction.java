package edu.ntnu.idatt2001;

public class HealthAction implements Action {
  private final int health;
  
  public HealthAction(int health) {
    this.health = health;
  }
  
  @Override
  public void execute(Player player) {
    player.addHealth(health);
  }
}

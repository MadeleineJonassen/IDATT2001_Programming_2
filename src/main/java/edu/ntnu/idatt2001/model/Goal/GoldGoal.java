package edu.ntnu.idatt2001.model.Goal;

import edu.ntnu.idatt2001.model.Player;

public class GoldGoal implements Goal {
  private final int minimumGold;
  
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

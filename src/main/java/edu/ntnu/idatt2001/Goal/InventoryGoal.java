package edu.ntnu.idatt2001.Goal;

import edu.ntnu.idatt2001.Players.Player;

import java.util.List;

public class InventoryGoal implements Goal {
  private final List<String> mandatoryItems;
  
  public InventoryGoal(List<String> mandatoryItems) {
    this.mandatoryItems = mandatoryItems;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    return player.getInventory().contains(mandatoryItems);
  }
}

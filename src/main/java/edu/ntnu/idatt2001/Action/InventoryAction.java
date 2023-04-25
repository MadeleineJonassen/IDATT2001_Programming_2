package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.Players.Player;

public class InventoryAction implements Action {
  private final String inventory;
  
  public InventoryAction(String inventory) {
    this.inventory = inventory;
  }
  
  @Override
  public void execute(Player player) {
    player.addToInventory(inventory);
  }
}

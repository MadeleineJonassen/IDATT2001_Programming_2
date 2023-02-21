package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.Player;

public class InventoryAction implements Action {
  private String inventory;
  
  public void GoldAction(String inventory) {
    this.inventory = inventory;
  }
  
  @Override
  public void execute(Player player) {
    player.addToInventory(inventory);
  }
}

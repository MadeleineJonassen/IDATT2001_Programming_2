package edu.ntnu.idatt2001.model.Action;

import edu.ntnu.idatt2001.model.Player;

public class InventoryAction implements Action {
  private final String inventory;
  
  public InventoryAction(String inventory) {
    this.inventory = inventory;
  }
  
  @Override
  public void execute(Player player) {
    player.addToInventory(inventory);
  }
  
  @Override
  public String toString(){
    return "Inventory(" + inventory + ")";
  }
}

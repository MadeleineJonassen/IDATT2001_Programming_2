package edu.ntnu.idatt2001.action;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Inventory action.
 */
public class InventoryAction implements Action {
  private final String inventory;
  
  /**
   * Instantiates a new Inventory action.
   *
   * @param inventory the inventory
   */
  public InventoryAction(String inventory) {
    this.inventory = inventory;
  }
  
  @Override
  public void execute(Player player) {
    player.addToInventory(inventory);
  }
  
  @Override
  public String toString(){
    return "Inventory: " + inventory.toString();
  }
}

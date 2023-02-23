package edu.ntnu.idatt2001;

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

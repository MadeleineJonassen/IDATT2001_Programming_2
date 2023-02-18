package edu.ntnu.idatt2001;

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

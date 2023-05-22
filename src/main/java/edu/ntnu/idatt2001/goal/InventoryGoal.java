package edu.ntnu.idatt2001.goal;

import edu.ntnu.idatt2001.Players.Player;

import java.util.List;

/**
 * The type Inventory goal.
 */
public class InventoryGoal implements Goal {
  private final List<String> mandatoryItems;
  
  /**
   * Instantiates a new Inventory goal.
   *
   * @param mandatoryItems the mandatory items
   */
  public InventoryGoal(List<String> mandatoryItems) {
    this.mandatoryItems = mandatoryItems;
  }
  
  @Override
  public boolean isFulfilled(Player player) {
    List<String> playerInventory = player.getInventory();
    
    int numOfItemsInInventory = 0;
    for (String s : mandatoryItems){
      for (String i : playerInventory){
        if (playerInventory.contains(i)){
          numOfItemsInInventory++;
        }
      }
    }
    return numOfItemsInInventory == mandatoryItems.size();
  }
  
  @Override
  public String toString() {
    return "Inventory Goal:" + mandatoryItems.toString();
  }
}

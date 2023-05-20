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

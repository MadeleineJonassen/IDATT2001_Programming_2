package edu.ntnu.idatt2001.model.Action;

import edu.ntnu.idatt2001.model.Player;

/**
 * An action for gold.
 */
public class GoldAction implements  Action {
  private final int gold;
  
  public GoldAction(int gold) {
    this.gold = gold;
  }
  
  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
  
  @Override
  public String toString() {
    return "Gold(" + gold + ")";
  }
}

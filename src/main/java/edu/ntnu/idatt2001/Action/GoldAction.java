package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.Player;

public class GoldAction implements Action {
  private int gold;
  
  public void GoldAction(int gold) {
    this.gold = gold;
  }
  
  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
}

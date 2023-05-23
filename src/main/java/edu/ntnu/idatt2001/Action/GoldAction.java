package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.model.Player;

public class GoldAction implements  Action{
  private final int gold;
  
  public GoldAction(int gold) {
    this.gold = gold;
  }
  
  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
  
  @Override
  public String toString(){
    return "Gold(" + gold + ")";
  }
}

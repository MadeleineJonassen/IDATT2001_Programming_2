package edu.ntnu.idatt2001.Action;

import edu.ntnu.idatt2001.Players.Player;

public class GoldAction implements  Action{
  private final int gold;
  
  public GoldAction(int gold) {
    this.gold = gold;
  }
  
  @Override
  public void execute(Player player) {
    System.out.println("goldAction execute1");
    player.addGold(gold);
    System.out.println("goldAction execute2");
    
  }
}

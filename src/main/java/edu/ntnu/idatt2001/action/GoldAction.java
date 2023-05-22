package edu.ntnu.idatt2001.action;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The type Gold action.
 */
public class GoldAction implements  Action{
  private final int gold;
  
  /**
   * Instantiates a new Gold action.
   *
   * @param gold the gold
   */
  public GoldAction(int gold) {
    this.gold = gold;
  }
  
  @Override
  public void execute(Player player) {
    player.addGold(gold);
  }
  
  @Override
  public String toString(){
    return "Gold: " + gold;
  }
}

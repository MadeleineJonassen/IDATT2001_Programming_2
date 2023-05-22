package edu.ntnu.idatt2001.action;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The interface Action.
 */
public interface Action {
  /**
   * Execute.
   *
   * @param player the player
   */
  public void execute(Player player);
  public String toString();
}


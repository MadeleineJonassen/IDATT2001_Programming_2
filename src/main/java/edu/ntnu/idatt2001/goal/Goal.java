package edu.ntnu.idatt2001.goal;

import edu.ntnu.idatt2001.Players.Player;

/**
 * The interface Goal.
 */
public interface Goal {
  /**
   * Is fulfilled boolean.
   *
   * @param player the player
   * @return the boolean
   */
  public boolean isFulfilled(Player player);
  public String toString();
}
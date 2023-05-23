package edu.ntnu.idatt2001.model.Goal;

import edu.ntnu.idatt2001.model.Player;

/**
 * An interface for goals.
 */
public interface Goal {
  public boolean isFulfilled(Player player);

  public String toString();
}
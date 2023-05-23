package edu.ntnu.idatt2001.Goal;

import edu.ntnu.idatt2001.model.Player;

public interface Goal {
  public boolean isFulfilled(Player player);
  public String toString();
}
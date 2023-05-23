package edu.ntnu.idatt2001.model.Action;

import edu.ntnu.idatt2001.model.Player;

public interface Action {
  public void execute(Player player);
  public String toString();
}


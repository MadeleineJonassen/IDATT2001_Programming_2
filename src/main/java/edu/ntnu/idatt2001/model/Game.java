package edu.ntnu.idatt2001.model;

import edu.ntnu.idatt2001.model.Action.*;
import edu.ntnu.idatt2001.model.Action.Action;
import edu.ntnu.idatt2001.model.Goal.Goal;

import java.util.List;


/**
 * The type Game.
 */
public class Game {
  private final Player player;
  private final Story story;
  private final List<Goal> goals;
  
  
  /**
   * Instantiates a new Game.
   *
   * @param player the player
   * @param story  the story
   * @param goals  the goals
   */
  public Game(Player player, Story story, List<Goal> goals) {
    this.player = player;
    this.story = story;
    this.goals = goals;
  }
  
  /**
   * Instantiates a new Game.
   *
   * @param game the game
   */
  public Game(Game game) {
    this.player = game.getPlayer();
    this.story = game.getStory();
    this.goals = game.getGoals();
  }
  
  /**
   * Gets player.
   *
   * @return the player
   */
  public Player getPlayer() {
    return player;
  }
  
  /**
   * Gets story.
   *
   * @return the story
   */
  public Story getStory() {
    return story;
  }
  
  /**
   * Get goals list.
   *
   * @return the list
   */
  public List<Goal> getGoals() {
    return goals;
  }
  
  /**
   * Begin passage.
   *
   * @return the passage
   */
  public Passage begin() {
    return story.getOpeningPassage();
  }
  
  /**
   * Go passage.
   *
   * @param link the link
   * @return the passage
   */
  public Passage go(Link link) {
    for (Action action : link.getActions()) {
      action.execute(player);
    }
    
    return story.getPassage(link);
  }
}

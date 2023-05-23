package edu.ntnu.idatt2001.model;


import edu.ntnu.idatt2001.model.Goal.Goal;

import java.util.*;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The type Game manager.
 */
public class GameManager {
  private Game game;
  private PlayGameModel startedGame;
  private Story story;
  private Player player;
  private final ObservableList<Goal> goalsList = FXCollections.observableList(new ArrayList<>());
  private ObservableList<String> playerList = FXCollections.observableList(new ArrayList<>());
  
  /**
   * Set story.
   *
   * @param story the story
   */
  public void setStory(Story story) {
    this.story = story;
  }
  
  /**
   * Set player.
   *
   * @param player the player
   */
  public void setPlayer(Player player) {
    this.player = player;
    playerList.clear();
    playerList.addAll(player.getName(),
            Integer.toString(player.getHealth()),
            Integer.toString(player.getGold()),
            Integer.toString(player.getScore()),
            player.getInventory().toString().replace("[", "").replace("]", ""));
  }
  
  /**
   * Add goal.
   *
   * @param goal the goal
   */
  public void addGoal(Goal goal) {
    if (goalsList.contains(goal)) {
      throw new IllegalArgumentException("Goal has already been added.");
    }
    goalsList.add(goal);
  }
  
  /**
   * Get goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getGoals() {
    return goalsList;
  }
  
  /**
   * Get player info observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPlayerInfo() {
    return playerList;
  }
  
  /**
   * Clear goals.
   */
  public void clearGoals() {
    goalsList.clear();
  }
  
  /**
   * Story has been added boolean.
   *
   * @return the boolean
   */
  public boolean storyHasBeenAdded() {
    return (story != null);
  }
  
  /**
   * Player has been added boolean.
   *
   * @return the boolean
   */
  public boolean playerHasBeenAdded() {
    return (player != null);
  }
  
  /**
   * Create game.
   */
  public void createGame() {
    if (this.story == null) {
      throw new NullPointerException("Story has not been added");
    }
    if (this.player == null) {
      throw new NullPointerException("Player has not been added");
    }
    if (this.goalsList.isEmpty()) {
      throw new NullPointerException("Goals have not been added");
    }
    this.game = new Game(this.player, this.story, this.goalsList.stream().toList());
  }
  
  /**
   * Get game game.
   *
   * @return the game
   */
  public Game getGame() {
    if (this.game == null) {
      return null;
    }
    
    return new Game(game);
  }
  
  /**
   * Set game in progress.
   *
   * @param gameInProgress the game in progress
   */
  public void setGameInProgress(PlayGameModel gameInProgress) {
    this.startedGame = gameInProgress;
  }
  
  /**
   * Get game in progress play game model.
   *
   * @return the play game model
   */
  public PlayGameModel getGameInProgress() {
    return startedGame;
  }
  
  /**
   * Get player name string.
   *
   * @return the string
   */
  public String getPlayerName() {
    if (this.player == null) {
      throw new IllegalArgumentException("The player is not defined");
    }
    return player.getName();
  }
  
  /**
   * Get player player.
   *
   * @return the player
   */
  public Player getPlayer() {
    if (player == null) {
      throw new IllegalArgumentException("Player has not been added.");
    }
    return player;
  }
  
  /**
   * Get broken links list.
   *
   * @return the list
   */
  public List<String> getBrokenLinks() {
    if (this.story == null) {
      throw new IllegalArgumentException("The story is not defined");
    }
    
    List<Link> links = this.story.getBrokenLinks();
    
    List<String> linkNames = new ArrayList<>();
    for (Link l : links) {
      linkNames.add(l.getText());
    }
    return linkNames;
  }
  
  /**
   * Delete broken links.
   */
  public void deleteBrokenLinks() {
    story.deleteBrokenLinks();
  }
  
  /**
   * Get story title string.
   *
   * @return the string
   */
  public String getStoryTitle() {
    if (this.story == null) {
      throw new NullPointerException("Story must be added first");
    }
    return story.getTitle();
  }
  
  private Collection<Passage> getStoryPassages() {
    if (this.story == null) {
      throw new NullPointerException("Story must be added first");
    }
    
    return this.story.getPassages();
  }
  
  /**
   * Get story passage names set.
   *
   * @return the set
   */
  public Set<String> getStoryPassageNames() {
    return getStoryPassages().stream().map(Passage::getTitle).collect(Collectors.toSet());
  }
  
  
}

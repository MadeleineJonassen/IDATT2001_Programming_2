package edu.ntnu.idatt2001.model;

import edu.ntnu.idatt2001.Goal.Goal;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The type Play game model.
 */
public class PlayGameModel {
  private final Game game;
  private ObservableList<String> currentPassageText = FXCollections.observableArrayList();
  private ObservableList<String> currentLinkTitles = FXCollections.observableArrayList();
  private ObservableList<String> currentPlayerInfo = FXCollections.observableArrayList();
  private ObservableList<Goal> completedGoals = FXCollections.observableList(new ArrayList<>());
  private ObservableList<Goal> nonCompletedGoals = FXCollections.observableList(new ArrayList<>());
  private Passage currentPassage;
  private List<Link> currentLinks;
  
  /**
   * Instantiates a new Play game model.
   *
   * @param game the game
   */
  public PlayGameModel(Game game) {
    this.game = game;
    currentPassage = game.begin();
    updateCurrentLinks();
    updatePassageInfo();
    updatePlayerInfo();
    nonCompletedGoals.addAll(game.getGoals());
  }
  
  /**
   * Get story title string.
   *
   * @return the string
   */
  public String getStoryTitle() {
    return this.game.getStory().getTitle();
  }
  
  /**
   * Get passage text observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPassageText() {
    return this.currentPassageText;
  }
  
  /**
   * Get links text observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getLinksText() {
    return this.currentLinkTitles;
  }
  
  /**
   * Get player info observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPlayerInfo() {
    return this.currentPlayerInfo;
  }
  
  /**
   * Get non completed goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getNonCompletedGoals() {
    return nonCompletedGoals;
  }
  
  /**
   * Get completed goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getCompletedGoals() {
    return completedGoals;
  }
  
  /**
   * Next passage.
   *
   * @param linkText the link text
   */
  public void nextPassage(String linkText) {
    Link link = null;
    
    for (Link l : currentLinks) {
      if (l.getText().equals(linkText)) {
        link = l;
      }
    }
    
    if (link == null) {
      throw new IllegalArgumentException("Cannot find the matching link");
    }
    
    try {
      currentPassage = game.go(link);
    } catch (Exception ex) {
      throw new IllegalArgumentException("Cannot find passage");
    }
    
    updateCurrentLinks();
    updatePassageInfo();
    checkGoalCompletion();
    updatePlayerInfo();
  }
  
  private void updateCurrentLinks() {
    currentLinks = currentPassage.getLinks();
    currentLinkTitles.clear();
    for (Link l : currentLinks) {
      currentLinkTitles.add(l.getText());
    }
  }
  
  private void updatePassageInfo() {
    currentPassageText.clear();
    currentPassageText.addAll(currentPassage.getTitle(), currentPassage.getContent());
  }
  
  private void updatePlayerInfo() {
    currentPlayerInfo.clear();
    currentPlayerInfo.addAll(
            this.game.getPlayer().getName(),
            Integer.toString(this.game.getPlayer().getGold()),
            Integer.toString(this.game.getPlayer().getHealth()),
            Integer.toString(this.game.getPlayer().getScore()),
            this.game.getPlayer().getInventory().toString()
    );
  }
  
  private void checkGoalCompletion() {
    for (Goal g : nonCompletedGoals) {
      if (g.isFulfilled(this.game.getPlayer())) {
        if (nonCompletedGoals.size() > 1) {
          nonCompletedGoals.remove(g);
        } else if (nonCompletedGoals.size() == 1) {
          nonCompletedGoals.clear();
        }

        completedGoals.add(g);
      }
    }
  }
}
